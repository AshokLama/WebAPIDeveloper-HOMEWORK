package com.WebAPIDeveloper.WebAPIDeveloper;

import jakarta.annotation.Generated;

import java.time.Month;

public class Customer {

    private int customerId;
    private Month month;
    private int rewardPoints;

    public Customer(int customerId, Month month, int rewardPoints) {
        this.customerId = customerId;
        this.month = month;
        this.rewardPoints = rewardPoints;
    }

    public Customer(Month month, int rewardPoints) {
        this.month = month;
        this.rewardPoints = rewardPoints;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public int getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(int rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", month=" + month +
                ", rewardPoints=" + rewardPoints +
                '}';
    }
}
