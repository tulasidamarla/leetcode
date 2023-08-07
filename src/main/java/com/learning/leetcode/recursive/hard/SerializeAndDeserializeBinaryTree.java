package com.learning.leetcode.recursive.hard;

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
