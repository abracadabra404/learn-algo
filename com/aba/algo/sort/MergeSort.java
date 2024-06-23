package com.aba.algo.sort;

/**
 * merge sort
 *
 * @program learn-algo
 * @author: abracadabra
 * @create: 2024/06/23 22:35
 */
public class MergeSort {

    public static void main(String[] args) {

    }


    public static void mergeSort(int[] arr) {
        int length = arr.length;
        if (arr == null || length < 2) {
            return;
        }
        mergeSortRecursive(arr, 0, length - 1);
    }

    private static void mergeSortRecursive(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSortRecursive(arr, start, mid);
        mergeSortRecursive(arr, mid + 1, end);
//        merge(arr, start, mid, end);
    }

//    private static void merge(int[] arr, int start, int mid, int end) {
//        int[] help = new int[end - start + 1];
//        int i = 0;
//    }
}
