package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Inventory {


    public void stockInventory() {

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

        }
        Gum uchews = new Gum("D1", "U-Chews", 0.85, 5);
        Gum littleLeagueChews = new Gum("D2", "Little League Chews", 0.95, 5);
        Gum chiclets = new Gum("D3", "Chicklets", 0.75, 5);
        Gum tripleMint = new Gum("D4", "TripleMint", 0.75, 5);
        Chips potatoChips = new Chips("A1", "Potato Chips", 3.05, 5);
        Chips stackers = new Chips("A2", "Stackers", 1.45, 5);
        Chips grainWaves = new Chips("A3", "Grain Waves", 2.75, 5);
    }
}
