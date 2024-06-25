package com.aba.algo.sort;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {3,6,8,10,1,2,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr,int left,int right){
        if (left < right) {
            // 找到pivot点
            int pi  = partition(arr, left, right);
            // 分别对pivot左边的和右边的数组进行排序
            quickSort(arr, left, pi-1);
            quickSort(arr, pi+1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        // 较小元素的索引
        int i = left-1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                // 交换 i，j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

            }
        }
        return i+1;
    }
}
