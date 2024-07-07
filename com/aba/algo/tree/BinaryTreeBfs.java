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
     * 体现了一种“一圈一圈向外扩展”的逐层遍历方式
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

    /**
     * 采用层次遍历的方式，
     * 每一层记录都记录下当前队列的长度，这个是队尾，每一层队头从0开始。
     * 然后每遍历一个元素，队头下标+1。直到队头下标等于队尾下标。这个时候表示当前层遍历完成。
     * 每一层刚开始遍历的时候，树的高度+1。
     * 最后队列为空，就能得到树的高度。
     * @param: [root]
     * @return: int
     * @author: abracadabra
     * @date: 2024/7/7 16:33
     */
    public static int heightTree(TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        while (!queue.isEmpty()){
            //  记录当前队列的长度
            int size = queue.size();
            // 每一层开始遍历的时候，
            // 树的高度加1
            height++;
            // 遍历当前队列,每遍历一个元素，队头下标+1
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return height;
    }




}
