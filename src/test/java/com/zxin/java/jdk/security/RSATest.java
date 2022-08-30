package com.zxin.java.jdk.security;

import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RSATest {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, InvalidKeyException {
		String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALcYRPbQEgTpZ2Houu9Kma8dCwGuheYJJPCVVsc3Tmr0q4zkw_V9rcYzN_PKBOGlqr6zUGSRZxRoeos7txVzvpsCAwEAAQ";
		String privateKey = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAtxhE9tASBOlnYei670qZrx0LAa6F5gkk8JVWxzdOavSrjOTD9X2txjM388oE4aWqvrNQZJFnFGh6izu3FXO-mwIDAQABAkApMD17ZG1ZS4RlQyyiXh7ahOcP9snKaO41bPL7l9Z9OrHZByAzVflr2jf-N01Di82J4gcH5uCcO6Z88OKLpP25AiEA3dl7ZUilwsGdJPbeKZ6ng1Qtz7cUo8TchA4HxkJRH6cCIQDTR5AsvsKdzW0vKZgePOoHBR9Mco4Q7TnsBowJwCEn7QIhAJDWo2RN2MLdKx5t-j-L8GuicsJREi2Voi6pBlRfCZ2zAiEAzzRi6A8ZbIt4JgXD4vvYhJP4cw_x1hXhdWGiWzmrCq0CIH5Zd5rxAIOBUoq0NjORzaPZX9FEhIRkRNOzmtoImaq4";
		String original = "{\"customId\": \"mockCustomMark\",\"cardId\": \"mockCard\",\"type\": \"T001,T002,T003,T004\"}";
		
		for (int i = 0; i < 5; i++) {
			original+=original;
		}

	}
}

