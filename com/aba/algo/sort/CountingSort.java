package com.aba.algo.sort;

import java.util.Arrays;

/**
 * counting sort
 *
 * @program learn-algo
 * @author: abracadabra
 * @create: 2024/06/26 22:10
 */
public class CountingSort {


    public static void main(String[] args) {
        int [] arr = {1, 4, 1, 2, 7, 5, 2};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 计数排序
     * 只适用于数据范围不大的场景，而且只能对非负整数进行排序
     * 核心：使用一个额外的数组C，其中第i个元素是待排序数组A中值等于i的元素的个数。然后根据数组C来将A中的元素排到正确的位置。
     * 时间复杂度：O(n+k)，其中k是数组A中数据范围
     * 空间复杂度：O(k)
     * 稳定排序算法，不是原地排序算法，用到了额外的数组count
     * @param: [arr]
     * @return: void
     * @author: abracadabra
     * @date: 2024/6/27 21:39
     */
    public  static void countingSort(int[] arr) {

        if (arr == null || arr.length == 0) {
            return;
        }
        // 找最大值和最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        // 创建计数数组count，并统计元素个数
        int[] count = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }
        // 依次累加
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i - 1] + count[i];
        }
        // 倒序遍历原始数组，从count数组找到正确位置，输出到结果数组
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            res[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        // 复制回原数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res[i];
        }
    }
}
