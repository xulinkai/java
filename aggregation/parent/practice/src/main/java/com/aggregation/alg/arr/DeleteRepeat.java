package com.aggregation.alg.arr;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午10:48
 */
public class DeleteRepeat {

    /**
     * @Desc 删除有序数组中的重复项
     * 不相等的时候两个指针一起往前移动，相等的时候 快指针往前移动，慢指针不动
     * @Date 2022/3/20 下午10:48
     **/
    public void deleteRepeat(int[] arr) {
        int i = 1;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i - 1]) {
                arr[i] = arr[j];
                i++;
            }
        }
    }
}
