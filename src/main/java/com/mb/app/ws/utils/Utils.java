package com.mb.app.ws.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	private final String ALPHABETS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; 
	
	private final Random RANDOM = new SecureRandom();
	
	public String generateUserId(int length) {
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < length; i++) {
			builder.append(ALPHABETS.charAt(RANDOM.nextInt(ALPHABETS.length())));
		}
		return new String(builder);
	}
}
