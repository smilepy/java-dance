package com.smilepy.javadance.algorithm;

/**
 * 递归实现冒泡排序
 *
 * @author peiyu
 * @date 2020-8-2 13:33
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] num = {7, 4, 3, 2, 5, 4, 2, 1};
        if (num.length >= 2) {
//            maximumSort(num, num.length - 1);
            minimumSort(num, 0);
        }
        for (int i = 0; i < num.length; i++) {
            System.out.print(String.format("%d,", num[i]));
        }
    }

    /**
     * find the maximum element first
     *
     * @param num
     * @param end
     */
    public static void maximumSort(int[] num, int end) {
        if (end == 0) {
            return;
        } else {
            for (int i = 0; i < end; i++) {
                if (num[i] > num[i + 1]) {
                    int temp = num[i];
                    num[i] = num[i + 1];
                    num[i + 1] = temp;
                }
            }
            maximumSort(num, end - 1);
        }
    }

    /**
     * find the minimum element first
     *
     * @param num
     * @param start
     */
    public static void minimumSort(int[] num, int start) {
        if (start == num.length - 1) {
            return;
        } else {
            for (int i = num.length - 1; i > start; i--) {
                if (num[i] < num[i - 1]) {
                    int temp = num[i - 1];
                    num[i - 1] = num[i];
                    num[i] = temp;
                }
            }
            minimumSort(num, start + 1);
        }
    }
}

