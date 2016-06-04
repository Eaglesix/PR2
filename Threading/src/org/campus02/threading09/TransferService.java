package org.campus02.threading09;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TransferService implements Runnable {

	private ArrayList<Transaction> transactions;
	private String serviceName;
	private static Object lockObject = new Object();
	
	public TransferService(String serviceName, ArrayList<Transaction> transactions)
	{
		this.transactions = transactions;
		this.serviceName = serviceName;
	}
	
	@Override
	public void run() {
		
		for (Transaction transaction : transactions) {

			System.out.println(serviceName + " waiting for " + transaction.getAccountCreditor().getAccountHolder());
			try {
				if (transaction.getAccountCreditor()
						.getLock().tryLock(100, TimeUnit.MILLISECONDS))
				{
					System.out.println(serviceName + " waiting for " + transaction.getAccountDepitor().getAccountHolder());
					if(transaction.getAccountDepitor()
							.getLock().tryLock(100, TimeUnit.MILLISECONDS))
					{
						if (transaction.getAccountDepitor().hasSufficientAmount(transaction.getAmount()))
						{
							transaction.doTransaction();
							
							// Depitor wieder freigeben
							transaction.getAccountDepitor().getLock().unlock();
						}
					}
					else 
						System.out.println(serviceName + " lock for " + transaction.getAccountDepitor().getAccountHolder() + " not possible!");
					
					// Creditor wieder freigeben
					transaction.getAccountCreditor().getLock().unlock();
				}
				else
					System.out.println(serviceName + " lock for " + transaction.getAccountCreditor().getAccountHolder() + " not possible!");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	

	}

}
