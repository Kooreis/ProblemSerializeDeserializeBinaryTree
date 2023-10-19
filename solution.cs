Here is a simple console application in C# that serializes and deserializes a binary tree:

```C#
using System;
using System.Collections.Generic;

public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
}

public class Codec
{
    public string serialize(TreeNode root)
    {
        if (root == null)
        {
            return "null";
        }

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(string data)
    {
        var nodes = new Queue<string>(data.Split(','));

        return BuildTree(nodes);
    }

    private TreeNode BuildTree(Queue<string> nodes)
    {
        var val = nodes.Dequeue();

        if (val == "null")
        {
            return null;
        }

        var node = new TreeNode(int.Parse(val));
        node.left = BuildTree(nodes);
        node.right = BuildTree(nodes);

        return node;
    }
}

class Program
{
    static void Main(string[] args)
    {
        var codec = new Codec();
        var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        var serialized = codec.serialize(root);
        Console.WriteLine("Serialized: " + serialized);

        var deserialized = codec.deserialize(serialized);
        Console.WriteLine("Deserialized: " + codec.serialize(deserialized));
    }
}
```

This program creates a binary tree, serializes it to a string, then deserializes it back to a binary tree. The serialized string is printed to the console, as well as the serialized version of the deserialized tree (which should match the original serialized string).