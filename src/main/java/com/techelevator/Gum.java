package com.techelevator;

import java.math.BigDecimal;

public class Gum implements Snacks{

    private String id;
    private String name;
    private double price;
    private String catchphrase;
    private int inventory;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCatchphrase(String catchphrase) {
        this.catchphrase = catchphrase;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public Gum(String id, String name, double price, int inventory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }

    public double updatedAmount(double userAmount, double price){

        userAmount = userAmount - price;
        return userAmount;
    }

    public String saying(){
        catchphrase = "Chew Chew, Gum";
        return catchphrase;
    }
}
