package com.example.MusicRecc.facts;
import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {


    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double cost;
    private Double salePrice;

    public Item() {
    }

    public Item(String name, Double cost, Double salePrice) {
        this(null, name, cost, salePrice);
    }

    public Item(Long id, String name, Double cost, Double salePrice) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.salePrice = salePrice;
    }

}