package com.wow.user.util;

import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * 用户密码辅助
 */
public class PasswordUtil {

    public String magento_pwd(String pwd) throws NoSuchAlgorithmException {

        String salt             = this.randomString();
        String res              = PasswordUtil.MD5( salt + pwd ) + ':' + salt;
        return res;

    }

    //todo
    private String randomString(){
        int length_default  = 32;
        String chars        = "";

        String CHARS_LOWERS   = "abcdefghijklmnopqrstuvwxyz";
        String CHARS_UPPERS   = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String CHARS_DIGITS   = "0123456789";

        if ( chars == null || chars.isEmpty() ) {
            // is emtpy
            chars  = CHARS_LOWERS + CHARS_UPPERS + CHARS_DIGITS;
        }

        String str = "";

        // console.log("lenght chars is ",length_chars); // red green blue

        for ( int i = 0,  lc = chars.length() - 1 ; i < length_default; i++) {
            long mt_rand_res = this.mt_rand(0, lc);
            // console.log(mt_rand_res); // red green blue
//            str  += chars[mt_rand_res];
        }

        return str;
    }

    public static long mt_rand( long min, long max){

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

    public static String MD5(String md5) throws NoSuchAlgorithmException {
        String res = "";
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            res =  sb.toString();
        }
        catch (java.security.NoSuchAlgorithmException e) {
            throw e;
        }finally {
            return res;
        }
    }

}
