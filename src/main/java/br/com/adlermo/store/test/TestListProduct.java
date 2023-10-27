package br.com.adlermo.store.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.adlermo.store.model.Product;

public class TestListProduct {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("store");
        EntityManager em = factory.createEntityManager();

        List<Product> products = em.createQuery("SELECT * FROM products").getResultList();

        products.forEach(p -> System.out.println(p.getName()));
    }

}
