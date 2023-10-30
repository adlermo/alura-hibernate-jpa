package br.com.adlermo.store.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.adlermo.store.model.Customer;

public class CustomerDao {

    private EntityManager eManager;

    public CustomerDao(EntityManager em) {
        this.eManager = em;
    }

    public void create(Customer customer) {
        this.eManager.persist(customer);
    }

    public List<Customer> readAll() {
        return this.eManager.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();
    }
}
