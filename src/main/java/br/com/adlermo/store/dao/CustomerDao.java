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

    public Customer readById(Long id) {
        return this.eManager.createQuery("SELECT c FROM Customer c WHERE c.id = :id", Customer.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    public void delete(Customer customer) {
        customer = this.eManager.merge(customer);
        this.eManager.remove(customer);
    }
}
