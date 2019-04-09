package com.user;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Car {
	private String make;
	private String model;
	private String year;
	private String condition; //used or new
	private String miles;
	private String purchaseDate; 
	private String purchasePrice;
	private String sellPrice;
	private String description;
	private int ID;
	private final static String path="/Users/chrisyoung/Documents/carText/";
	private LocalDate localDate;//this is your LocalDate object with all of its methods
	private Boolean expired;
	
	
	
	
	public Car() {
		
		
	}
	
	
	
	
	
	public Boolean getExpired() {
		return expired;
	}





	public void setExpired(Boolean expired) {
		this.expired = expired;
	}





	public void setID(int iD) {
		ID = iD;
	}



	public LocalDate getLocalDate() {
		return localDate;
	}






	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}












	public String getPurchasePrice() {
		return purchasePrice;
	}


	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}


	public String getSellPrice() {
		return sellPrice;
	}


	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}


public String getPurchaseDate() {
	return purchaseDate;
}


public void setPurchaseDate(String purchaseDate) {
	this.purchaseDate = purchaseDate;
}


public String getMake() {
	return make;
}


public void setMake(String make) {
	this.make = make;
}


public String getModel() {
	return model;
}


public void setModel(String model) {
	this.model = model;
}


public String getYear() {
	return year;
}


public void setYear(String year) {
	this.year = year;
}


public String getCondition() {
	return condition;
}


public void setCondition(String condition) {
	this.condition = condition;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public String getMiles() {
	return miles;
}





public void setMiles(String miles) {
	this.miles = miles;
}





public int getID() {
	
	
	return ID;
}


public void setID() {
	
	ID = (int) (Math.random() * Math.pow(10,  4));
	
}


//building .txt file and including unique ID 
public static Car readFromFile(int ID) {
	Car car = new Car();
	
			String shark = "shark";
			
			String fileName = path + shark + ID + ".txt";
				
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
				car.setMake(parsedLine[0]);
				car.setModel(parsedLine[1]);
				car.setYear(parsedLine[2]);
				car.setCondition(parsedLine[3]);
				car.setMiles(parsedLine[4]);
				car.setPurchaseDate(parsedLine[5]);
				car.setPurchasePrice(parsedLine[6]);
				car.setSellPrice(parsedLine[7]);
				//can't put this in a String[], so we need to parse it then set it. 
//				int parsePurchasePrice = Integer.parseInt(parsedLine[5]); 
//				car.setPurchasePrice(parsePurchasePrice);
				car.setDescription(parsedLine[8]);
				
				//car.setID();
				int parseID = Integer.parseInt(parsedLine[9]);
				car.setID(parseID);
				
				
				
			}
		}catch(FileNotFoundException e) {
			System.out.println("Invalid file name");
		}
		
		
		
	return car;
}

//save file 
	//Think about how you want to parse this data  
	//Be sure to put this where you are creating the object so that you can call method and saveToFile
	public void saveToFile() {
		
		String shark = "shark";
		
		String fileName = path + shark + ID + ".txt";
		
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
	
	
//	public boolean checkSpecialPricing(String purchaseDate) {
//		// Need to check if the date from today and purchase date is greater than 120
//		specialPricing = false;
//		// This is todays date
//		LocalDate today = LocalDate.now();
//
//		// Here I am formatting the purchaseDate we grab from the data
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDate dateConvert = LocalDate.parse(purchaseDate, formatter);
//
//		// This is the today's date minus 120
//		LocalDate day120 = today.minusDays(120);
//		System.out.println("Day 120: " + day120);
//
//		Long timeLapsed = ChronoUnit.DAYS.between(dateConvert, day120);
//		System.out.println("Number of days since added into system: " + timeLapsed);
//
//		if(timeLapsed > 120) {
//		specialPricing = true;
//		}
//		return specialPricing;
//		}
	
	public boolean isExpired(String purchaseDate) {
		
		//System.out.println("purchaseDate : " + purchaseDate);
		//set as field 
		expired = false;
		
		//get todays date 
		LocalDate today = LocalDate.now();
		//System.out.println("Today's date in original format : " + today);
		
		//
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		//System.out.println("Today's date reformatted : " + formatter);
		
		//Parsing into a LocalDate type? 
		LocalDate dateConvert = LocalDate.parse(purchaseDate, formatter);
		//System.out.println("dateConvert  : " + dateConvert);
		
		//subtract today from purhaseDate to get days in inventory
//		LocalDate expirationDate = today.minusDays(purchaseDate);
//		System.out.println("Expires on : " + expirationDate);
		
		Long timeLapsed = ChronoUnit.DAYS.between(dateConvert, today);
		//System.out.println("Car has been in inventory :" + timeLapsed + " days");
		
		if(timeLapsed > 120) {
			expired = true;
		}
		
		return expired;
		
	}

////add checkCurrentDate??
//no one else needs to accesss this method but this class so make it private 
private String formatData(){
	//firstName = 0 first that got stored 
	return this.make + "," + this.model + "," + this.year + "," + this.condition + ","  + this.miles + ","
			
			+ this.purchaseDate + "," + this.purchasePrice + "," + this.sellPrice + "," + this.description + "," + this.ID;
}

//add checkCurrentDate??
public String toString() {
return this.make + "," + this.model + "," + this.year + "," + this.condition + ","  + this.miles + ","
			
			+ this.purchaseDate + "," + this.purchasePrice + "," + this.sellPrice + "," + this.description + "," + this.ID;
}


public void today() {
	
	
	
}


	
}

	
	

	


