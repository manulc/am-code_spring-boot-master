package com.mlorenzo.demo.customer;

import com.mlorenzo.demo.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepo) {
        customerRepository = customerRepo;
    }

    public List<Customer> getCustomers() {
        LOGGER.info("getCustomers was called");
        return customerRepository.getCustomers();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.getCustomer(id)
                .orElseThrow(() -> {
                    NotFoundException notFoundException = new NotFoundException("Customer with id " + id  + " not found");
                    LOGGER.error("error in getting customer with id {}", id, notFoundException);
                    return notFoundException;
                });
    }
}
