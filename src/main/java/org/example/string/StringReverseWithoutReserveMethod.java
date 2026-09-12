package org.example.string;

public class StringReverseWithoutReserveMethod {

    public static void main(String[] args) {
        String s1 = "Main";
        StringBuilder sb = new StringBuilder();
        for(int i=s1.length()-1; i>=0; i-- ){
            System.out.print(s1.charAt(i));
            sb.append(s1.charAt(i));
        }
        System.out.println("\n\n"+sb.toString());

    }
}
