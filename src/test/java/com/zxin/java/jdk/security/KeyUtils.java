package com.zxin.java.jdk.security;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @author zxin
 */
public class KeyUtils {
    
    /**
     * Key对象 转 Base64密钥字符串
     * @param key
     * @return
     */
    public static String keyBase64Str(Key key){
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
    
    /**
     * base64密钥字符串 转 key对象
     * @param algorithm
     * @param keyBase64Str
     * @return
     */
    public static SecretKey key(String algorithm, String keyBase64Str){
        byte[] key = Base64.getDecoder().decode(keyBase64Str);
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, algorithm);
        return secretKeySpec;
    }
  
    /**
     * 生成密钥
     * @param algorithm
     * @return
     * @throws GeneralSecurityException
     */
    public static SecretKey generateKey(String algorithm) throws GeneralSecurityException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
//        keyGenerator.init(keysize, secureRandom);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey;
    }
    
    
    /**
     * 生成随记序列对象 RNG
     * @param seed  "123456789012345678901234"
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
     * 生成非对称密钥对
     * @param algorithm
     * @return
     * @throws GeneralSecurityException
     */
    public static KeyPair generateKeyPair(String algorithm) throws GeneralSecurityException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        //		keyPairGenerator.initialize(2048);
        return keyPairGenerator.generateKeyPair();
    }
    
    /**
     * 转换 成 公钥对象
     * @param algorithm RSA
     * @param publicKeyBase64Str
     * @return
     * @throws GeneralSecurityException
     */
    public static PublicKey publicKey(String algorithm, String publicKeyBase64Str) throws GeneralSecurityException{
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKeyBase64Str));
        PublicKey publicKey = keyFactory.generatePublic(x509KeySpec);
        return publicKey;
    }
    
    /**
     * 转换 成 私钥对象
     * @param algorithm RSA
     * @param privateKeyBase64Str
     * @return
     * @throws GeneralSecurityException
     */
    public static PrivateKey privateKey(String algorithm, String privateKeyBase64Str) throws GeneralSecurityException {
        KeyFactory keyFactory = KeyFactory.getInstance(algorithm);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyBase64Str));
        PrivateKey key = keyFactory.generatePrivate(pkcs8KeySpec);
        return key;
    }
    
}
