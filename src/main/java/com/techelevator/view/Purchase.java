package com.techelevator.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Purchase {

    // method in Purchase
    public BigDecimal updatedBalance(BigDecimal balance, List<Snacks>, String input){
        List<Snacks> stockInventory = new ArrayList<>();

        for(Snacks items : stockInventory){
            if(items.getSlot().equals(input)){
                balance = balance.subtract(items.getPrice());
                return balance;
            }
        }
    }



    }


}
