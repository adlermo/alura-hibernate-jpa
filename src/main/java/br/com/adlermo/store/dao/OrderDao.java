package br.com.adlermo.store.dao;

import javax.persistence.EntityManager;

import br.com.adlermo.store.model.Category;

public class OrderDao {
    private EntityManager eManager;

    public OrderDao(EntityManager em) {
        this.eManager = em;
    }

    public void create(Category category) {
        this.eManager.persist(category);
    }
}
