package org.example.questions.modulr;


import java.util.HashMap;

// Anagram
// Silent
// listent
public class Test {
    public static void main(String[] args) {
        String s1 = "silenttt";
        String s2 = "listenoo";
        if(s1.length() == s2.length()){

            HashMap<Character, Integer> map1 = new HashMap<>();
            //HashMap<Character, Integer> map2 = new HashMap<>();

            for(int i = 0; i<= s1.length()-1; i++ ){
                map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0)+1);
            }
            for(int i = 0; i<= s2.length()-1; i++ ){
                if(map1.containsKey(s2.charAt(i))){
                    if(map1.get(s2.charAt(i)) > 1)
                        map1.put(s2.charAt(i), map1.get(s2.charAt(i)) -1);
                    else
                        map1.remove(s2.charAt(i));
                }

                //map1.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0)+1);
            }
            if(map1.isEmpty())
                System.out.println("Anagram");
            else
                System.out.println("Not Anagram");


        } else {
            System.out.println("not Anagram");
        }
    }
}
// Input : bcwhstfvsbanc
// t = abc

// a = 8
// b = 7
// c = 11
//min and max = 8 -11
