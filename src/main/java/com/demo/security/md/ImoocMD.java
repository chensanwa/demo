package com.demo.security.md;

import net.sourceforge.jtds.util.MD4Digest;
import net.sourceforge.jtds.util.MD5Digest;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: demo
 * @description: 慕课网上学习的MD加密算法
 * @author: Mr.Chen
 * @create: 2018-04-26 22:03
 **/
public class ImoocMD {

    private static String src = "I am a javaer.";

    public static void main(String [] args){
        System.out.println("---------------------------------------------");
        System.out.println("JDK MD5:" + jdkMD5(src));
        System.out.println("JDK MD2:" + jdkMD2(src));
        System.out.println("BC MD4:" + bcMD4(src));
        System.out.println("BC MD5:" + bcMD5(src));
        System.out.println("CC MD5:" + ccMD5(src));
        System.out.println("CC MD2:" + ccMD2(src));
        System.out.println("---------------------------------------------");
    }

    /**
     * 利用JDK MD5加密
     * @param plaintext 待加密字符串
     * @return  加密后的十六进制表示密文
     */
    public static String jdkMD5(String plaintext){
        String result = "";
        try {
            //获得MD对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //加密生成byte数组
            byte[] md5Bytes = messageDigest.digest(plaintext.getBytes());
            //将加密后的数组进行转换为16进制字符串
            result = Hex.encodeHexString(md5Bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 利用JDK MD2加密
     * @param plaintext 明文
     * @return  密文
     */
    public static String jdkMD2(String plaintext){
        String result = "";
        try {
            //获得MD对象
            MessageDigest messageDigest = MessageDigest.getInstance("MD2");
            //加密生成byte数组
            byte[] md2Bytes = messageDigest.digest(plaintext.getBytes());
            //将加密后的数组进行转换为16进制字符串
            result = Hex.encodeHexString(md2Bytes);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 利用Bouncy Castle MD4加密
     * @param plaintext 明文
     * @return 密文
     */
    public static String bcMD4(String plaintext){
//        Security.addProvider(new BouncyCastleProvider())
        //创建加密对象
        MD4Digest digest = new MD4Digest();

        digest.update(plaintext.getBytes(),0,plaintext.getBytes().length);
        byte [] md4Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md4Bytes,0);
        String result = Hex.encodeHexString(md4Bytes);
        return result;
    }

    /**
     * 利用Bouncy Castle MD5加密
     * @param plaintext 明文
     * @return 密文
     */
    public static String bcMD5(String plaintext){
        //创建加密对象
        MD5Digest digest = new MD5Digest();

        digest.update(plaintext.getBytes(),0,plaintext.getBytes().length);
        byte [] md5Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md5Bytes,0);
        String result = Hex.encodeHexString(md5Bytes);
        return result;
    }

    /**
     * CC MD5加密
     * @param plaintext 明文
     * @return 密文
     */
    public static String ccMD5(String plaintext){
        return DigestUtils.md5Hex(plaintext.getBytes());
    }

    /**
     * CC MD2加密
     * @param plaintext 明文
     * @return 密文
     */
    public static String ccMD2(String plaintext){
        return DigestUtils.md2Hex(plaintext.getBytes());
    }
}
