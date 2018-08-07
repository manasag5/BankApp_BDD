package CreateAccount;

import static org.junit.Assert.*;

import org.cap.dao.IAccountDao;
import org.cap.exception.InvalidCustomer;
import org.cap.exception.InvalidOpeningbalance;
import org.cap.model.Address;
import org.cap.model.Customer;
import org.cap.service.IService;
import org.cap.service.ServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



public class AccountTest {

	private Customer customer;
	private IService accountService;
	private IAccountDao accountDao;
	
	@Before
	public void setUp() {
		customer = new Customer();
		customer.setFirstname("tom");
		customer.setLastname("jerry");
		Address address=new Address();
		address.setDoorno("12");
		address.setCityname("Chennai");
		customer.setAddress(address);
		

	accountService = new ServiceImpl(accountDao);	
	}
	
	@Rule
	public ExpectedException exception=ExpectedException.none();
	
	@Test //(expected=NullPointerException.class)
	public void test_customer_with_null() throws InvalidCustomer, InvalidOpeningbalance{
		
		customer = null;
		
		exception.expect(InvalidCustomer.class);
		exception.expectMessage("sorry! Customer refers null.");
		
		try {
			accountService.CreateAccount(customer,1000);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test //(expected=NullPointerException.class)
	public void test_invalid_balance() throws InvalidCustomer, InvalidOpeningbalance, ClassNotFoundException{ 
		exception.expect(InvalidOpeningbalance.class);
		exception.expectMessage("Sorry! Insufficient balance given.");
		
		accountService.CreateAccount(customer,200);
	}
}