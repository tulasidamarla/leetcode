package com.interview.questions.lloyds.tech;

public class NoOfElementsLessthanK {
    public static void main(String[] args) {
        int[] arr = {1,7,4,5,6,3,2};
        System.out.println(getCount(arr, 5));
    }

    private static int getCount(int[] arr, int i) {
        int count = 0;
        for(int num: arr){
            if(count < i){
                count++;
            }
        }
        return count;
    }
}

