package br.com.adlermo.store.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDateTime dateTime = LocalDateTime.now();

    @ManyToOne
    private Customer customer;

    // Bidirectional relationship need to map and define cascade
    // Attribute named on OrderItem class line: 33
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    private BigDecimal total = BigDecimal.ZERO;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(OrderItem item) {
        item.setOrder(this);
        this.items.add(item);
        this.total = this.total.add(item.getTotal());
    }

    @Override
    public String toString() {
        return "{\n" +
                " id: " + this.id + ",\n" +
                " date_time: " + this.dateTime + ",\n" +
                " customer: " + this.customer.getName() + ",\n" +
                " items: " + this.items.size() + "\n" +
                " total: $ " + this.total + "\n" +
                "}";
    }
}
