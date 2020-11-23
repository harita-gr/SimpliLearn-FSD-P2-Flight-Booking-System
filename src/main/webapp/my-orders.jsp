<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="java.util.*,com.*" %>  

<%@include file="header.html" %>
<div id="navbar">
  <ul>
     <li><a href="home.jsp">Hi User </a> </li>
     <li><a href="#" class="active">MY PROFILE</a> </li>
     <li><a href="LogoutServlet" onclick="if(!(confirm('Are you sure you want to logout?')))return false">LOGOUT </a></li>
  </ul>
 </div> 
         
 <div id="option-container" style="border:2px solid black;background-color:white;opacity:0.9;margin: auto;width:50%;padding:15px;">
 <h2>MY ORDERS</h2><br>
 
 <% List<BookingDetails> orders = (List<BookingDetails> )request.getAttribute("ORDER_LIST"); 
 
  for(BookingDetails order : orders) {
	  
	out.println("______________________________________________"+"<br>");	  
    out.println("Full Name: "+ order.getFullName()+"<br>");
    out.println("Age: "+ order.getAge()+"<br>");
    out.println("Email: "+ order.getEmail()+"<br>");
    out.println("Date: "+ order.getDate()+"<br>");
    out.println("Source: "+ order.getBookedflight().getSource()+"<br>");
    out.println("Destination: "+ order.getBookedflight().getDestination()+"<br>");
    out.println("No of People: "+ order.getNo_of_ppl()+"<br>");
    out.println("Total Fare: "+ order.getBookedflight().getFare()*order.getNo_of_ppl()+"<br>");
    
    out.println("______________________________________________"+"<br>");

}
  %>
  
 <button  style="margin-left:40px;padding: 10px 24px;font-size: 16px;background-color: #00cc00;cursor:pointer;border-radius:12px" onclick="window.location.href='my-profile.jsp';return false;">BACK TO PROFILE</button>      
       
 
 </div>
 
 <%@include file="footer.html" %>