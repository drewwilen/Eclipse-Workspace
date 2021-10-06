package associationTest;

public class Person {
	private String name;
	private double salary;
	private Wallet wallet;
	private BankAccount bankAccount;

	public Person(String name, double salary, Wallet wallet, BankAccount bankAccount) {
		super();
		this.name = name;
		this.salary = salary;
		this.wallet = wallet;
		this.bankAccount = bankAccount;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the wallet
	 */
	public Wallet getWallet() {
		return wallet;
	}

	/**
	 * @param wallet the wallet to set
	 */
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	/**
	 * @return the bankAccount
	 */
	public BankAccount getBankAccount() {
		return bankAccount;
	}

	/**
	 * @param bankAccount the bankAccount to set
	 */
	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public void modifyWallet(double amount) {
		wallet.modifyBalance(amount);
	}
	public void modifyBankAccount(double amount) {
		 bankAccount.modifyBalance(amount);
	}
	public void deposit(double val) {
		wallet.modifyBalance(-val);
		bankAccount.modifyBalance(val);
	}
	public void withdraw(double val) {
		wallet.modifyBalance(val);
		bankAccount.modifyBalance(-val);
	}
	public void walletTransfer(Person otherPerson, double val) {
		wallet.modifyBalance(-val);
		otherPerson.getWallet().modifyBalance(val);
	}
	

	@Override
	public String toString() {
		return "Name: " + name + "\n" + "Salary: $" + String.format("%.2f", salary) + "\n" + wallet + "\n"
				+ bankAccount;
	}

}
