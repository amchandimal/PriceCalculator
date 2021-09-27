package com.carton.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int cartonSize;
    private double cartonPrice;
    private int disountQty;
    private double discountRate;
    private double handlingPercentage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCartonSize() {
        return cartonSize;
    }

    public void setCartonSize(int cartonSize) {
        this.cartonSize = cartonSize;
    }

    public double getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(double cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    public int getDisountQty() {
        return disountQty;
    }

    public void setDisountQty(int disountQty) {
        this.disountQty = disountQty;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getHandlingPercentage() {
        return handlingPercentage;
    }

    public void setHandlingPercentage(double handlingPercentage) {
        this.handlingPercentage = handlingPercentage;
    }
}
