package com.zxin.java.jdk.security;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.security.GeneralSecurityException;
import java.security.Key;

/**
 *
 * https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#Cipher
 * cn.hutool.crypto.KeyUtil
 * cn.hutool.crypto.symmetric.AES
 * @author zxin
 */
public class AESTest {
    
    @Test
    public void generateKey() throws GeneralSecurityException {
        String originalStr = "{\"customId\": \"mockCustomMark\",\"cardId\": \"mockCard\",\"type\": \"T001,T002,T003,T004\"}";
    
        String transformation = "AES/ECB/PKCS5Padding";
        String algorithm = "AES";
        SecretKey key = KeyUtils.generateKey(algorithm);
        
        byte[] encrypt = encrypt(transformation, originalStr.getBytes(), key);
        byte[] original = decrypt(transformation, encrypt, key);
        System.out.println(new String(original));
    
    }
    
    
    /**
     * 加密
     * @param transformation
     * @param original
     * @param key
     * @return
     * @throws GeneralSecurityException
     */
    public static byte[] encrypt(String transformation, byte[] original, Key key) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypt = cipher.doFinal(original);
        return encrypt;
    }
    
    /**
     * 解密
     * @param transformation
     * @param encrypt
     * @param key
     * @return
     * @throws GeneralSecurityException
     */
    public static byte[] decrypt(String transformation, byte[] encrypt, Key key) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.DECRYPT_MODE, key);
//        cipher.init(mode, key, iv);
        byte[] original = cipher.doFinal(encrypt);
        return original;
    }
    
}
