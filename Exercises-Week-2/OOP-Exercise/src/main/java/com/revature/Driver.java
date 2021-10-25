package com.revature;


public class Driver {

	
	public static void main(String[] args) {
		Birds a = new Caique("Pachinko", "seeds");
		Birds b = new Conure("Larry", "seeds");
		Birds c = new Lorikeet("Maya", "honey");
		
		System.out.println("Good Morning, have you fed the birds?");
		System.out.println("I hope you remember what to feed them!");
		System.out.println("Good Morning " + a +", " + b + " and " + c + "!");
		
		a.getFood();
		b.getFood();
		c.getFood();
		
		System.out.println("Good job, you've fed the birds! Now let's get on with our day.");
	}
}
