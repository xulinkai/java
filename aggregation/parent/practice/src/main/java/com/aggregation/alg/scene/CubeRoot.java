package com.aggregation.alg.scene;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/22 下午2:09
 */
public class CubeRoot {

    /**
     * @Desc 立方根
     * @Date 2022/3/22 下午2:09
     **/
    public static double cubeRoot(double num) {
        double left = 0;
        double right = num;
        double mid = (left + right) / 2;
        double ans = mid * mid * mid;
        while (Math.abs(ans - num) > 0.000001) {
            mid = (left + right) / 2;
            ans = mid * mid * mid;
            if ((ans - num) > 0.000001) {
                right = mid;
            } else if ((num - ans) > 0.000001) {
                left = mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        System.out.println(cubeRoot(1000));
        System.out.println(cubeRoot(8));
        System.out.println(cubeRoot(15));
    }


}
