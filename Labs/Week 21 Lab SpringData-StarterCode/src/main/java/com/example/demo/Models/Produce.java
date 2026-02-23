package com.example.demo.Models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Produce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // One produce can be sold by many sellers
    @OneToMany(mappedBy = "produce")
    private List<SellerProduce> sellerProduceList;

    public Produce() {}

    public Produce(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SellerProduce> getSellerProduceList() {
        return sellerProduceList;
    }

    public void setSellerProduceList(List<SellerProduce> sellerProduceList) {
        this.sellerProduceList = sellerProduceList;
    }
}
