package com.quantum.notification.service;

import com.quantum.client.notification.NotificationRequest;
import com.quantum.notification.entity.Notification;
import com.quantum.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationService(NotificationRepository notificationRepository) {

    public void sendNotification(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .toCustomerId(notificationRequest.toCustomerId())
                .sentAt(LocalDateTime.now())
                .message(notificationRequest.message())
                .build();

        notificationRepository.save(notification);

    }

}
