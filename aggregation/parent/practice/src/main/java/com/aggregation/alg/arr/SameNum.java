package com.aggregation.alg.arr;


import com.aggregation.alg.utils.ArrUtil;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午11:58
 */
public class SameNum {

    /**
     * @Desc 给定一个长度为 n 的整数数组 nums，数组中所有的数字都在 0∼n−1 的范围内。
     * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
     * 请找出数组中任意一个重复的数字。
     * 注意：如果某些数字不在 0∼n−1 的范围内，或数组中不包含重复数字，则返回 -1；
     * 数据范围：0≤n≤1000
     * 样例
     * 给定 nums = [2, 3, 5, 4, 3, 2, 6, 7]。返回 2 或 3。
     * @Date 2022/3/20 下午11:58
     **/
    public int sameNum(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            while (i != arr[i]) {
                if (arr[i] == arr[arr[i]]) {
                    return arr[i];
                }
                ArrUtil.swap(arr, i, arr[i]);
            }

        }
        return -1;
    }

    /**
     * @Desc 数组中只有一个数字出现了一次，其它均出现了两次
     * @Date 2022/3/21 上午12:27
     **/
    public int sameNumOneTime(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;
    }


}
