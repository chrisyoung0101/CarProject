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



/**
 * This servlet creates customer files from CustomerSignUp.jsp.  It writes and saves to file.
 * 
 * Servlet implementation class CustomerAccountsServlet
 */
@WebServlet("/CustomerAccountsServlet")
public class CustomerAccountsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAccountsServlet() {
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
				ArrayList<Customer> customerAccounts = (ArrayList<Customer>) session.getAttribute("customer");
						
						
				//fetch courseList from session if it exists
						//if session has no courseList it is null.  If null, create a new list from scratch
				if(customerAccounts == null) {
					customerAccounts = new ArrayList<Customer>();
					
						}
				
				
				//************************************************************************
				
				
				Customer customer = new Customer();
				
				
				
				customer.setfName(request.getParameter("fName"));
				customer.setlName(request.getParameter("lName"));
				customer.setAddress(request.getParameter("address"));
				customer.setEmail(request.getParameter("email"));
				
				
				
				System.out.println(customer);
				
				customerAccounts.add(customer);
				
				customer.saveToFile();
				
				//sets the attribute "student" = student;   
				session.setAttribute("customerAccounts", customerAccounts);
				
				//Navigate to account page
				//Identifies the next page to go to after user is done with registration
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
				
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
