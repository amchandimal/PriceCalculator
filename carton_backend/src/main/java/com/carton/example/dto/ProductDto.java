package com.carton.example.dto;

import com.carton.example.model.Product;

public class ProductDto {
    private int id;
    private String name;
    private int cartonSize;
    private double cartonPrice;
    private int disountQty;
    private double discountRate;
    private double singleUnitPrice;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.cartonSize = product.getCartonSize();
        this.cartonPrice = product.getCartonPrice();
        this.disountQty = product.getDisountQty();
        this.discountRate = product.getDiscountRate()*100;
        this.singleUnitPrice = (cartonPrice/cartonSize)*(1+product.getDiscountRate());
    }

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

    public double getSingleUnitPrice() {
        return singleUnitPrice;
    }

    public void setSingleUnitPrice(double singleUnitPrice) {
        this.singleUnitPrice = singleUnitPrice;
    }
}
