package org;

public class Test2 {

    public static void main(String[] args) {
        /*String[] arr = {
                "flower", "flow", "flight", "flame", "flat",
                "flash", "flock", "floor", "flip", "float"
        };
        String firstStr = arr[0];

        for(int i =0; i<firstStr.length(); i++) {
            for(int j=1; j< arr.length; j++){
                if(arr[j].length()<=i || arr[j].charAt(i) != firstStr.charAt(i)){
                    System.out.println(firstStr.substring(0,i));
                    return;
                }
            }
        }
        System.out.println(firstStr);*/



    int[][] arrSource = {
            {1, 0, 3},
            {4, 5, 0},
            {7, 8, 9}
    };
    int[][] resultArr = {
            {1, 0, 3},
            {4, 5, 0},
            {7, 8, 9}
    };
    for(int i=0; i<arrSource.length; i++){
        for(int j=0; j<arrSource[i].length; j++){
            //System.out.print(arrSource[i][j]);
            //if(arrSource[i][j] == 0)
               // updateDestinationArrayToZerosForPosition(i, j);
        }
        System.out.println();
    }


    }

    /*private static void updateDestinationArrayToZerosForPosition(int i, int j) {
        for(int k=0;k<){

        }
    }*/
   /* //
     //
     //
 //arr[][]
 for(){
     for(){
         //if element is zero-> take the element position from i and then j
         // example: i= 2, j = 0
         //then
         //  iterate through j and make every element at i as 0
         // iterate through i and make every element at j as 0
     }
    }*/
}
