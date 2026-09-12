package org.boiler;

public class Main {
    public static void main(String[] args) {
        String str = "sillis";
        int j = str.length()-1;
        for (int i = 0; j>=i ; i++){
            if(str.charAt(i) == str.charAt(j)){
                System.out.println(str.charAt(j) + " = "+str.charAt(j));
                j--;
            } else {
                System.out.println("Not a palindrome");
                break;
            }
        }
        System.out.println("Palindrome: "+str);
    }
}
