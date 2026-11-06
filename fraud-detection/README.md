# Fraud Detection System

Система обнаружения мошеннических транзакций в реальном времени на основе Apache Kafka Streams и Spring Boot.

## Технологический стек

| Технология | Версия | Назначение |
|---|---|---|
| **Java** | 21 | Язык разработки |
| **Spring Boot** | 4.1.2 | Основной фреймворк |
| **Spring Web** | 4.1.2 | REST API |
| **Spring Data JPA** | 4.1.2 | Работа с БД |
| **Spring Kafka** | 4.1.2 | Интеграция с Kafka |
| **Kafka Streams** | — | Stream processing |
| **PostgreSQL** | 13 | Хранилище транзакций |
| **Apache Kafka** | 7.4.0 (Confluent) | Event streaming |
| **Debezium** | 2.3 | CDC (Kafka Connect) |
| **ZooKeeper** | 7.4.0 (Confluent) | Координация Kafka |
| **Lombok** | — | Генерация boilerplate-кода |
| **Testcontainers** | — | Тестирование |
| **Maven** | — | Сборка проекта |

## Структура проекта

```
src/main/java/org/example/fraud/detection/
├── FraudDetectionApplication.java   # Точка входа
├── config/
│   └── KafkaConfig.java             # Конфигурация Kafka Streams
├── controller/
│   └── TransactionController.java   # REST API для транзакций
├── model/
│   └── Transaction.java             # Модель транзакции
├── repository/
│   └── TransactionRepository.java   # JPA-репозиторий
└── service/
    ├── FraudDetectionService.java   # Логика обнаружения мошенничества
    └── FraudProcessor.java          # Обработчик Kafka Streams
```

## Инструкции по запуску

### 1. Запуск инфраструктуры (Docker)

Проект использует Docker Compose для запуска всех зависимых сервисов:

```bash
cd fraud-detection
docker-compose up -d
```

Эта команда запустит:

| Сервис | Порт | Описание |
|---|---|---|
| **PostgreSQL** | `5432` | База данных `transactions_db` (пользователь: `debezium`, пароль: `dbz`) |
| **ZooKeeper** | `2181` | Координация Kafka |
| **Kafka** | `9092` (внутр.), `9093` (внешний) | Event streaming платформа |
| **Debezium Connect** | `8083` | CDC для PostgreSQL |

Проверка статуса:

```bash
docker-compose ps
```

### 2. Сборка проекта

```bash
./mvnw clean package
```

### 3. Запуск приложения

**Вариант A — Maven:**

```bash
./mvnw spring-boot:run
```

**Вариант B — JAR:**

```bash
./mvnw package -DskipTests
java -jar target/fraud-detection-0.0.1-SNAPSHOT.jar
```

Приложение запустится на порту `8080` (по умолчанию).

### 4. Проверка работоспособности

```bash
# Проверка, что приложение запущено
curl http://localhost:8080/actuator/health

# Отправка тестовой транзакции
curl -X POST http://localhost:8080/api/transactions \
  -H "Content-Type: application/json" \
  -d '{"amount": 1500.00, "currency": "RUB", "accountId": "acc-123"}'
```

### 5. Остановка инфраструктуры

```bash
docker-compose down
# Или с удалением данных:
docker-compose down -v
```

## REST API

| Метод | Endpoint | Описание |
|---|---|---|
| `POST` | `/api/transactions` | Создать транзакцию |
| `GET` | `/api/transactions` | Получить список транзакций |
| `GET` | `/api/transactions/{id}` | Получить транзакцию по ID |

## Конфигурация

Основные параметры конфигурации находятся в `src/main/resources/application.yaml`:

- **База данных:** `jdbc:postgresql://localhost:5432/transactions_db`
- **Kafka:** `localhost:9093`
- **Kafka Streams application-id:** `fraud-detection-streams`

## Тестирование

```bash
./mvnw test
```

## Лицензия

© 2026 Internal Project
