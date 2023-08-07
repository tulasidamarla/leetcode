## Problem description

- Complexity: Hard
- Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
- Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
- Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Example 1:
![Binary Tree](./bintree3.jpeg)
```
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]
```
Example 2:
```
Input: root = []
Output: []
```
Constraints:
```
The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
```

## Solution
```python
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

```
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(4);
        node.right = new Node(5);
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = node;
        Codec solution = new Codec();
        String serializedData = solution.serialize(root);
        System.out.println("serialized tree data is " + serializedData);
        Node deserialized = solution.deserialize(serializedData);
        String serializedData2 = solution.serialize(deserialized);
        System.out.println("serialized tree data from deserialized root node is is " + serializedData2);
        System.out.println("Serialized strings match: " + serializedData.equals(serializedData2));
    }
}


class Codec {

    int i = 0;

    public String serialize(Node root) {
        List<String> res = new ArrayList<>();
        serialize(root, res);
        return String.join(",", res);
    }

    private void serialize(Node node, List<String> res) {
        if (node == null) {
            res.add("N");
            return;
        }
        res.add(String.valueOf(node.val));
        serialize(node.left, res);
        serialize(node.right, res);
    }

    public Node deserialize(String data) {
        List<String> vals = new ArrayList<>(Arrays.asList(data.split(",")));
        return deserialize(vals);
    }

    private Node deserialize(List<String> vals) {
        if (vals.get(i).equals("N")) {
            i++;
            return null;
        }
        Node node = new Node(Integer.parseInt(vals.get(i)));
        i++;
        node.left = deserialize(vals);
        node.right = deserialize(vals);
        return node;
    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}
```