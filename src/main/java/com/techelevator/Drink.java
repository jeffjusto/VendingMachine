package com.techelevator;

import com.techelevator.view.Snacks;

import java.math.BigDecimal;

public class Drink extends Snacks {


    public Drink(String name, String slot, BigDecimal price) {
        super(name, slot, price, 5);
    }

    @Override
    public String getNoise() {
        return "glug glug, yum";
    }
}
