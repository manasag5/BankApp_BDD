package org.cap.service;

import org.cap.dao.AccountDaoImpl;
import org.cap.dao.IAccountDao;
import org.cap.exception.AccountNotFound;
import org.cap.exception.InsufficientBalance;
import org.cap.exception.InvalidCustomer;
import org.cap.exception.InvalidOpeningbalance;
import org.cap.model.Account;
import org.cap.model.Customer;
import org.cap.util.AccountUtil;

public class ServiceImpl implements IService{

	
	 private IAccountDao accountDao;
	public ServiceImpl(IAccountDao accountDao2) {
		this.accountDao=accountDao2;
		// TODO Auto-generated constructor stub
	}

	public Account CreateAccount(Customer customer, double amount) throws InvalidOpeningbalance, InvalidCustomer, ClassNotFoundException{
		// TODO Auto-generated method stub
		
		if(customer!=null) {
			if(amount>=500) {
				Account account=new Account();
				
				account.setOpeningbalance(amount);
				account.setCustomer(customer);
				account.setAccountno(AccountUtil.generateAccountNumber());
			
				boolean flag=accountDao.addAccount(account);
				if(flag)
				return account;
				else
					return null;
				
			}
				else {
				throw new InvalidOpeningbalance("Sorry! Insufficient balance given.");
			}
			
		}else {
			throw new InvalidCustomer("sorry! Customer refers null.");
		}
		
		
	}
	public ServiceImpl() {
		super();
	}

	@Override
	public Account CreateAccount1(Customer customer, double amount) {
		// TODO Auto-generated method stub
		Account account=null;
		if(customer!=null) {
		     account=new Account();
			account.setCustomer(customer);
			if(amount>0) {
				if(amount==1000) {
					account.setAccountType("Savings");
					account.setOpeningbalance(amount);
				}
				else if(amount==10000) {
					account.setAccountType("Current");
					account.setOpeningbalance(amount);
				}
				else if(amount==100) {
					account.setAccountType("RD");
					account.setOpeningbalance(amount);
				}
				else if(amount==500) {
					account.setAccountType("FD");
					account.setOpeningbalance(amount);
				}
					account.setAccountno(AccountUtil.generateAccountNumber());
					
				}
			}
		
		return account;
	}

	@Override
	public Account findAccount(int accountno) {
		// TODO Auto-generated method stub
		return accountDao.findAccount(accountno);
	}

	@Override
	public Account withdraw(int accountno, double amount_withdraw) throws AccountNotFound,InsufficientBalance  {
		// TODO Auto-generated method stub
		
		Account account=accountDao.findAccount(accountno);
		if(account==null) 
			throw new AccountNotFound("Sorry! Account id is not found");
		
			if(amount_withdraw>account.getOpeningbalance()) 
				throw new InsufficientBalance("Insufficient Balance Exception");
			
			account.setOpeningbalance(account.getOpeningbalance()-amount_withdraw);
			
	 updatedBalance(accountno,account.getOpeningbalance());
		return account;
	}

	@Override
	public Account updatedBalance(int accountno, double amount) {
		// TODO Auto-generated method stub
		
	return accountDao.updatedBalance(accountno,amount);
	}

	@Override
	public Account deposit(int accountno, double amount_withdraw)throws AccountNotFound,InsufficientBalance  {
		// TODO Auto-generated method stub
		Account account=accountDao.findAccount(accountno);
		if(account==null) 
			throw new AccountNotFound("Sorry! Account id is not found");
		
			if(amount_withdraw>account.getOpeningbalance()) 
				throw new InsufficientBalance("Insufficient Balance Exception");
			
			account.setOpeningbalance(account.getOpeningbalance()+amount_withdraw);
			
	 updatedBalance(accountno,account.getOpeningbalance());
		return account;
	}

}
