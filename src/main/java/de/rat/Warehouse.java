package de.rat;

import java.util.ArrayList;

public class Warehouse extends Station {

    private int numberofStocks;
    private ArrayList<Integer>[] al = new ArrayList[n];

    // initializing

    public Warehouse(String description, int numberOfBoxes, Address address, int numberofStocks) {
        super(description, numberOfBoxes, address);
        this.numberofStocks=numberofStocks;

        for (int i = 0; i < n; i++) {
            al[i] = new ArrayList<Tool>();
        }
    }




}
