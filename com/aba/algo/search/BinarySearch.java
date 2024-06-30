package com.aba.algo.search;

/**
 * binary search
 *
 * @program learn-algo
 * @author: abracadabra
 * @create: 2024/06/30 14:12
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
//        System.out.println(binarySearch(nums, target));
        System.out.println(binarySearchRecursive(nums,0,nums.length-1, target));
    }

    /**
     * 二分查找：
     *  1. 数据必须是通过顺序表存储的数据结构，因为需要用索引下标随机访问元素
     *  2. 数组必须是有序的
     *  3. 数组中不能有重复元素，因为无法确定返回的是哪个元素
     *  4. 只能用在插入，删除操作不频繁，一次排序多次查找的场景。更适合静态数据
     *  5. 查找效率高，时间复杂度为O(logn)
     *  6. 因为使用的是数组，数组为了支持随机访问的特性，所以需要连续的内存空间，对内存要求比较苛刻
     * @param: [nums, target]
     * @return: int
     * @author: abracadabra
     * @date: 2024/6/30 14:39
     */
    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        //  注意：这里使用 <= ，是为了防止数组越界. 退出条件不是low<high,而是low<=high
        while (low <= high) {
            // 防止 (low + high) 溢出 , 替换为：low + (high - low) / 2
            // low + (high - low) / 2 替换为 low + ((high - low) >> 1))
//            int mid = low + (high - low) / 2;
            int mid = low + ((high - low) >> 1);
            int midValue = nums[mid];
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                // 注意：这里使用的是 low = mid + 1;
                // 因为如果使用 low = mid，high = mid,可能会发生死循环，当low=high=3，若a[3]!=target,无法退出循环
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] nums, int low, int high, int target) {
        if (nums == null || nums.length==0 || low > high)
            return -1;
        int mid = low + ((high - low) >> 1);
        int midValue = nums[mid];
        if (midValue == target) {
            return mid;
        } else  if (midValue < target) {
            return binarySearchRecursive(nums, mid + 1, high, target);
        } else {
            return binarySearchRecursive(nums, low, mid - 1, target);
        }
    }
}
