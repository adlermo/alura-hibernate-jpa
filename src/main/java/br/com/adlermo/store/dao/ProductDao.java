package br.com.adlermo.store.dao;

import javax.persistence.EntityManager;

import br.com.adlermo.store.model.Product;

public class ProductDao {

    private EntityManager entityManager;

    public ProductDao(EntityManager em) {
        this.entityManager = em;
    }

    public void create(Product product) {
        this.entityManager.persist(product);
    }

}
