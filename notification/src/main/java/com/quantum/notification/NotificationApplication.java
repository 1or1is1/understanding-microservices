package com.quantum.notification;

//import com.quantum.amqp.producer.RabbitmqMessageProducer;
//import com.quantum.notification.config.NotificationConfig;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {
        "com.quantum.notification",
        "com.quantum.amqp"
})
@EnableEurekaClient
public class NotificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(
//            NotificationConfig config,
//            RabbitmqMessageProducer producer
//    ) {
//        return args -> {
//            producer.publish("Testing", config.getInternalExchange(), config.getInternalNotificationRoutingKey());
//        };
//    }

}
