package org.example.string;

public class PalindromeCheck {
    public static void main(String[] args) {
        String original = "madama";
        StringBuilder reversed = new StringBuilder();
        for(int i=original.length()-1; i>=0; i-- ){
            System.out.print(original.charAt(i));
            reversed.append(original.charAt(i));
        }
        System.out.println("\n\n"+reversed.toString());
        if(reversed.toString().equalsIgnoreCase(original))
            System.out.println("The string is a palindrome.");
        else
            System.out.println("The string is not a palindrome.");
    }
}
