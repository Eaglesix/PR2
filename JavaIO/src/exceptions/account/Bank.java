package exceptions.account;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Bank {
	
	private Map<String, Account> accounts = new HashMap<>();

	public void addAccount(String owner, double balance, double overdraftFrame) 
					throws BankException {
		if(accounts.containsKey(owner)) {
			throw new BankException("account for "+owner+" already exists");
		}
		accounts.put(owner, new Account(owner,balance,overdraftFrame));
	}
	
	public void transfer(String fromOwner, String toOwner, double amount) 
					throws AccountNotFoundException, BankException
	{
		if(!accounts.containsKey(fromOwner)
				|| !accounts.containsKey(toOwner)) {
			throw new AccountNotFoundException("NO account found for one or both of "
					+ fromOwner + " and "+ toOwner);
		}
		try {
			accounts.get(fromOwner).debit(amount);
			accounts.get(toOwner).credit(amount);
		} catch(NotEnoughMoneyException exc) {
			
			throw new BankException(exc);
		}
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		StringBuilder builder = new StringBuilder();
		builder.append("Bank [accounts=");
		builder.append(accounts != null ? toString(accounts.entrySet(), maxLen) : null);
		builder.append("]");
		return builder.toString();
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[\n");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			builder.append(iterator.next()+"\n");
		}
		builder.append("]");
		return builder.toString();
	}
	
}
