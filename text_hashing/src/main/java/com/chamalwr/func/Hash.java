package com.chamalwr.func;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	
			public String hashText(String password) {
					
					StringBuilder hashedText = new StringBuilder();
			
					try {
						
						MessageDigest sha = MessageDigest.getInstance("SHA-1");
						byte[] hashedBytes = sha.digest(password.getBytes());
						char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
								'a', 'b', 'c', 'd', 'e', 'f' };
						for (int idx = 0; idx < hashedBytes.length; ++idx) {
							byte b = hashedBytes[idx];
							hashedText.append(digits[(b & 0xf0) >> 4]);
							hashedText.append(digits[b & 0x0f]);
						}
					} catch (NoSuchAlgorithmException erx) {
						erx.printStackTrace();
					}
			
					return hashedText.toString();
				}
	
}
