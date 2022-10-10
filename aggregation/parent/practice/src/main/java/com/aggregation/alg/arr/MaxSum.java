package com.aggregation.alg.arr;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午9:43
 */
public class MaxSum {

    /**
     * @Desc 连续子数组的最大和
     * F(n) = Math.max(F(n-1) + arr[n], arr[n])
     * @Date 2022/3/20 下午9:44
     **/
    public int maxSum(int[] arr) {
        int max = arr[0];
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            max = Math.max(max + temp, temp);
            res = Math.max(res, max);
        }
        return res;
    }
}
