package org.example.string;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class S1_FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String input = "swiss";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<input.length(); i++){
            map.put(input.charAt(i), map.getOrDefault(input.charAt(i), 0)+1);
        }
        for (Character c : map.keySet()){
            if(map.get(c)<2) {
                System.out.println(c);
                break;
            }
        }
         }
}
