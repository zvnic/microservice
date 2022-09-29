package ru.datavendor.customer.service;

import ru.datavendor.customer.model.Customer;
import ru.datavendor.customer.model.CustomerRegistrationRequest;

public record CustomerService() {

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

    }
}
