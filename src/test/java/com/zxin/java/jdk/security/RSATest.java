package com.zxin.java.jdk.security;

import org.junit.Test;

import javax.crypto.Cipher;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RSATest {
	
	@Test
	public void test() throws GeneralSecurityException {
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCQsO8lvLGvqhjj8rvHpRaSPbcKhP+ijQXvznfOjtuAqG6x7iMUM+hY99W5c0fVVCW9kUSKeMnlCgSrxZxcKcvvIwMD3HBKWpPQdr4ScazhHBOI2wq7NGMlMJUmB9xtotCvzrcH/DvwbcmI0ra0fCqYWDHulxCuILv2siF3rO2/lwIDAQAB";
		String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJCw7yW8sa+qGOPyu8elFpI9twqE/6KNBe/Od86O24CobrHuIxQz6Fj31blzR9VUJb2RRIp4yeUKBKvFnFwpy+8jAwPccEpak9B2vhJxrOEcE4jbCrs0YyUwlSYH3G2i0K/Otwf8O/BtyYjStrR8KphYMe6XEK4gu/ayIXes7b+XAgMBAAECgYB0i0/VoautxuDNmtLN+Je5q6QoAQC3uceyZSfzZPZBJ2oiP6JZv4XDQ70O52BQ4LqVetEuiCR3LB6fDUjoo3HzJ/2hAHe3dTyt3W7pSKiIl7cIz5kz9EUXy0OUohFUVnbq3Pul6elQYmUyEwev+yMdMMVhrRCagHQMpAB2y/O7QQJBAPpJeBjjJV6geV0dSCq043Zkhq0fLNn43Ay3C3yBzEhSgOvX5lBcW85U1/aCzPxDdfEUmt7nMmbDGiIoBh+Nec8CQQCT/my3YpW5BoyIRcKKFAPuWgWUqdYtmZQc7Q9wxM4gOVAE4lZtZSCGcZW4hUkAXPVXStzLr2Rnjjk6Yi5atve5AkAPNBlMgbfKaLsWkenJVlWe4npf1830q65KQ3A6LvRGzGQyb1n5NbMJ9JNt0QI8rKhkbZj+w1KHdYCH5KCCmCh3AkAtP89xyrzIk84IJHw0x6XkDLZEHCGWU6zLo1fjPOlhROTIeYO/cvoc4UHL50TIzaNeC0+zH29tkjjBNx/BMMxRAkEA1KZAchL/Qq6eitnO/STCbxWDhHleF3zN3ifVTHCQ36u8PqehW7eQ/bTUNBL9YGMZQI3GK5mX2kBFTKLHq+S54w==";
		String originalStr = "{\"customId\": \"mockCustomMark\",\"cardId\": \"mockCard\",\"type\": \"T001,T002,T003,T004\"}";
		
		String transformation = "RSA/ECB/PKCS1Padding";
		String algorithm = "RSA";
		byte[] encrypt = encrypt(transformation, originalStr.getBytes(), KeyUtils.privateKey(algorithm, privateKey));
		
		byte[] original = decrypt(transformation, encrypt, KeyUtils.publicKey(algorithm, publicKey));
		System.out.println(Base64.getEncoder().encodeToString(encrypt));
		System.out.println(new String(original));
	}
	
	
	/**
	 * 私钥加密
	 * @param transformation
	 * @param original
	 * @param privateKey
	 * @return
	 * @throws GeneralSecurityException
	 */
	public static byte[] encrypt(String transformation, byte[] original, PrivateKey privateKey) throws GeneralSecurityException {
		Cipher cipher = Cipher.getInstance(transformation);
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		byte[] encrypt = cipher.doFinal(original);
		return encrypt;
	}
	
	/**
	 * 公钥解密
	 * @param transformation
	 * @param encrypt
	 * @param publicKey
	 * @return
	 * @throws GeneralSecurityException
	 */
	public static byte[] decrypt(String transformation, byte[] encrypt, PublicKey publicKey) throws GeneralSecurityException{
		Cipher cipher = Cipher.getInstance(transformation);
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		byte[] original = cipher.doFinal(encrypt);
		return original;
	}
	
	
}

