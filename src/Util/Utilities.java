package Util;

import java.util.Random;

public class Utilities {
	private static Utilities instance = null;
	private static Random rand = new Random();
	public static Random getRand() {
		return rand;
	}
	private Utilities() {
		
	}
	public static Utilities getInstance() {
		if (instance == null) {
			instance = new Utilities();
		}
		return instance;
	}
	public void cls() {
		for(int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
	public String generateInitial() {
		char rand1 = generateChar();
		char rand2 = generateChar();
		String initial = String.valueOf(rand1) + rand2;
		return initial;
	}
	private char generateChar() {
		int random = rand.nextInt(26) + 'A';
		return (char) random;
	}
}
