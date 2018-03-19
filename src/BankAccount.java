
/**
 * Basic bank account program which allows user to withdraw and deposit.
 * The balance of the bank account can never be overdrafted more than the allowed amount.
 */
public abstract class BankAccount {
    double balance = 0.0; // Initialize the bank account balance.
    private Customer customer = new Customer("Bob",100);
    private double overdraftAmt;
    /**
     * Constructs a BankAccount no arguments
     */
    public BankAccount() {

    }

    /**
     * Constructs a BankAccount given a customer and a balance
     */
    public BankAccount(Customer aCustomer, double aBalance) {
        setCustomer(aCustomer);
        balance = aBalance;
    }

    /**
     * @param amount The amount of money the user wishes to withdraw.
     */
    public void withdraw(double amount) {
        if (amount < 0.0) {
            System.out.println("You can not withdraw a negative amount, please deposit instead.");
        } else if (balance >= amount) {
            balance -= amount;
        }
    }

    /**
     * @param amount The amount of money the user wishes to deposit.
     */
    public void deposit(double amount){
        if (amount < 0.0){
            System.out.println("You can not deposit a negative amount, please withdraw instead.");
        } else {
            balance += amount;
        }
    }


    /**
     * Transfer specified amount from the account to account provided
     * @param amount The amount to transfer to another bank account
     * @param toAccount The bank account which the transfer is directed to
     */
    public void transfer(double amount, BankAccount toAccount) {
        if (balance >= amount) {
            withdraw(amount);
            toAccount.deposit(amount);
        }
    }


    /**
     * Abstract class for other chequing and savings accounts
     */
    protected abstract double getMonthlyFeesAndInterest();


    /**
     * Modifies balance based off the interest
     */
    public void monthEndUpdate() {
        double monthlyFees = getMonthlyFeesAndInterest();
        balance += monthlyFees;
    }

    /**
     * Sets the balance (allows child classes access)
     */
    protected void setBalance(double amount) {
        this.balance = amount;
    }


    /**
     * @return The current balance in the account as a double.
     */
    public double getBalance() {
        return balance;
    }

    /**
     *
     * @return The customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *  Sets the customer
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setOverdraftAmount(double d) {
        this.overdraftAmt = d;

    }


}