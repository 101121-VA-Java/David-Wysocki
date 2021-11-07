package com.revature.models;


public class Task {

	private String name;
	private int tId;
	
	public Task() {
		super();
	}

	public Task(String name, int tId) {
		super();
		this.name = name;
		this.tId = tId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + tId;
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
		Task other = (Task) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tId != other.tId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", tId=" + tId + "]";
	}
	
	
}
