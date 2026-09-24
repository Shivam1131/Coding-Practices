package org.example.string;

public class S5_PalindromeCheck {
    public static void main(String[] args) {
//[HIGH] Check whether a string is a palindrome. [Two Pointers]
        String input = "madama";
        System.out.println(input);
        char[] arr = input.toCharArray();
        char temp;
        int left = 0;
        int right = arr.length-1;
        boolean palindrome = true;
        while(left < right){
            if(arr[left]!= arr[right]){
                palindrome = false;
                break;
            }
            left++;
            right--;
        }
        System.out.println(palindrome ? " palindrom": "Not a palindrom");
    }
}
