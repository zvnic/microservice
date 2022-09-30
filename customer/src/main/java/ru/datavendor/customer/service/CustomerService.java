package ru.datavendor.customer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.datavendor.customer.dto.FraudCheckResponse;
import ru.datavendor.customer.model.Customer;
import ru.datavendor.customer.model.CustomerRegistrationRequest;
import ru.datavendor.customer.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        repository.saveAndFlush(customer);
        FraudCheckResponse response = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if(response.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}
