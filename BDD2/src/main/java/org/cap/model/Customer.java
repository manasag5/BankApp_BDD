package org.cap.model;

import java.util.List;

public class Customer {
 private String Firstname;
 private String Lastname;
 private Address address;
 private List<Account> accounts;
 
 
public List<Account> getAccounts() {
	return accounts;
}
public void setAccounts(List<Account> accounts) {
	this.accounts = accounts;
}
public Customer(String firstname, String lastname, Address address, List<Account> accounts) {
	super();
	Firstname = firstname;
	Lastname = lastname;
	this.address = address;
	this.accounts = accounts;
}
public Customer(String firstname, String lastname, Address address) {
	super();
	Firstname = firstname;
	Lastname = lastname;
	this.address = address;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((Firstname == null) ? 0 : Firstname.hashCode());
	result = prime * result + ((Lastname == null) ? 0 : Lastname.hashCode());
	result = prime * result + ((accounts == null) ? 0 : accounts.hashCode());
	result = prime * result + ((address == null) ? 0 : address.hashCode());
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
	if (Firstname == null) {
		if (other.Firstname != null)
			return false;
	} else if (!Firstname.equals(other.Firstname))
		return false;
	if (Lastname == null) {
		if (other.Lastname != null)
			return false;
	} else if (!Lastname.equals(other.Lastname))
		return false;
	if (accounts == null) {
		if (other.accounts != null)
			return false;
	} else if (!accounts.equals(other.accounts))
		return false;
	if (address == null) {
		if (other.address != null)
			return false;
	} else if (!address.equals(other.address))
		return false;
	return true;
}
public Customer() {
	
}
public String getFirstname() {
	return Firstname;
}
public void setFirstname(String firstname) {
	Firstname = firstname;
}
public String getLastname() {
	return Lastname;
}
public void setLastname(String lastname) {
	Lastname = lastname;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
@Override
public String toString() {
	return "Customer [Firstname=" + Firstname + ", Lastname=" + Lastname + ", address=" + address + ", accounts="
			+ accounts + "]";
}


}
