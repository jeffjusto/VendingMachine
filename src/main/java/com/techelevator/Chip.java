package com.techelevator;

import com.techelevator.view.Snacks;

import java.math.BigDecimal;

public class Chip extends Snacks {


    public Chip(String name, String slot, BigDecimal price) {
        super(name, slot, price, 5);
    }




    @Override
    public String getNoise() {
        return "munch munch, yum";
    }
}
