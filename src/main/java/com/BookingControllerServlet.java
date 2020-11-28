package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class BookingControllerServlet
 */
public class BookingControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookingDbUtil bookingDbUtil;
	
	//Resource Injection
	@Resource(name="jdbc/flight_booking")
	private DataSource dataSource; // Creating handle

	
	
	@Override // First called by Tomcat/server when it is first initialized
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		//create our booking db util..and pass in the conn pool/datasource
		try {
			bookingDbUtil = new BookingDbUtil(dataSource);
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
					theCommand="HOME";
				}
				//route to appropriate method
			    switch(theCommand){
			    
			    case "HOME":
			    	viewHomePage(request,response);
			    	break;
			    case "SEARCH":
			    	searchFlight(request,response);
			        break;
			    case "BOOK":
			    	bookFlight(request,response);	
			    	break;
			    case "CONFIRM":
			    	confirmDetails(request,response);
			    case "EDIT":
			    	editDetails(request,response);
			    case "PAY":
			    	makePayment(request,response);
			    default:
			    	viewHomePage(request,response);			      
			    }	
			    
			} catch (Exception e) {
				System.out.println("Exception: "+e);
			}
		}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				       try {
				    	   		     	   
		            // read the "command" parameter
					String theCommand = request.getParameter("command");
					
					//if command is missing,then default to listing students
					if (theCommand==null) {
						theCommand="HOME";
					}
					//route to appropriate method
				    switch(theCommand){
				    
				    case "HOME": 
				    	viewHomePage(request,response);
				    	break;
				    case "SEARCH":
				    	searchFlight(request,response);
				        break;
				    case "BOOK":
				    	bookFlight(request,response);	
				    	break;
				    case "CONFIRM":
				    	confirmDetails(request,response);	
				    	break;
				    case "EDIT":
				    	editDetails(request,response);
				    case "PAY":
				    	makePayment(request,response);
				    default:
				    	viewHomePage(request,response);			      
				    }	
				    
				} catch (Exception e) {
					System.out.println("Exception: "+e);
				}
	
	}
	
	private void makePayment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		HttpSession session=request.getSession(false); 
		BookingDetails order_success=(BookingDetails) session.getAttribute("BookingUserDetail");
		System.out.println("SUCCESS 1");
		String src= String.valueOf(session.getAttribute("book_source"));
		System.out.println("SUCCESS 2");
		String dest=(String)session.getAttribute("book_dest");
		System.out.println("SUCCESS 3");
		String fid=(String) session.getAttribute("book_flightID");
		System.out.println("SUCCESS 4");
        float fare=Float.parseFloat((String) session.getAttribute("book_fare"));
        System.out.println("SUCCESS 5");
        String aline=(String) session.getAttribute("book_airline");
        System.out.println("SUCCESS 6");
        String date = (String) session.getAttribute("book_date");
        System.out.println("SUCCESS 7");
        int ppl = Integer.parseInt( (String) session.getAttribute("book_no_of_ppl"));
        System.out.println("SUCCESS z");
        
		bookingDbUtil.saveOrderDetails(order_success,src,dest,fid,fare,aline,date,ppl);  
		RequestDispatcher dispatcher=request.getRequestDispatcher("payment-success.jsp");
		dispatcher.forward(request, response);	
	}

	//Need to Edit
	private void editDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, Exception {
		RequestDispatcher dispatcher;
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		BookingDetails details=(BookingDetails) session.getAttribute("BookingUserDetail");
		
//		String fullName=details.getFullName();
//		int age=details.getAge();
//		String email=details.getEmail();
//		String address=details.getAddress();
		
		dispatcher = request.getRequestDispatcher("book-flight.jsp");
		dispatcher.include(request, response);
		out.println("<script>document.getElementById('fullName').value=details.getFullName(); </script>");		   
	
	}
      
	
	private void confirmDetails(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		//read student info from form data
		String fullName=request.getParameter("fullName");
		int age=Integer.parseInt(request.getParameter("age"));
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		
		HttpSession session=request.getSession(); 	//check later	
		
		BookingDetails details=new BookingDetails(fullName,age,email,address);
		request.setAttribute("BookingUserDetail", details);
		session.setAttribute("BookingUserDetail", details);
		RequestDispatcher rd= request.getRequestDispatcher("confirm-flight.jsp");
		rd.forward(request, response);	
		
	}
	private void bookFlight(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
	
		RequestDispatcher rd=null;
	    HttpSession session=request.getSession(false);
	    PrintWriter out=response.getWriter();
	    
//	    if(session.isNew()) {
//        	System.out.println("New Session Created @BC-BOOK:" +session.getId());
//        }
	    
	    if(session!=null) {
	  //flight details stored in session
	    System.out.println("Session Active - Book Now!");
		session.setAttribute("book_flightID",request.getParameter("flightID"));
		session.setAttribute("book_fare",request.getParameter("fare"));
		session.setAttribute("book_source",request.getParameter("source"));
		session.setAttribute("book_dest",request.getParameter("destination"));
		session.setAttribute("book_airline",request.getParameter("airline"));		
		
		System.out.println("session flightDetails:" +session.getAttribute("book_flightID")+session.getAttribute("book_fare"));
		rd= request.getRequestDispatcher("book-flight.jsp");
		rd.forward(request, response);	
	    }
	    else {
	    	System.out.println("User not logged in!");
	    	
	    	rd=request.getRequestDispatcher("login.html");			
			rd.include(request, response); // HTML page output + output of else condition will be printed
			out.println("<script>document.getElementById('loginalert').innerHTML='Please Login to Continue'; </script>");
	    }
	}

	private void searchFlight(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//read search info from form data
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		HttpSession session=request.getSession(false);

		if(session!=null) {
			session.setAttribute("book_date",request.getParameter("date"));//data calender data
			session.setAttribute("book_no_of_ppl", request.getParameter("no-of-people"));
//			System.out.println("session date:" +session.getAttribute("book_date"));
//			System.out.println("session id:" +session.getId() + " "+session.getCreationTime());
		}
		else {
			   request.setAttribute("book_date", request.getParameter("date"));
			   request.setAttribute("book_no_of_ppl",request.getParameter("no-of-people"));
		}

		List<Flight> flightList=bookingDbUtil.searchFlight(source,destination);
		for(int i=0;i<flightList.size();i++) {
			System.out.println(flightList.get(i));
		}
		
		RequestDispatcher dispatcher;
		PrintWriter out=response.getWriter();
		
		if(flightList.size()==0) {
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.include(request, response);	
			out.println("<script>document.getElementById('error').innerHTML='NO RESULTS FOUND!!'; </script>");
		}
		else {
		
		// add flight details to the request as attribute
		request.setAttribute("FLIGHT_LIST", flightList);
		
		//send to JSP page(view)
	    dispatcher = request.getRequestDispatcher("search-results.jsp");
		dispatcher.forward(request, response);		
		}
	}

	private void viewHomePage(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {
		RequestDispatcher rd= request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);		
	}
	

}
