package com.techelevator.view;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Scanner;

public abstract class Snacks {

    private String name;
    private String slot;
    private BigDecimal price;
    private int inventory;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }


    public Snacks(String slot, String name, BigDecimal price, int inventory) {
        this.name = name;
        this.slot = slot;
        this.price = price;
        this.inventory = inventory;
    }


    public abstract String getNoise();


}
