package com.aba.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * binary tree bfs
 *
 * @program learn-algo
 * @author: abracadabra
 * @create: 2024/07/07 14:58
 */
public class BinaryTreeBfs {

    /**
     * 102. 二叉树的层序遍历
     * 广度优先遍历（breadth-first traversal）,广度优先搜索（breadth-first search bfs）
     * 广度优先遍历使用队列来实现，队列先进先出，符合广度优先的定义。
     * @param: [root]
     * @return: java.util.List<java.lang.Integer>
     * @author: abracadabra
     * @date: 2024/7/7 14:43
     */
    public static List<Integer> levelOrder(TreeNode root) {
        // 初始化队列，加入根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //初始化一个列表，用于保存遍历序列
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            // 弹出队列的第一个元素
            TreeNode node = queue.poll();
            // 保存该元素
            list.add(node.val);
            // 把该元素的左右子节点加入队列
            if (node.left != null){
                queue.offer(node.left);
            }
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return  list;
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
        List<Integer> val = levelOrder(n1);
        System.out.println(val);
    }
}
