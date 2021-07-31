package com.entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opencsv.CSVWriter;

public class BookManagement {
	static Scanner sc = new Scanner(System.in);
	static List<Entity> list = new ArrayList<Entity>();
	Entity e = new Entity();
	
	public void WriteDataInCsvFile() {
		//first created file object by adding specified path 
		File file = new File("D:\\Files\\book.csv");
		
		try {      //create file writer object as passing file in parameter 
			
			FileWriter fw = new FileWriter(file);
			
			CSVWriter csvWriter = new 	CSVWriter(fw);
				
			String[] header = {"FirstName" , "LastName" , "Address" , "City" , "State" , "Zip" , "PhoneNumber" };
			csvWriter.writeNext(header);
				
			String[] contact =  {e.getFirstName() , e.getLastName() , e.getAddress() ,e.getCity() ,e.getState()
					,e.getZip() ,e.getPhoneNumber() };
			csvWriter.writeNext(contact);
			csvWriter.close();
			fw.close();
			
			System.out.println("success ");
		} catch (IOException e) {
				
			System.out.println(e);
			}		
	}
		
	public void readDataUsingCsv()  {
		try {
		FileReader fr  = new FileReader("D:\\Files\\book.csv");
		BufferedReader br = new BufferedReader(fr);
		String line ; 
		while((line = br.readLine()) != null) {
			String[] array  = line.split(",");
			System.out.println(Arrays.toString(array));
		}
		}
		catch(IOException e) {
			System.out.println(e);
			
				
		}
	}
	
	public void writeDataToJsonFile() {
		
		JsonObject bookObj = new JsonObject();
		JsonArray jsonArray = new JsonArray();
		bookObj.addProperty("FirstName", e.getFirstName());
		bookObj.addProperty("LastName", e.getLastName());
		bookObj.addProperty("Address", e.getAddress());
		bookObj.addProperty("City", e.getCity());
		bookObj.addProperty("State", e.getState());
		bookObj.addProperty("Zip", e.getZip());
		bookObj.addProperty("PhoneNumber", e.getPhoneNumber());
		jsonArray.add(bookObj);
		
		try {
			FileWriter fw = new FileWriter("C:\\Users\\admin\\Desktop\\Eclipse data\\AddressBooKFileIO\\src\\com\\files\\Address.json");
			fw.write(jsonArray.toString());
			fw.flush();
	
		} catch (IOException e1) {
			System.out.println(e);
		}
		System.out.println("----Data added to Json File----");
		
	}
	
	public void writeBookDataInFile() {
		try {
			FileWriter fout = new FileWriter("C:\\Users\\admin\\Desktop"+ "\\Eclipse data\\AddressBooKFileIO\\src\\com\\files\\FileData");
			BufferedWriter bout = new BufferedWriter(fout);
			for(Entity element : list) {
				bout.write(element +System.lineSeparator());
				System.out.println("Succeess");
			}
			bout.close();
			fout.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void  readBookDataFromFile()  {
			
			try {
			FileReader fin = new FileReader("C:\\Users\\admin\\Desktop\\Eclipse data\\AddressBooKFileIO\\src\\com\\files\\FileData");
			BufferedReader bin = new BufferedReader(fin);
			String data = " " ;
			while(data != null) {
				System.out.println(data);
				data = bin.readLine();
				
			}
			bin.close();
			fin.close();
			}
			catch(IOException e ) {
				System.out.println(e);
			}
		
	}

	public void sortByCityUsingSteam() {
		List<Entity> sortedList = list.stream().sorted(Comparator.comparing(Entity::
			getCity)) .collect(Collectors.toList());
		sortedList.forEach(System.out::println);
		    }
	
	public void sortByNameUsingStream() {
		List<Entity> sortedList = list.stream().sorted(Comparator.comparing(Entity::
			getFirstName)) .collect(Collectors.toList());
		sortedList.forEach(System.out::println);
	}
	
	public void sortByPinCodeUsingStream() {
		List<Entity>  sortByPin = list.stream().sorted(Comparator.comparing(Entity::getZip)).collect(Collectors.toList());
		 sortByPin.forEach(System.out::println);
	}
	
	public void addData() {
		
		
		System.out.println("Enter first name");
		e.setFirstName(sc.next());
		System.out.println("Enter last name");
		e.setLastName(sc.next());
		System.out.println("Enter the address");
		e.setAddress(sc.next());
		System.out.println("Enter the city");
		e.setCity(sc.next());
		System.out.println("Enter the state");
		e.setState(sc.next());
		System.out.println("Enter the zip");
		e.setZip(sc.next());
		System.out.println("Enter the phonenumber");
		e.setPhoneNumber(sc.next());
		list.add(e);
		writeDataToJsonFile();
	}
		
	
	public void print() {
		for (Entity element : list) {
			System.out.println(element);
		}
	}
	
	public void editPerson() {
		System.out.println("Enter the name to edit person detail");
		String person = sc.next();
		Entity entity = getEntity(person);
		System.out.println("Enter what to you want to edit\n1.first name\n2.last name\n3.address\n4.city\n5.state\n6.zip\n7.phone number");
		int option = sc.nextInt();
		switch (option) {
		case 1 : 
			editFirstName(entity);
			break;
		case 2 :
			editLastName(entity);
			break;
		case 3 : 
			editAddress(entity);
			break;
		case 4 : 
			editCity(entity);
			break;
		case 5 : 
			editState(entity);
			break;
		case 6 : 
			editZip(entity);
			break;
		case 7 :
			editPhoneNumber(entity);
			break;
		default : 
			System.out.println("Wrong selection");
		}
	}

	public void editPhoneNumber(Entity entity) {
		System.out.println("Enter new phone number");
		entity.setPhoneNumber(sc.next());
		System.out.println("Succeessfully updated");
	}

	public void editZip(Entity entity) {
		System.out.println("Enter new Zip");
		entity.setZip(sc.next());
		System.out.println("Succeessfully updated");
	}

	public void editState(Entity entity) {
		System.out.println("Enter new State");
		entity.setState(sc.next());
		System.out.println("Succeessfully updated");
	}

	public void editCity(Entity entity) {
		System.out.println("Enter new City");
		entity.setCity(sc.next());
		System.out.println("Succeessfully updated");
	}

	public void editAddress(Entity entity) {
		System.out.println("Enter new Address");
		entity.setAddress(sc.next());
		System.out.println("Succeessfully updated");
	}

	public void editLastName(Entity entity) {
		System.out.println("Enter the last name");
		entity.setLastName(sc.next());
		System.out.println("Succeessfully updated");
	}

	public void editFirstName(Entity entity) {
		System.out.println("Enter new first name");
		entity.setFirstName(sc.next());
		System.out.println("Succeessfully updated");
	}

	public Entity getEntity(String person) {
			Iterator itr = list.iterator();
			while(itr.hasNext()) {
				for (int i = 0 ; i < list.size();i++) {
					Entity entity = (Entity) itr.next();
					if(entity.getFirstName().equalsIgnoreCase(person));
						return entity;
					
				}
			}
		return null;
	}
	public void deletePerson() {
		System.out.println("Enter the person name to be delete");
		String personName = sc.next();
		Entity entity = getEntity(personName);
		if(personName == null) {
			System.out.println("No such person in book ");
		}
		else {	
			list.remove(personName);

		}
		
	}
	public void search() {
		int count = 0 ; 
		System.out.println("Enter the city");
		String city = sc.next() ;
		for (Entity entity : list) {
			if(entity.getCity().contains(city));{
				System.out.println(entity);
				count ++;
		}
	}
		System.out.println("Total number of person from this city ::" + count);
		
	}
}



