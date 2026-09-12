package org.example.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters2 {
    public static void main(String[] args) {
        String str = "abcabcbbxmladslkjlkjwuyvcjeoajdhftrbcnamdos";
        int left=0;
        int maxLength= 0;
        String maxString = "";
        Set<Character> set = new HashSet<>();

        for(int right = 0; right < str.length()-1; right++){
            char ch = str.charAt(right);
            while(set.contains(ch)){
                set.remove(str.charAt(left));
                left++;
            }
            set.add(ch);
            int currentLength = right - left+1;
            if(currentLength > maxLength){
                maxLength = currentLength;
                maxString = str.substring(left, right+1);
            }

        }
        System.out.println(maxLength);
        System.out.println(maxString);
    }
}
