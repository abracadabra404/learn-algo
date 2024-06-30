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


    public static int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            // 防止 (low + high) 溢出 , 替换为：low + (high - low) / 2
            // low + (high - low) / 2 替换为 low + ((high - low) >> 1))
//            int mid = low + (high - low) / 2;
            int mid = low + ((high - low) >> 1);
            int midValue = nums[mid];
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
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
