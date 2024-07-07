package com.aba.algo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * binary tree dfs
 *
 * @program learn-algo
 * @author: abracadabra
 * @create: 2024/07/07 15:07
 */
public class BinaryTreeDfs {

    public final static  List<Integer> res = new ArrayList<>();




    public static void preOrder(TreeNode root) {
        if (root == null)
            return ;
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null)
            return ;
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }

    public static void postOrder(TreeNode root) {
        if (root == null)
            return ;
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.val);
    }


}
