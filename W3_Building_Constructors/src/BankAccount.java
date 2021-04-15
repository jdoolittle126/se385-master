/**
 * Represents a bank account
 * @author Jonathan Doolittle
 *
 */

public class BankAccount {
	
	// ******************************
	// Variables
	// ******************************
	
	private String fullName;
	private String accountType;
	
	// ******************************
	// Constructors
	// ******************************
	
	/**
	 * Creates a new bank account with a blank name and blank account type
	 */
	public BankAccount() {
		this.fullName = "";
		this.accountType = "";
	}
	
	/**
	 * Creates a new bank account with a name and account type
	 * @param fullName The account owner's name
	 * @param accountType The account type
	 */
	public BankAccount(String fullName, String accountType) {
		this.fullName = fullName;
		this.accountType = accountType;
	}
	
	// ******************************
	// Getters & Setters
	// ******************************
	
	/**
	 * Gets the account owner's name
	 * @return The owner's name
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * Sets the account owner's name
	 * @param fullName The owner's new name
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Gets the account type
	 * @return The account type
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * Sets the account type
	 * @param accountType The account type
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	

}
