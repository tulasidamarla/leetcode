## Problem statement

- Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
- Each number in candidates may only be used once in the combination.
- Note: The solution set must not contain duplicate combinations.

Example 1:
```
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
```
```
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]
```

Constraints:
```
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
```

## Solution
```java
public class CombinationsSum2 {

    public static void main(String[] args) {
        final List<List<Integer>> result = new ArrayList<>();
        final int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        final int target = 8;
        Arrays.sort(candidates);
        combinations(candidates, target, 0, 0, new ArrayList<>(), result);
        System.out.println("No of combinations for " + Arrays.toString(candidates) + " and target " + target + " are " + result.size());
        result.forEach(System.out::println);
    }

    static void combinations(final int[] nums, final int target, int index, int sumTillNow, final List<Integer> subset, final List<List<Integer>> result) {

        if (sumTillNow == target) {
            result.add(new ArrayList<>(subset));
            return;
        }
        if (sumTillNow > target) {
            return;
        }
        if (index == nums.length) {
            return;
        }

        subset.add(nums[index]);
        sumTillNow += nums[index];
        combinations(nums, target, index + 1, sumTillNow, subset, result);
        sumTillNow -= nums[index];
        subset.remove(subset.size() - 1);
        while (index + 1 < nums.length && nums[index] == nums[index + 1])
            index++;
        combinations(nums, target, index + 1, sumTillNow, subset, result);
    }
}
```
