package com.example.demo.Models;

import jakarta.persistence.*;

@Entity
public class SellerProduce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Seller is just a User with role = "seller"
    @ManyToOne
    private User seller;

    @ManyToOne
    private Produce produce;

    private double price;
    private int stock;

    public SellerProduce() {}

    public SellerProduce(User seller, Produce produce, double price, int stock) {
        this.seller = seller;
        this.produce = produce;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Produce getProduce() {
        return produce;
    }

    public void setProduce(Produce produce) {
        this.produce = produce;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

