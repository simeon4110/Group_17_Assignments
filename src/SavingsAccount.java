/**
 * A basic savings account with a static interest rate variable to tack annual interest rate.
 */

public class SavingsAccount extends BankAccount {
    private static double annualInterestRate;

    /**
     * Constructs basic savings account
     */
    public SavingsAccount() {
    }

    /**
     * Constructs savings account with customer, balance, and interest rate
     */
    public SavingsAccount(Customer accountHolder, double startBalance) {
        setCustomer(accountHolder);
        balance = startBalance;
    }

    /**
     * Gets the monthly fees
     */
    @Override
    protected double getMonthlyFeesAndInterest() {
        double monthlyFee = 5;
        double monthlyInterest = 0;

        if (balance < 1000) {
            monthlyInterest = -monthlyFee + (balance * (1.0 / 12.0) * (annualInterestRate / 100.0));
        } else {
            monthlyInterest = balance * (1.0 / 12.0) * (annualInterestRate / 100.0);
        }
        return monthlyInterest;
    }

    /**
     * Gets the interest rate
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * @param rate Sets the interest rate
     */
    public static void setAnnualInterestRate(double rate) {
        annualInterestRate = rate;
    }

}
