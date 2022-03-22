package com.group9.gametime.servlets.helpers;

import java.util.ArrayList;
import java.util.Random;

public class RandomPasswordGenerator {
	private static RandomPasswordGenerator instance;
	private ArrayList<String> randomPassRecord = new ArrayList<String>();
	
	private RandomPasswordGenerator() {}
	
	public static RandomPasswordGenerator getInstance() {
		if ( instance == null ) {
			instance = new RandomPasswordGenerator();
		}
		return instance;
	}
	

	public synchronized String getRandomPassword() {
		String randomPassword = randomChars(12);
		
		//iterate through short codes to ensure new one is unique if array is not empty
		if ( randomPassRecord.size() != 0 ) {
			for ( String generatedShortCode: randomPassRecord ) {
				if ( generatedShortCode == randomPassword) {
					//if not short code isn't unique, generate a new one
					this.getRandomPassword();
				}
			}
		}
		//add new short code to array
		this.randomPassRecord.add(randomPassword);
		return randomPassword;
	}

	//method is from assignment 4 codebase @author jesus
	private String randomChars(int n) {
		String randomchars = "";
		String chars = "abcdefghijklmnopqrstuvwxyz1234567890#!?.<>[]";
		Random rnd = new Random();
		for (int i = 0; i < n; i++) {
			randomchars += chars.charAt(rnd.nextInt(chars.length()));
		}
		return randomchars;
	}
}
