package org.example.string;

public class S15_LongestPrefix {
    public static void main(String[] args) {
        String[] words = {"flower", "flow", "floght"};
        System.out.println(longestCommonPrefix(words)); // Output: "flo"
    }

    public static String longestCommonPrefix(String[] words) {
        for (int i = 0; i < words[0].length(); i++) {
            char ch = words[0].charAt(i);
            for (int j = 1; j < words.length; j++) {
                if (words[j].length() <= i || words[j].charAt(i) != ch) {
                    return words[j].substring(0, i);
                }
            }
        }
        return words[0];
    }
}
