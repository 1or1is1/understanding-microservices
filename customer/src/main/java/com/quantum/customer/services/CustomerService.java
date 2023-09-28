package com.quantum.customer.services;

import com.quantum.customer.entity.Customer;
import com.quantum.customer.model.CustomerRegistrationRequest;
import com.quantum.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
@Slf4j
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);
        Map<?, ?> response = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}", Map.class, customer.getId());
        log.info(response.toString());
    }

}
