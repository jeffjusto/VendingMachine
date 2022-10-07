package com.techelevator;

import com.techelevator.view.Snacks;

import java.math.BigDecimal;

public class Gum extends Snacks {


    public Gum(String slot, String name, BigDecimal price) {

        super(slot, name, price, 5);
    }



    @Override
    public String getNoise() {
        return "Chew Chew Yum";
    }
}

