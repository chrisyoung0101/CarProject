package com.servlet;

import java.io.File;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.Customer;
import com.user.Transaction;

/**
 * Servlet implementation class ShowTransactions
 */
@WebServlet("/ShowTransactions")
public class ShowTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTransactions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
HttpSession session = request.getSession(true);
		
		ArrayList<Transaction> transactionReport = (ArrayList<Transaction>) session.getAttribute("transaction");
		
		if(transactionReport == null) {
			transactionReport = new ArrayList<Transaction>();
		}
		
		File directory = new File("/Users/chrisyoung/Documents/transactionLog/");
		
		
		File[] files = directory.listFiles();
		
		
		for(int i = 0; i < files.length; i++) {
			
			Transaction transaction = new Transaction();
			
			
			
			try {
				Scanner scanner = new Scanner(new File(files[i].toString()));
				
				while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parsedLine = line.split(",");
				
				transaction.setCarDescription(parsedLine[0]);
				transaction.setPrice(parsedLine[1]);
				transaction.setCustomerName(parsedLine[2]);
				transaction.setEmail(parsedLine[3]);
				transaction.setDate(parsedLine[4]);
				
				
				
				} 
				
			} catch(FileNotFoundException e) {
				System.out.println("Invalid file name");
			}
			
			
			String toSort = transaction.getDate();
			
			System.out.println("^^^^^^^^^^^^^^^^^^^>>>>>>>> date to sort " + toSort);
			//Collections.so(sorted);
			
			//ArrayList
			//transactionReport.methodThatArrangesByAsc
			
			
			transactionReport.add(transaction);
			System.out.println("^^^^^^^^^^^^^^^^^^^>>>>>>>> transaction " + transaction);
			
		}
		
		
		Collections.sort(transactionReport);
		
		System.out.println("%%%%%%%%%%%&&&&&&&%&&&&&&&&&%%%%%%%% transactionReport " + transactionReport.toString());
		
		session.setAttribute("transactionReport", transactionReport);
		
		RequestDispatcher rs = request.getRequestDispatcher("report.jsp");			
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
