package com.aggregation.alg.string;

import com.google.common.collect.Sets;

import java.util.HashSet;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午9:10
 */
public class MaxLenHuiWen {


    /**
     * @Desc 一个字符串可以构成的最长回文串
     * @Date 2022/3/20 下午9:11
     **/
    public int maxLenHuiWen(String str) {
        char[] chars = str.toCharArray();
        int maxLen = 0;
        HashSet<Character> objects = Sets.newHashSet();
        for (int i = 0; i < chars.length; i++) {
            if (objects.contains(chars[i])) {
                objects.remove(chars[i]);
                maxLen++;
            } else {
                objects.add(chars[i]);
            }
        }
        return objects.isEmpty() ? maxLen * 2 : maxLen * 2 + 1;
    }


}
