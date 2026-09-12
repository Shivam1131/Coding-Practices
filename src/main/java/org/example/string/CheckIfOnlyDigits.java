package org.example.string;

public class CheckIfOnlyDigits {
    public static void main(String[] args) {
        String str = "12345";
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)< '0' || str.charAt(i)> '9'){
                System.out.println("Not a digit");
                break;
            }
        }
        System.out.println("Digit");
    }

}
