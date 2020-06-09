package com.company;

import java.util.Arrays;
import java.util.Objects;


public class Sentences {
    private SentenceParts[] sentenceParts;
    private static final String punctsymb = ".,!?:;";

    public Sentences(SentenceParts[] sentenceParts) {
        this.sentenceParts = sentenceParts;
    }

    public Sentences(String mySentence) {
        String[] senElStr = mySentence.split("(?=[,.!?;:])|\\s");
        sentenceParts = new  SentenceParts[senElStr.length];
        String senElSt;
        for (int i = 0; i < senElStr.length; i++) {
            senElSt = senElStr[i];
            sentenceParts[i] = punctsymb.contains(senElSt)
                    ? new PunctMarks(senElSt)
                    : new Words(senElSt);

        }
    }

    @Override
    public String toString() {
        StringBuilder sentenceStr = new StringBuilder();
        for (int i = 0; i < sentenceParts.length; i++) {
            sentenceStr.append(
                    (i != 0 &&sentenceParts[i] instanceof Words? " ": "") +
                    sentenceParts[i].toString());
        }
        return sentenceStr.toString();
    }

    public int findTheQuantityOfWord(String wordString) {
        int wordEntrasQuantQuant = 0;

        for (SentenceParts parts : sentenceParts){
            if (parts instanceof Words){
                Words word = (Words)parts;
                if(word.equalsString(wordString)){
                    wordEntrasQuantQuant++;
                }
            }
        }
        return wordEntrasQuantQuant;
    }

}

