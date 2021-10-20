package com.revature;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class taskDriver {

	
	public static void main(String[] args) {
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		Task2 myPractice = new Task2();
		myPractice.setName("David");
		System.out.println(myPractice.getName() + " is stuyding hard on " + dateTime.format(formatter));
		
	}

}
