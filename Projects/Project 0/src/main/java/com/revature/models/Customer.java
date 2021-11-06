package com.revature.models;

public class Customer {
private String cName;
private String cUserName;
private String cPassword;
private String cEmail;
private int cCard;
private boolean isGiveawayEligible;
private static Role role;

public Customer() {
	super();
}
public Customer(String cName, String cUserName, String cPassword, String cEmail, int cCard,
		boolean isGiveawayEligible) {
	super();
	this.cName = cName;
	this.cUserName = cUserName;
	this.cPassword = cPassword;
	this.cEmail = cEmail;
	this.cCard = cCard;
	this.isGiveawayEligible = isGiveawayEligible;
}
public Customer(String cName, String cUserName, String cPassword) {
	super();
	this.cName = cName;
	this.cUserName = cUserName;
	this.cPassword = cPassword;
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
public static Role getRole() {
	return role;
}
public static void setRole(Role role) {
	Customer.role = role;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + cCard;
	result = prime * result + ((cEmail == null) ? 0 : cEmail.hashCode());
	result = prime * result + ((cName == null) ? 0 : cName.hashCode());
	result = prime * result + ((cPassword == null) ? 0 : cPassword.hashCode());
	result = prime * result + ((cUserName == null) ? 0 : cUserName.hashCode());
	result = prime * result + (isGiveawayEligible ? 1231 : 1237);
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
	return true;
}
@Override
public String toString() {
	return "Customer [cName=" + cName + ", cUserName=" + cUserName + ", cPassword=" + cPassword + ", cEmail=" + cEmail
			+ ", cCard=" + cCard + ", isGiveawayEligible=" + isGiveawayEligible + "]";
}


}
