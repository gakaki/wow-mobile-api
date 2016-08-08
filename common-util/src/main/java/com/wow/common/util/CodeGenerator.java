package com.wow.common.util;

/**
 * Created by win7 on 2016/8/8.
 */
public class CodeGenerator {

    private static String convertStr(long num,int length){
        return String.format("%0"+length+"d", num%((int)Math.pow(10,length)));
    }

    private static String getRandomTime(int mode,int len) {
        return convertStr(System.nanoTime() % mode, len);
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
        sb.append(getRandomTime(mode,length));
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
        sb.append(getRandomTime(mode,length));
        sb.append(getRandomInt(count));
        return sb.toString();
    }

    /**
     * 生成订单号
     * @param userId
     * @return
     */
    public static String createOrderNo(int userId){
        return createCode(9999,4,3,convertStr(userId,3));
    }

    /**
     * 生成产品code
     * @return
     */
    public static String createProductCode(){
        return createCode(9999,4,4);
    }
}
