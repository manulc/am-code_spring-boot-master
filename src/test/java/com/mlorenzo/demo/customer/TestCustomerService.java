package com.mlorenzo.demo.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Nota: En vez de usar la propiedad "spring.profiles.active=default", otra opción es usar la anotación
// @ActiveProfile("default").
// Nota: En vez de usar los datos del script "data.sql", usamos los datos del script "test_data.sql"
@DataJpaTest(properties = {"spring.profiles.active=default", "spring.datasource.data=test_data.sql"})
@Import(CustomerJpaRepository.class)
public class TestCustomerService {
    CustomerService customerService;

    // Nota: Otra opción es usar un método anotado con @BeforeEach en lugar de usar este constructor
    @Autowired
    TestCustomerService(ICustomerRepository customerRepository) {
        customerService = new CustomerService(customerRepository);
    }

    @Test
    void testGetCustomers() {
        // when
        List<Customer> customers = customerService.getCustomers();
        // then
        assertEquals(2, customers.size());
    }

    @Test
    void testGetCustomer() {
        // when
        Customer customer = customerService.getCustomer(1L);
        // then
        assertNotNull(customer);
        assertEquals(1L, customer.getId());
        assertEquals("John Doe", customer.getName());
        assertEquals("pass123", customer.getPassword());
        assertTrue(customer.getEmail().equals("john.doe@test.com"));
    }
}
