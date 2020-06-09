package com.company;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Words extends SentenceParts {
    private Letters[] letters;

    public Words(Letters[] letters) {
        this.letters = letters;
    }

    public Words(String myWord) {
        char[] letterChars = myWord.toCharArray();
        letters = new Letters[letterChars.length];
        for (int i = 0; i < letterChars.length; i++) {
            letters[i] = new Letters(letterChars[i]);
        }
    }

    public String toString() {
        StringBuilder wordString = new StringBuilder();
        for (Letters letter : letters) {
            wordString.append(letter.toString());
        }
        return wordString.toString();
    }

    public boolean equalsString(String wordString) {
        return  toString().toUpperCase().equals(wordString);
    }

    public void worsArrray(){

    }



}