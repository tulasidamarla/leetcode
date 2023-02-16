package com.learning.leetcode.recursive;

/**
 * This method has time complexity of logn, as recursive calls are made on x*x.
 * space complexity is logn, no of recursive call stacks
 */
public class PowerXN {
    public static void main(String[] args) {
        System.out.println(2>>1);
        System.out.println(pow2(2, 5) == 32.0);
        System.out.println(pow2(2, 2) == 4.0);
    }

    static double pow1(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        if (n == 1) {
            return x;
        }
        if ((n & 1) == 0) // For even numbers. Event no check can also be written as n%2 === 0
            return pow1(x * x, n >>> 1); // can write n/2 instead of n >>> 1
        else // For odd numbers
            return x * pow1(x * x, n >>> 1);
    }

    /**
     * For explanation refer this
     *
     * https://leetcode.com/problems/powx-n/solutions/1337794/java-c-simple-o-log-n-easy-faster-than-100-explained/
     *
     * @param x
     * @param n
     * @return
     */
    static double pow2(double x, int n){
        double pow = 1;
        if(n<0)
        {
            n=-n;
            x= 1/x;
        }
        while(n != 0){
            if((n & 1) != 0) // equivalent to if((n % 2) != 0) i.e. multiply only when the number is odd
                pow *= x;

            x *= x;
            n >>>= 1; // equivalent to n = n / 2; i.e. keep dividing the number by 2

        }
        return pow;
    }
}
