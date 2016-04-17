package exceptions.account;

public class BankDemo {

	public static void main(String[] args) {
		
		Bank bank = new Bank();
		
		try {
			bank.addAccount("Max", 500, 500);
			bank.addAccount("Susi", 3000, 1000);
			System.out.println(bank);
			
			bank.transfer("Max", "Susi", 500);
			
			//would cause AccountNotFoundException
			//bank.transfer("Fritz", "Max", 10000);
			
			//causes the BankException due to a 
			//NotEnoughMoneyException which happens
			//during debit method call
			bank.transfer("Max", "Susi", 750);
			
		} catch(BankException e) {
			e.printStackTrace();
		} catch (AccountNotFoundException e) {
			e.printStackTrace();
		} finally {
			//we always print the bank status in 
			//the finally block to check accounts
			System.out.println(bank);
		}
		
		
	}
	
}
