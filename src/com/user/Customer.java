package com.user;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Customer {
	
	private String fName;
	private String lName;
	private String address;
	private String email;
	private final static String path="/Users/chrisyoung/Desktop/customerAccounts/";
	//private int ID;
	
	
	
	public Customer() {}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public static String getPath() {
		return path;
	}
	
	//building .txt file and including unique ID 
	public static Customer readFromFile(String email) {
		Customer customer = new Customer();
		
				
				String fileName = path + email + ".txt";
					
			try {
				
				Scanner scanner = new Scanner(new File(fileName));
				while(scanner.hasNextLine()) {
					//grab user input 
					String line = scanner.nextLine();				
					//each comma will represent a position in the array
					//Create a String array called parseLine. Set it to line which is the user input.  
					//Split the array with a comma 
					String[] parsedLine = line.split(",");
					
					

					//set the new car object 
					//car.setMake(parsedLine[0]);
					customer.setfName(parsedLine[0]);
					customer.setlName(parsedLine[1]);
					customer.setAddress(parsedLine[2]);
					customer.setEmail(parsedLine[3]);
					
					
					
					
				}
			}catch(FileNotFoundException e) {
				System.out.println("Invalid file name");
			}
			
			
			
		return customer;
	}

	//save file 
		//Think about how you want to parse this data  
		//Be sure to put this where you are creating the object so that you can call method and saveToFile
		public void saveToFile() {
			
			System.out.println("saveToFile method");
			
			String fileName = path + email + ".txt";
			
			try {
			BufferedWriter bw = 
					new BufferedWriter(new FileWriter(fileName));
			bw.write(formatData());
			//close stream or it will not write 
			bw.close();
			} catch (IOException e) {
				System.out.println("Save to file failed");
			}
		}
		
	////add checkCurrentDate??
		//no one else needs to accesss this method but this class so make it private 
		private String formatData(){
			//firstName = 0 first that got stored 
			return this.fName + ", " + this.lName + ", " + this.getAddress() + ", " + this.email;
		}

		

	@Override
	public String toString() {
		return "Customer [fName= " + fName + ", lName= " + lName + ", address= " + address + ", email= " + email + "]";
	};
	
	
	
	

}
