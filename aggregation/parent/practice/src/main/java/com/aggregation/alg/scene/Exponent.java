package com.aggregation.alg.scene;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午10:13
 */
public class Exponent {

    public double power(double base, int exponent) {
        double result = 1.0;
        for (int i = 0; i < Math.abs(exponent); i++) {
            result = result * base;
        }
        if (exponent > 0) {
            return result;
        }
        return 1 / result;
    }
}
