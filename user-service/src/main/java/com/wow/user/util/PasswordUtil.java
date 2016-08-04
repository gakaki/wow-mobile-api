package com.wow.user.util;

import java.util.Random;

/**
 * 用户密码辅助
 */
public class PasswordUtil {

    public static String passwordHashGenerate(String pwd) {
        String salt = randomString();
        String res = PasswordUtil.MD5(salt + pwd) + ':' + salt;
        return res;
    }

    public static boolean passwordHashValidate(String pwd, String pwdHash) {
        String[] hash = pwdHash.split(":");
        String hashPart1 = hash[0];
        String hashPart2 = hash[1];
        //已检查没有长度为hash length1的密码了 放心用下面的算法吧
        String pwdDigest = MD5(hashPart2 + pwd);

        return pwdDigest.equals(hashPart1);

    }

    //todo
    private static String randomString() {
        int defaultLen = 32;

        String chars = "";

        String CHARS_LOWERS = "abcdefghijklmnopqrstuvwxyz";
        String CHARS_UPPERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String CHARS_DIGITS = "0123456789";

        if (chars == null || chars.isEmpty()) {
            // is emtpy
            chars = CHARS_LOWERS + CHARS_UPPERS + CHARS_DIGITS;
        }

        String str = "";

        for (int i = 0, lc = chars.length() - 1; i < defaultLen; i++) {
            long mtRandRes = mtRand(0, lc);
            int mtRandResInt = Math.toIntExact(mtRandRes);
            System.out.print(mtRandResInt);
            str += chars.charAt(mtRandResInt);
        }

        return str;
    }

    public static long mtRand(long min, long max) {

        Random rnd = new Random();

        long range = max - min + 1;

        if (range <= 0) {
            return min;
        }

        long value = rnd.nextLong();
        if (value < 0) {
            value = -value;
        }

        return min + value % range;
    }

    public static String MD5(String md5) {
        String res = "";
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            res = sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }

        return res;
    }

}