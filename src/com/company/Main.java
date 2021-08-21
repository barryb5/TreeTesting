package com.company;

public class Main {

    public static void main(String[] args) {

        int n = 36;
        Node root = new Node(n, 1, 1, 0);
        root.nodes[0] = new Node(n, 2, 2,1);
        root.nodes[1] = new Node(n, 3,3,1);
        root.nodes[2] = new Node(n, 24,4,1);
        root.nodes[0].nodes[0] = new Node(n, 5,5,2);
        root.nodes[0].nodes[1] = new Node(n, 6,6,2);
        root.nodes[0].nodes[2] = new Node(n, 7,7,2);

        root.inorder(root);

        Node temp = root.findParentNode(root, 4);
        System.out.println("");
        if (temp != null) {
            System.out.println(temp.data);
        } else {
            System.out.println("Found nothing");
        }

        root.addNode(root, new Node(n,8,8,1));
        root.addNode(root, new Node(n,9,9,3));
        System.out.println(root.nodes[1].nodes[0]);
        root.inorder(root);




//        node.insert(3);
//        node.insert(6);
//        node.insert(8);
//        node.insert(2);
//        node.insert(4);
//        node.printInOrder();
    }
}
