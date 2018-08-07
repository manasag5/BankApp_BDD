package org.cap.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.cap.exception.AccountNotFound;
import org.cap.exception.InsufficientBalance;
import org.cap.model.Account;

public class AccountDaoImpl implements IAccountDao{

	@Override
	public boolean addAccount(Account account){
		// TODO Auto-generated method stub
		String sql="insert into account values(?,?,?)" ;
		try {
		PreparedStatement pst=getMySqlConnection().prepareStatement(sql);
		pst.setInt(1,account.getAccountno());
		pst.setDouble(2,account.getOpeningbalance());
		pst.setString(3,account.getCustomer().getFirstname());
		
		int count=pst.executeUpdate();
		if(count>0)
			return true;
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	private Connection getMySqlConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/wallet","root","India123");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	@Override
	public Account findAccount(int accountno) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account withdraw(int accountno, double amount_withdraw) throws AccountNotFound, InsufficientBalance {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Account updatedBalance(int accountno, double amount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
