package br.com.adlermo.store.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_items")
@Getter
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private BigDecimal price;

    private int amount;

    @ManyToOne
    private Product product;

    @Setter
    @ManyToOne
    private Order order;

    public OrderItem(int amount, Product product, Order order) {
        this.price = product.getPrice(); // To keep track of product prices

        this.amount = amount;
        this.product = product;
        this.order = order;
    }

}
