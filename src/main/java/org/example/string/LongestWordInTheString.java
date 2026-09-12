package org.example.string;

public class LongestWordInTheString {
    public static void main(String[] args) {
        String s1 = "Java is very powerful";
        String longestWord = "";
        int longestWordlength = 0;
        for(String str : s1.split("\\s+")){
            if(longestWordlength<str.length()){
                longestWord = str;
                longestWordlength = str.length();
            }
        }
        System.out.println(longestWord);
        System.out.println(longestWordlength);
    }

}
