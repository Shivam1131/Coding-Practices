package org.example.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VowelAndConsonant {
    public static void main(String[] args) {
        String str  = "SADA SHIVPOPA TKADAM12 34";
        List<Character> vowelsData = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        List<Character> vowels = new ArrayList<>();
        List<Character> consonants = new ArrayList<>();

        for (int i=0; i<str.length(); i++) {
            if((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')){
                if(vowelsData.contains(str.charAt(i)))
                    vowels.add(str.charAt(i));
                else
                    consonants.add(str.charAt(i));
            }
        }
        System.out.println(vowels);
        System.out.println(consonants);
    }

}
