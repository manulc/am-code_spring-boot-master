package com.mlorenzo.demo.customer;

import java.util.List;
import java.util.Optional;

//@Repository("fake")
public class CustomerFakeRepository implements ICustomerRepository {

    @Override
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(1L, "James Bond", "password123", "test@gmail.com"),
                new Customer(2L, "John Doe", "123password", "test@gmail.com"));
    }

    @Override
    public Optional<Customer> getCustomer(Long id) {
        return getCustomers().stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }
}
