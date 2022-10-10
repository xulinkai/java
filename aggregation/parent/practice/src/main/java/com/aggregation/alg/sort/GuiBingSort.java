package com.aggregation.alg.sort;


import com.aggregation.alg.utils.ArrUtil;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/21 上午12:42
 */
public class GuiBingSort {


    public static void guiBingSort(int[] arr) {
        guiBingSort(arr, 0, arr.length - 1);
    }

    public static void guiBingSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            guiBingSort(arr, left, mid);
            guiBingSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }

        while (p2 <= right) {
            temp[i++] = arr[p2++];
        }
        for (int i1 = 0; i1 < temp.length; i1++) {
            arr[left + i1] = temp[i1];
        }
    }

    public static void main(String[] args) {
        int[] arr = ArrUtil.getArr(50);
        ArrUtil.out(arr);
        guiBingSort(arr);
        ArrUtil.out(arr);
    }

}
