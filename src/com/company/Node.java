package com.company;

public class Node {
    Node[] nodes;
    int data;
    int ID;
    int parentID;

    public Node(int n, int data, int ID, int parentID) {
        nodes = new Node[n];
        this.data = data;
        this.ID = ID;
        this.parentID = parentID;
    }

    public boolean addNode(Node root, Node newChild) {
        // return 0 is true, return 1 is false
        if (root == null) {
            return false;
        }

        int parentID = newChild.parentID;

        Node parentNode = findParentNode(root, parentID);

        parentNode.nodes[numOfNotNullChildren(parentNode)] = newChild;

        return true;
    }

    public Node findParentNode(Node parent, int parentID) {
        if (parent == null) {
            return null;
        }

        if (parent.ID == parentID) {
            return parent;
        }
        for (int i = 0; i < numOfNotNullChildren(parent); i++) {
            Node temp = findParentNode(parent.nodes[i], parentID);
            if (temp != null) {
                return temp;
            }
        }

        return null;
    }

    static void inorder(Node node)
    {
        if (node == null)
            return;

        // Total node count
        int total = node.nodes.length;
        // All the nodes except the last
        for (int i = 0; i < total - 1; i++)
            inorder(node.nodes[i]);

        // Print the current node's data
        System.out.print("" + node.data + " ");

        // Last node
        inorder(node.nodes[total - 1]);
    }

    public int numOfNotNullChildren(Node node) {
        int num = 0;

        for (int i = 0; i < node.nodes.length; i++) {
            if (node.nodes[i] != null) {
                num++;
            }
        }

        return num;
    }

    /*
    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value >= data) {
            if (left == null) {
                return false;
            }
            return left.contains(value);
        } else {
            if (right == null) {
                return false;
            }
            return right.contains(data);
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printInOrder();
        }
    }
    */
}
