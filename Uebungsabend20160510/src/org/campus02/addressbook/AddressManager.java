package org.campus02.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.campus02.addressbook.exceptions.AddressBookException;
import org.campus02.addressbook.exceptions.AddressExportException;
import org.campus02.addressbook.exceptions.AddressExportFileAlreadyExistsException;
import org.campus02.addressbook.exceptions.AddressLoadException;
import org.campus02.addressbook.exceptions.AddressLoadWrongFormatException;

public class AddressManager {

	private ArrayList<Address> addresses;
	
	public AddressManager()
	{
		addresses = new ArrayList<>();
	}
	
	public void add(Address a)
	{
		addresses.add(a);
	}
	
	public void loadFromCSV(String path, String separator) 
			throws AddressBookException
	{
		try (FileReader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr))
		{
			
			String line;
			while ((line = br.readLine()) != null)
			{
				String[] array = line.split(separator);
				if (array.length != 4)
				{
					throw new 
					AddressLoadWrongFormatException("Fehler in Zeile: " + line);
				}
				
				Address a = new Address(
						array[0], array[1], array[2],
						array[3]
						);
				
				add(a);
			}
			
		} catch (FileNotFoundException e) {
			throw new AddressLoadException(e);
		} catch (IOException e1) {
			throw new AddressLoadException(e1);
		}
	}
	
	public void saveToCSV(String path, String separator) 
			throws AddressBookException
	{	
		File file = new File(path);
		if (file.exists())
		{
			throw new AddressExportFileAlreadyExistsException("Die Datei existiert bereits: " + path);
		}
		
		
		try (FileWriter fw = new FileWriter(path);
				PrintWriter pw1 = new PrintWriter(fw)
				){

			for (Address address : addresses) {
				pw1.println(
						address.getFirstname() + separator +
						address.getLastname() + separator +
						address.getMobileNumber() + separator +
						address.getEmail() + separator
						
						);
			}
			pw1.flush();
			
		} catch (IOException e) {
			throw new AddressExportException(e);
		}
		
	}

	public ArrayList<Address> getAddresses() {
		return addresses;
	}


}
