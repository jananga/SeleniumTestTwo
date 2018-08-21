package com.wdg.encription;

import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encription {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("encryption : "+encripto("jananga"));
		
	}

	public static String encripto(String inputText) {
		byte[] input = inputText.getBytes();
		byte[] keyBytes = "1234".getBytes();
		byte[] ivBytes = "input123".getBytes();
		Cipher cipher = null;
		byte[] ciperText = null;
		int ctLength;
		
		
		try {
			
			Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

			SecretKeySpec key = new SecretKeySpec(keyBytes, "DES");
			IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
			cipher.getInstance("DES/CTR/NoPadding", "BC");

			cipher.init(cipher.ENCRYPT_MODE, key, ivSpec);

			ciperText = new byte[cipher.getOutputSize(input.length)];

			ctLength = cipher.update(input, 0, input.length, ciperText, 0);
			
			ctLength += cipher.doFinal(ciperText, ctLength);
			
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			return ciperText.toString();

		}

	}

}
