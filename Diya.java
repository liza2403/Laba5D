package com.company;
import java.util.Scanner;

public class Diya {
    private Text txt;

    public Diya(Text txt){
        this.txt = txt;
    }

    Scanner scanner = new Scanner(System.in);
    String userswill = scanner.nextLine();

    public void nachnem(){
       System.out.println("The number of times:" + txt.findTheQuantityOfWord(userswill.toUpperCase()));
    };
}
