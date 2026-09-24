package org.example.string;

import java.util.HashSet;
import java.util.Set;

public class S2_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
//[VERY HIGH] Find the longest substring without repeating characters (sliding window).
        String input = "abcabcbbbjgde";
        int left = 0;
        int maxLength = 0;
        String longestString = "";

        Set<Character> set = new HashSet<>();
        for(int right = 0; right<input.length(); right++){
            Character ch = input.charAt(right);
            while(set.contains(ch)) {
                set.remove(input.charAt(left));
                left++;
            }
            set.add(input.charAt(right));
            int currentLength = right - left + 1;
            if(currentLength > maxLength) {
                maxLength = currentLength;
                longestString = input.substring(left, right+1);
            }
            //

        }
        //System.out.println("Character: "+ch);
        System.out.println("maxLength: "+maxLength);
        System.out.println("longestString: "+longestString);
        //System.out.println(set);
    }
}
