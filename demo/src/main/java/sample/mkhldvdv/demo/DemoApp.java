package sample.mkhldvdv.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@Slf4j
@SpringBootApplication
//@SpringBootApplication(exclude = {
//        DataSourceAutoConfiguration.class,
//        SecurityAutoConfiguration.class,
//})
public class DemoApp {

    public static void main(String[] args) {
        SpringApplication.run(DemoApp.class, args);
        log.info("DemoApp started successfully at {}", LocalDateTime.now());
    }

}
