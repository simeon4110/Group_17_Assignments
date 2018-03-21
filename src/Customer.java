/**
 * This class represents a customer to be used in the BankAccount class.
 */
public final class Customer {
    private final String name;
    private final int customerID;

    /**
     * Constructs a customer for customer param.
     */
    public Customer(Customer aCustomer) {
        this.name = aCustomer.name;
        this.customerID = aCustomer.customerID;
    }

    /**
     * Constructs for name and ID
     */
    public Customer(String aName, int aID) {
        this.name = aName;
        this.customerID = aID;
    }

    /**
     * Constructs the initial ID of the customer
     */
    public Customer(int inputID) {
        customerID = inputID;
        name = "";
    }

    /**
     * Constructs the initial name of the customer
     */
    public Customer(String userName) {
        name = userName;
        customerID = 0;
    }

    /**
     * Converts to string
     */
    public String toString() {
        return "Customer :" + this.name + ", " + this.customerID;
    }

    /**
     * @return the customer's name as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the customer's ID as an int.
     */
    public int getCustomerID() {
        return customerID;
    }
}
