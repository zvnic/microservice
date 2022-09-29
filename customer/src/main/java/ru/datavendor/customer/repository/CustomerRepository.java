package ru.datavendor.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.datavendor.customer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}