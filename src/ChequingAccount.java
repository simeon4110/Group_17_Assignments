/**
 * @author Lincoln
 * A chequing account subclass of bank account,
 */
public class ChequingAccount extends BankAccount {
    private double overdraftFee;
    private double overdraftAmount;

    public ChequingAccount(double transactionFee) {
        overdraftFee = transactionFee;
    }

    public ChequingAccount(Customer accountHolder, double startBalance, double transactionFee) {
        setCustomer(accountHolder);
        balance = startBalance;
        overdraftFee = transactionFee;
    }

    /**
     * @return the overdraft fee as a double.
     */
    public double getOverdraftFee() {
        return this.overdraftFee;
    }

    /**
     * Sets the overdraft fee.
     */
    public void setOverdraftFee(double fee) {
        this.overdraftFee = fee;
    }

    /**
     * @return the overdraft amount as a double.
     */
    public double getOverdraftAmount() {
        return overdraftAmount;
    }

    /**
     * Sets the overdraft amount
     */
    public void setOverdraftAmount(double amount) {
        this.overdraftAmount = amount;
    }

    /**
     * Withdraws specified amount from the account
     */
    public void withdraw(double amount) {
        if (amount < 0.0) {
            System.out.println("You can not withdraw a negative amount, please deposit instead.");
        } else if (amount > (overdraftAmount + balance)) {
            System.out.println("You can not withdraw this amount as you will exceed the overdraft amount.");
        } else if (amount > balance) {
            // Charge the overdraft fee
            balance -= overdraftFee + amount;
        } else balance -= amount;

    }

    /**
     * Getsthe monthly fees
     */
    @Override
    protected double getMonthlyFeesAndInterest() {
        double monthlyInterest;
        if (balance > 0) {
            monthlyInterest = 0;
        } else {
            monthlyInterest = 0.20 * balance;
        }

        return monthlyInterest;
    }

}
