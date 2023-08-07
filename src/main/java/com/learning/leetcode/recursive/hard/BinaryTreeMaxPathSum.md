## Problem statement

- A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
- The path sum of a path is the sum of the node's values in the path.
- Given the root of a binary tree, return the maximum path sum of any non-empty path.

Example 1:
![Binary Tree](./bintree1.jpeg)
```
Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
```
Example 2:
![Binary Tree](./bintree2.jpeg)

```
Input: root = [-10,9,20,null,null,15,7]
Output: 42
Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
```
Constraints:

The number of nodes in the tree is in the range [1, 3 * 104].
-1000 <= Node.val <= 1000

## Solution
```python
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        res = [root.val]

        def dfs(root):
            if not root:
                return 0
            # Ignore left or right if negative, use 0 to ignore.
            leftMax = max(dfs(root.left), 0)
            rightMax = max(dfs(root.right), 0)
            # Find max with split
            res[0] = max(res[0], root.val + leftMax + rightMax)
            return root.val + max(leftMax, rightMax)

        dfs(root)
        return res[0]


def main():
    solution = Solution()
    root = TreeNode(1, TreeNode(2), TreeNode(3))
    maxPath = solution.maxPathSum(root)
    print("max path is ", maxPath)
    node = TreeNode(20, TreeNode(15), TreeNode(7))
    root = TreeNode(-10, TreeNode(9), node)
    maxPath = solution.maxPathSum(root)
    print("max path is ", maxPath)


main()
```
```java
public class BinaryTreeMaxPathSum {
    static int maxPathSum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        int maxPath = maxPathSum(root);
        System.out.println("max path is " +  maxPath);
        TreeNode node = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        root = new TreeNode(-10, new TreeNode(9), node);
        maxPath = maxPathSum(root);
        System.out.println("max path is " +  maxPath);
    }

    static int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPathSum;
    }

    static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);

        // Find max with split
        maxPathSum = Math.max(maxPathSum, root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```