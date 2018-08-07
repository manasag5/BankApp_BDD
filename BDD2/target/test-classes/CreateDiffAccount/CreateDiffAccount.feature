


@account
Feature: Create Different new Account
  Create Account like Savings,current,rd and fd

  Scenario Outline: creating new different account
    Given customer details and valid Openingbalance
    When  Valid customer and minimum Openingbalance <value>
    Then create new  <account Type> Account
    
  Examples:
    |account Type|value|
    |Savings     |1000 |
    |Current     |10000|
    |RD          |100  |
    |FD          |500  |
   
  
    
 
