package org.campus02.addressbook;

import org.campus02.addressbook.exceptions.AddressBookException;
import org.campus02.addressbook.exceptions.AddressExportException;
import org.campus02.addressbook.exceptions.AddressExportFileAlreadyExistsException;
import org.campus02.addressbook.exceptions.AddressLoadException;
import org.campus02.addressbook.exceptions.AddressLoadWrongFormatException;

public class AddressDemo {

	public static void main(String[] args) 
			throws AddressBookException {

		AddressManager manager = new AddressManager();
		
		/*manager.add(new Address("Max", "Mustermann", "004366412345678", 
				"max.muster@gmx.net"
				));
		
		manager.add(new Address("Susi", "Sorglos", "004967612345678", 
				"susi.sorglos@gmx.net"
				));*/
		
		manager.loadFromCSV("D:\\temp\\addresses.csv", ",");
		manager.saveToCSV("D:\\temp\\addresses1.csv", ",");
		
		for (Address address : manager.getAddresses()) {
			System.out.println(address);
		}
		

	}

}
