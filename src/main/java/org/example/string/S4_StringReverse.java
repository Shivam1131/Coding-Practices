package org.example.string;

public class S4_StringReverse {

    public static void main(String[] args) {
//[VERY HIGH] Find the longest substring without repeating characters (sliding window).
        String input = "abcabcbbq";
        System.out.println(input);
        char[] arr = input.toCharArray();
        char temp;
        int left = 0;
        int right = arr.length-1;

        while(left < right){
            System.out.println("=>  "+ arr[left] +" = "+ arr[right]);
            temp = arr[left];
            arr[left]= arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        System.out.println(new String(arr));
    }
}
