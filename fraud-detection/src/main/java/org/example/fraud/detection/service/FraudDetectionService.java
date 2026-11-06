package org.example.fraud.detection.service;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.apache.kafka.streams.kstream.Windowed;
import org.example.fraud.detection.model.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.support.serializer.JacksonJsonSerde;
import org.springframework.stereotype.Service;

import java.time.Duration;

@EnableKafkaStreams
@Service
public class FraudDetectionService {

    // 1. Конфигурация входов/выходов
    private static final String INPUT_TOPIC = "fraud-server.public.transaction";
    private static final Duration WINDOW_SIZE = Duration.ofMinutes(5);
    private static final String OUTPUT_TOPIC = "fraud-alerts";

    @Bean
    public KStream<Windowed<String>, String> kStream(StreamsBuilder builder) {

        // 2. Десериализация транзакций
        JacksonJsonSerde<Transaction> transactionSerde = new JacksonJsonSerde<>(Transaction.class);
        KStream<String, Transaction> stream = builder.stream(
                INPUT_TOPIC,
                Consumed.with(Serdes.String(), transactionSerde)
        );

        // 3. Фильтрация и обработка
        KTable<Windowed<String>, Long> counts = stream
                .filter((key, tx) -> tx.getStatus() == Transaction.Status.NEW)
                .selectKey((key, tx) -> tx.getUserId().toString())
                .groupByKey(Grouped.with(Serdes.String(), transactionSerde))
                .windowedBy(TimeWindows.ofSizeWithNoGrace(WINDOW_SIZE))
                .count();

        // 4. Генерация алертов
        counts.toStream()
                .filter((windowedKey, count) -> count >= 3)
                .map((windowedKey, count) ->
                        KeyValue.pair(
                                windowedKey.key(),
                                "Fraud detected: " + count + " User: " + windowedKey.key()
                        )
                )
                .to(OUTPUT_TOPIC, Produced.with(Serdes.String(), Serdes.String()));

        return counts.toStream().mapValues(Object::toString);
    }
}
