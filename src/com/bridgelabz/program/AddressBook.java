package com.bridgelabz.program;

import java.util.Scanner;

import com.entity.BookManagement;

public class AddressBook {
	
	BookManagement book = new BookManagement();
public static void main(String[] args ){
	AddressBook addressBook  = new AddressBook();
	System.out.println("First Add data in book ");

	addressBook.showUserOption();
	
	}
	public void showUserOption() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while (choice != 12) {
			System.out.println("1.Add contact details\n2. Show data in Book\n3.Edit existing contact\n4.Delete person\n5.Search\n6..sortByCityUsingSteam \n7.writeBookDataInFile\n8.readBookDataFromFile\n9.WriteDataInCsvFile\n10.readData from CsvFile\n11.write data in json   ");
			
			choice = sc.nextInt();
			switch (choice) {
			case 1 : 
				book.addData();
				break;
			case 2 : 
				book.print();
				break;
			case 3 : 
				book.editPerson();
				break;	
			case 4 : 
				book.deletePerson();
				break;	
			case 5 : 
				book.search();
				break;		
			case 6 : 
				book.sortByCityUsingSteam();
				break;
			case 7 : 
				book. writeBookDataInFile();
				break;		
			case 8 : 
				book.readBookDataFromFile();
				break;
			case 9:
				book.WriteDataInCsvFile();
				break;
			case 10 :
				book.readDataUsingCsv();
			case 11 :
				book.writeDataToJsonFile();
				break;
			default : 
				System.out.println("Please enter correct input ");
			break;
			}
			
		

		}
	}
}
	