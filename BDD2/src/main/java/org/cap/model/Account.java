package org.cap.model;

public class Account {
	private int accountno;
	private Customer customer;
	private double Openingbalance;
	private String accountType;
	
	
	public Account(int accountno, Customer customer, double openingbalance, String accountType) {
		super();
		this.accountno = accountno;
		this.customer = customer;
		Openingbalance = openingbalance;
		this.accountType = accountType;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Account(int accountno, Customer customer, double openingbalance) {
		super();
		this.accountno = accountno;
		this.customer = customer;
		Openingbalance = openingbalance;
	}
	public Account() {
		
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getOpeningbalance() {
		return Openingbalance;
	}
	public void setOpeningbalance(double openingbalance) {
		Openingbalance = openingbalance;
	}
	@Override
	public String toString() {
		return "Account [accountno=" + accountno + ", customer=" + customer + ", Openingbalance=" + Openingbalance
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(Openingbalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + accountno;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
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
		Account other = (Account) obj;
		if (Double.doubleToLongBits(Openingbalance) != Double.doubleToLongBits(other.Openingbalance))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (accountno != other.accountno)
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		return true;
	}
	

}
