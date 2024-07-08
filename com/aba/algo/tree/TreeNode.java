package com.aba.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * tree node
 *
 * @program learn-algo
 * @author: abracadabra
 * @create: 2024/07/07 14:33
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;

    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
//        List<Integer> val = BinaryTreeBfs.levelOrder(n1);
//        BinaryTreeDfs.preOrder(n1);
//        BinaryTreeDfs.postOrder(n1);
//        BinaryTreeDfs.inOrder(n1);
//        System.out.println(BinaryTreeDfs.res);
//        System.out.println(BinaryTreeBfs.heightTree(n1));
    }






}
