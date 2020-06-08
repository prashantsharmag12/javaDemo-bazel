package net.javaguides.todoapp.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.todoapp.dao.TodoDao;
import net.javaguides.todoapp.dao.TodoDaoImpl;
import net.javaguides.todoapp.model.LoginBean;
import net.javaguides.todoapp.model.Todo;

@WebServlet("/")
public class TodoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private TodoDao todoDAO;

	
   public void init()
   {
	   todoDAO = new TodoDaoImpl();
   }
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

	
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		  throws ServletException, IOException {
		
	
	  String action = request.getServletPath();
	  switch(action) {
	  
	  case "/new":
		  showNewForm(request,response);
		  break;
	  case "/insert":
		  insertTodo(request,response);
		  break;
	  case "/delete":
		  deleteTodo(request,response);
		  break;
	  case "/edit":
		  showEditTodo(request,response);
		  break;
	  case "/edit?:id":
		  showEditTodo(request,response);
		  break;
	  case "/list":
		  listTodo(request,response);
		  break;
	  case "/update":
		  updateTodo(request,response);
		  break;
	 
	 default:
		 RequestDispatcher dispatcher = request.getRequestDispatcher("login/login.jsp");
		 dispatcher.forward(request, response);
		 break;
	  
	  }
	  
	  
	}


private void updateTodo(HttpServletRequest request, HttpServletResponse response) 
		throws IOException {
	
	String id = request.getParameter("id");
	String title = request.getParameter("title");
	String description = request.getParameter("description");
	String username = request.getParameter("username");
	
     LoginBean loginbean = (LoginBean)request.getSession().getAttribute("currentSessionUser");
	
	System.out.println("usename is fdfdfdfd fdfdf "+loginbean.getUsername());
	System.out.println("value of user is");

	username = loginbean.getUsername();
	
	String targetDate =request.getParameter("targetDate");
	boolean isDone = Boolean.valueOf(request.getParameter("isDone"));
	
	Todo updateTodo = new Todo(id,title,username,description,targetDate,isDone);
	
	todoDAO.updateTodoMongo(updateTodo);
	
	response.sendRedirect("list");
	
	
}


private void listTodo(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	
	
	System.out.println(request.getParameter("username"));
	//List<Todo> listTodo = todoDAO.selectAllTodos((LoginBean)request.getSession().getAttribute("currentSessionUser"));
	
	List<Todo> listTodoMongo = todoDAO.selectAllTodosMongo((LoginBean)request.getSession().getAttribute("currentSessionUser"));
	
	System.out.println("in the list");
	request.setAttribute("listTodo", listTodoMongo);
	RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-list.jsp");
	
	dispatcher.forward(request, response);
	
	
}


private void showEditTodo(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	
	String id =request.getParameter("id");
	
	System.out.println("id i want is "+id);
	
	Todo existingTodo = todoDAO.selectTodoMongo(id);
	
	System.out.println("in the edit ");
	System.out.println(existingTodo);
	System.out.println(id);
	RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
	request.setAttribute("todo", existingTodo);
	dispatcher.forward(request, response);
	
}


private void deleteTodo(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	
   String id = request.getParameter("id");
	
	boolean value = todoDAO.deleteTodoMongo(id);
	
	System.out.println("in the deleted todo mongo "+value);
	
	response.sendRedirect("list");
	
	
}


private void insertTodo(HttpServletRequest request, HttpServletResponse response) 
		throws IOException {
	
	String title=request.getParameter("title");
	String description = request.getParameter("description");
	String username = request.getParameter("userName");
	Boolean isDone = Boolean.valueOf(request.getParameter("idDone"));
	
	LoginBean loginbean = (LoginBean)request.getSession().getAttribute("currentSessionUser");
	
	System.out.println("usename is fdfdfdfd fdfdf "+loginbean.getUsername());
	System.out.println("value of user is");
	System.out.println(request.getParameter("myhiddenvalue"));
	username = loginbean.getUsername();
	String targetDate = request.getParameter("targetDate");
	
	
	
	Todo newTodo = new Todo(title,username,description,targetDate,isDone);
	
	//todoDAO.insertTodo(newTodo);
	System.out.println("inserting in the todos");
	todoDAO.insertTodoMongo(newTodo);
	System.out.println("successfully in the todos");
	response.sendRedirect("list");
	
	
	
	
	
}


private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("todo/todo-form.jsp");
	dispatcher.forward(request, response);
	
}

}
