/**
 * This class represents a customer to be used
 * at the bank
 */
public class Customer {
    private String name = "";
    private int customerID = 0;

    /**
     * Constructs a customer for customer param
     */
    public Customer(Customer aCustomer) {
        name = aCustomer.name;
        customerID = aCustomer.customerID;
    }

    /**
     * Constructs a customer for no params
     */
    public Customer() {
    }

    /**
     * Constructs for name and ID
     */
    public Customer(String aName, int aID) {
        name = aName;
        customerID = aID;
    }

    /**
     * Constructs the initial ID of the customer
     *
     * @return
     */
    public Customer(int inputID) {
        customerID = inputID;
    }

    /**
     * Constructs the initial name of the customer
     *
     * @return
     */
    public Customer(String userName) {
        name = userName;
    }

    /**
     * Gets the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the customer ID
     */
    public int getID() {
        return this.customerID;
    }

    /**
     * Sets the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the customer ID
     */
    public void setID(int newID) {
        this.customerID = newID;
    }

    /**
     * Converts to string
     */
    public String toString() {
        return "Customer :" + this.name + ", " + this.customerID;
    }
}
