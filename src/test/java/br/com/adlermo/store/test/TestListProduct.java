package br.com.adlermo.store.test;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.adlermo.store.dao.ProductDao;
import br.com.adlermo.store.model.Product;
import br.com.adlermo.store.util.JPAUtil;

public class TestListProduct {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        ProductDao dao = new ProductDao(em);

        List<Product> products = dao.readAll();

        products.forEach(p -> System.out.println(p.toString()));
    }

}
