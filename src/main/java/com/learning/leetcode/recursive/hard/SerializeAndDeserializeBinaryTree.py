# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.

        :type root: TreeNode
        :rtype: str
        """
        res = []

        def dfs(node):
            if not node:
                res.append("N")
                return
            res.append(str(node.val))
            dfs(node.left)
            dfs(node.right)

        dfs(root)
        return ",".join(res)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        :type data: str
        :rtype: TreeNode
        """
        vals = data.split(",")
        self.i = 0

        def dfs():
            if vals[self.i] == "N":
                self.i += 1
                return None
            node = TreeNode(int(vals[self.i]))
            self.i += 1
            node.left = dfs()
            node.right = dfs()
            return node

        return dfs()


def main():
    node = TreeNode(3)
    node.left = TreeNode(4)
    node.right = TreeNode(5)
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = node
    solution = Codec()
    serializedData = solution.serialize(root)
    print("serialized tree data is ", serializedData)
    deserialized = solution.deserialize(serializedData)
    serializedData2 = solution.serialize(deserialized)
    print("serialized tree data from deserialized root node is is ", serializedData2)
    print("Serialized strings match: ", serializedData == serializedData2)


main()
