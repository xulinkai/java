package com.aggregation.alg.scene;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午10:59
 */
public class MaxArea {


    /**
     * @Desc 给出一个非负整数数组，每一个整数表示一个竖立在坐标轴x位置的一堵高度为该整数的墙，选择两堵墙，和x轴构成的容器可以容纳最多的水
     * @Date 2022/3/20 下午10:59
     **/
    public int maxArea(int[] arr) {
        int max = 0;
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            max = Math.max(max, (r - l) * Math.min(arr[l], arr[r]));
            if (arr[l] < arr[r]) {
                l++;
            } else {
                r++;
            }
        }
        return max;
    }
}
