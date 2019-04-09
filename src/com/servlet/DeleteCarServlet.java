package com.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Car;

/**
 * Servlet implementation class DeleteCarServlet
 */
@WebServlet("/DeleteCarServlet")
public class DeleteCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
HttpSession session = request.getSession(true);
		
		//argument of String values "carCards" is null when there is not carList on session
		ArrayList<Car> carCards = (ArrayList<Car>) session.getAttribute("carCards");
						
						
				//fetch carCards from session if it exists
				//if session has no carCards it is null.  If null, create a new list from scratch
				//we will fill this ArrayList<Car> with car objects below
				if(carCards == null) {
					carCards = new ArrayList<Car>();
						}
		
		
		//create a new file object passing in the path of the directory to be read
		File directory = new File("/Users/chrisyoung/Documents/carText/");
		
		
		
		//return an array of pathnames and set it to File[] files.
		File[] files = directory.listFiles();
		
		
		
		//System.out.println("This # of files: " + files.length);
		
		//*****************if not working, delete carText folder and create another carText folder***********
		for(int i = 0; i < files.length; i++) {
			
			System.out.println("***********************" + files[i].toString());
			
			//create a new car object on each loop
			Car car = new Car();
			
			
			
			try {
				Scanner scanner = new Scanner(new File(files[i].toString()));
				
				
				
				while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parsedLine = line.split(",");
				
				
				
				car.setMake(parsedLine[0]);
				car.setModel(parsedLine[1]);
				car.setYear(parsedLine[2]);
				car.setCondition(parsedLine[3]);
				car.setMiles(parsedLine[4]);
				car.setPurchaseDate(parsedLine[5]);
				car.setPurchasePrice(parsedLine[6]);
				car.setSellPrice(parsedLine[7]);
				car.setDescription(parsedLine[8]);
				int parseID = Integer.parseInt(parsedLine[9]);
				car.setID(parseID);
				
				}
				
			} catch(FileNotFoundException e) {
				System.out.println("Invalid file name");
			}
			
			
			
			//set current date on car.
			car.setLocalDate(LocalDate.now());
			//System.out.println("Reading Line 106 from CreateCarServlet");//reads this line 
			car.isExpired(car.getPurchaseDate());
			//System.out.println("Reading Line 108 from CreateCarServlet");//not reading
			
			
			//System.out.println("isExpired Method : " + car.isExpired(car.getPurchaseDate()));
			
//			String make = car.getMake();
//			System.out.println("make ------------->" + make);
			
			
			//remove method? 
			
			
			
			carCards.add(car);
			//System.out.println("******************************");
			//System.out.println(car.getLocalDate());
			
			System.out.println(files[i]);
			
			
				//set the current item to make read from file
				String make = carCards.get(i).getMake();
				Car carToShow;
				
				String makeInput = request.getParameter("makeInput");
				
				//makeInput is the make of the car input from the user
				//if `makeInput` matches `make` delete it.  Refer to DeleteFileTest Class for more about deleting file
				if(make.equals(makeInput)) {
					//String path = "";
					File deleteFile = new File(files[i].toString() + "/");
					deleteFile.delete();
					System.out.println(carCards.get(i));
					carToShow = carCards.get(i);
					System.out.println("******************************CAR TO DELETE  " + carToShow);
					System.out.println("***********************%%%%%%%%File TO DELETE  " + files[i]);
					session.setAttribute("carToShow", carToShow);
					
				} 
			
			
		}
		
		
		
		//Grab input data from search
		String makeInput = request.getParameter("makeInput");
		
		System.out.println("******************************MakeInput  " + makeInput);
		
		//grab the make value of the car object
		//String make = carCards.get(0).getMake();
		
		
		for (int i = 0; i < carCards.size(); i++) {
			
			String make = carCards.get(i).getMake();
			Car carToShow;
		     
			if(make.equals(makeInput)) {
				System.out.println(carCards.get(i));
				carToShow = carCards.get(i);
				//System.out.println("******************************CAR TO DELETE  " + carToShow);
				session.setAttribute("carToShow", carToShow);
				
			} 
//			else {
//				System.out.println("****************** CAR NOT AVAILABLE *****************");
//			}
			
		    }
		
		
		
		
		//session.setAttribute("carCards", carCards);
		
		RequestDispatcher rs = request.getRequestDispatcher("inventory.jsp");			
	    rs.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
