package com.learning.leetcode.arrays.easy;

import java.util.Arrays;

public class FibonacciNumber {
    public static void main(String[] args) {
        System.out.println("Fibonacci Series using iterative method for 10 numbers"
                + Arrays.toString(fibIterative(10)));
        final int[] input = new int[11];
        fibRec(10, input);
        System.out.println("Fibonacci Series using recursion method for 10 numbers"
                + Arrays.toString(input));
        System.out.println("Fibonacci number without using array " + fibIterativeEfficient(10));

    }

    private static int[] fibIterative(int n) {
        int[] arr = new int[n+1];
        if (n >= 1){
            arr[0] = 0;
            arr[1] = 1;
        }
        for(int i = 2; i <= n ; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr;
    }

    // If whole sequence is not required then using constant memory return nth number in the series
    private static int fibIterativeEfficient(int n){
        int a=0;
        int b=1;
        for(int i = 2; i <= n; i++){
            int c = a +b;
            a = b;
            b = c;
        }
        return b;
    }

    private static int fibRec(int n, int[] arr){
        if ( n == 0 || n == 1){
            arr[n] = n;
            return n;
        }
        if (arr[n] != 0) return arr[n];
        arr[n] = fibRec(n-1, arr) + fibRec(n-2, arr);
        return arr[n];
    }


}
