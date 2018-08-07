package CreateAccount;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.cap.dao.AccountDaoImpl;
import org.cap.dao.IAccountDao;
import org.cap.exception.InvalidCustomer;
import org.cap.exception.InvalidOpeningbalance;
import org.cap.model.Account;
import org.cap.model.Address;
import org.cap.model.Customer;
import org.cap.service.IService;
import org.cap.service.ServiceImpl;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.MockitoAnnotationsMockAnnotationProcessor;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class StepDef {
 
		private Customer customer;  
	
			private double Openingbalance;
			private IService accountService;
			@Mock
			private IAccountDao accountDao;
			private int accountno;
			private double amount_withdraw;
			
			@Before
			public void setup() {
				
				MockitoAnnotations.initMocks(this);
				customer=new Customer();
				Openingbalance=1000;
	//accountDao=new AccountDaoImpl();
				accountService=new ServiceImpl(accountDao);
			}
			
			@Given("^customer details$")
			public void customer_details() throws Throwable {
				 customer.setFirstname("Manu");
				  customer.setLastname("Nama");
				  Address address=new Address();
				  address.setDoorno("12");
				  address.setCityname("chennai");
				  customer.setAddress(address);
			}

			@When("^vaild customer$")
			public void valid_Customer() throws Throwable {
			assertNotNull(customer);
			}


		@When("^vaild opening balance$")
			public void valid_opening_balance() throws Throwable {
				assertTrue(Openingbalance>=500);
			}

		@Then("^create new Account$")
			public void craete_new_Account() throws Throwable {
			
			
			Account account=new Account();
			account.setAccountno(1);
			account.setOpeningbalance(1000);
			account.setCustomer(customer);
			Mockito.when(accountDao.addAccount(account)).thenReturn(true);
			
			
			
				   Account account2 = accountService.CreateAccount(customer, Openingbalance);
				 Mockito.verify(accountDao).addAccount(account);
				   assertNotNull(account2);
				   assertEquals(Openingbalance, account2.getOpeningbalance(),0.0);;
				   assertEquals(1,account2.getAccountno());
			}
		@Given("^customer details(\\d+)$")
		public void customer_details(int arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		   customer=null;
		}
		@When("^Invaild customer$")
		public void invaild_customer() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		   assertNull(customer);
		}

		@Then("^throw 'Invalid Customer' error message$")
		public void throw_Invalid_Customer_error_message() throws InvalidCustomer, InvalidOpeningbalance, ClassNotFoundException{
		    // Write code here that turns the phrase above into concrete actions
			try {accountService.CreateAccount(customer, 3000);
			}catch(InvalidCustomer e) {
			}
			}
		    
		

		@Given("^customer details and Openingbalance$")
		public void customer_details_and_Openingbalance() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		  Openingbalance=100;
		}

		@When("^Invaild Openingbalance$")
		public void invaild_Openingbalance() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    assertTrue(Openingbalance<500);
		}

		@Then("^throw 'Insufficient Balance' error message$")
		public void throw_Insufficient_Balance_error_message() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		  try {
			  accountService.CreateAccount(customer, Openingbalance);
		  }catch(Exception e) {
			  
		  }
		}
		@Given("^Account number$")
		public void account_number() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		   accountno=1;
		}

		@When("^Valid account number$")
		public void valid_account_number() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			 assertTrue(accountno>0);
		}

		@Then("^find account details$")
		public void find_account_details() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			

			Account account=new Account();
			account.setAccountno(1);
			account.setOpeningbalance(1000);
			account.setCustomer(customer);
			Mockito.when(accountDao.findAccount(1)).thenReturn(account);
			
			 Account account2=accountService.findAccount(accountno);
			 Mockito.verify(accountDao).findAccount(1);
			/* assertNotNull(account2);
			 assertEquals(1,account2.getAccountno());*/
		}
		@Given("^Account number (\\d+) and amount (\\d+)$")
		public void account_number_and_amount(int accNo, int amount) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		  this.accountno=accNo;
		  this.amount_withdraw=amount;
		}

		@When("^Find account and do withdrawal$")
		public void find_account_and_do_withdrawal() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			Account account=new Account();
			account.setAccountno(1);
			account.setOpeningbalance(10000);
			account.setCustomer(customer);
			
			//Mockito.times(2);
			Mockito.when(accountDao.findAccount(1)).thenReturn(account);
		
			Mockito.when(accountDao.updatedBalance(accountno,9000)).thenReturn(account);
			
			
		   Account account2= accountService.withdraw(accountno,amount_withdraw);
		   Mockito.verify(accountDao).findAccount(1);
		   Mockito.verify(accountDao).updatedBalance(accountno,9000);
		   assertEquals(9000,account2.getOpeningbalance(),0.0);
		}

		@Then("^update the account details$")
		public void update_the_account_details() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions

			Account account=new Account();
			account.setAccountno(1);
			account.setOpeningbalance(9000);
			account.setCustomer(customer);
			Mockito.when(accountDao.updatedBalance(accountno,9000)).thenReturn(account);

			 Account account2= accountService.updatedBalance(accountno,9000);
			 //Mockito.verify(accountDao).updatedBalance(accountno,9000);
			 assertEquals(9000,account2.getOpeningbalance(),0.0);
			
		   
		}
		@When("^Find account and do deposit$")
		public void find_account_and_do_deposit() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			Account account=new Account();
			account.setAccountno(1);
			account.setOpeningbalance(10000);
			account.setCustomer(customer);
			
			//Mockito.times(2);
			Mockito.when(accountDao.findAccount(1)).thenReturn(account);
		
			Mockito.when(accountDao.updatedBalance(accountno,11000)).thenReturn(account);
			
			
		   Account account2= accountService.deposit(accountno,amount_withdraw);
		   Mockito.verify(accountDao).findAccount(1);
		   Mockito.verify(accountDao).updatedBalance(accountno,11000);
		   assertEquals(11000,account2.getOpeningbalance(),0.0);
		}
		  
		}





		
		 
