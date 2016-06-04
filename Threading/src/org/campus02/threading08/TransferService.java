package org.campus02.threading08;

import java.util.ArrayList;

public class TransferService implements Runnable {

	private ArrayList<Transaction> transactions;
	private String serviceName;
	
	public TransferService(String serviceName, ArrayList<Transaction> transactions)
	{
		this.transactions = transactions;
		this.serviceName = serviceName;
	}
	
	@Override
	public void run() {

		for (Transaction transaction : transactions) {
			System.out.println(serviceName + " waiting for " + transaction.getAccountCreditor().getAccountHolder());
			synchronized(transaction.getAccountCreditor())
			{
				System.out.println(serviceName + " waiting for " + transaction.getAccountDepitor().getAccountHolder());
				synchronized(transaction.getAccountDepitor())
				{
					if (transaction
							.getAccountDepitor()
							.hasSufficientAmount(transaction.getAmount()))
					{
						transaction.doTransaction();
					}
				}
			}
		}	

	}

}
