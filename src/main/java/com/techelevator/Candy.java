package com.techelevator;

import com.techelevator.view.Snacks;

import java.math.BigDecimal;

public class Candy extends Snacks {


    public Candy(String slot, String name, BigDecimal price) {
        super(slot, name, price, 5);
    }


    @Override
    public String getNoise() {
        return null;
    }

}
