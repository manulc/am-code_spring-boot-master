package com.mlorenzo.demo.customer;

import com.mlorenzo.demo.exception.ApiRequestException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v2/customers")
public class CustomerControllerV2 {
    private final CustomerService customerService;

    public CustomerControllerV2(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("{customerId}")
    public Customer getCustomer(@PathVariable(name = "customerId") Long id) {
        return customerService.getCustomer(id);
    }

    @GetMapping("{customerId}/exception")
    public Customer getCustomerException(@PathVariable(name = "customerId") Long id) {
        throw new ApiRequestException("ApiRequestException for customer " + id);
    }

    // Para realizar las validaciones, podemos usar tanto la anotación @Valid de JPA como la anotación @Validated
    // de Spring.

    @PostMapping
    public void createNewCustomer(@RequestBody @Valid Customer customer) {
        System.out.println("POST REQUEST...");
        System.out.println(customer);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(@RequestBody @Validated Customer customer, @PathVariable(value = "customerId") Long id) {
        System.out.println("UPDATE REQUEST FOR CUSTOMER WITH ID " + id);
        System.out.println(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long id) {
        System.out.println("DELETE REQUEST FOR CUSTOMER WITH ID " + id);
    }
}
