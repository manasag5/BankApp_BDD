package org.cap.service;

import org.cap.exception.AccountNotFound;
import org.cap.exception.InsufficientBalance;
import org.cap.exception.InvalidCustomer;
import org.cap.exception.InvalidOpeningbalance;
import org.cap.model.Account;
import org.cap.model.Customer;

public interface IService {
	public Account CreateAccount(Customer customer,double amount) throws InvalidOpeningbalance, InvalidCustomer, ClassNotFoundException;
	public Account CreateAccount1(Customer customer,double amount);
	public Account findAccount(int accountno);
public Account withdraw(int accountno, double amount_withdraw) throws AccountNotFound,InsufficientBalance ;
public Account updatedBalance(int accountno,double amount);
public Account deposit(int accountno, double amount_withdraw) throws AccountNotFound, InsufficientBalance;

}
