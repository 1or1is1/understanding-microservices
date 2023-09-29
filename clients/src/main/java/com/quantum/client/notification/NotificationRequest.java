package com.quantum.client.notification;

public record NotificationRequest(Integer toCustomerId, String toCustomerEmail, String message) {
}
