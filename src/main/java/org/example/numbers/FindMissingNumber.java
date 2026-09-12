package org.example.numbers;

import java.util.Arrays;

public class FindMissingNumber {
    public static void main(String[] args) {
        int n = 7;
        int arr[] = {1,3,4,7,6,2};
        int arrSum = Arrays.stream(arr).sum();
        int expSum = n * (n + 1) / 2;
        System.out.println("Missing number: "+ (expSum-arrSum));
    }
}
