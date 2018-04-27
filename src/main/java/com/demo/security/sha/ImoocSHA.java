package com.demo.security.sha;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @program: demo
 * @description: 慕课网上学习的SHA系列的加密算法
 * @author: Mr.Chen
 * @create: 2018-04-27 16:44
 **/
public class ImoocSHA {

    private static String src = "I am a javaer.";

    public static void main(String [] args){
        System.out.println("------------------------------------------------");
        System.out.println("JDK SHA-1：" + jdkSHA1(src));
        System.out.println("CC SHA-1: " + ccSHA1(src));
        System.out.println("CC SHA-1_1: " + ccSHA1_1(src));
        System.out.println("------------------------------------------------");

    }

    /**
     * JDK SHA-1加密算法
     * @param plaintext 明文
     * @return 密文
     */
    public static String jdkSHA1(String plaintext){
        String result = "";
        try {
            //获取加密对象
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");

            messageDigest.update(plaintext.getBytes());

            result = Hex.encodeHexString(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * CC SHA-1加密算法
     * @param plaintext 明文
     * @return 密文
     */
    public static String ccSHA1(String plaintext){
        return DigestUtils.sha1Hex(plaintext);
    }


    /**
     * CC SHA-1加密算法另一种实现形式
     * @param plaintext
     * @return
     */
    public static String ccSHA1_1(String plaintext){
        return DigestUtils.sha1Hex(plaintext.getBytes());
    }
}
