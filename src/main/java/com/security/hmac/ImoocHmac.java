package com.security.hmac;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @program: demo
 * @description: 慕课网上学习的HMAC（消息认证码加密）算法
 * @author: Mr.Chen
 * @create: 2018-04-27 17:18
 **/
public class ImoocHmac {

    public static void main(String [] args){

        String src = "I am a javaer.";

        System.out.println("----------------------------------------");
        System.out.println("JDK HMAC MD5: " + jdkHmacMD5(src));

        System.out.println("----------------------------------------");
    }

    /**
     * HMAC MD5加密算法
     * @param plaintext
     * @return
     */
    public static String jdkHmacMD5(String plaintext){
        String result = "";
        try {
            //初始化KeyGenerator
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
            //产生密钥
            SecretKey secretKey = keyGenerator.generateKey();
            //获得密钥
//            byte[] key = secretKey.getEncoded(); //自动生成密钥
            byte[] key = Hex.decodeHex(new char[]{'a','a','a','a','a','a','a','a','a','a'});  //自定义密钥

            //还原密钥
            SecretKey restoreSecretKey = new SecretKeySpec(key,"HmacMD5");
            //实例化MAC
            Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
            //初始化mac
            mac.init(restoreSecretKey);
            byte[] hmacMD5Bytes = mac.doFinal(plaintext.getBytes());

            result = Hex.encodeHexString(hmacMD5Bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }




}
