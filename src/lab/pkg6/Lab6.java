package lab.pkg6;

import java.util.Scanner;
import java.util.Stack;

public class Lab6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Instance of Binary Tree
        BinaryTree binary = new BinaryTree();
        //Adding 15 values to binary tree
        for (int i = 0; i < 15; i++) {
            System.out.print("Enter a node value: ");
            binary.insertNode(scanner.nextInt());
        }
        //Calling inOrder method of Binary tree to print values of tree inorder
        //Left subtree, root, right subtree
        binary.inOrder();
    }
}

class Node {
//Creating node for binary tree with key value and nodes for left tree and right tree

    int key;
    Node left;
    Node right;

    Node(int key) {
        //constructor initializing key as key input and left & right as null
        this.key = key;
        left = right = null;
    }
}

class BinaryTree {
//Attribute root to set root of binary tree
    Node root;
    public void insertNode(int key) {
        //Creating an instance of Node with the key value input
        Node node = new Node(key);
        //If there is no root set root to the first key value input
        if (root == null) {
            root = node;
        } else {
            //Set the current node to the root node 
            Node currentNode = root;
            while (true) {
                //Check if key entered is less than the current key
                if (node.key < currentNode.key) {
                    //Check if child to the left of the node is null
                    if (currentNode.left == null) {
                        //Set left child node to value input and exit loop
                        currentNode.left = node;
                        return;
                    }
                    //If value is not null, move the node we check (currentNode) to the left of the parent node
                    else { 
                        currentNode = currentNode.left;
                    }
                }
                //If key is greater than the current key
                else {
                    //Check if the child node to the right of the node is null
                    if (currentNode.right == null) {
                        //If it is null, set right child node to value input and exit loop
                        currentNode.right = node;
                        return;
                    } //if the value is not null move the node we check (currentNode) to the right of the parent node
                    else {
                        currentNode = currentNode.right;
                    }
                    
                }
            }
        }
    }

public void inOrder() {
        //Creating a Stack to store node value
        Stack<Node> nodeStack = new Stack<>();
        //initializing the current node to the root node
        Node currentNode = root;
        //Infinite while loop to traverse binary tree
        while (true) {
            //Check if node is null, if not, push value to stack, and move to the left child
            if (currentNode != null) {
                nodeStack.push(currentNode);
                currentNode = currentNode.left;
            } //If node is null, pop and print the stack, and check the right child of the parent that was popped
            else {
                currentNode = nodeStack.pop();
                System.out.print(currentNode.key + " ");
                currentNode = currentNode.right;
                //Once the nodes are traversed and the stack is empty, exit the while loop
                if (nodeStack.isEmpty() && currentNode == null) {
                    return;
                }
            }
        }
    }
}
