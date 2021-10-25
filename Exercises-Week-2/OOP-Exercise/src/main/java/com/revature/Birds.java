package com.revature;

public abstract class Birds {
	private String type;
	private String food;

	public Birds(String type) {
		super();
		this.type = type;
	}

	public Birds(String type, String food) {
		super();
		this.type = type;
		this.food = food;

	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	@Override
	public String toString() {
		return  type;
	}
}
