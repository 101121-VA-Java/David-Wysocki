package com.revature;

import java.util.Random;
import java.util.Scanner;

public class ScannerPractice {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menuScreen();
	}

	public static void menuScreen() {
		System.out.println("Welcome! Please select one of the available options:");
		System.out.println("Option 1 - Get a Random Number!");
		System.out.println("Option 2 - Reverse your word!");
		System.out.println("Option 3 - Exit!");

		int num = sc.nextInt();
		sc.nextLine();
		while (num !=  4) {
			if (num == 1) {
				Random rand = new Random();
				int randint = rand.nextInt(100);
				System.out.println("Your random number is: " + randint);
				menuScreen();
				break;
			}
			if (num == 2) {
				System.out.println("Enter your word!");
				String s = sc.nextLine();
				StringBuilder sb = new StringBuilder(s);
				System.out.println(sb.reverse());
				menuScreen();
				break;
			}
			else {
				System.out.println("Understandable, have a nice day");
				sc.close();
				break;
			}
		}
	}
}
