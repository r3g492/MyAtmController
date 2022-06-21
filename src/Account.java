import java.util.ArrayList;

public class Account {
    private int balance;
    private final ArrayList<String> linkedCardsPinNums = new ArrayList<>();

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ArrayList<String> getLinkedCardsPinNums() {
        return linkedCardsPinNums;
    }

    public void addLinkedCardsPinNums(String pinNumber) {
        linkedCardsPinNums.add(pinNumber);
    }
}
