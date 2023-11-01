package br.com.adlermo.store.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private LocalDateTime creationDateTime = LocalDateTime.now();

    @ManyToOne
    private Category category;

    public Product(String name, String description, BigDecimal price, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return "{\n" +
                " id: " + this.id + ",\n" +
                " name: " + this.name + ",\n" +
                " description: " + this.description + ",\n" +
                " price: " + this.price + ",\n" +
                " category: " + this.category.getName() + "\n" +
                "}";
    }
}
