package com.carton.example.dto;

public class PricingResponseBulkModel extends PricingResponseBaseModel {
    private int totalUnits;

    public int getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(int totalUnits) {
        this.totalUnits = totalUnits;
    }

    public PricingResponseBulkModel(int totalUnits,int cartons,int units,double cost) {
        this.totalUnits = totalUnits;
        this.setCartons(cartons);
        this.setPrice(cost);
        this.setUnits(units);
    }
}
