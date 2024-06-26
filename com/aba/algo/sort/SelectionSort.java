package com.aba.algo.sort;

import java.util.Arrays;

/**
 * selection sort
 *
 * @program learn-algo
 * @author: abracadabra
 * @create: 2024/06/23 16:33
 */
public class SelectionSort {


    public static void main(String[] args) {
        int[] arr = {8,6,9,3,1,5};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    /**
     * 选择排序: 有点类似于插入排序，也分为已排序区间和待排序区间，每次从未排序区间中找到最小的元素，然后放到已排序区间的末尾
     * 是一种原地排序算法，空间复杂度为O(1)
     * 是一种不稳定的排序算法
     * 最好时间复杂度：O(n^2)，最差时间复杂度：O(n^2)，平均时间复杂度：O(n^2)
     * @param: [arr]
     * @return: void
     * @author: abracadabra
     * @date: 2024/6/23 16:49
     */
    public static void selectionSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 找出最小值的索引
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            // 用最小值跟数组中的元素交换位置
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}
