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
        int[] arr = {1, 3, 2, 6, 4, 5};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }


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
        merge(arr, left, mid, right);
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
}
