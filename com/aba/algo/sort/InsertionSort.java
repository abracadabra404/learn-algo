package com.aba.algo.sort;

import java.util.Arrays;

/**
 * insertion sort
 *
 * @program learn-algo
 * @author: abracadabra
 * @create: 2024/06/23 16:05
 */
public class InsertionSort {


    public static void main(String[] args) {
        int arr[] = {4, 1, 3, 2, 5};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序
     * 是原地排序算法，不需要额外的存储空间，空间复杂度为O(1)
     * 是稳定的排序算法，对于相等的元素，可以选择将后出现的元素插入到前面已经出现该元素的后面
     * 平均时间复杂度为O(n^2)，最坏时间复杂度为O(n^2)，最好时间复杂度为O(n)
     * 适用于数据量较小，且基本有序的数组
     *
     * @param: [arr]
     * @return: void
     * @author: abracadabra
     * @date: 2024/6/23 16:27
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 从第二个元素开始，插入到前面有序的序列中. 第一个元素是默认有序的
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            // 保证前面的元素已经有序
            for (; j >= 0 ; j--) {
                if (arr[j] > value) {
                    //  移动元素
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            // 插入位置找到，插入元素
            arr[j+1] = value;
        }

    }
}
