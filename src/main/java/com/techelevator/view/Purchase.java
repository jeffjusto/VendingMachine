package com.techelevator.view;

import com.techelevator.Inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class Purchase {

    LocalDateTime dateTime = LocalDateTime.now();

    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


    private BigDecimal balance = new BigDecimal(0.00);

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

    public void getChange( BigDecimal balance){
        balance = balance.multiply(new BigDecimal("100"));
        int coinBalance = balance.intValue();
        int numOfquarters;
        int numOfdimes;
        int numOfnickels;

        numOfquarters = coinBalance / 25;
        coinBalance = coinBalance % 25;
        numOfdimes = coinBalance / 10;
        coinBalance = coinBalance % 10;
        numOfnickels = coinBalance / 5;
        System.out.println("Your change is " + numOfquarters + " quarters, " + numOfdimes + " dimes, " + numOfnickels + " nickels");
    }




}
