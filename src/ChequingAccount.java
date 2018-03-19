/**
 *
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
     * Gets the overdraft fee
     */
    public double getOverdraftFee() {
        return this.overdraftFee;
    }

    /**
     * Gets the overdraft amount
     */
    public double getOverdraftAmount() {
        return this.overdraftAmount;
    }

    /**
     * Sets the overdraft fee
     */
    public void setOverdraftFee(double fee) {
        this.overdraftFee = fee;
    }

    /**
     * Sets the overdraft amount
     */
    public void setOverdraftAmount(double amount) {
        this.overdraftAmount = amount;
    }

    @Override
    /**
     * Getsthe monthly fees
     */
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
