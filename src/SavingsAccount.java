public class SavingsAccount extends Account{
    private double interestRate;

    public SavingsAccount(int idNum, double startBal, double intR){
        super(idNum,startBal);
        interestRate = intR;
    }

    public double monthlyInterest() {
        return (super.currentBalance()*interestRate)/12;
    }
}
