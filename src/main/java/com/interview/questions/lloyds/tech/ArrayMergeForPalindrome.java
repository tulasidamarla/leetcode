package com.interview.questions.lloyds.tech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayMergeForPalindrome {
    static int findMinOps(int[] arr, int n, List<Integer> list)
    {
        int ans = 0; // Initialize result

        // Start from two corners
        for (int i=0,j=n-1; i<=j;)
        {
            // If corner elements are same,
            // problem reduces arr[i+1..j-1]
            if (arr[i] == arr[j])
            {
                //list.addAll(List.of(arr[i], arr[j]));
                System.out.println("pair found " +  arr[i] + " : " +arr[j]);
                i++;
                j--;
            }

            // If left element is greater, then
            // we merge right two elements
            else if (arr[i] > arr[j])
            {
                // need to merge from tail.
                j--;
                arr[j] += arr[j+1] ;
                ans++;
            }

            // Else we merge left two elements
            else
            {
                i++;
                arr[i] += arr[i-1];
                ans++;
            }
        }

        return ans;
    }

    static List<Integer> palindromeList(int[] nums){
        final List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int leftTotal = 0;
        int rightTotal = nums[right];
        while(left < right){
            if (leftTotal < rightTotal){
                leftTotal += nums[left];
                left += 1;
            } else if(leftTotal > rightTotal){
                leftTotal -= nums[left];
                left -= 2;
                list.add(rightTotal);
                right -= 1;
                rightTotal = nums[right];
            } else {
                list.add(leftTotal);
                list.add(rightTotal);
                left += 1;
                right -= 1;
                leftTotal = nums[left];
                rightTotal = nums[right];
                System.out.println("lT" +  leftTotal + "rT" + rightTotal);
                System.out.println("l,r" + left + "," + right);
            }
        }
        return list;
    }

    // Driver method to test the above function
    public static void main(String[] args)
    {
//        int arr[] = new int[]{1, 4, 5, 9, 1} ;
//        List<Integer> palindromeList = new ArrayList<>();
//        System.out.println("Count of minimum operations is "+
//                findMinOps(arr, arr.length, palindromeList));
        //palindromeList.forEach(System.out::println);
        int arr2[] = new int[]{10,15,25,15,34,15};
        List<Integer> palindromeList = new ArrayList<>();
        //findMinOps(arr2, arr2.length, palindromeList);
        //palindromeList.forEach(System.out::println);
        palindromeList(arr2).forEach(System.out::println);
        // 10 15 15 15 25 34

    }
}
