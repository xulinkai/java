package com.aggregation.alg.arr;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午11:46
 */
public class MinLenForNum {

    /**
     * @Desc 给定一个整形数组和一个数字s，找到数组中最短的一个连续子数组，使得连续子数组的数字和sum>=target，返回这个最短的连续子数组的长度值
     * @Date 2022/3/20 下午11:47
     **/
    public int minLenForNum(int[] arr, int target) {
        int sum = 0;
        int l = 0;
        int minLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum >= target) {
                minLen = Math.min(i - l + 1, minLen);
                sum -= arr[l];
                l++;
            }
        }
        return minLen;
    }

    public int minLenForNum1(int[] arr, int target) {
        int head = 0, tail = 0, sum = 0, minLen = Integer.MAX_VALUE;

        while (head < arr.length) {
            sum += arr[head];
            while (sum >= target) {
                minLen = Math.min(minLen, head - tail);
                sum -= arr[tail++];
            }
        }
        return minLen;
    }
}
