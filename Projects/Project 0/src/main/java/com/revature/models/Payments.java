package com.revature.models;

public class Payments {
		
		private int birdId;
		private String customerName;
		private String birdType;
		private String birdName;
		private boolean paymentMade;
		public Payments(int birdId, String customerName, String birdType, String birdName, boolean paymentMade) {
			super();
			this.birdId = birdId;
			this.customerName = customerName;
			this.birdType = birdType;
			this.birdName = birdName;
			this.paymentMade = paymentMade;
		}
		public int getBirdId() {
			return birdId;
		}
		public void setBirdId(int birdId) {
			this.birdId = birdId;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getBirdType() {
			return birdType;
		}
		public void setBirdType(String birdType) {
			this.birdType = birdType;
		}
		public String getBirdName() {
			return birdName;
		}
		public void setBirdName(String birdName) {
			this.birdName = birdName;
		}
		public boolean isPaymentMade() {
			return paymentMade;
		}
		public void setPaymentMade(boolean paymentMade) {
			this.paymentMade = paymentMade;
		}
		@Override
		public String toString() {
			return "Payments [birdId=" + birdId + ", customerName=" + customerName + ", birdType=" + birdType
					+ ", birdName=" + birdName + ", paymentMade=" + paymentMade + "]";
		}
		
		
		
}
