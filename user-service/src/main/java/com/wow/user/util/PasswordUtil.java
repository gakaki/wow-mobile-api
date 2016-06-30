package com.wow.user.util;

import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * 用户密码辅助
 */
public class PasswordUtil {

    public static String passwordHashGenerate(String pwd) throws NoSuchAlgorithmException {

        String salt             = randomString();
        String res              = PasswordUtil.MD5( salt + pwd ) + ':' + salt;

        return res;

    }
    public static boolean passwordHashValidate(String pwd,String pwdHash) throws NoSuchAlgorithmException {

        String[] hash              = pwdHash.split(":");
        String hash_part_1         = hash[0];
        String hash_part_2         = hash[1];

        //已检查没有长度为hash length1的密码了 放心用下面的算法吧
        String entrypat_str        = MD5(hash_part_2 + pwd);

        if( entrypat_str.equals(hash_part_1) ){
            return true;
        }

        return false;
    }
    //todo
    private static String randomString(){
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
            long mt_rand_res = mt_rand(0, lc);
            int  mt_rand_res_int = Math.toIntExact(mt_rand_res);
            System.out.print( mt_rand_res_int) ;
            str  += chars.charAt(mt_rand_res_int);
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
