package com.revature.models;

public class Customer {
private int cId;	
private String cName;
private String cUserName;
private String cPassword;
private String cEmail;
private int cCard;
private boolean isGiveawayEligible;
private Role role;

public Customer() {
	super();
}



public Customer(int cId, String cName, String cUserName, String cPassword, String cEmail, int cCard,
		boolean isGiveawayEligible, Role role) {
	super();
	this.cId = cId;
	this.cName = cName;
	this.cUserName = cUserName;
	this.cPassword = cPassword;
	this.cEmail = cEmail;
	this.cCard = cCard;
	this.isGiveawayEligible = isGiveawayEligible;
	this.role = role;
}




public Customer(String cName, String cUserName, String cPassword, String cEmail, boolean isGiveawayEligible,
		Role role) {
	super();
	this.cName = cName;
	this.cUserName = cUserName;
	this.cPassword = cPassword;
	this.cEmail = cEmail;
	this.isGiveawayEligible = isGiveawayEligible;
	this.role = role;
}



public String getcName() {
	return cName;
}
public void setcName(String cName) {
	this.cName = cName;
}
public String getcUserName() {
	return cUserName;
}
public void setcUserName(String cUserName) {
	this.cUserName = cUserName;
}
public String getcPassword() {
	return cPassword;
}
public void setcPassword(String cPassword) {
	this.cPassword = cPassword;
}
public String getcEmail() {
	return cEmail;
}
public void setcEmail(String cEmail) {
	this.cEmail = cEmail;
}
public int getcCard() {
	return cCard;
}
public void setcCard(int cCard) {
	this.cCard = cCard;
}
public boolean isGiveawayEligible() {
	return isGiveawayEligible;
}
public void setGiveawayEligible(boolean isGiveawayEligible) {
	this.isGiveawayEligible = isGiveawayEligible;
}



public int getcId() {
	return cId;
}

public void setcId(int cId) {
	this.cId = cId;
}



public Role getRole() {
	return role;
}



public void setRole(Role role) {
	this.role = role;
}







@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + cCard;
	result = prime * result + ((cEmail == null) ? 0 : cEmail.hashCode());
	result = prime * result + cId;
	result = prime * result + ((cName == null) ? 0 : cName.hashCode());
	result = prime * result + ((cPassword == null) ? 0 : cPassword.hashCode());
	result = prime * result + ((cUserName == null) ? 0 : cUserName.hashCode());
	result = prime * result + (isGiveawayEligible ? 1231 : 1237);
	result = prime * result + ((role == null) ? 0 : role.hashCode());
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
	Customer other = (Customer) obj;
	if (cCard != other.cCard)
		return false;
	if (cEmail == null) {
		if (other.cEmail != null)
			return false;
	} else if (!cEmail.equals(other.cEmail))
		return false;
	if (cId != other.cId)
		return false;
	if (cName == null) {
		if (other.cName != null)
			return false;
	} else if (!cName.equals(other.cName))
		return false;
	if (cPassword == null) {
		if (other.cPassword != null)
			return false;
	} else if (!cPassword.equals(other.cPassword))
		return false;
	if (cUserName == null) {
		if (other.cUserName != null)
			return false;
	} else if (!cUserName.equals(other.cUserName))
		return false;
	if (isGiveawayEligible != other.isGiveawayEligible)
		return false;
	if (role != other.role)
		return false;
	return true;
}



@Override
public String toString() {
	return "Customer [cId=" + cId + ", cName=" + cName + ", cUserName=" + cUserName + ", cPassword=" + cPassword
			+ ", cEmail=" + cEmail + ", cCard=" + cCard + ", isGiveawayEligible=" + isGiveawayEligible + ", role="
			+ role + "]";
}







}
