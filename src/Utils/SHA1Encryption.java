package Utils;
/*
 Copyright (c) 2020.5--2020.5 221801222-郑茂基 All rights reserved.
 工具类：对密码进行SHA加密
 输入为初始密码字符串
 输出为加密后的密文字符串
*/
import java.security.MessageDigest;

public class SHA1Encryption {
    public static String getSHA1(String mes)
    {

        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
            mdTemp.update(mes.getBytes("UTF-8"));
            byte[] md = mdTemp.digest();
            int j = md.length;
            char buf[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
                buf[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(buf);
        } catch (Exception e) {
            return null;
        }
    }
}
