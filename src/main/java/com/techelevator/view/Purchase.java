package com.techelevator.view;

import com.techelevator.Inventory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Purchase {

    // method in Purchase
    public BigDecimal updatedBalance(BigDecimal balance, String input) {

        Inventory stock = new Inventory();
        List<Snacks> stockInventory = stock.stockInventory();
        for (Snacks items : stockInventory) {
            if (items.getSlot().equals(input)) {
                balance = balance.subtract(items.getPrice());
            }
        }
        return balance;

    }
}
