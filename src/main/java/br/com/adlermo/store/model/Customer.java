package br.com.adlermo.store.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customers")
@Getter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String document;

    public Customer(String name, String document) {
        this.name = name;
        this.document = document;
    }

    @Override
    public String toString() {
        return "--------------------\n" +
                " id= " + this.id + "\n" +
                " name= " + this.name + "\n" +
                " document= " + this.document + "\n" +
                "--------------------";
    }

}
