package org.example.numbers;


public class SecondLargestNumber {
    public static void main(String[] args) {
        int[] arr = {2,5,7,3,6,4,6,1,9,9};
        int largest = 0;
        int secondlargest = 0;
        for (int element : arr) {
            if(element>largest) {
                secondlargest = largest;
                largest = element;
            } else if(element>secondlargest && element<largest) {
                secondlargest = element;
            }
        }
        System.out.println(largest);
        System.out.println(secondlargest);

    }
}
