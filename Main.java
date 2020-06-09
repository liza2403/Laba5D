package com.company;

import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, it's default text:\n");

        Text txt = new Text ("I live in village. I like cats, but not dogs! My favourite cat is Lucy! " +
                "Why is she my favourite cat? " +
                "Because i love her colour of eyes.");

        String txt1 = "I live in village. I like cats, but not dogs! My favourite cat is Lucy! " +
                "Why is she my favourite cat? " +
                "Because i love her colour of eyes.";


        System.out.println(txt);
        System.out.println("\n-------------------------------------------------------------------\n");
        System.out.println("Enter the word, frequancy of which in text you would like to know ");


        Diya user = new Diya(txt);
        user.nachnem();

        Obed tvoyn= new Obed(txt1);
        tvoyn.rialMad();
    }


}
