package com.learning.leetcode.recursive.medium.combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        combinations(1, 4, 2, new ArrayList<>(), result);
        System.out.println("No of combinations: " + result.size());
        result.forEach(subset -> {
            System.out.println(" ");
            subset.forEach(System.out::print);
        });
    }

    private static void combinations(int index, int n, int k, List<Integer> subset, List<List<Integer>> result){
        if (k == 0){
            result.add(new ArrayList<>(subset));
            return;
        }

        if ( index > n){
            return;
        }

        subset.add(index);
        System.out.println("subset " + subset);
        combinations(index+1, n , k-1, subset, result);
        //Remove the previously added element
        subset.remove(subset.size()-1);
        // It should be k now not k-1 because element is removed
        combinations(index+1, n, k, subset, result);
    }
}
