package br.com.adlermo.store.test;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.adlermo.store.dao.ProductDao;
import br.com.adlermo.store.model.Product;
import br.com.adlermo.store.util.JPAUtil;

public class TestRegisterProduct {
    public static void main(String[] args) {
        Product phone = new Product();
        phone.setName("Samsung A52");
        phone.setDescription("A smartphone by Samsung");
        phone.setPrice(new BigDecimal(799.90));

        // JPA follows the factory pattern
        // EntityManagerFactory factory =
        //      Persistence.createEntityManagerFactory("store");
        // EntityManager manager = factory.createEntityManager();

        EntityManager manager = JPAUtil.getEntityManager();

        ProductDao dao = new ProductDao(manager);
        manager.getTransaction().begin();
        dao.create(phone);
        manager.getTransaction().commit();
        manager.close();
    }

}
