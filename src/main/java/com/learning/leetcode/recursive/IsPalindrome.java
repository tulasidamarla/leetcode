package com.learning.leetcode.recursive;

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

    private static boolean isPalindrome(String s, int l, int r){
        //Base condition
        if (l >= r){
            return true;
        }

        //move to next character if char is not a letter or digit
        if(!Character.isLetterOrDigit(s.charAt(l))){
            return isPalindrome(s, ++l, r);
        }
        if(!Character.isLetterOrDigit(s.charAt(r))){
            return isPalindrome(s, l, --r);
        }

        //If chars do not match return false
        if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
            return false;
        }

        //If previous condition is not success then it means chars match.
        //Call isPalindrome recursively on the substring
        return isPalindrome(s, ++l, --r);
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
