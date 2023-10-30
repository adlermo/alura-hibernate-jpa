package br.com.adlermo.store.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime dateTime = LocalDateTime.now();

    @ManyToOne
    private Customer customer;

    // Bidirectional relationship need to map and define cascade
    // Attribute named on OrderItem class line: 33
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items = new ArrayList<>();

    private float value;

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void addProduct(OrderItem item) {
        item.setOrder(this);
        this.items.add(item);
    }
}
