package me.finlayson.ryan.framework.util;

import java.util.Random;

public class RandomNumberGenerator {
	
	public static Random rand = new Random();
	
	public static int getRandIntBetween(int lowerBound, int upperBound){
		return rand.nextInt(upperBound - lowerBound) + lowerBound;
	}
	
	public static int getRandInt(int upperBound){
		return rand.nextInt(upperBound);
	}
	
	

}
