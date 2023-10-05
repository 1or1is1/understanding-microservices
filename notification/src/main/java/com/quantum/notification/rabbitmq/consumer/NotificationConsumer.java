package com.quantum.notification.rabbitmq.consumer;

import com.quantum.client.notification.NotificationRequest;
import com.quantum.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = {"${rabbitmq.queue.notification}"})
    public void consume(NotificationRequest notificationRequest) {
        log.info("Consuming notification : {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }

}
