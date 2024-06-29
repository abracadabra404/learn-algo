package com.aba.algo.sort;

import java.util.Arrays;

public class QuickSort {


    public static void main(String[] args) {
        int[] arr = {3,6,8,10,1,2};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 快速排序
     * 是一个原地排序算法
     * 不是一个稳定的排序算法，排序后相同的元素的相对位置会改变
     * 时间复杂度：平均O(nlogn)，最坏O(n^2)，最好O(nlogn)
     * 处理过程是由上到下，先分区，再处理子问题
     * 优化：
     *  合理选择分区点 todo
     *  1.使用三数取中法选择分区点
     *  2.随机选择分区点
     *  3.为了避免快速排序中，递归太深而堆栈过小，导致堆栈溢出
     *      限制递归深度，当递归深度大于某个阈值时，停止递归，转而使用堆排序
     *      在堆上实现一个模拟函数调用栈，手动模拟压栈出栈的过程，这样就没有了系统栈大小的限制
     *
     * @param: [arr, left, right]
     * @return: void
     * @author: abracadabra
     * @date: 2024/6/26 21:41
     */
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
        // 交换pivot
        int temp = arr[i+1];
        arr[i+1] = arr[right];
        arr[right] = temp;
        return i+1;
    }
}
