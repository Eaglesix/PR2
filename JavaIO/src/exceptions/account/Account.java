package exceptions.account;

public class Account {
	
	private String owner;
	private double balance;
	private double overdraftFrame;
	
	public Account(String owner, double balance, double overdraftFrame) {
		super();
		this.owner = owner;
		this.balance = balance;
		this.overdraftFrame = overdraftFrame;
	}
	
	public String getOwner() {
		return owner;
	}

	public double getBalance() {
		return balance;
	}

	public double getOverdraftFrame() {
		return overdraftFrame;
	}

	public void credit(double amount) {
		balance += amount;
	}
	
	public void debit(double amount)
			throws NotEnoughMoneyException {
		if(amount > balance + overdraftFrame) {
			throw new NotEnoughMoneyException();
		}
		balance -= amount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [owner=");
		builder.append(owner);
		builder.append(", balance=");
		builder.append(balance);
		builder.append(", overdraftFrame=");
		builder.append(overdraftFrame);
		builder.append("]");
		return builder.toString();
	}

}
