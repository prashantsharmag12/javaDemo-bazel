package net.javaguides.todoapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.todoapp.dao.UserDao;
import net.javaguides.todoapp.model.User;

/**
 * @email Ramesh Fadatare
 */

@WebServlet("/register")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

	public void init() {
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		System.out.println("in the post");
		register(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("register/register.jsp");
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("userName");
		String password = request.getParameter("password");

		User employee = new User();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setUsername(username);
		employee.setPassword(password);

		try {
			
			//int result = userDao.registerEmployee(employee);
			//System.out.println("result is "+ result);
			
			System.out.println("before callong mongo db");
			
			int ans = userDao.registerEmployeeMongo(employee);
			
			System.out.println("unreachable point");
			
		
			if(ans==1)
			{
			request.setAttribute("NOTIFICATION", "User Registered Successfully!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
			dispatcher.forward(request, response);
			}
			else
			{
				request.setAttribute("NOTIFICATION", "User Not Registered!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
				dispatcher.forward(request, response);
				
			}
			
			
		} catch (Exception e) {
			System.out.println("not able to connect in the post");
			e.printStackTrace();
		}
		request.setAttribute("NOTIFICATION", "User Not Registered!");
		RequestDispatcher dispatcher = request.getRequestDispatcher("register/register.jsp");
		dispatcher.forward(request, response);
	}
}
