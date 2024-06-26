package com.aba.algo.sort;

import java.util.Arrays;

/**
 * merge sort
 *
 * @program learn-algo
 * @author: abracadabra
 * @create: 2024/06/23 22:35
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6,5,4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    /**
     * 归并排序
     * 归并排序是一种分而治之的算法，通过递归的方式将数组分为较小的数组，直到每个小数组只有一个位置，接着将数组归并成排序好的数组。
     * 不是原地排序算法，空间复杂度为O(n)。每次合并需要申请额外的临时空间，但最多不超多n个元素的大小。
     * 是稳定排序算法，对相等键值的元素排序后，它们的前后顺序保持不变
     * 时间复杂度为O(nlogn)，最好最坏平均时间复杂度都是O(nlogn)。执行效率与原始数据的有序程度无关。
     * 处理过程是由下到上，先处理子问题，然后再合并
     * todo：merge函数的时间复杂度为O(n)，递归调用mergeSort函数的时间复杂度为O(logn)，所以总的时间复杂度为O(nlogn)。
     * 优化：
     * 1. 哨兵技巧简化merge函数
     * @param: [arr]
     * @return: void
     * @author: abracadabra
     * @date: 2024/6/24 21:52
     */
    public static void mergeSort(int[] arr) {
        int length = arr.length;
        if (arr == null || length < 2) {
            return;
        }
        mergeSortRecursive(arr, 0, length - 1);
    }

    private static void mergeSortRecursive(int[] arr, int left, int right) {

        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSortRecursive(arr, left, mid);
        mergeSortRecursive(arr, mid + 1, right);
        mergeOptimize(arr, left, mid, right);
    }


    private static void merge(int[] arr, int left, int mid, int right) {
        // 找到两个子数组的大小
        int leftLength = mid - left + 1;
        int rightLength = right - mid;
        // 申请两个对应大小的数组
        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];
        // 把数据复制到这两个数组中
        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightLength; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        // 初始化两个数组的指针
        int i = 0, j = 0;
        // 初始化合并后数组的指针
        int index = left;
        // 合并两个子数组
        while (i < leftLength && j < rightLength) {
            if (leftArray[i] <= rightArray[j]) {
                arr[index] = leftArray[i];
                i++;
            } else {
                arr[index] = rightArray[j];
                j++;
            }
            index++;
        }
        // 把左边剩余的数组元素复制到合并后数组
        while (i < leftLength) {
            arr[index] = leftArray[i];
            i++;
            index++;
        }
        // 把右边剩余的数组元素复制到合并后数组
        while (j < rightLength) {
            arr[index] = rightArray[j];
            j++;
            index++;
        }
    }

    private static void mergeOptimize(int[] arr, int left, int mid, int right) {
        // 找到两个子数组的大小
        int leftLength = mid - left + 1;
        int rightLength = right - mid;
        // 申请两个对应大小的数组
        int[] leftArray = new int[leftLength + 1];
        int[] rightArray = new int[rightLength + 1];
        // 把数据复制到这两个数组中
        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightLength; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }
        // 在这里添加边界判断，防止数组越界. 哨兵技巧
        leftArray[leftLength] = Integer.MAX_VALUE;
        rightArray[rightLength] = Integer.MAX_VALUE;

        // 初始化两个数组的指针
        int i = 0, j = 0;
        // 合并两个子数组
        for (int index = left; index <= right; index++) {
            if (leftArray[i] <= rightArray[j]) {
                arr[index] = leftArray[i];
                i++;
            } else {
                arr[index] = rightArray[j];
                j++;
            }
        }
    }
}
