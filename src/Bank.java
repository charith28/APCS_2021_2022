import java.util.ArrayList;
public class Bank {

    private ArrayList<Account> accounts;
    public Bank() {
        accounts = new ArrayList<>();
        accounts.add(new SavingsAccount(1234, 5000, .001));
        accounts.add(new SavingsAccount(2345, 1000, .5));
        accounts.add(new SpecialCheckingAccount(3456, 2500, .75, .0005, 2000));
    }
    public void postMonthlyInterest() {
        for(Account a : accounts) {
        a.deposit(a.monthlyInterest());
        }
    }
    public void printAccounts() {
        for(Account a : accounts) {
        System.out.println(a);
        }
    }
    public static void main(String[] args) {
        Bank b = new Bank();
        System.out.println("BEFORE");
        b.printAccounts();
        b.postMonthlyInterest();
        System.out.println("AFTER");
        b.printAccounts();
    }
}