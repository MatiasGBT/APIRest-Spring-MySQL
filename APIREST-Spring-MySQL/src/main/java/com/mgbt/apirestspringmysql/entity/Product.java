package com.mgbt.apirestspringmysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private int idProduct;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "category")
    private String category;
}
