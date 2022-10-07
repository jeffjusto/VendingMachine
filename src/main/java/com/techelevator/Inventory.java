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
            if (type.equals("Chips")) {
                snacksList.add(new Chips(products[0], products[1], price));
            }
            if (type.equals("Drinks")) {
                snacksList.add(new Drinks(products[0], products[1], price));
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
}
