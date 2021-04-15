
public class RunBankAccount {

	public static void main(String[] args) {
		
		BankAccount accountA = new BankAccount("Jonathan Doolittle", "Checkings");
		
		BankAccount accountB = new BankAccount();
		accountB.setFullName("Scott Lambert");
		accountB.setAccountType("Savings");
	}
	
	
}
