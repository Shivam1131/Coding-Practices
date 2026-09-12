package org.example.string;

import java.util.LinkedHashMap;

public class FirstRepeatedCharacter {
    public static void main(String[] args) {
        String input = "swiss";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<input.length(); i++){
            if(map.containsKey(input.charAt(i))){
                System.out.println("First Repeated character: " +input.charAt(i));
                break;
            }
            map.putIfAbsent(input.charAt(i), 1);
        }
    }
}
