package com.tpe.app;

import java.util.Scanner;

public class deneme {
    public static void main(String[] args) {

        int count = 0;
        String sentence = "My name is DEATHVADER, Hello World!!! XD";
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (char vowel : vowels){
            for (int i = 0; i <sentence.length() ; i++) {
                if (vowel==sentence.toLowerCase().charAt(i)){
                    count++;
                }
            }
        }

        System.out.println("Number of vowels in the given sentence is " + count);






    }


}


