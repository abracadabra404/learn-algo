package com.aba.algo.sort;

public class QuickSort {


    public static void main(String[] args) {

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
        int i = left-1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
//                swap(arr, i, j);
            }
            return 0;
        }
        return 0;
    }
}
