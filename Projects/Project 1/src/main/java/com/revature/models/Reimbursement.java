package com.revature.models;

import java.sql.Timestamp;

public class Reimbursement {
private int id;
private float amount;
private Timestamp submitted;
private Timestamp resolved;
private String description;
private User author;
private User resolver;
private int status;
private int type;

/**
 * Constructor built for the purpose of submitting a User reimbursement.
 * @param id ID of Reimbursement itself
 * @param amount Amount of reimbursement requested
 * @param submitted Time of submission
 * @param description Brief description of reimbursement request
 * @param author User who is submitting request
 * @param status Integer coded to show status of request(Accepted/Denied/Pending)
 * @param type Integer category of reimbursement request(Gas/Food/Other/ect..)
 */
public Reimbursement(int id, float amount, Timestamp submitted, String description, User author, int status, int type) {
	super();
	this.id = id;
	this.amount = amount;
	this.submitted = submitted;
	this.description = description;
	this.author = author;
	this.status = status;
	this.type = type;
}

public Reimbursement(int id, float amount, Timestamp submitted, Timestamp resolved, String description, User author,
		User resolver, int status, int type) {
	super();
	this.id = id;
	this.amount = amount;
	this.submitted = submitted;
	this.resolved = resolved;
	this.description = description;
	this.author = author;
	this.resolver = resolver;
	this.status = status;
	this.type = type;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public float getAmount() {
	return amount;
}

public void setAmount(float amount) {
	this.amount = amount;
}

public Timestamp getSubmitted() {
	return submitted;
}

public void setSubmitted(Timestamp submitted) {
	this.submitted = submitted;
}

public Timestamp getResolved() {
	return resolved;
}

public void setResolved(Timestamp resolved) {
	this.resolved = resolved;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public User getAuthor() {
	return author;
}

public void setAuthor(User author) {
	this.author = author;
}

public User getResolver() {
	return resolver;
}

public void setResolver(User resolver) {
	this.resolver = resolver;
}

public int getStatus() {
	return status;
}

public void setStatus(int status) {
	this.status = status;
}

public int getType() {
	return type;
}

public void setType(int type) {
	this.type = type;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + Float.floatToIntBits(amount);
	result = prime * result + ((author == null) ? 0 : author.hashCode());
	result = prime * result + ((description == null) ? 0 : description.hashCode());
	result = prime * result + id;
	result = prime * result + ((resolved == null) ? 0 : resolved.hashCode());
	result = prime * result + ((resolver == null) ? 0 : resolver.hashCode());
	result = prime * result + status;
	result = prime * result + ((submitted == null) ? 0 : submitted.hashCode());
	result = prime * result + type;
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
	Reimbursement other = (Reimbursement) obj;
	if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
		return false;
	if (author == null) {
		if (other.author != null)
			return false;
	} else if (!author.equals(other.author))
		return false;
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
		return false;
	if (id != other.id)
		return false;
	if (resolved == null) {
		if (other.resolved != null)
			return false;
	} else if (!resolved.equals(other.resolved))
		return false;
	if (resolver == null) {
		if (other.resolver != null)
			return false;
	} else if (!resolver.equals(other.resolver))
		return false;
	if (status != other.status)
		return false;
	if (submitted == null) {
		if (other.submitted != null)
			return false;
	} else if (!submitted.equals(other.submitted))
		return false;
	if (type != other.type)
		return false;
	return true;
}

@Override
public String toString() {
	return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
			+ ", description=" + description + ", author=" + author + ", resolver=" + resolver + ", status=" + status
			+ ", type=" + type + "]";
}




}
