package associationTest;

public class BankAccount {
	private double balance;

	public BankAccount(double balance) {
		super();
		this.balance = balance;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account Balance: $" + String.format("%.2f", balance);
	}

	public void deposite(double val) {
		balance += val;
	}

	public void withdraw(double val) {
		balance -= val;
	}
	public void modifyBalance(double val) {
		balance += val;
	}
}
