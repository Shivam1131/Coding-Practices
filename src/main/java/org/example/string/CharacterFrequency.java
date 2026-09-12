package org.example.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharacterFrequency {

    public static void main(String[] args) {
        /*String input = "banana";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i< input.length(); i++){
            map.putIfAbsent(input.charAt(i), 0);
            map.put(input.charAt(i), map.get(input.charAt(i))+1);
        }
        System.out.println(map);
        System.out.println(Arrays.stream(input.split("")).collect(Collectors.groupingBy(ch->ch,Collectors.counting())));
*/
        int position = 0;
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
        System.out.println(Arrays.toString(arr));
    }

}
