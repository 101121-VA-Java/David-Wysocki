package com.revature;

public class prime {
	public static void isPrime(int a) {
		boolean check = false;
		for (int i = 2; i <= a / 2; i++) {
			if (a % i == 0) {
				check = true;
			}
		} if (!check) {
			System.out.println(a + " is a prime number");
		menu1.menu2();
	} 
		else {
			System.out.println(a + " is not a prime number");
		menu1.menu2();
		}
	}
	
}
