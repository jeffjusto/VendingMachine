package com.techelevator;

import com.techelevator.view.Snacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {


    public List<Snacks> stockInventory() {
        List<Snacks> snacksList = new ArrayList<>();
        File inputFile = new File("vendingmachine.csv");
        Scanner inputScanner = null;
        try {
            inputScanner = new Scanner(inputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            String[] products = line.split("\\|");
            BigDecimal price = new BigDecimal(products[2]);
            String type = products[3];
            if (type.equals("Chip")) {
                snacksList.add(new Chip(products[0], products[1], price));
            }
            if (type.equals("Drink")) {
                snacksList.add(new Drink(products[0], products[1], price));
            }
            if (type.equals("Candy")) {
                snacksList.add(new Candy(products[0], products[1], price));

            }
            if (type.equals("Gum")) {
                snacksList.add(new Gum(products[0], products[1], price));


            }
        }
        return snacksList;


    }

    public int newInventory() {
        int updatedInventory = 0;
        Inventory stock = new Inventory();
        List<Snacks> stockInventory = stock.stockInventory();
        for (Snacks snack : stockInventory) {
                updatedInventory = snack.getInventory() - 1;

        }
        return updatedInventory;
    }
}
