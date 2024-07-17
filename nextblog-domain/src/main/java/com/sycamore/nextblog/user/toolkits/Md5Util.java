package com.sycamore.nextblog.user.toolkits;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: Sycamore
 * @date: 2024/7/15 10:08
 * @version: 1.0
 * @description: TODO
 */
public class Md5Util {
    /**
     * 将给定的字符串转换为其MD5散列值。
     *
     * @param input 要转换的字符串
     * @return 字符串的MD5散列值，如果发生异常则返回null
     */
    public static String toMd5(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(input.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    public static void main(String[] args) {
        System.out.println(toMd5("123456"));
    }
}
