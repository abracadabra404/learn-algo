package com.aba.algo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * bucket sort
 *
 * @program learn-algo
 * @author: abracadabra
 * @create: 2024/06/26 22:10
 */
public class BucketSort {

    public static void main(String[] args) {
        float[] arr = {0.72f, 0.12f, 0.65f, 0.95f, 0.48f, 0.76f};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 桶排序
     * 适用与在外部排序中，外部排序是指数据存储在外部存储设备上，数据量大，内存有限，排序时数据需要被读入内存中进行排序。
     * 将数组分块，然后对每个块进行排序，最后合并。
     * 时间复杂度 O(n+k)
     * 空间复杂度 O(n+k)
     * @param: [arr]
     * @return: void
     * @author: abracadabra
     * @date: 2024/6/27 21:43
     */
    public static void bucketSort(float[] arr) {
        if (arr == null || arr.length ==0) {
            return;
        }
        // 创建n个桶
        int n = arr.length;
        ArrayList<Float>[] buckets = new ArrayList[n];
        // 初始化桶
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        // 遍历数组，将元素放入桶中
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int)(arr[i] * n);
            buckets[bucketIndex].add(arr[i]);
        }
        // 对每个桶进行排序
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }
        // 合并桶
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }

    }
}
