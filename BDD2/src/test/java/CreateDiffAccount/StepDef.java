package CreateDiffAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.cap.dao.AccountDaoImpl;
import org.cap.dao.IAccountDao;
import org.cap.model.Account;
import org.cap.model.Address;
import org.cap.model.Customer;
import org.cap.service.IService;
import org.cap.service.ServiceImpl;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	
	private Customer customer;
	private double Openingbalance;
	private Account account;
	private IService accountService;
	
	@Before
	public void setup() {
		customer=new Customer();
		IAccountDao accountDao = new AccountDaoImpl();
		accountService=new ServiceImpl(accountDao);
	}
	@Given("^customer details and valid Openingbalance$")
	public void customer_details_and_valid_Openingbalance() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 customer.setFirstname("Manu");
		  customer.setLastname("Nama");
		  Address address=new Address();
		  address.setDoorno("12");
		  address.setCityname("chennai");
		  customer.setAddress(address);
		  Openingbalance=1000;
	}
	

	@When("^Valid customer and minimum Openingbalance (\\d+)$")
	public void valid_customer_and_minimum_Openingbalance(int amount) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   this.Openingbalance=amount;
	
	   
	}

	@Then("^create new  Savings Account$")
	public void create_new_Savings_Account() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 account = accountService.CreateAccount1(customer, Openingbalance);
	   assertNotNull(account);
	   assertEquals("Savings", account.getAccountType());
	}

	@Then("^create new  Current Account$")
	public void create_new_Current_Account() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		  account = accountService.CreateAccount1(customer, Openingbalance);
		assertNotNull(account);
		 assertEquals("Current", account.getAccountType());
	}

	@Then("^create new  RD Account$")
	public void create_new_RD_Account() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 account = accountService.CreateAccount1(customer, Openingbalance);
		assertNotNull(account);
		 assertEquals("RD", account.getAccountType());
	}

	@Then("^create new  FD Account$")
	public void create_new_FD_Account() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 account = accountService.CreateAccount1(customer, Openingbalance);
		assertNotNull(account);
		 assertEquals("FD", account.getAccountType());
	}



}
