package com.wow.common.util;

/**
 * Created by win7 on 2016/8/8.
 */
public class CodeGenerator {

    private static String getMode(int mode,int len) {
        String valueOf = String.valueOf(System.nanoTime() % mode);
        if (valueOf.length() < len) {
            int count = len-valueOf.length();
            for (int i = 0; i < count; i++) {
                valueOf += "0";
            }
        }
        return valueOf;
    }

    private static String getRandomInt(int count){
        StringBuilder builder=new StringBuilder();
        while(count>0){
            count--;
            builder.append((int)(10*Math.random()));
        }
        return builder.toString();
    }

    /**
     *
     * @param mode 整数,用作模运算
     * @param length 模运算位数
     * @param count 随机数位数
     * @param suffix 后缀
     * @return
     */
    public static String createCode(int mode,int length,int count,String suffix){
        StringBuilder sb = new StringBuilder();
        sb.append(getMode(mode,length));
        sb.append(getRandomInt(count));
        sb.append(suffix);
        return sb.toString();
    }

    /**
     *
     * @param mode 整数,用作模运算
     * @param length 模运算位数
     * @param count 随机数位数
     * @return
     */
    public static String createCode(int mode,int length,int count){
        StringBuilder sb = new StringBuilder();
        sb.append(getMode(mode,length));
        sb.append(getRandomInt(count));
        return sb.toString();
    }

    private static String getMode(int num){
        return String.format("%03d", num%1000);
    }

    /**
     * 生成订单号
     * @param userId
     * @return
     */
    public static String createOrderNo(int userId){
        return createCode(9999,4,3,getMode(userId));
    }

    /**
     * 生成产品code
     * @return
     */
    public static String createProductCode(){
        return createCode(9999,4,4);
    }
}
