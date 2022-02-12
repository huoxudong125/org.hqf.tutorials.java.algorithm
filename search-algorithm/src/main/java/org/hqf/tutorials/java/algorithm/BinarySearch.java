package org.hqf.tutorials.java.algorithm;

/**
 * @author Frank
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 6};
        int index = binarySearch(nums, 4);
        System.out.println("index = " + index);

        index = binarySearchR(nums, 4, 0, nums.length);
        System.out.println("index = " + index);
    }

    /**
     * 非递归方式查找
     *
     * @param nums
     * @param key
     * @return
     */
    public static int binarySearch(int[] nums, int key) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (nums[middle] == key) {
                return middle;
            } else if (nums[middle] > key) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 递归方法查找
     *
     * @param nums
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int binarySearchR(int[] nums, int key, int low, int high) {
        if (low > high) {
            return -1;
        }

        int middle = low + (high - low) / 2;

        if (nums[middle] == key) {
            return middle;
        } else if (nums[middle] > key) {
            return binarySearchR(nums, key, low, middle - 1);
        } else {
            return binarySearchR(nums, key, low, middle - 1);
        }


    }
}
