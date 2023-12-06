package com.mlorenzo.demo.customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {
    List<Customer> getCustomers();
    Optional<Customer> getCustomer(Long id);
}
