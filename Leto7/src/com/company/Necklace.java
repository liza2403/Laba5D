package com.company;

import java.util.*;
import java.util.Scanner;

public class Necklace {
    private Gems[] gems;
    private int price;
    private int weight;
    private int transparency;

    public Necklace(int transparency) {
        this.transparency = transparency;
    }

    public Necklace(Gems[] gems) {
        this.gems = gems;
    }

    public Necklace(int price, int weight, int transparency) {
        this.price = price;
        this.weight = weight;
        this.transparency = transparency;
    }


    public int valueOfGem() {
        return price;
    }

    public int weihgtOfGem() {
        return weight;
    }

    public int trancperancyOfGem() {
        return transparency;
    }

    @Override
    public String toString() {
        return "Gem" + "  " +
                "Type = " + getClass().getSimpleName() +" => "+
                "Price = " + price;
    }

    public void sortgemsValue(){
        List<Gems> valueList = new ArrayList();
        for (Gems gem : gems) {
            valueList.add(gem);
        }
        valueList.sort(Comparator.comparing(Gems::valueOfGem));
        System.out.println(valueList);
    }


    public void priceOfNecklace(){
        int priceOfNeck = 0;
        for (int i = 0; i < gems.length; i++) {
            priceOfNeck += gems[i].valueOfGem();
        }
        System.out.println(priceOfNeck);
    }

    public void weightOfNecklace(){
        int weightOfNeck = 0;
        for (int i = 0; i < gems.length; i++) {
            weightOfNeck += gems[i].weihgtOfGem();
        }
        System.out.println(weightOfNeck + " carat");
    }

    public void trancperancyLevel(){

        List <Integer> transperancyList = new ArrayList();

        Scanner userswill = new Scanner(System.in);
        System.out.println("Please, enter the max value of acceptable trancperancy:");
        Integer userswill1 = userswill.nextInt();


        Scanner userswill2 = new Scanner(System.in);
        System.out.println("Please, enter the min value of acceptable trancperancy:");
        Integer userswill3 = userswill2.nextInt();



        for (int i = 0; i < gems.length; i++) {
            transperancyList.add(gems[i].trancperancyOfGem());
        }
        for(int i = 0; i <transperancyList.size(); i++){
            if(transperancyList.get(i) <= userswill1 && transperancyList.get(i)>= userswill3){
                System.out.println("Gem with such trancperancy is: " + gems[i]+"\n"+"And it's transperancy = "+ transperancyList.get(i));
            }
        }

    }


}
