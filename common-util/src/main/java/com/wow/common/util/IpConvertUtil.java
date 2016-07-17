package com.wow.common.util;

/**
 * ip和数字互相转化工具
 */
public class IpConvertUtil {

    /**
     *将ip转换为数字
     * @param ipAddress
     * @return
     */
    public static long ipToLong(String ipAddress) {
        long result = 0;

        if (StringUtil.isNotBlank(ipAddress)) {
            String[] ipAddressInArray = StringUtil.splitString(ipAddress, ".");
            int ipAddressInArrayLen = ipAddressInArray.length;

            for (int i = 0; i < ipAddressInArrayLen; i++) {
                int power = 3 - i;
                int ip = Integer.parseInt(ipAddressInArray[i]);
                result += ip * Math.pow(256, power);
            }
        }

        return result;
    }

    /**
     *将数字转换为ip
     * @param i
     * @return
     */
    public static String longToIp(long i) {
        StringBuilder sb = new StringBuilder(15);

        sb.append(((i >> 24) & 0xFF)).append(".").append((i >> 16) & 0xFF).append(".").append((i >> 8) & 0xFF)
            .append(".").append(i & 0xFF);

        return sb.toString();
    }

}