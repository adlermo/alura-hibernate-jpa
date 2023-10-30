package br.com.adlermo.store.test;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.adlermo.store.dao.CustomerDao;
import br.com.adlermo.store.model.Customer;
import br.com.adlermo.store.util.JPAUtil;

public class TestReadCustomer {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        CustomerDao customerDao = new CustomerDao(em);

        List<Customer> customers = customerDao.readAll();

        customers.forEach(c -> System.out.println(c.toString()));
    }
}
