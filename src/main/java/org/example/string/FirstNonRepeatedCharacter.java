package org.example.string;

import java.util.LinkedHashMap;

public class FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String input = "swiss";
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<input.length(); i++){
            map.putIfAbsent(input.charAt(i), 0);
            map.put(input.charAt(i), map.get(input.charAt(i))+1);
        }
        for (Character c : map.keySet()){
            if(map.get(c)<2) {
                System.out.println(c);
                break;
            }
        }
    }
}
