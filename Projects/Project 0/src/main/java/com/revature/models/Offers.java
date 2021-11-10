package com.revature.models;

public class Offers {
private int offerId;
private int custId;
private int itemId;
private float offerAmount;
private boolean isAccepted;
public Offers(int offerId, int custId, int itemId, float offerAmount, boolean isAccepted) {
	super();
	this.offerId = offerId;
	this.custId = custId;
	this.itemId = itemId;
	this.offerAmount = offerAmount;
	this.isAccepted = isAccepted;
}
public Offers(int custId, int itemId, float offerAmount) {
	super();
	this.custId = custId;
	this.itemId = itemId;
	this.offerAmount = offerAmount;
}
public int getOfferId() {
	return offerId;
}
public void setOfferId(int offerId) {
	this.offerId = offerId;
}
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public float getOfferAmount() {
	return offerAmount;
}
public void setOfferAmount(float offerAmount) {
	this.offerAmount = offerAmount;
}
public boolean isAccepted() {
	return isAccepted;
}
public void setAccepted(boolean isAccepted) {
	this.isAccepted = isAccepted;
}
@Override
public String toString() {
	return "Offers [offerId=" + offerId + ", custId=" + custId + ", itemId=" + itemId + ", offerAmount=" + offerAmount
			+ ", isAccepted=" + isAccepted + "]\n";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + custId;
	result = prime * result + (isAccepted ? 1231 : 1237);
	result = prime * result + itemId;
	result = prime * result + Float.floatToIntBits(offerAmount);
	result = prime * result + offerId;
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
	Offers other = (Offers) obj;
	if (custId != other.custId)
		return false;
	if (isAccepted != other.isAccepted)
		return false;
	if (itemId != other.itemId)
		return false;
	if (Float.floatToIntBits(offerAmount) != Float.floatToIntBits(other.offerAmount))
		return false;
	if (offerId != other.offerId)
		return false;
	return true;
}


}
