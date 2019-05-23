package com.hz.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5Util {

    public static final String HEX_CHARS = "0123456789abcdef";
    /** 日志 */
    public static Log logger = LogFactory.getLog(MD5Util.class);
    public MD5Util() {}

   /**
     * 返回 MessageDigest MD5
     */
   private static MessageDigest getDigest() {
       try {
           return MessageDigest.getInstance("MD5");
       } catch (NoSuchAlgorithmException e) {
           throw new RuntimeException(e);
       }
    }

    /**
     * MD5加密，并返回作为一个十六进制字节
     */
    public static byte[] md5(byte[] data) {
        return getDigest().digest(data);
    }

    /**
     * MD5加密，并返回作为一个十六进制字节
     * <code>byte[]</code>.
     * 
     * @param data
     *            Data to digest
     * @return MD5 digest
     */
    public static byte[] md5(String data) {
        byte[] bytes = null;
        try {
            bytes = md5(data.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            logger.error("MD5加密出错。",e);
        }
        return bytes;
    }

    /**
     * MD5加密，并返回一个32字符的十六进制值
     */
    public static String md5Hex(byte[] data) {
        return toHexString(md5(data));
    }

    /**
     * MD5加密，并返回一个32字符的十六进制值
     */
    public static String md5Hex(String data) {
        return toHexString(md5(data));
    }
    
    public static String toHexString(byte[] b) {
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            stringbuffer.append(HEX_CHARS.charAt(b[i] >>> 4 & 0x0F));
            stringbuffer.append(HEX_CHARS.charAt(b[i] & 0x0F));
        }
        return stringbuffer.toString();
    }
 
 
}
