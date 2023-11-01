package br.com.adlermo.store.test;

import javax.persistence.EntityManager;

import br.com.adlermo.store.dao.ProductDao;
import br.com.adlermo.store.util.JPAUtil;

public class TestDeleteProduct {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        ProductDao productDao = new ProductDao(em);

        em.getTransaction().begin();

        productDao.readAll().forEach(p -> productDao.delete(p));

        em.getTransaction().commit();
        em.close();
    }
}
