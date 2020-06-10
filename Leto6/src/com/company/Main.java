package com.company;
import java.util.regex.*;

public class Main {

    public static void main(String [] gems){
       Gems gem = new Larimar("blue", 660, 133, 16);
       Gems gem1 = new Tanzanite(307,453, 10);
       Gems gem2 = new BlackOpal(120, 321, 44);
       Gems gem3 = new Grandiderite(5540, 543, 25);

       Necklace necklaceForMama = new Necklace(new Gems[]{gem, gem1, gem2, gem3});

       System.out.println("\nMama's Necklace contains next types of gems:\n");
       necklaceForMama.sortgemsValue();
       System.out.println("====================");
       System.out.println("Dad spent on it:\n");
       necklaceForMama.priceOfNecklace();
       System.out.println("====================");
       System.out.println("And it's weight:\n");
       necklaceForMama.weightOfNecklace();
       System.out.println("====================");
       necklaceForMama.trancperancyLevel();

    }
}
