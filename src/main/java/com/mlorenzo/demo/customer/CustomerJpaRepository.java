package com.mlorenzo.demo.customer;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

//@Primary
//@Repository
public class CustomerJpaRepository implements ICustomerRepository {
    private final EntityManager em;

    public CustomerJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Customer> getCustomers() {
        return em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }

    @Override
    public Optional<Customer> getCustomer(Long id) {
        return Optional.ofNullable(em.find(Customer.class, id));
    }
}
