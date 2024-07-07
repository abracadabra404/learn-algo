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

    // 前序遍历,访问优先级：
    // 1.访问根节点
    // 2.前序遍历左子树
    // 3.前序遍历右子树
    public static void preOrder(TreeNode root) {
        if (root == null)
            return ;
        res.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历,访问优先级：
    // 1.中序遍历左子树
    // 2.访问根节点
    // 3.中序遍历右子树
    public static void inOrder(TreeNode root) {
        if (root == null)
            return ;
        inOrder(root.left);
        res.add(root.val);
        inOrder(root.right);
    }

    // 后序遍历,访问优先级：
    // 1.后序遍历左子树
    // 2.后序遍历右子树
    // 3.访问根节点
    public static void postOrder(TreeNode root) {
        if (root == null)
            return ;
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.val);
    }


}
