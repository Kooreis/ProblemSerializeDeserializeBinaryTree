Here is a Java console application that serializes and deserializes a binary tree:

```java
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = deserialize(serialized);
        System.out.println("Deserialized: " + serialize(deserialized));
    }

    public static String serialize(TreeNode root) {
        if(root==null){
            return "null,";
        }
        String serializedTree = root.val + ",";
        serializedTree += serialize(root.left);
        serializedTree += serialize(root.right);
        return serializedTree;
    }

    public static TreeNode deserialize(String data) {
        Queue<String> nodesLeft = new LinkedList<>();
        nodesLeft.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodesLeft);
    }

    private static TreeNode deserializeHelper(Queue<String> nodesLeft) {
        String valueForNode = nodesLeft.poll();
        if (valueForNode.equals("null")) {
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.valueOf(valueForNode));
        newNode.left = deserializeHelper(nodesLeft);
        newNode.right = deserializeHelper(nodesLeft);
        return newNode;
    }
}
```

This program first creates a binary tree with the root node having a value of 1. The left child of the root node has a value of 2, and the right child of the root node has a value of 3. The right child of the root node also has two children, with values of 4 and 5.

The program then serializes the binary tree into a string, prints the serialized string, deserializes the string back into a binary tree, and prints the serialized string of the deserialized binary tree to verify that the original binary tree was correctly serialized and deserialized.