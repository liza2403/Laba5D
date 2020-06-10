package com.company;

import java.util.regex.Pattern;

public class Obed {
    private String txt1;

    public Obed(String txt1){
        this.txt1 = txt1;
    }
    public void rialMad(){

        txt1 = txt1.replace("?", " ").replace("!", " ").replace("...", " ").replace(".", " ").replace(",", " ");
        String txt2 = txt1.replace("?", ".").replace("!", ".").replace("...", ".");

        String [] SetofWords = txt1.split(" ");
        String [] SetOfSent = txt2.split("//.");

        int occurenceCount = 0;
        int maxOcurances = 0;
        String MostPopWord = new String();
        for (int f = 1; f < SetofWords.length; f++) {
            for (int j = 0; j < SetOfSent.length; j++) {
                Pattern pattern = Pattern.compile(SetofWords[f] + "\\b");
                if (pattern.matcher(SetOfSent[j]).find()) {
                    occurenceCount++;
                }
            }
            if (occurenceCount > maxOcurances) {
                maxOcurances = occurenceCount;
                MostPopWord = SetofWords[f];
            }
            occurenceCount = 0;

        }
        System.out.println("The most popular word:"+ MostPopWord);

    }
}
