package com.servlet;

import java.io.IOException;

import java.util.ArrayList;


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
 * Servlet implementation class TransactionServlet
 */
@WebServlet("/TransactionServlet")
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//SESSION : get session object from request --> we don't create session
		//pull session data from request object
		HttpSession session = request.getSession(true);
		
		//argument "carList" is null when there is not carList on session
		ArrayList<Transaction> transactionLog = (ArrayList<Transaction>) session.getAttribute("transaction");
				
				
		//fetch courseList from session if it exists
				//if session has no courseList it is null.  If null, create a new list from scratch
		if(transactionLog == null) {
			transactionLog = new ArrayList<Transaction>();
			
				}
		
		
		//************************************************************************
		
		Transaction transaction = new Transaction();
		
		
		transaction.setCarDescription(request.getParameter("carDescription"));
		transaction.setPrice(request.getParameter("price"));
		transaction.setCustomerName(request.getParameter("customerName"));
		transaction.setEmail(request.getParameter("email"));
		transaction.setDate(request.getParameter("date"));
		
		
		
		//System.out.println(customer);
		
		transactionLog.add(transaction);
	
		
		transaction.saveToFile();
		
		//sets the attribute "student" = student;   
		session.setAttribute("transactionLog", transactionLog);
		
		//Navigate to account page
		//Identifies the next page to go to after user is done with registration
		RequestDispatcher rs = request.getRequestDispatcher("purchaseConfirmation.jsp");
		
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
