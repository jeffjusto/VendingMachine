package com.techelevator;

import com.techelevator.view.Snacks;

import java.math.BigDecimal;

public class Drinks extends Snacks {


    public Drinks(String name, String slot, BigDecimal price) {
        super(name, slot, price, 5);
    }

    @Override
    public String getNoise() {
        return "glug glug, yum";
    }
}
