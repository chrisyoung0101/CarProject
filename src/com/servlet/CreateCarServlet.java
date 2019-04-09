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

import com.user.Car;


/**
 * Servlet implementation class CreateCarServlet
 */
@WebServlet("/CreateCarServlet")
public class CreateCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCarServlet() {
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
		ArrayList<Car> carList = (ArrayList<Car>) session.getAttribute("carList");
				
				
		//fetch courseList from session if it exists
				//if session has no courseList it is null.  If null, create a new list from scratch
		if(carList == null) {
					carList = new ArrayList<Car>();
				}
		
		//************************************************************************
		
		Car car = new Car();
		
		car.setMake(request.getParameter("make"));
		car.setModel(request.getParameter("model"));
		car.setYear(request.getParameter("year"));
		car.setCondition(request.getParameter("condition"));
		car.setMiles(request.getParameter("miles"));
		car.setPurchaseDate(request.getParameter("purchaseDate"));
		car.setPurchasePrice(request.getParameter("purchasePrice"));
		car.setSellPrice(request.getParameter("sellPrice"));
		car.setDescription(request.getParameter("description"));
		car.setID();
		
		
		carList.add(car);
		
		car.saveToFile();
		
		//sets the attribute "student" = student;   
		session.setAttribute("carList", carList);
		
		//Navigate to account page
		//Identifies the next page to go to after user is done with registration
		RequestDispatcher rs = request.getRequestDispatcher("AddNewCar.jsp");
		
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
