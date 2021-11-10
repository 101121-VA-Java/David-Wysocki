package com.revature.models;


public class Task {

	public Task(String name, boolean isComplete, int tUser) {
		super();
		this.name = name;
		this.isComplete = isComplete;
		this.tUser = tUser;
	}

	private String name;
	private int tId;
	private boolean isComplete;
	private int tUser;
	
	public Task() {
		super();
	}

	public Task(String name, int tId, boolean isComplete, int tUser) {
		super();
		this.name = name;
		this.tId = tId;
		this.isComplete = isComplete;
		this.tUser = tUser;
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

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public int gettUser() {
		return tUser;
	}

	public void settUser(int tUser) {
		this.tUser = tUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isComplete ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + tId;
		result = prime * result + tUser;
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
		if (isComplete != other.isComplete)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tId != other.tId)
			return false;
		if (tUser != other.tUser)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Task [name=" + name + ", tId=" + tId + ", isComplete=" + isComplete + ", tUser=" + tUser + "]";
	}
}	