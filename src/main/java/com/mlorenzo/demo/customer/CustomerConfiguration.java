package com.mlorenzo.demo.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class CustomerConfiguration {
    private final Boolean useFakeCustomerRepo;

    public CustomerConfiguration(@Value("${app.useFakeCustomerRepo:false}") Boolean useFakeCustomerRepo) {
        this.useFakeCustomerRepo = useFakeCustomerRepo;
    }

    @Bean("customerRunner")
    public CommandLineRunner runner() {
        return args -> System.out.println("Command line runner hooray");
    }

    @Bean
    public ICustomerRepository customerRepository(EntityManager em) {
        System.out.println("useFakeCustomerRepo=" + useFakeCustomerRepo);
        return useFakeCustomerRepo ? new CustomerFakeRepository() : new CustomerJpaRepository(em);
    }
}
