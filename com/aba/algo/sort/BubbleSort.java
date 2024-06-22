package com.aba.algo.sort;

import java.util.Arrays;

/**
 * bubble sort
 *
 * @program learn-algo
 * @author: abracadabra
 * @create: 2024/06/22 20:06
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 7, 4, 8, 1, 6, 5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    /**
     * 冒泡排序
     * 是原地排序算法，只涉及数据的交换，只需常量级的临时空间，空间复杂度为O(1)
     * 是稳定的排序算法，因为相同的元素不做交换，相对顺序并没有改变
     * 最好时间复杂度为O(n)，最坏时间复杂度为O(n^2)，平均时间复杂度为O(n^2)
     * 满有序度=逆序度+有序度，排序过程就是增加有序度，减少逆序度直到满有序度的过程
     * 冒泡排序的优化：
     *    1. 增加一个标志位，记录某一趟排序中是否发生了交换，如果发生了交换，则继续下一趟排序，否则说明该数据已经有序，直接退出排序过程
     * @param: [arr]
     * @return: void
     * @author: abracadabra
     * @date: 2024/6/22 21:31
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return ;
        }
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            // optimize: add quit flag
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                //  相邻元素两两对比
                //  元素交换，元素小的排前面
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // 此轮发生数据交换
                    flag = true;
                }
            }
            if (!flag) {
                return;
                //  没有数据交换，数组已经有序，直接退出
            }
        }
    }


}
