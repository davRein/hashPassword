package de.dreinerts.hashpassword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
	private String strPassword = "";
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public String hashPwd() {
		System.out.print("Enter password: ");
		try {
			strPassword = br.readLine();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String strGeneratedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			//Add password bytes to digest
			md.update(strPassword.getBytes());
			//Get the hash's bytes 
			byte[] bytes = md.digest();
			//This bytes[] has bytes in decimal format;
			//Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + +0x100, 16).substring(1));
				
			}
			//Get complete hashed password in hex format
			strGeneratedPassword = sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return strGeneratedPassword;
	}
	
}
