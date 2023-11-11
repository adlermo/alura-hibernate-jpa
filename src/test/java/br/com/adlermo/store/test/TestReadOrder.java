package br.com.adlermo.store.test;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.adlermo.store.dao.OrderDao;
import br.com.adlermo.store.model.Order;
import br.com.adlermo.store.util.JPAUtil;

public class TestReadOrder {

    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        OrderDao orderDao = new OrderDao(em);

        List<Order> orders = orderDao.readAll();

        orders.forEach(order -> System.out.println(order.toString()));
        System.out.println("Total de vendas: " + orders.size());

        System.out.println("Total amount sold: " + orderDao.readTotalValue());

        orderDao.readSalesReport().forEach(line -> {
            System.out.println(line[0]);
            System.out.println(line[1]);
            System.out.println(line[2]);
        });
    }
}
