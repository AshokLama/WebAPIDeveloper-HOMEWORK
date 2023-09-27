package com.WebAPIDeveloper.WebAPIDeveloper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private int customerId;
    private BigDecimal purchaseAmount;
    private LocalDate purchaseDate;

    public Transaction(int customerId, BigDecimal purchaseAmount, LocalDate purchaseDate) {
        this.customerId = customerId;
        this.purchaseAmount = purchaseAmount;
        this.purchaseDate = purchaseDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(BigDecimal purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "customerId=" + customerId +
                ", purchaseAmount=" + purchaseAmount +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
