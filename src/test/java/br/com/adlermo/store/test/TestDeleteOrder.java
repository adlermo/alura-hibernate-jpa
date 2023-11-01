package br.com.adlermo.store.test;

import javax.persistence.EntityManager;

import br.com.adlermo.store.dao.OrderDao;
import br.com.adlermo.store.util.JPAUtil;

public class TestDeleteOrder {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        OrderDao orderDao = new OrderDao(em);

        em.getTransaction().begin();

        orderDao.readAll().forEach(order -> orderDao.delete(order));

        em.getTransaction().commit();
        em.close();
    }
}
