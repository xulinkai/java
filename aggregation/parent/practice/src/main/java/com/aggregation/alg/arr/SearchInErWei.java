package com.aggregation.alg.arr;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午10:03
 */
public class SearchInErWei {


    public boolean searchInErWei(int[][] arr, int target) {
        int column = 0;
        int row = arr.length - 1;
        while (row >= 0 && column <= arr[0].length - 1) {
            if (arr[row][column] > target) {
                row--;
            } else if (arr[row][column] < target) {
                column++;
            } else {
                return true;
            }
        }
        return false;
    }


}
