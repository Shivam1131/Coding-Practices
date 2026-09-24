package org.example.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class S3_CharacterFrequency {

    public static void main(String[] args) {

//[VERY HIGH] Count the frequency of each character in a string.
        String input = "abcabcbbbjgde";
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        System.out.println("Result: " + map);
        System.out.println("Using Streams => " + Arrays.stream(input.split("")).collect(Collectors.groupingBy(e -> e, Collectors.counting())));
    }

       /* int position = 0;
        int[] arr = {1,4,0,3,0,5,0,1,5};
        for(int a: arr){
            if(a!=0){
                arr[position]=a;
                position++;
            }
        }
        for(int i = position; i<arr.length; i++){
            arr[i] =0;
        }
        System.out.println(Arrays.toString(arr));*/
}


