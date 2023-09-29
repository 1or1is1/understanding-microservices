package com.quantum.customer.services;

import com.quantum.client.fraud.FraudClient;
import com.quantum.client.fraud.model.FraudCheckHistoryResponse;
import com.quantum.client.notification.NotificationClient;
import com.quantum.client.notification.NotificationRequest;
import com.quantum.customer.entity.Customer;
import com.quantum.customer.model.CustomerRegistrationRequest;
import com.quantum.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public record CustomerService(
        CustomerRepository customerRepository,
        RestTemplate restTemplate,
        FraudClient fraudClient,
        NotificationClient notificationClient) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
        FraudCheckHistoryResponse response = this.fraudClient.isFraudster(customer.getId());
        log.info(response.toString());
        log.info("SENDING NOTIFICATION...");
        NotificationRequest notificationRequest =
                new NotificationRequest(customer.getId(), customer.getEmail(), "Notification Sample Test");
        notificationClient.sendNotification(notificationRequest);
    }

}
