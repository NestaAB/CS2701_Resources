package com.example.demo.Models;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Each order item belongs to ONE order
    @ManyToOne
    private Order order;

    // Each order item refers to ONE seller-produce entry
    @ManyToOne
    private SellerProduce sellerProduce;

    private int quantity;

    // Price at the time of ordering (important because prices can change later)
    private double priceAtPurchase;

    public OrderItem() {}

    public OrderItem(Order order, SellerProduce sellerProduce, int quantity, double priceAtPurchase) {
        this.order = order;
        this.sellerProduce = sellerProduce;
        this.quantity = quantity;
        this.priceAtPurchase = priceAtPurchase;
    }

    public Long getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public SellerProduce getSellerProduce() {
        return sellerProduce;
    }

    public void setSellerProduce(SellerProduce sellerProduce) {
        this.sellerProduce = sellerProduce;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceAtPurchase() {
        return priceAtPurchase;
    }

    public void setPriceAtPurchase(double priceAtPurchase) {
        this.priceAtPurchase = priceAtPurchase;
    }
}
