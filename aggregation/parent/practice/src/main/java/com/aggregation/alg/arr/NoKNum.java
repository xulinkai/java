package com.aggregation.alg.arr;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午11:18
 */
public class NoKNum {

    /**
     * @Desc 在数组中找到第k大的元素
     * 取基准元素，将元素分为两个集合，一个集合元素比基准小，另一个比基准大 ，三种情况。
     * 1.比基准大的元素数目标志位m正好为k-1，基准就是目的元素。
     * 2.比基准大的元素标志位m小于k, 那么就在比基准小的集合里面找第(k-m)大的元素
     * 3.若是比基准大的元素为m大于k，那就继续在该集合里面找第k大的元素。
     * @Date 2022/3/20 下午11:18
     **/
    public int noKNum(int[] arr, int k, int left, int right) {
        int partition = partition(arr, left, right);
        if (partition == k - 1) {
            return partition;
        } else if (partition > k - 1) {
            return noKNum(arr, k, left, partition - 1);
        } else {
            return noKNum(arr, k - partition, partition + 1, right);
        }
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = left;
        int index = left + 1;
        for (int i = index; i <= arr.length; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
