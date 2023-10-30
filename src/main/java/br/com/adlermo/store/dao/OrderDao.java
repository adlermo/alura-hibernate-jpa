package br.com.adlermo.store.dao;

import javax.persistence.EntityManager;

import br.com.adlermo.store.model.Order;

public class OrderDao {
    private EntityManager eManager;

    public OrderDao(EntityManager em) {
        this.eManager = em;
    }

    public void create(Order order) {
        this.eManager.persist(order);
    }
}
