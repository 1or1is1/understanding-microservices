package com.quantum.customer.services;

import com.quantum.customer.entity.Customer;
import com.quantum.customer.model.CustomerRegistrationRequest;
import com.quantum.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.save(customer);
    }

}
