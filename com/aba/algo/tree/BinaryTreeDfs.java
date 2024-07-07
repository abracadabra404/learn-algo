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

    // 计算二叉树的高度
    // 1.如果二叉树为空，返回0
    // 2.如果二叉树不为空，返回其根节点为起点的子树的最大高度
    // 3.最大高度 = max(左子树的最大高度, 右子树的最大高度) + 1
    // 4.左子树和右子树的最大高度，可以通过递归的方式计算
    // 5.递归的终止条件是，当遇到空节点时，返回0
    // 6.递归的单层逻辑是，计算左子树和右子树的最大高度，并取其中较大的值，再将该值加1
    // 7.最终，返回计算得到的最大高度
    public static int heightTree(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(heightTree(root.left), heightTree(root.right)) + 1;
    }


}
