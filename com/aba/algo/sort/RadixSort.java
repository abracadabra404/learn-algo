package com.aba.algo.sort;

import java.util.Arrays;

/**
 * radix sort
 *
 * @program learn-algo
 * @author: abracadabra
 * @create: 2024/06/26 22:11
 */
public class RadixSort {

    public static void main(String[] args) {

        int[] arr = {100, 20, 61, 4, 82, 11, 13, 25, 70};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    /**
     * 基数排序，线性排序算法
     * 对排序的数据是有要求的，需要可以分割出来独立的位，而且位之间有递进的关系，才能使用这个排序方法。
     * 适用于整数或者位数固定的字符串。
     * 步骤：
     *  1. 确定最大位数：取得数组中的最大元素的位数，决定排序的轮次数；
     *  2. 按每个位进行排序：从最低位开始，对每个位进行排序，可以使用计数排序等稳定排序算法对每一位进行排序；
     *  3. 从最低位开始，对每个位进行排序，可以使用计数排序等稳定排序算法对每一位进行排序；
     *  4. 降低位数的值，进行下一位的排序，直到最高位排序完成，完成排序。
     *  复杂度分析：
     *  时间复杂度：O(d(n+k))，d为最大位数，n为数组的长度，k是基数；
     *  空间复杂度：O(n+k)，需要额外的空间来存储计数数组；
     *  是稳定的排序算法，不是原地排序算法。
     * @param: [arr]
     * @return: void
     * @author: abracadabra
     * @date: 2024/6/27 21:48
     */
    public static void radixSort(int[] arr) {
        if (arr==null && arr.length == 0) {
            return;
        }
        // 找到最大数，确定最大位数
        int max = Arrays.stream(arr).max().getAsInt();
        // 按照每个位排序, 从最低位开始
        // 这里使用计数排序，也可以使用其他稳定的排序方法，如快速排序等
        for (int mod = 1; max / mod > 0; mod *= 10) {
            countingSortByDigit(arr, mod);
        }

    }

    private static void countingSortByDigit(int[] arr, int mod) {
        int length = arr.length;
        // 创建一个计数数组，用于统计每个数字出现的次数
        int[] count = new int[10];
        // 创建一个临时数组，用于存储排序后的结果
        int[] temp = new int[length];
        // 统计每个数字出现的次数
        for (int i = 0; i < length; i++) {
            count[(arr[i] / mod) % 10]++;
        }
        // 累加每个数字出现的次数
        for (int i = 1; i < 10; i++) {
            count[i]  += count[i - 1];
        }
        // 按照计数数组中的位置，将数字放到临时数组中。
        // 这里使用倒序遍历，保证排序的稳定性
        // 构建输出数组
        for (int i = length - 1; i >= 0; i--) {
            int index = (arr[i] / mod) % 10;
            temp[count[index] - 1] = arr[i];
            count[index]--;
        }
        // 将临时数组中的排序结果复制到原数组中
        System.arraycopy(temp, 0, arr, 0, length);
    }
}
