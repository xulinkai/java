package com.aggregation.alg.arr;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午10:18
 */
public class ModifyArrOrder {


    /**
     * @Desc 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * 分析：这道题有挺多种解法的，给大家介绍一种我觉得挺好理解的方法：
     * 我们首先统计奇数的个数假设为n,然后新建一个等长数组，然后通过循环判断原数组中的元素为偶数还是奇数。
     * 如果是则从数组下标0的元素开始，把该奇数添加到新数组；如果是偶数则从数组下标为n的元素开始把该偶数添加到新数组中。
     * @Date 2022/3/20 下午10:18
     **/
    public void modifyArrOrder(int[] arr) {
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                oddCount++;
            }
        }
        int oddBegin = 0;
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                temp[oddBegin++] = arr[i];
            } else {
                temp[oddCount++] = arr[i];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }
    }
}
