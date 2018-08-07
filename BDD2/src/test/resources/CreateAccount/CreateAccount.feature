
@account
Feature:Create New Account
  Create new Account for the valid customer details
  Scenario: For valid customer create new Account 
    Given customer details
    When vaild customer
    And vaild opening balance
    Then create new Account 


 
  Scenario: For Invalid Customer
  For invalid customer details throws error message
    Given customer details1
    When Invaild customer
    Then throw 'Invalid Customer' error message
    
    
  Scenario: For Invalid Openingbalance
  Given customer details and Openingbalance
    When Invaild Openingbalance
    Then throw 'Insufficient Balance' error message

  
    Scenario: Find account details for customer
 Find account details for the customer for given account number
 Given Account number
 When Valid account number
 Then find account details
   
   Scenario: Withdraw amount from account
  Find account details and withdraw money
 Given Account number 1 and amount 1000
 When Find account and do withdrawal
 Then update the account details 
 
 Scenario: deposit amount to account
  Find account details and deposit money
 Given Account number 1 and amount 1000
 When Find account and do deposit
 Then update the account details 