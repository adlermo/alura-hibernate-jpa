package br.com.adlermo.store.dao;

import java.math.BigDecimal;
import java.util.List;

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

    public List<Product> readAll() {
        return this.entityManager.createQuery("SELECT p FROM Produto p", Product.class).getResultList();
    }

    public List<Product> readAllByName(String name) {
        return this.entityManager.createQuery("SELECT p FROM Produto p WHERE p.name = :name", Product.class)
                .setParameter("name", name).getResultList();
    }    
    
    public List<Product> readAllByCategory(String category) {
        return this.entityManager.createQuery("SELECT p FROM Produto p WHERE p.category.name = :category", Product.class)
                .setParameter("category", category).getResultList();
    }

    public BigDecimal readPriceProductById(Long id) {
        return this.entityManager.createQuery("SELECT p.price FROM Produto p WHERE p.id = :id", BigDecimal.class)
                .setParameter("id", id).getSingleResult();
    }

    public Product readById(Long id) {
        return this.entityManager.find(Product.class, id);
    }

    public void update(Product product) {
        this.entityManager.merge(product);
    }

    public void delete(Product product) {
        product = this.entityManager.merge(product);
        this.entityManager.remove(product);
    }

}
