package org.example.string;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateCharactersFromString {
    public static void main(String[] args) {
        String str = "programming";
        StringBuilder sb = new StringBuilder();
        Set<Character> charsSet = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            if(charsSet.add(str.charAt(i)))
                sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }

}
