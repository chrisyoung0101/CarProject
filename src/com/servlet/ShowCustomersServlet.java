package com.servlet;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.user.Customer;


/**
 * This servlet reads the .txt files 
 * 
 * Servlet implementation class ShowCustomersServlet
 */
@WebServlet("/ShowCustomersServlet")
public class ShowCustomersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCustomersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		ArrayList<Customer> customerAccounts = (ArrayList<Customer>) session.getAttribute("customer");
		
		if(customerAccounts == null) {
			customerAccounts = new ArrayList<Customer>();
		}
		
		File directory = new File("/Users/chrisyoung/Desktop/customerAccounts");
		
		
		File[] files = directory.listFiles();
		
		
		for(int i = 0; i < files.length; i++) {
			
			Customer customer = new Customer();
			
			
			try {
				Scanner scanner = new Scanner(new File(files[i].toString()));
				
				while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parsedLine = line.split(",");
				
				
				customer.setfName(parsedLine[0]);
				customer.setfName(parsedLine[1]);
				customer.setAddress(parsedLine[2]);
				customer.setEmail(parsedLine[3]);
				
				
				} 
				
			} catch(FileNotFoundException e) {
				System.out.println("Invalid file name");
			}
			
			customerAccounts.add(customer);
			
		}
			
		
session.setAttribute("customerAccounts", customerAccounts);
		
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
