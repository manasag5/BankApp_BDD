package org.cap.dao;

import org.cap.exception.AccountNotFound;
import org.cap.exception.InsufficientBalance;
import org.cap.model.Account;


public interface IAccountDao {
	
	public boolean addAccount(Account account) throws ClassNotFoundException;

	public Account findAccount(int accountno);

	public Account withdraw(int accountno, double amount_withdraw) throws AccountNotFound,InsufficientBalance ;

	public Account updatedBalance(int accountno,double amount);

}
