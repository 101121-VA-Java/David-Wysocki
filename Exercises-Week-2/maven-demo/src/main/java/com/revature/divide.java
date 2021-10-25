package com.revature;

import com.revature.exceptions.CalculatorException;

public class divide {
	public static void divideThem(double x3, double y3) {
		if(y3 == 0) {
			throw new CalculatorException();
		}
		double z = (x3 / y3);
		System.out.println("Your answer is " + z);
		menu1.menu2();
		
	}
}
