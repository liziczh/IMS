package com.liziczh.ims.tools;

import java.security.MessageDigest;

public class MD5Util {
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    /**
     * 转换字节数组为16进制字串
     *
     * @param b
     *            字节数组
     * @return 16进制字串
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /** 将一个字节转化成十六进制形式的字符串     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**  对字符串进行MD5加密     */
    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString
                    .getBytes()));
        } catch (Exception ex) {
        }
        return resultString;
    }

    /**
     * 验证前端输入的密码是否正确，input为前端输入的密码字符串，password为数据库读取的密码
     *
     * @param b
     *            字节数组
     * @return 16进制字串
     */
    public static boolean isValidate(String input,String password){
        boolean status = false;
        if(MD5Util.MD5Encode(input).equals(password)){
            status = true;
        }else{
            status = false;
        }
        return status;
    }

    /**  主方法测试     */
/*    public static void main(String[] args) {
        System.out.println(MD5Encode("123"));
        boolean b = MD5Util.isValidate("123", "21232f297a57a5a743894a0e4a801fc3");
        System.out.println(b);
    }*/
}
