package org.hqf.tutorials.java.algorithm;

/**
 * @author Frank
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums=new int[]{2,3,4,6};
        int index = binarySearch(nums, 4);
        System.out.println("index = " + index);
    }

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
}
