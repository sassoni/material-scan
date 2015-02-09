package com.theandroidpeople.materialscan.cart;

public class CartItem {
    private String description;
    private boolean hasSavings;
    private float savings;
    private float initialPrice;
    private float finalPrice;
    private int drawableId;

    public CartItem(String description, float initialPrice, float savings) {
        this.description = description;
        this.hasSavings = (savings != 0.0);
        this.initialPrice = initialPrice;
        this.savings = savings;
        this.finalPrice = initialPrice-savings;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasSavings() {
        return hasSavings;
    }

    public float getSavings() {
        return savings;
    }

    public float getFinalPrice() {
        return finalPrice;
    }
}
