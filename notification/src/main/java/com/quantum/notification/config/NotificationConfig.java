package com.quantum.notification.config;

import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
public class NotificationConfig {

    @Value("${rabbitmq.exchange.internal}")
    private String internalExchange;

    @Value("${rabbitmq.queue.notification}")
    private String notificationQueue;

    @Value("${rabbitmq.routing-key.internal-notification}")
    private String internalNotificationRoutingKey;

    @Bean
    public TopicExchange internalTopicExchange() {
        return new TopicExchange(getInternalExchange());
    }

    @Bean
    public Queue notificationQueue() {
        return new Queue(getNotificationQueue());
    }

    @Bean
    public Binding internalToNotificationQueueBinding() {
        return BindingBuilder
                .bind(notificationQueue())
                .to(internalTopicExchange())
                .with(getInternalNotificationRoutingKey());
    }

}
