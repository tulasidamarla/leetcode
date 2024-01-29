## Problem statement
- Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
  - Only numbers 1 through 9 are used.
  - Each number is used at most once.
- Return a list of all possible valid combinations. The list must not contain the same combination twice, and 
  the combinations may be returned in any order. 
  
- Example 1:
```
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
```
```
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
```
```
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
```
```
Constraints:

2 <= k <= 9
1 <= n <= 60
```

## Solution
```java

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

    static void combinations(int min, 
                           int max, 
                           int index, 
                           int target, 
                           int sumTillNow, 
                           List<Integer> subList, 
                           List<List<Integer>> result) {

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
        combinations(min+1, max, index-1, 
                target, sumTillNow, subList, result);
        subList.remove(subList.size()-1);
        sumTillNow -= min;
        combinations(min+1, max, index, target, 
                sumTillNow, subList, result);
    }
}

```