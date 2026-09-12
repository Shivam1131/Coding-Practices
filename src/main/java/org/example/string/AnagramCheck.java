package org.example.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AnagramCheck {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";

        if (str1.length() != str2.length()) {
            System.out.println("Not an anagram 1");
            return;
        }
        Map<Character, Integer> countmap = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            countmap.put(str1.charAt(i), countmap.getOrDefault(i, 0) + 1);
        }

        Map<Character, Integer> countmap2 = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            countmap2.put(str2.charAt(i), countmap2.getOrDefault(i, 0) + 1);
        }

        if (countmap.equals(countmap2)) {
            System.out.println("Anagram");
        } else {
            System.out.println("Not an anagram");
        }
    }
}
