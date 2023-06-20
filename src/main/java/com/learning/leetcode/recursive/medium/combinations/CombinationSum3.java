package com.learning.leetcode.recursive.medium.combinations;

import java.util.*;

public class CombinationSum3 {

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(1, 9, 3, 7, 0, new ArrayList<>(), result);
        System.out.println("Combinations for k=3 and n=7 are");
        result.forEach(System.out::println);
        result= new ArrayList<>();
        combinations(1, 9, 3, 9, 0, new ArrayList<>(), result);
        System.out.println("Combinations for k=3 and n=9 are");
        result.forEach(System.out::println);
        result= new ArrayList<>();
        combinations(1, 9, 4, 1, 0, new ArrayList<>(), result);
        System.out.println("Combinations for k=4 and n=1 are");
        result.forEach(System.out::println);

    }

    static void combinations(int min, int max, int index, int target, int sumTillNow, List<Integer> subList, List<List<Integer>> result) {

        if (sumTillNow > target){
            return;
        }
        if (index == 0){
            if (sumTillNow == target){
                result.add(new ArrayList<>(subList));
            }
            return;
        }
        if (min > max){
            return;
        }

        subList.add(min);
        sumTillNow += min;
        combinations(min+1, max, index-1, target, sumTillNow, subList, result);
        subList.remove(subList.size()-1);
        sumTillNow -= min;
        combinations(min+1, max, index, target, sumTillNow, subList, result);
    }
}
