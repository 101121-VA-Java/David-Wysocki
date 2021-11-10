package com.revature.models;

public class Bird {
	private int id;
	private int bandnum;
	private String type;
	private String name;
	private boolean isinstock;
	private float price;
	private Customer newOwner;
	public Bird(int id, int bandnum, String type, String name, boolean isinstock, float price, Customer newOwner) {
		super();
		this.id = id;
		this.bandnum = bandnum;
		this.type = type;
		this.name = name;
		this.isinstock = isinstock;
		this.price = price;
		this.newOwner = newOwner;
	}
	public Bird(int bandnum, String type, String name, float price) {
		super();
		this.bandnum = bandnum;
		this.type = type;
		this.name = name;
		this.price = price;
	}
	
	public Bird(int id, int bandnum, String type, String name, boolean isinstock, float price) {
		super();
		this.id = id;
		this.bandnum = bandnum;
		this.type = type;
		this.name = name;
		this.isinstock = isinstock;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBandnum() {
		return bandnum;
	}
	public void setBandnum(int bandnum) {
		this.bandnum = bandnum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isIsinstock() {
		return isinstock;
	}
	public void setIsinstock(boolean isinstock) {
		this.isinstock = isinstock;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Customer getNewOwner() {
		return newOwner;
	}
	public void setNewOwner(Customer newOwner) {
		this.newOwner = newOwner;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bandnum;
		result = prime * result + id;
		result = prime * result + (isinstock ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((newOwner == null) ? 0 : newOwner.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bird other = (Bird) obj;
		if (bandnum != other.bandnum)
			return false;
		if (id != other.id)
			return false;
		if (isinstock != other.isinstock)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (newOwner == null) {
			if (other.newOwner != null)
				return false;
		} else if (!newOwner.equals(other.newOwner))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Bird [id=" + id + ", bandnum=" + bandnum + ", type=" + type + ", name=" + name + ", isinstock="
				+ isinstock + ", price=" + price + ", newOwner=" + newOwner + "]\n";
	}
	
}
