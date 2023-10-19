Sure, here is a Python solution using the `json` module for serialization and deserialization of a binary tree.

```python
import json

class Node:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def serialize(root):
    if not root:
        return None
    serialized_tree_map = dict()
    serialized_left = serialize(root.left)
    serialized_right = serialize(root.right)
    serialized_tree_map['val'] = root.val
    if serialized_left:
        serialized_tree_map['left'] = serialized_left
    if serialized_right:
        serialized_tree_map['right'] = serialized_right
    return json.dumps(serialized_tree_map)

def deserialize(s):
    if not s:
        return None
    serialized_tree_map = json.loads(s)
    node = Node(serialized_tree_map['val'])
    if 'left' in serialized_tree_map:
        node.left = deserialize(serialized_tree_map['left'])
    if 'right' in serialized_tree_map:
        node.right = deserialize(serialized_tree_map['right'])
    return node

def main():
    root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left.left = Node(4)
    root.left.right = Node(5)
    serialized = serialize(root)
    print(f"Serialized: {serialized}")
    deserialized = deserialize(serialized)
    print(f"Deserialized: {serialize(deserialized)}")

if __name__ == "__main__":
    main()
```

This code first defines a `Node` class for the binary tree. Then it defines two functions `serialize` and `deserialize`. The `serialize` function converts the binary tree into a JSON string. The `deserialize` function converts the JSON string back into a binary tree. The `main` function creates a binary tree, serializes it, and then deserializes it.