package com.carton.example.dto;

public class PricingResponeDto extends PricingResponseBaseModel{

    private int productId;
    private String name;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
