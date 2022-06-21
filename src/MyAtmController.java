import java.util.ArrayList;
import java.util.HashMap;

public class MyAtmController {
    private final String[] validPins = {"1234", "5678"};
    private Account currentAccount;
    private final HashMap<String, ArrayList<Account>> pinAccountMap = new HashMap<>();
    private boolean insertCard(String pinNumber) {
        for (String validPin : validPins) {
            if (validPin.equals(pinNumber)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Account> getPinAccounts(String pinNumber) {
        return pinAccountMap.get(pinNumber);
    }

    public boolean selectAccount(String pinNumber, Account account) {
        if (!insertCard(pinNumber)) {
            return false;
        } else if (account.getLinkedCardsPinNums().contains(pinNumber)) {
            this.currentAccount = account;
            return true;
        } else {
            return false;
        }
    }
    public void putPinAccount(String pinNumber, Account account) {
        if (!insertCard(pinNumber)) {
            return;
        }
        if (pinAccountMap.containsKey(pinNumber)) {
            pinAccountMap.get(pinNumber).add(account);
        } else {
            ArrayList<Account> accounts = pinAccountMap.get(pinNumber);
            if (accounts == null) {
                accounts = new ArrayList<>();
            }
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
            pinAccountMap.put(pinNumber, accounts);
        }
    }

    public int seeBalance(String pinNumber) {
        if (!insertCard(pinNumber)) {
            return -1;
        }
        if (currentAccount == null) {
            return -1;
        }
        return currentAccount.getBalance();
    }
    public boolean deposit(String pinNumber, int amount) {
        if (!insertCard(pinNumber)) {
            return false;
        }
        if (currentAccount == null) {
            return false;
        }
        if (amount > 0) {
            currentAccount.setBalance(currentAccount.getBalance() + amount);
            return true;
        } else {
            return false;
        }
    }
    public boolean withdraw(String pinNumber, int amount) {
        if (!insertCard(pinNumber)) {
            return false;
        }
        if (currentAccount == null) {
            return false;
        }
        if (amount > 0 && currentAccount.getBalance() - amount >= 0) {
            currentAccount.setBalance(currentAccount.getBalance() - amount);
            return true;
        } else {
            return false;
        }
    }
}
