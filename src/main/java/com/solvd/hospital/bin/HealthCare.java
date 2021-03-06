package com.solvd.hospital.bin;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HealthCare {
    @JsonProperty
    int healthCareID;
    @JsonProperty
    double price;
    @JsonProperty
    String category;

    public HealthCare() {
    }

    public HealthCare(int healthCareID, double price, String category) {
        this.healthCareID = healthCareID;
        this.price = price;
        this.category = category;
    }

    public int getHealthCareID() {
        return healthCareID;
    }

    public void setHealthCareID(int healthCareID) {
        this.healthCareID = healthCareID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        return hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return equals(obj);
    }

    @Override
    public String toString() {
        return "HealthCare{" +
                "healthCareID=" + healthCareID +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}
