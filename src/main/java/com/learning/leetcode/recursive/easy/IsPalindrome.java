package com.learning.leetcode.recursive.easy;

/**
 *  Problem description can be found at https://leetcode.com/problems/valid-palindrome/
 *
 */
public class IsPalindrome {
    public static void main(String[] args) {
        //Test case 1
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s, 0, s.toCharArray().length-1));
        System.out.println(isPalindromeIterative(s));
        s = "race a car";
        System.out.println(isPalindrome(s, 0, s.toCharArray().length-1));
        System.out.println(isPalindromeIterative(s));

    }

    private static boolean isPalindrome(String s, int first, int last){
        //Base condition
        if (first >= last){
            return true;
        } else {
            //remove characters other than letters and digits
            if(!Character.isLetterOrDigit(s.charAt(first))){
                first++;
                return isPalindrome(s, first, last);
            }
            if(!Character.isLetterOrDigit(s.charAt(last))){
                last--;
                return isPalindrome(s, first, last);
            }

            //If chars not match return false
            if (Character.toLowerCase(s.charAt(first)) != Character.toLowerCase(s.charAt(last))){
                return false;
            }

            //If characters match then call isPalindrome on the substring
            if(Character.toLowerCase(s.charAt(first)) == Character.toLowerCase(s.charAt(last))){
                first++;
                last--;
                return isPalindrome(s, first, last);
            }
        }
        return true;
    }

    static boolean isPalindromeIterative(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }
        return true;
    }
}
