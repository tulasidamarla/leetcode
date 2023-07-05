package com.learning.leetcode.patterns;

import static java.lang.Math.min;

public class Squares {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Square pattern");
        square(n);
        System.out.println("Hollow Square pattern");
        hollowSquare(n);
        System.out.println("Matrix number pattern");
        matrixNumber(n);
    }

    private static void square(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    private static void hollowSquare(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    private static void matrixNumber(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                int top = i;
                int left = j;
                int right = (2 * n - 1) - 1 - j;
                int bottom = (2 * n - 1) - 1 - i;
                int val = n - min(min(top, left), min(right, bottom));
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
