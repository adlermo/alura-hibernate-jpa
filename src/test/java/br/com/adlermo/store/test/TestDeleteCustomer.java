package br.com.adlermo.store.test;

import javax.persistence.EntityManager;

import br.com.adlermo.store.dao.CustomerDao;
import br.com.adlermo.store.util.JPAUtil;

public class TestDeleteCustomer {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        CustomerDao customerDao = new CustomerDao(em);

        em.getTransaction().begin();

        customerDao.readAll().forEach(c -> customerDao.delete(c));
    }
}
