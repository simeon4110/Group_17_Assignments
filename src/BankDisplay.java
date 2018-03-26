/**
 * 
 * @author Lincoln
 * Creates a GUI for a simple bank that withdraws or deposits money.
 * Allows for the creation of a new customer and bank account, deletes all old information
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class BankDisplay extends Application {
	private Customer user = new Customer("Joe", 123);
	private BankAccount userBank = new BankAccount(user, 0.0);
	Button withdrawButton;
	Button depositButton;
	Button createButton;
	Button createNewAccountButton;
	Scene bankingScene, bankCreationScene;
	
	/**
	 * 
	 * Launches the javaFX application
	 */
	
	public static void main(String[] args) {
		launch(args);
	}
	

    /**
     * Creates both scenes and all required objects for the bank account
     * Displays the banking scene by default
     */
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Bank Account");
		
		
		/**
		 * All objects for the banking scene
		 */
		// Layout for banking scene
		GridPane bankingGrid = new GridPane();
		bankingGrid.setPadding(new Insets(10, 10, 10, 10));
		bankingGrid.setVgap(8);
		bankingGrid.setHgap(10);
		
		// Bank labels
		Label customerLabel = new Label("Name: " + getCustomer().getName());
		GridPane.setConstraints(customerLabel, 0, 0);
		
		// Current Balance
		Label currentBalance = new Label("Current Balance: " + getBankAccount().getBalance());
		GridPane.setConstraints(currentBalance, 5, 1);
		
		// Text fields
		TextField withdrawAmt = new TextField();
		GridPane.setConstraints(withdrawAmt, 1, 1);
		
		TextField depositAmt = new TextField();
		GridPane.setConstraints(depositAmt, 1, 2);
		
		// Buttons
		withdrawButton = new Button();
		withdrawButton.setText("Withdraw");
		
		// Lambda notation for event handling
		withdrawButton.setOnAction(e -> {
			userBank.withdraw(isDouble(withdrawAmt));
			currentBalance.setText("Current Balance: " + getBankAccount().getBalance());
		});
		
		GridPane.setConstraints(withdrawButton, 0, 1);
		
		depositButton = new Button();
		depositButton.setText("Deposit");
		
		depositButton.setOnAction(e -> {
			userBank.deposit(isDouble(depositAmt));
			currentBalance.setText("Current Balance: " + getBankAccount().getBalance());
		});
		
		GridPane.setConstraints(depositButton, 0, 2);
		
		createButton = new Button();
		createButton.setText("Create");
		createButton.setOnAction(e -> primaryStage.setScene(bankCreationScene));
		
		GridPane.setConstraints(createButton, 0, 3);
		
		// Displaying the banking scene
		bankingGrid.getChildren().addAll(customerLabel, withdrawButton, withdrawAmt, depositButton, depositAmt, currentBalance, createButton);
		bankingScene = new Scene(bankingGrid, 800, 300);
		primaryStage.setScene(bankingScene);
		primaryStage.show();
		
		
		/**
		 * All objects for bank creation scene
		 */
		// Layout for bank creation scene
		GridPane creationGrid = new GridPane();
		creationGrid.setPadding(new Insets(10, 10, 10, 10));
		creationGrid.setVgap(8);
		creationGrid.setHgap(10);
		
		// Bank creation labels
		Label customerID = new Label("Customer ID:");
		GridPane.setConstraints(customerID, 0, 0);
		
		Label customerName = new Label("Customer Name:");
		GridPane.setConstraints(customerName, 0, 1);
		
		Label startBalance = new Label("Start balance:");
		GridPane.setConstraints(startBalance, 0, 2);
		
		// Text fields
		TextField newCustomerID = new TextField();
		GridPane.setConstraints(newCustomerID, 1, 0);
		
		TextField newCustomerName = new TextField();
		GridPane.setConstraints(newCustomerName, 1, 1);
		
		TextField newStartBalance = new TextField();
		GridPane.setConstraints(newStartBalance, 1, 2);

		// Button
		createNewAccountButton = new Button();
		createNewAccountButton.setText("Create");
		
		// Lambda notation as event handler only has one method Java interprets what you want
		createNewAccountButton.setOnAction(e -> {
			Customer newCustomer = new Customer(newCustomerName.getText(), isInt(newCustomerID));
			BankAccount newBankAccount = new BankAccount(user,isDouble(newStartBalance));
			setBankAccount(newBankAccount);
			setCustomer(newCustomer);
			
			customerLabel.setText("Name: " + getCustomer().getName());
			currentBalance.setText("Current Balance: " + getBankAccount().getBalance());
			primaryStage.setScene(bankingScene);
		});
		
		GridPane.setConstraints(createNewAccountButton, 0, 3);
		
		// The bank creation scene
		creationGrid.getChildren().addAll(customerID, customerName, startBalance, newCustomerID, newCustomerName, newStartBalance, createNewAccountButton);
		bankCreationScene = new Scene(creationGrid, 800, 300);

		// Default the first scene as the banking scene
		primaryStage.setScene(bankingScene);
		primaryStage.show();
		
	}
	
	
	/**
	 * Method that changes string to double
	 */
	public double isDouble(TextField input) {
		try {
			double transaction = Double.parseDouble(input.getText());
			return transaction;
		}catch(NumberFormatException e) {
			System.out.println("Error: NaN");
			return 0;
		}
	}
	
	/**
	 * Method that changes string to int
	 */
	public int isInt(TextField input) {
		try {
			int strToInt = Integer.parseInt(input.getText());
			return strToInt;
		}catch(NumberFormatException e) {
			System.out.println("Error: Tried to convert ID to integer");
			return 0;
		}
	}
	
    /**
     * Gets the customer ID
     */
    public Customer getCustomer() {
    	return this.user;
    }
    
    /**
     * Gets the bank account
     */
    public BankAccount getBankAccount() {
    	return this.userBank;
    }
	
    /**
     * Sets the customer
     */
    public void setCustomer(Customer newCustomer) {
    	this.user = newCustomer;
    }
    
    /**
     * Sets the bank account
     */
    public void setBankAccount(BankAccount newBankAccount) {
    	this.userBank = newBankAccount;
    }
	
	

}
