package org.example.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        int left = 0;
        int maxLength = 0;
        String longSubstring = "";

        String str = "abcabcbbxmla";
        Set<Character> set = new HashSet<>();

        for(int right=0; right<str.length(); right++){
            char ch = str.charAt(right);
            while(set.contains(ch)){
                set.remove(str.charAt(left));
                left++;
            }
            set.add(ch);

            // Current window length
            int currentLength = right - left + 1;
            if(currentLength > maxLength){
                maxLength = currentLength;
                longSubstring = str.substring(left, right+1);
            }
        }
        System.out.println(maxLength);
        System.out.println(longSubstring);

    }
}
