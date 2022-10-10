package com.aggregation.alg.scene;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午9:54
 */
public class ClimbStairs {

    /**
     * @Desc n阶楼梯 每次只能爬一阶或者两阶 总共有多少种爬法
     * f(n) = f(n-1) + f(n-2)
     * @Date 2022/3/20 下午9:55
     **/
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * @Desc n阶楼梯 每次只能爬一阶或者两阶 总共有多少种爬法
     * f(n) = f(n-1) + f(n-2)
     * @Date 2022/3/20 下午9:55
     **/
    public int climbStairsB(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }


}
