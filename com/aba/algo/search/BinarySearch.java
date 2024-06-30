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
        int[] nums = {-1, 0, 3, 5, 9, 9, 9, 12};
        int target = 4;
//        System.out.println(binarySearch(nums, target));
//        System.out.println(binarySearchRecursive(nums,0,nums.length-1, target));
//        System.out.println(binarySearchVariableFirstTarget(nums, target));
//        System.out.println(binarySearchVariableLastTarget(nums, target));
//        System.out.println(binarySearchVariableFirstGeTarget(nums,target));
        System.out.println(binarySearchVariableLastLeTarget(nums,target));
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


    /**
     * 二分查找的变种1:
     * 查找第一个与 target 相等的元素，返回其索引
     * @param: [nums, target]
     * @return: int
     * @author: abracadabra
     * @date: 2024/6/30 15:05
     */
    public static int binarySearchVariableFirstTarget(int[] nums, int target) {
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
            if (midValue < target) {
                // 注意：这里使用的是 low = mid + 1;
                // 因为如果使用 low = mid，high = mid,可能会发生死循环，当low=high=3，若a[3]!=target,无法退出循环
                low = mid + 1;
            } else if (midValue > target){
                high = mid - 1;
            } else {
                // midValue == target
                // 要查找第一个等于给定值的元素，就继续查找左边的元素
                // mid=0,这个元素是第一个等于给定值的元素，直接返回,如果mid前一个元素!=target,这个元素也是第一个出现的
                if ((mid == 0) || (nums[mid - 1] != target)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找变种2:
     *  查找最后一个等于给定值的元素
     * @param: [nums, target]
     * @return: int
     * @author: abracadabra
     * @date: 2024/6/30 19:57
     */
    public static int binarySearchVariableLastTarget(int[] nums, int target) {
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
            if (midValue < target) {
                // 注意：这里使用的是 low = mid + 1;
                // 因为如果使用 low = mid，high = mid,可能会发生死循环，当low=high=3，若a[3]!=target,无法退出循环
                low = mid + 1;
            } else if (midValue > target){
                high = mid - 1;
            } else {
                // midValue == target
                // 要查找第一个等于给定值的元素，就继续查找左边的元素
                // 如果mid是数组的最后一个元素
                // 或者 mid的下一个元素不等于给定值，则mid就是最后一个出现的
                if ((mid == nums.length-1) || (nums[mid + 1] != target)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找变种3:
     *  查找第一个大于等于给定值的元素
     * @param: [nums, target]
     * @return: int
     * @author: abracadabra
     * @date: 2024/6/30 19:59
     */
    public static int binarySearchVariableFirstGeTarget(int[] nums, int target) {
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
            if (midValue >= target) {
                // 如果nums[mid] 前面没有元素，或者 nums[mid-1]< target, 则mid就是第一个大于等于给定值的元素;
                // 否则，查找的值在[low,mid-1]之间
                if ((mid == 0) || (nums[mid - 1] < target)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                // 如果midValue < target, 则查找的值在[mid+1,high]之间
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变种4:
     *  查找最后一个小于等于给定值的元素
     * @param: [nums, target]
     * @return: int
     * @author: abracadabra
     * @date: 2024/6/30 20:13
     */
    public static int binarySearchVariableLastLeTarget(int[] nums, int target) {
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
            if (midValue <= target) {
                // 如果nums[mid] 后面没有元素，或者 nums[mid+1] > target, 则mid就是第一个小于等于给定值的元素;
                // 否则，查找的值在[mid+1,high]之间
                if ((mid == nums.length -1) || (nums[mid + 1] > target)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else {
                // 如果midValue > target, 则查找的值在[low,mid-1]之间
                high = mid - 1;
            }
        }
        return -1;
    }
}
