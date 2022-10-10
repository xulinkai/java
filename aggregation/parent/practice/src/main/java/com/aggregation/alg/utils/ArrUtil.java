package com.aggregation.alg.utils;

import java.util.Random;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/21 上午12:00
 */
public class ArrUtil {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void out(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }

    public static int[] getArr(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(50);
        }
        return arr;
    }

    public static void copy(int[] source, int[] target) {
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
    }

}
