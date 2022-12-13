package com.zxin.java.jdk.security;

import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author zxin
 */
public class SecureRandomTest {
    
    @Test
    public void generateKey() throws NoSuchAlgorithmException {
        String algorithm = "AES";
        String seed = "123456789012345678901234";
        int keysize = 192;
    
        generateRandomKey(algorithm, keysize, seed);
    }
    
    private SecretKey generateRandomKey(String algorithm, int keysize, String seed) throws NoSuchAlgorithmException {
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(seed.getBytes());
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        keyGenerator.init(keysize, secureRandom);
        return keyGenerator.generateKey();
    }
    
    /**
     * 生产RNG
     * @param seed
     * @return
     * @throws GeneralSecurityException
     */
    public static SecureRandom secureRandom(String algorithm, String seed) throws GeneralSecurityException {
//        SecureRandom secureRandom = new SecureRandom(seed); //"SHA1PRNG"
        SecureRandom secureRandom = SecureRandom.getInstance(algorithm);
        secureRandom.setSeed(seed.getBytes());
        return secureRandom;
    }
    
    /**
     * 加密
     * @param transformation
     * @param key
     * @param originalText
     * @return
     * @throws GeneralSecurityException
     */
    public static byte[] encrypt(String transformation, Key key, byte[] originalText) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] cipherText = cipher.doFinal(originalText);
        return cipherText;
    }
    
    /**
     * 解密
     * @param transformation
     * @param key
     * @param cipherText
     * @return
     * @throws GeneralSecurityException
     */
    public static byte[] decrypt(String transformation, Key key, byte[] cipherText) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance(transformation);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] originalText = cipher.doFinal(cipherText);
        return originalText;
    }
    
}
