package com.aggregation.alg.string;

import org.apache.commons.lang.StringUtils;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午8:57
 */
public class MaxLengthOfCommon {


    /**
     * @Desc 最长公共前缀
     * @Date 2022/3/20 下午9:04
     **/
    public String longestCommonPrefix(String[] arr) {
        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            while (!arr[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (StringUtils.isBlank(prefix)) {
                    return "";
                }
            }
        }
        return prefix;
    }


}
