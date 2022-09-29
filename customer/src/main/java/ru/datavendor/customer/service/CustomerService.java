package ru.datavendor.customer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.datavendor.customer.model.Customer;
import ru.datavendor.customer.model.CustomerRegistrationRequest;
import ru.datavendor.customer.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        repository.save(customer);
    }
}
