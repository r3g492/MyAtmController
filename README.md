# MyAtmController
  
  
I made 2 simple java classes, Account.java and MyAtmController.java.  
  
Test case are all written in the Main.java class.  
Just run the main as java application.  

## Tests

# // withdraw test
        Account accountWithdraw = new Account();
        accountWithdraw.setBalance(200);
        accountWithdraw.addLinkedCardsPinNums("1234");

        MyAtmController atmWithdraw = new MyAtmController();
        atmWithdraw.putPinAccount("1234", accountWithdraw);
        atmWithdraw.selectAccount("1234", accountWithdraw);

        System.out.println("withdraw test : from 200, withdraw 100");
        System.out.println(atmWithdraw.seeBalance("1234"));
        atmWithdraw.withdraw("1234", 100);
        System.out.println(atmWithdraw.seeBalance("1234"));
        assert atmWithdraw.seeBalance("1234") == 100;

# // deposit test
        Account accountDeposit = new Account();
        accountDeposit.setBalance(0);
        accountDeposit.addLinkedCardsPinNums("1234");

        MyAtmController atmDeposit = new MyAtmController();
        atmDeposit.putPinAccount("1234", accountDeposit);
        atmDeposit.selectAccount("1234", accountDeposit);

        System.out.println("deposit test : to 0, deposit 100");
        System.out.println(atmDeposit.seeBalance("1234"));
        atmDeposit.deposit("1234", 100);
        System.out.println(atmDeposit.seeBalance("1234"));
        assert atmDeposit.seeBalance("1234") == 100;

# // select account size test
        Account accountSelect = new Account();
        Account accountSelect0 = new Account();
        MyAtmController atmSelect = new MyAtmController();
        atmSelect.putPinAccount("1234", accountSelect);
        atmSelect.putPinAccount("1234", accountSelect0);

        System.out.println("select account size test : two account for pin number 1234");
        assert atmSelect.getPinAccounts("1234").size() == 2;

# // invalid pin number test
        Account accountInvalid = new Account();
        accountInvalid.setBalance(0);
        accountInvalid.addLinkedCardsPinNums("4567");
        MyAtmController atmInvalid = new MyAtmController();
        atmInvalid.putPinAccount("1234", accountInvalid);
        atmInvalid.selectAccount("1234", accountInvalid);

        System.out.println("invalid pin number test : pin number 1234");
        assert atmInvalid.seeBalance("1234") == -1;
