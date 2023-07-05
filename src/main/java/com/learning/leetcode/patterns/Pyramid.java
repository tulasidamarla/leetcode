package com.learning.leetcode.patterns;

public class Pyramid {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Pyramid stars pattern");
        pyramidStars(5);
        System.out.println("Pyramid stars reverse pattern");
        pyramidStarsReverse(5);
        System.out.println("Pyramid right pattern");
        rightPyramidStars(5);
        System.out.println("Pyramid symmetric alphabets pattern");
        pyramidSymmetricAlphabets(5);
        System.out.println("Pyramid diamond star pattern");
        pyramidDiamondStarPattern(10);
        System.out.println("Symmetric pyramid star pattern");
        symmetricPyramidStars(5);

    }

    private static void pyramidStars(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // Print space
                System.out.print("   ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                // Print stars
                System.out.print(" * ");
            }
            for (int j = 0; j < n - 1 - i; j++) {
                // Print space
                System.out.print("   ");
            }
            System.out.println();
        }
    }

    private static void pyramidStarsReverse(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Print space
                System.out.print("   ");
            }
            for (int j = 0; j < 2 * (n - i - 1) + 1; j++) {
                // Print stars
                System.out.print(" * ");
            }
            for (int j = 0; j < i; j++) {
                // Print space
                System.out.print("   ");
            }
            System.out.println();
        }
    }

    private static void rightPyramidStars(int n) {
        for (int i = 1; i < 2 * n; i++) {
            int stars = i > n ? 2 * n - i : i;
            for (int j = 0; j < stars; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        }
    }

    private static void pyramidSymmetricAlphabets(int n) {
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("   ");
            }
            char ch = 'A';
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(" " + ch + " ");
                if (j < i) {
                    ch = (char) (ch + 1);
                } else {
                    ch = (char) (ch - 1);
                }
            }

            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("   ");
            }
            System.out.println();
        }
    }

    private static void pyramidDiamondStarPattern(int n) {
        for (int i = 0; i < n / 2; i++) {
            // Stars
            for (int j = 0; j < n / 2 - i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }

            //Stars
            for (int j = 0; j < n / 2 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < n / 2; i++) {
            // Stars
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < n -2 - 2 * i; j++) {
                System.out.print(" ");
            }

            //Stars
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void symmetricPyramidStars(int n){
        int spaces = 2*n - 2;
        for (int i = 1; i <= 2*n - 1; i++){
            int stars = i;
            //star
            if (i > n){
                stars = 2*n - i;
            }

            for(int j=1; j<= stars; j++){
                System.out.print(" * ");
            }
            //space
            for (int j=1; j <= spaces; j++){
                System.out.print("   ");
            }
            //star
            for(int j=1; j<= stars; j++){
                System.out.print(" * ");
            }
            if (i < n){
                spaces -= 2;
            } else {
                spaces += 2;
            }
            System.out.println("");
        }
    }
}
