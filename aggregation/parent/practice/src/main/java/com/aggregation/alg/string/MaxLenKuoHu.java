package com.aggregation.alg.string;

import com.google.common.collect.Sets;
import org.apache.commons.lang.StringUtils;

import java.util.HashSet;

/**
 * @Desc
 * @Author xlk
 * @Date 2022/3/20 下午9:37
 */
public class MaxLenKuoHu {


    /**
     * @Desc
     * @Date 2022/3/20 下午9:39
     **/
    public int maxLenKuoHu(String str) {
        if (StringUtils.isBlank(str)) {
            return 0;
        }
        HashSet<Object> objects = Sets.newHashSet();
        int cnt = 0;
        int max = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                cnt++;
            } else {
                cnt--;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }


}
