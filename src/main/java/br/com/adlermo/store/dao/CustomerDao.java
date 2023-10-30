package br.com.adlermo.store.dao;

import javax.persistence.EntityManager;

import br.com.adlermo.store.model.Category;

public class CustomerDao {

    private EntityManager eManager;

    public CustomerDao(EntityManager em) {
        this.eManager = em;
    }

    public void create(Category category) {
        this.eManager.persist(category);
    }
}
