package com.smilepy.javadance.algorithm;

/**
 * 递归实现快速排序
 *
 * @author peiyu
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 7, 3, 8, 0, 10, 5};
        if (nums.length >= 2) {
            quickSort(nums, 0, nums.length - 1);
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(String.format("%d,", nums[i]));
        }
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int low = start, high = end;
            int pivot = nums[low];
            while (low < high) {
                while (low < high && nums[high] >= pivot) {
                    high--;
                }
                if (low < high) {
                    nums[low++] = nums[high];
                }
                while (low < high && nums[low] <= pivot) {
                    low++;
                }
                if (low < high) {
                    nums[high--] = nums[low];
                }
            }
            //low和high相等
            nums[low] = pivot;
            quickSort(nums, start, low - 1);
            quickSort(nums, low + 1, end);
        }
    }
}
