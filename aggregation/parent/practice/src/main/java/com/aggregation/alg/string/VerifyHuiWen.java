package com.aggregation.alg.string;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午9:18
 */
public class VerifyHuiWen {


    /**
     * @Desc 验证是否是回文串
     * @Date 2022/3/20 下午9:19
     **/
    public static boolean verifyHuiWen(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l <= r) {
            if (str.charAt(l) == str.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(verifyHuiWen("xlkklx"));
        System.out.println(verifyHuiWen("xlkmklx"));
        System.out.println(verifyHuiWen("xlkjlx"));
    }


}
