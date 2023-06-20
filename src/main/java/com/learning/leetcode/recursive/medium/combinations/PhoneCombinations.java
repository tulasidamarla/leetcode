package com.learning.leetcode.recursive.medium.combinations;

import java.util.*;

public class PhoneCombinations {
    public static void main(String[] args) {
        Map<Character, String> map = new HashMap<>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");

        }};
        System.out.println(map);
        List<String> result = new ArrayList<>();
        System.out.println("Combinations for 23 are");
        phoneCombinations(0, "23", "", map, result);
        System.out.println(result);
        result.clear();
        System.out.println("Combinations for 357 are");
        phoneCombinations(0, "357", "", map, result);
        System.out.println(result);

    }

    private static void phoneCombinations(int i, String digits, String temp, Map<Character, String> map, List<String> result) {
        if (i == digits.length()) {
            result.add(temp);
            return;
        }
        String chars = map.get(digits.charAt(i));
        for (int j = 0; j < chars.length(); j++) {
            temp = temp + chars.charAt(j);
            phoneCombinations(i + 1, digits, temp, map, result);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}
