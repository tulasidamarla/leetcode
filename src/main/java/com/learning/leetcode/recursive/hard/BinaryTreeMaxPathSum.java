package com.learning.leetcode.recursive.hard;

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
