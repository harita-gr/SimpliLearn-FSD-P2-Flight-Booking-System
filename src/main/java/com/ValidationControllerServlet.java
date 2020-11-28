package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;


/**
 * Servlet implementation class ValidationControllerServlet
 */
//@WebServlet("/ValidationControllerServlet")

public class ValidationControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserDbUtil userDbUtil;	
	
	//Resource Injection
	@Resource(name="jdbc/flight_booking")
	private DataSource dataSource; // Creating handle
	
	
	@Override // First called by Tomcat/server when it is first initialized
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		//create our user db util..and pass in the conn pool/datasource
		try {
			userDbUtil = new UserDbUtil(dataSource);
			
		}
		catch (Exception e){
			throw new ServletException(e) ;
	    }
	  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		       try {		    	   
		            // read the "command" parameter
					String theCommand = request.getParameter("command");
					
					//if command is missing,then default to listing students
					if (theCommand==null) {
						theCommand="SIGNUP";
					}
					//route to appropriate method
				    switch(theCommand){
				    
				    case "SIGNUP":
				    	registerUser(request,response);
				    	break;
				    case "LOGIN":
				    	validateLogin(request,response);
				        break;
				    case "ADMIN":
				    	adminLogin(request,response);				    
				    default:
				    	validateLogin(request,response);			      
				    }	
				    
				} catch (Exception e) {
					System.out.println("Exception Occured: "+e);
				}
			}

	private void adminLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		       //read admin info from form data
		
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				
				//create new admin user object
				AdminUser admin = new AdminUser(username,password);
				
				//pass the value to DAO to perform DB operation
					
				String dbPassword=userDbUtil.validateAdminLogin(admin);
				RequestDispatcher rd= null;
				PrintWriter out=response.getWriter();
				
				if(password.equals(dbPassword))
				{
					//Create Session (THIRD CASE) & Navigate to Home Page	if success	= FORWARD 
					HttpSession session=request.getSession(); 
					   if(session.isNew()) {
				        	System.out.println("New Session Created:" +session.getId());
				        }
					
					session.setAttribute("username",username);			
					
					rd= request.getRequestDispatcher("admin_home.jsp");
					out.println("<script>document.getElementById('error').innerHTML=''; </script>");
					rd.forward(request, response);
				}
				    //If failure, print error message in login page = INCLUDE
				else {
					rd=request.getRequestDispatcher("admin_login.html");
					rd.include(request, response); // HTML page output + output of else condition will be printed
					out.println("<script>document.getElementById('error').innerHTML='Invalid UserName or Password!'; </script>");
				}		
			}

	private void validateLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//read user info from form data
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		//create new user object
		User theUser = new User(email,password);
		
		//pass the value to DAO to perform DB operation
			
		String dbPassword=userDbUtil.validateLogin(theUser);
		RequestDispatcher rd= null;
		PrintWriter out=response.getWriter();
		
		
		
		if(password.equals(dbPassword))
		{
			//Create session (SECOND CASE) & Navigate to Home Page	if success	= FORWARD
			User profileDetails = userDbUtil.getProfileDetails(email);
			
			HttpSession session=request.getSession(); 
	        if(session.isNew()) {
	        	System.out.println("New Session Created:" +session.getId());
	        }			
			
			session.setAttribute("USER_DETAILS", profileDetails);
			session.setAttribute("username",profileDetails.getFname());
			session.setAttribute("user_email", email);
			rd= request.getRequestDispatcher("home.jsp");
			out.println("<script>document.getElementById('error').innerHTML=''; </script>");
			rd.forward(request, response);
		}
		    //If failure, print error message in login page = INCLUDE
		else {

			rd=request.getRequestDispatcher("login.html");			
			rd.include(request, response); // HTML page output + output of else condition will be printed
			out.println("<script>document.getElementById('error').innerHTML='Invalid UserName or Password!'; </script>");
		}		
	}

	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//read user info from form data
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String phno=request.getParameter("phno");
		String password=request.getParameter("password");
		
		//create new user object
		User theUser = new User(firstName,lastName,email,phno,password);
		
		//pass the value to DAO to perform DB operation
			
		userDbUtil.registerUser(theUser);
		System.out.println("User Registered Succesfully!");
		
		//Create Session - FIRST CASE
		HttpSession session=request.getSession(); 
        if(session.isNew()) {
        	System.out.println("New Session Created:" +session.getId());
        }
		session.setAttribute("username",firstName);
		session.setAttribute("user_email", email);
		//Navigate to Home Page		
		RequestDispatcher rd= request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}
	
	
	
}


