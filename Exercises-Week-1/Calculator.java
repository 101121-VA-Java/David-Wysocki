import java.util.Scanner;

public class Calculator {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
    	menu1();
	}
	public static void menu1()

	{
		System.out.println("Welcome to the Calculator! To whom do I have the pleasure of working with today?");
		String name = sc.nextLine();
		System.out.println("Nice to meet you " + name + ", let's get started!");
		menu2();
	}
	public static void menu2() {
		System.out.println("Please select from the list of the available options:");
		System.out.println("Option 1: Add 2 numbers");
		System.out.println("Option 2: Subtract 2 numbers");
		System.out.println("Option 3: Multiply 2 numbers");
		System.out.println("Option 4: Divide 2 numbers");
		System.out.println("Option 5: Pick a day of the week");
		
		int num = sc.nextInt();
		while(num != 6) {
			if (num == 1)
	}
	// Basic Variable declaration for use
	float a = 
	float b = 
	static float outputadd = addition(a, b);
	static float outputsub = subtraction(a, b);
	static float outputmulti = multiplication(a, b);
	static float outputdiv = division(a, b);

	/*
	 * method declaration: [access modifier] [non-access modifier] [return type]
	 * [name of method] ([param 1], [param 2])
	 */

	}

	

	}

	// Days of Week Switch Statement
	public String daysOfTheWeek(String daysArg) {
		String dayOfWeek;
		switch (daysArg) {
		case "Monday":
			dayOfWeek = "Monday, Garfields most dreaded day of the week.";
			break;
		case "Tuesday":
			dayOfWeek = "Tuesday, Slightly better than yesterday..";
			break;
		case "Wednesday":
			dayOfWeek = "Wednesday, As a once famous camel has once said, 'HUMP DAY!'";
			break;
		case "Thursday":
			dayOfWeek = "A fantastic day for tacos.";
			break;
		case "Friday":
			dayOfWeek = "One last push and work is done for the weekend!";
			break;
		case "Saturday":
			dayOfWeek = "Sorry, the office is closed.";
			break;
		case "Sunday":
			dayOfWeek = "Sorry bud, office is still closed. Try again tomorrow.";
		default:
			dayOfWeek = "Excuse me, that day doesn't exist. Try again.";

		}

		System.out.println(dayOfWeek);
		return dayOfWeek;
	}

	// Declaring methods used in a calculator
	public static float addition(float a, float b) {
		return (a + b);
	}

	public static float subtraction(float a, float b) {
		return (a - b);
	}

	public static float multiplication(float a1, float b1) {
		return (a1 * b1);
	}

	public static float division(float a1, float b1) {
		return (a1 / b1);
	}

}
