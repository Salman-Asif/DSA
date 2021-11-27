package com.dsa.tree;

import java.util.Random;

public class HeightOfBinaryTree {

    public static void main(String args[]) {
        Tree tree = new Tree();
        TreeNode root = new TreeNode(100, null, null);
        tree.root = root;
        tree.addOnLeft(root);
        tree.addOnLeft(root.left);
        tree.addOnLeft(root.left.left);
        tree.addOnRight(root);
        tree.addOnRight(root.right);

        System.out.println(tree.heightFromRoot());
    }
}


/*
    hypothesis:
    height(node) = h

    induction:
    height(node) = h
    height(node->left) = l
    height(node->right) = r

    combine:
    height(node) - height(node->left) = 1 --- (1) if height(node->left) > height(node->right)
        OR
    height(node) - height(node->right) = 1 --- (2) if height(node->right) > height(node->left)


    if height(node->left) > height(node->right)
        height(node) = 1 + height(node->left)
      OR
    if height(node->right) > height(node->left)
        height(node) = 1 + height(node->right)

    base condition:
    lastNode->left = null AND lastNode->right = null
    height(lastNode) = 1 + height(lastNode->left) // return here since height(lastNode->left) not valid or 0 height
    height(lastNode) = 1 + height(lastNode->right) // return here since height(lastNode->righ) not valid or 0 height


     */

class Tree {
    TreeNode root;

        /*
        Non refactored implementation
        int height(TreeNode node) {


            if(node == null) {
                return 0;
            }

            int leftHeight = height(node.left);
            int rightHeight = height(node.right);

            if(leftHeight > rightHeight) {
                return 1 + leftHeight;
            } else {
                return 1 + rightHeight;
            }
        }
        */

    int heightFromRoot() {
        return height(root);
    }

    private int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left) , height(node.right));
    }

    private TreeNode randomNode() {
        Random random = new Random();
        return new TreeNode(random.nextInt(), null, null);
    }

    public TreeNode addOnLeft(TreeNode node) {
        node.left = randomNode();
        return node.left;
    }

    public TreeNode addOnRight(TreeNode node) {
        node.right = randomNode();
        return node.right;
    }

}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

}
