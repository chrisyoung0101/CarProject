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

import com.user.Transaction;
import com.user.Car;
/**
 * Servlet implementation class OfferServlet
 */
@WebServlet("/OfferServlet")
public class OfferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OfferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//SESSION : get session object from request --> we don't create session
				//pull session data from request object
				HttpSession session = request.getSession(true);
				
				
				System.out.println("##################################################");
				String offer = request.getParameter("offer");
				System.out.println("offer " + offer);
				
				//remove first char of string
				offer = offer.substring(1);
					System.out.println("offer.substring(1) " + offer);
				
				//convert offer to int 
				int offerInt = Integer.parseInt(offer);
					System.out.println("offerInt  " + offerInt);
				
				String originalPrice = request.getParameter("originalPrice");
					System.out.println("originalPrice  " + originalPrice);
				
				//remove first char of string
				originalPrice = originalPrice.substring(1);
					System.out.println("originalPrice.substring(1)  " + originalPrice);
				
				//convert originalPrice to int 
				int originalPriceInt = Integer.parseInt(originalPrice);
					System.out.println("originalPriceInt  " + originalPriceInt);
							
				//take 10% off 
				//int k = (int)(value*(10.0f/100.0f));
				int discountPrice = (int)(originalPriceInt * (90.0f/100.0f));
					System.out.println("discountPrice  " + discountPrice);
				//convert discountPrice to String
				//String numberAsString = Integer.toString(number);
				//String discountPriceString = Integer.toString(discountPrice);
				
				
				
				System.out.println("##################################################");
				
				
				if (offerInt < discountPrice) {
					//reject offer
					//send back to offer.jsp
					System.out.println("You are a cheapskate!  Rejected!");
					String rejected = "DeclineOffer.jsp";
					response.sendRedirect(rejected);
					return;
				} 
				
				System.out.println("Offer accepted");
				
				
				
				
				
				
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
				transaction.setPrice(request.getParameter("offer"));
				transaction.setCustomerName(request.getParameter("customerName"));
				transaction.setEmail(request.getParameter("email"));
				transaction.setDate(request.getParameter("date"));
				
				
				
				//if(transaction.getPrice() 
				
				//System.out.println(customer);
				
				transactionLog.add(transaction);
			
				
				transaction.saveToFile();
				
				//sets the attribute "student" = student;   
				session.setAttribute("transactionLog", transactionLog);
				
				//Navigate to account page
				//Identifies the next page to go to after user is done with registration
				RequestDispatcher rs = request.getRequestDispatcher("offerAccepted.jsp");
				
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
