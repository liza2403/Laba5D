package com.company;
import java.util.Scanner;
import java.util.Arrays;

public class Text {
    private Sentences[] sentences;

    public Text(Sentences[] sentences){
        this.sentences = sentences;
    }

    public Text(String myText) {
             String[] delimitedText = myText.split("(?<=[.!?]) ");
             sentences = new Sentences[delimitedText.length];
        for (int i = 0; i < delimitedText.length; i++) {
            sentences[i] = new Sentences(delimitedText[i]);
            
        }
    }


       /* Scanner scanner = new Scanner(System.in);
        System.out.println("Write 1 if you want to enter your text or 0 if you want to choose the default one:");
        int bool= scanner.nextInt();

        if (bool == 1){
            System.out.println("Enter your text:");
            String usersText = scanner.nextLine();
            String[] delimitedText = usersText.split("[.!?;]");
        }
        if( bool == 0){
            System.out.println("Default text:" + myText);
            String[] delimitedText = myText.split("[.!?;]");
        }
        else{
            System.out.println("You entered incorect value. Rerun the program");
        }*/

    @Override
    public String toString() {
        StringBuilder TextString = new StringBuilder();
        for(int i =0; i < sentences.length; i++){
            TextString.append(sentences[i].toString() + (i != sentences.length -1 ? " " : "")) ;
        }
        return TextString.toString();
    }

    public int findTheQuantityOfWord(String wordString) {
        int wordEntrasQuantQuant = 0;

        for (Sentences sentence : sentences) {
            wordEntrasQuantQuant += sentence.findTheQuantityOfWord(wordString);
            
        }
        return wordEntrasQuantQuant;

    }
}
