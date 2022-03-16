package com.example.vk8_3;

import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class BottleDispenser {
    private int bottles;
    private double money;

    private static BottleDispenser bottledispenser = new BottleDispenser();

    public static BottleDispenser getInstance(){
        return bottledispenser;
    }

    private ArrayList<Bottle> list = new ArrayList<Bottle>();

    private BottleDispenser() {
        bottles = 5;
        money = 0;

        for(int i = 0;i<bottles;i++) {
            list.add(new Bottle("Pepsi Max", 0.5, 1.8));
        }

    }

    public void addMoney(TextView text, int value ) {
        money += value;
        text.setText("Klink! Added more money!");
    }


    public void buyBottle(TextView text) {

        if(money < list.get(bottles-1).getPrice()){ //indeksi 4
            text.setText("Add money first!");
        }
        else if(bottles > 0){
            bottles -= 1; //muuttuu indeksi 4
            money -= list.get(bottles).getPrice(); //indeksi 4
            text.setText("KACHUNK! " + list.get(bottles).getName() + " came out of the dispenser!"); //indeksi 4
            removeObject();
        }
    }

    public void returnMoney(TextView text) {

        DecimalFormat formatted = new DecimalFormat("0.00");
        text.setText("Klink klink. Money came out! You got " + formatted.format(money) + "€ back");
        money = 0;
    }

    public void removeObject(){
        list.remove(bottles);

    }
}
