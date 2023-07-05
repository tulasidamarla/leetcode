package com.learning.leetcode.patterns;

public class Triangle {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Triangle stars pattern");
        triangleStars(n);
        System.out.println("Triangle stars Reverse pattern");
        triangleStarsReverse(n);
        System.out.println("Triangle numbers pattern");
        triangleNumbers(n);
        System.out.println("Triangle same number row pattern");
        triangleNumbers2(n);
        System.out.println("Triangle numbers alternate pattern");
        triangleNumbers3(n);
        System.out.println("Triangle numbers incrementing pattern");
        triangleNumbers4(n);
        System.out.println("Triangle numbers symmetric pattern");
        triangleNumbersIncrement(n);
        System.out.println("Triangle numbers Reverse pattern");
        triangleNumbersReverse(n);
        System.out.println("Triangle characters pattern");
        triangleCharacters(n);
        System.out.println("Triangle alphabets pattern 2");
        triangleCharacters2(n);
        System.out.println("Triangle alphabets reverse pattern");
        triangleCharactersReverse(n);
        System.out.println("Triangle alphabets reverse pattern 2");
        triangleCharacters3(n);
    }

    private static void triangleStars(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void triangleStarsReverse(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    private static void triangleNumbers(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }
    }

    private static void triangleNumbers2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print((i + 1) + " ");
            }
            System.out.println();
        }
    }

    private static void triangleNumbers3(int n) {
        for (int i = 0; i < n; i++) {
            int start = i % 2 == 0 ? 1 : 0;
            for (int j = 0; j <= i; j++) {
                System.out.print(start + " ");
                start = 1 - start;
            }
            System.out.println();
        }
    }

    private static void triangleNumbers4(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(j + 1 + " ");
            }
            for (int j = 0; j < 2 * (n - i - 1); j++) {
                System.out.print("  ");
            }
            for (int j = i + 1; j > 0; j--) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void triangleNumbersIncrement(int n) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(count++ + " ");
            }
            System.out.println();
        }
    }

    private static void triangleNumbersReverse(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print((j + 1) + " ");
            }
            System.out.println();
        }
    }

    private static void triangleCharacters(int n) {
        for (int i = 0; i < n; i++) {
            for (char j = 'A'; j <= 'A' + i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void triangleCharacters2(int n) {
        for (char i = 0; i < n; i++) {
            char ch = (char) ('A' + i);
            for (char j = 0; j <= i; j++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }


    private static void triangleCharactersReverse(int n) {
        for (int i = 0; i < n; i++) {
            for (char j = 'A'; j < 'A' + n - i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void triangleCharacters3(int n) {
        for (int i = 0; i < n; i++) {
            for (char ch = (char) ('E' - i); ch <= 'E'; ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
