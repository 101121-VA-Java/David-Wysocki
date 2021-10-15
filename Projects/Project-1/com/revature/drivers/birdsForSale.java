package com.revature.drivers;
import com.revature.models.Bird;

public class birdsForSale{

    public static void main(String[] args){
        Bird rio = new Bird("Rio");
        Bird larry = new Bird("Larry");
        Bird poptart = new Bird("Poptart");
        Bird sherman = new Bird("Sherman");
        System.out.println(larry.name);
    }
}