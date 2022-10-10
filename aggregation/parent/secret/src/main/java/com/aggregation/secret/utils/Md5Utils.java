package com.aggregation.secret.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description:
 */
public class Md5Utils {

    /**
     * 生成签名
     *
     * @param value 数据
     * @return 结果
     */
    public static String generateSignature(String value) {
        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(value.getBytes());
            StringBuilder buffer = new StringBuilder();
            // 把每个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }
            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
