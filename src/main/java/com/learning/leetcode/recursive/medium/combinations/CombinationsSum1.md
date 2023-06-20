## Problem statement
- Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
- The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency of at least one of the chosen numbers is different.
- The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
- Example 1:
```
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
```
- Example 2:
```
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
```
- Example 3:
```
Input: candidates = [2], target = 1
Output: []
```

## Solution
```java
public class CombinationsSum1 {
    public static void main(String[] args) {
        final List<List<Integer>> result = new ArrayList<>();
        final int[] candidates = {2,3,6,7};
        final int target = 7;
        combinations(candidates, target, 0, 0, new ArrayList<>(), result);
        System.out.println("No of combinations for "+ Arrays.toString(candidates) + " and target " + target + " are "+ result.size());
        result.forEach(System.out::println);
    }

    static void combinations(final int[] nums, final int target, int sumSoFar, int index, final List<Integer> subset, final List<List<Integer>> result){

        if (sumSoFar == target){
            result.add(new ArrayList<>(subset));
            return;
        }

        if (sumSoFar > target){
            return;
        }

        if (index == nums.length){
            return;
        }

        //include the ith element
        subset.add(nums[index]);
        sumSoFar += nums[index];
        //Don't increment index because we want to recursively call with the same index
        combinations(nums, target, sumSoFar, index, subset, result);
        sumSoFar -= nums[index];
        subset.remove(subset.size()-1);
        //skip the ith element
        combinations(nums, target, sumSoFar, index+1, subset, result);
    }
}
```