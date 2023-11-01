package br.com.adlermo.store.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.adlermo.store.model.Order;

public class OrderDao {
    private EntityManager eManager;

    public OrderDao(EntityManager em) {
        this.eManager = em;
    }

    public void create(Order order) {
        this.eManager.persist(order);
    }

    public List<Order> readAll() {
        return this.eManager.createQuery("SELECT o " +
                "FROM Order o", Order.class).getResultList();
    }

    public BigDecimal readTotalValue() {
        return this.eManager.createQuery("SELECT SUM(o.total) " +
                "FROM Order o", BigDecimal.class).getSingleResult();
    }

    public List<Object[]> readSalesReport() {
        return this.eManager.createQuery("SELECT product.name, " +
                "SUM(item.amount), " +
                "MAX(order.dateTime) " +
                "FROM Order order " +
                "JOIN order.items item " +
                "JOIN item.product product " +
                "GROUP BY product.name " +
                "ORDER BY item.amount DESC", Object[].class).getResultList();
    }

    public void delete(Order order) {
        order = this.eManager.merge(order);
        this.eManager.remove(order);
    }
}
