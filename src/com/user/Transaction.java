package com.user;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Transaction implements Comparable<Transaction> {

private String carDescription;
private String price;
private String customerName;
private String email;
private String date;
private final static String path="/Users/chrisyoung/Documents/transactionLog/";


public Transaction() {}



public String getCarDescription() {
	return carDescription;
}



public void setCarDescription(String carDescription) {
	this.carDescription = carDescription;
}



public String getPrice() {
	return price;
}



public void setPrice(String price) {
	this.price = price;
}



public String getCustomerName() {
	return customerName;
}



public void setCustomerName(String customerName) {
	this.customerName = customerName;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getDate() {
	return date;
}



public void setDate(String date) {
	this.date = date;
}



public static String getPath() {
	return path;
}

//building .txt file and including unique ID 
	public static Transaction readFromFile(String email) {
		
		Transaction transaction = new Transaction();
		
				
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
					
					

					
					
					transaction.setCarDescription(parsedLine[0]);
					transaction.setPrice(parsedLine[1]);
					transaction.setCustomerName(parsedLine[2]);
					transaction.setEmail(parsedLine[3]);
					transaction.setDate(parsedLine[4]);
					

					
					
					
				}
			}catch(FileNotFoundException e) {
				System.out.println("Invalid file name");
			}
			
			
			
		return transaction;
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
		
	
private String formatData(){
			
			return this.carDescription + "," + this.price + "," + this.customerName + "," + this.email + "," + this.date;
			
		}

//public int compareTo(Transaction s)
//{
//    return this.date - s.date;     //Sorts the objects in ascending order
//     
//    // return s.id - this.id;    //Sorts the objects in descending order
//}



@Override
public String toString() {
	return "Transaction [carDescription=" + carDescription + ", price=" + price + ", customerName=" + customerName
			+ ", email=" + email + ", date=" + date + "]";
}

//https://stackoverflow.com/questions/2784514/sort-arraylist-of-custom-objects-by-property/2784576#2784576
// NEED interface above : public class Transaction implements Comparable<Transaction> {


@Override
public int compareTo(Transaction transaction) {
	// TODO Auto-generated method stub
	return customerName.compareTo(transaction.getCustomerName());
}

	
	
	
}
