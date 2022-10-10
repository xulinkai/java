package com.aggregation.alg.sort;


import com.aggregation.alg.utils.ArrUtil;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/21 上午12:34
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = partition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = left + 1;
        for (int i = index; i < arr.length; i++) {
            if (arr[i] < arr[pivot]) {
                ArrUtil.swap(arr, index, i);
                index++;
            }
        }
        ArrUtil.swap(arr, index - 1, pivot);
        return index - 1;
    }

    public static void main(String[] args) {
        int[] arr = ArrUtil.getArr(50);
        quickSort(arr);
        ArrUtil.out(arr);
    }
}
