package org.example.string;

public class ReverseEachWordInString {
    public static void main(String[] args) {
        String s1 = "Java is easy";
        StringBuilder sb = new StringBuilder();
        for (String str : s1.split(" ")) {
            for (int i = str.length()-1; i >= 0; i--) {
                sb.append(str.charAt(i));
            }
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
