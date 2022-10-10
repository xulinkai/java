package com.aggregation.alg.string;

import org.apache.commons.lang.StringUtils;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午9:27
 */
public class SearchMaxLenHuiWen {

    private int index;
    private int len;

    /**
     * @Desc 查找最长回文串
     * @Date 2022/3/20 下午9:27
     **/
    public String searchMaxLen(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            searchMaxLen(str, i, i + 1);
            searchMaxLen(str, i, i);
        }


        return str.substring(index, index + len);
    }

    /**
     * @Desc
     * @Date 2022/3/20 下午9:29
     **/
    public void searchMaxLen(String str, int l, int r) {
        while (l >= 0 && r <= str.length() - 1 && str.charAt(l) == str.charAt(r)) {
            l--;
            r++;
        }

        if (this.len < r - l - 1) {
            this.len = r - l - 1;
            this.index = l + 1;
        }
    }


}
