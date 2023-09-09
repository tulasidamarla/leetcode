package com.interview.questions;

public class FindNearestValue {

    public static void main(String[] args) {
        int[] prices = {21, 33, 47, 53, 77, 89, 91};
        int target = 48;
        int closest = nearest(prices, 0, prices.length - 1, target);
        System.out.println("Closest to target " + target + " is " + closest);
    }

    public static int nearest(int[] arr, int left, int right, int target) {
        if (left == right) {
            return getMin(arr, left, target);
        }

        if (arr[left] < target) {
            return nearest(arr, left + 1, right, target);
        } else {
            return nearest(arr, left, right - 1, target);
        }
    }

    private static int getMin(int[] arr, int left, int target) {
        int diff1 = Math.abs(arr[left] - target);
        int diff2 = Math.abs(arr[left - 1] - target);
        int diff3 = Math.abs(arr[left + 1] - target);
        int minDiff = Math.min(diff1, Math.min(diff2, diff3));
        if (minDiff == diff1) {
            return arr[left];
        } else if (minDiff == diff2) {
            return arr[left - 1];
        } else {
            return arr[left + 1];
        }
    }

}
