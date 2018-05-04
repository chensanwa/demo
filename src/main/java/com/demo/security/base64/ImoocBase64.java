package com.demo.security.base64;

import org.codehaus.plexus.util.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @program: demo
 * @description: base64加密算法API
 * @author: Mr.Chen
 * @create: 2018-05-04 20:29
 **/
public class ImoocBase64 {

    /**
     * maven依赖
     * <!--Bouncy Caslte Provider-->
     * <dependency>
     * <groupId>org.bouncycastle</groupId>
     * <artifactId>bcprov-jdk16</artifactId>
     * <version>1.45</version>
     * </dependency>
     */

    public static void main(String[] args) throws Exception {
        String plain = "I am a javaer.";

        System.out.println("JDK base64加密：" + encodeByJdkBase64(plain));
        System.out.println("JDK base64解密：" + decodeByJdkBase64(encodeByJdkBase64(plain)));

        System.out.println("CommonsCodec base64加密：" + encodeByCommonsCodecBase64(plain));
        System.out.println("CommonsCodec base64解密：" + decodeByCommonsCodecBase64(encodeByJdkBase64(plain)));

        System.out.println("BouncyCastle base64加密：" + encodeByBouncyCastleBase64(plain));
        System.out.println("BouncyCastle base64解密：" + decodeByBouncyCastleBase64(encodeByJdkBase64(plain)));

    }

    /**
     * 通过base64的方式进行加密
     * @param plaintext 明文
     * @return 密文
     */
    public static String encodeByJdkBase64(String plaintext){
        String result = "";
        BASE64Encoder encoder = new BASE64Encoder();
        result = encoder.encode(plaintext.getBytes());
        return result;
    }

    /**
     * 通过base64方式进行解密
     * @param ciphertext 密文
     * @return
     */
    public static String decodeByJdkBase64(String ciphertext) throws Exception{
        String result = "";
        try {
            BASE64Decoder decoder = new BASE64Decoder();
            result = new  String (decoder.decodeBuffer(ciphertext));
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    /**
     * 通过CommonsCodes实现Base64的方式进行加密
     * @param plaintext
     * @return
     */
    public static String encodeByCommonsCodecBase64(String plaintext){
        String result = "";
        byte[] encodeBytes = Base64.encodeBase64(plaintext.getBytes());
        result = new String(encodeBytes);
        return result;
    }

    /**
     * 通过CommonsCodes实现Base64的方式进行解密
     * @param ciphertext
     * @return
     */
    public static String decodeByCommonsCodecBase64(String ciphertext){
        String result = "";
        byte[] decodeBytes = Base64.decodeBase64(ciphertext.getBytes());
        result = new String(decodeBytes);
        return result;
    }

    /**
     * 使用BouncyCastle实现的Base64进行加密
     * @param plaintext
     * @return
     */
    public static String encodeByBouncyCastleBase64(String plaintext){
        String result = "";
        byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(plaintext.getBytes());
        result = new String(encodeBytes);
        return result;
    }

    /**
     * 使用BouncyCastle实现的Base64进行解密
     * @param ciphertext
     * @return
     */
    public static String decodeByBouncyCastleBase64(String ciphertext){
        String result = "";
        byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(ciphertext);
        result = new String(decodeBytes);
        return result;
    }

}
