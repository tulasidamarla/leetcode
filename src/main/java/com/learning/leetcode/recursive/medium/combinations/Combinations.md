## Problem statement

- Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n]. You may return
  the answer in any order.
- Example 1:

```
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]

Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are 
considered to be the same combination.
```

- Example 2:

```
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
```

## Solution

```java

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

    private static void combinations(int index, int n, int k, List<Integer> subset, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        if (index > n) {
            return;
        }

        subset.add(index);
        System.out.println("subset " + subset);
        combinations(index + 1, n, k - 1, subset, result);
        //Remove the previously added element
        subset.remove(subset.size() - 1);
        // It should be k now not k-1 because element is removed
        combinations(index + 1, n, k, subset, result);
    }
}
```