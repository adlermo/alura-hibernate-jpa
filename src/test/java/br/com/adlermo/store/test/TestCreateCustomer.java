package br.com.adlermo.store.test;

import javax.persistence.EntityManager;

import br.com.adlermo.store.dao.CustomerDao;
import br.com.adlermo.store.model.Customer;
import br.com.adlermo.store.util.JPAUtil;

public class TestCreateCustomer {

    public static void main(String[] args) {
        Customer customer1 = new Customer("Adler Orteney", "051.XXX.XXX-97");
        Customer customer2 = new Customer("Andrews Orteney", "028.XXX.XXX-37");

        EntityManager em = JPAUtil.getEntityManager();

        CustomerDao customerDao = new CustomerDao(em);

        em.getTransaction().begin();
        customerDao.create(customer1);
        customerDao.create(customer2);

        em.getTransaction().commit();
        em.close();

    }
}
