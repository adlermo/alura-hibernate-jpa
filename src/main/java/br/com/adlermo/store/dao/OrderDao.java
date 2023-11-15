package br.com.adlermo.store.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.adlermo.store.model.Order;
import br.com.adlermo.store.vo.SalesReportVO;

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

    public List<SalesReportVO[]> readSalesReport() {
        return this.eManager.createQuery("SELECT new br.com.adlermo.store.vo.SalesReportVO(" +
                "product.name, " +
                "SUM(item.amount), " +
                "MAX(o.dateTime)) " +
                "FROM Order o " +
                "JOIN o.items item " +
                "JOIN item.product product " +
                "GROUP BY product.name " +
                "ORDER BY item.amount DESC", SalesReportVO[].class).getResultList();
    }

    public void delete(Order order) {
        order = this.eManager.merge(order);
        this.eManager.remove(order);
    }
}
