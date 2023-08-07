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
