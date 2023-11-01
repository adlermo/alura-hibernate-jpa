package br.com.adlermo.store.test;

import javax.persistence.EntityManager;

import br.com.adlermo.store.dao.CustomerDao;
import br.com.adlermo.store.dao.OrderDao;
import br.com.adlermo.store.dao.ProductDao;
import br.com.adlermo.store.model.Customer;
import br.com.adlermo.store.model.Order;
import br.com.adlermo.store.model.OrderItem;
import br.com.adlermo.store.model.Product;
import br.com.adlermo.store.util.JPAUtil;

public class TestCreateOrder {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        OrderDao orderDao = new OrderDao(em);
        CustomerDao customerDao = new CustomerDao(em);
        ProductDao productDao = new ProductDao(em);

        Customer customer = customerDao.readById(9l);
        Product product = productDao.readAll().get(0);

        Order order = new Order(customer);

        order.addProduct(new OrderItem(2, product, order));

        em.getTransaction().begin();

        orderDao.create(order);

        em.getTransaction().commit();
        em.close();
    }
}
