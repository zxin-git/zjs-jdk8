package com.zxin.java.jdk.security;

import lombok.extern.slf4j.Slf4j;

import java.security.Provider;
import java.security.Security;
import java.util.Arrays;

@Slf4j
public class SecurityTest {

	public static void main(String[] args) {
		// 安全厂商
		Arrays.stream(Security.getProviders()).forEach((p) -> System.out.println(p+"\t\t\t"+p.getInfo()));

		Security.getAlgorithms("Signature").stream().forEach(System.out::println);
		Security.getAlgorithms("MessageDigest").stream().forEach(System.out::println);

	}
}

