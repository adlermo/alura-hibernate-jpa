package br.com.adlermo.store.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.adlermo.store.model.Product;

public class ProductDao {

    private EntityManager eManager;

    public ProductDao(EntityManager em) {
        this.eManager = em;
    }

    public void create(Product product) {
        this.eManager.persist(product);
    }

    public List<Product> readAll() {
        return this.eManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    public List<Product> readAllByName(String name) {
        return this.eManager.createQuery("SELECT p FROM Product p WHERE p.name = :name", Product.class)
                .setParameter("name", name).getResultList();
    }    
    
    public List<Product> readAllByCategory(String category) {
        return this.eManager.createQuery("SELECT p FROM Product p WHERE p.category.name = :category", Product.class)
                .setParameter("category", category).getResultList();
    }

    public BigDecimal readPriceProductById(Long id) {
        return this.eManager.createQuery("SELECT p.price FROM Product p WHERE p.id = :id", BigDecimal.class)
                .setParameter("id", id).getSingleResult();
    }

    public Product readById(Long id) {
        return this.eManager.find(Product.class, id);
    }

    public void update(Product product) {
        this.eManager.merge(product);
    }

    public void delete(Product product) {
        product = this.eManager.merge(product);
        this.eManager.remove(product);
    }

}
