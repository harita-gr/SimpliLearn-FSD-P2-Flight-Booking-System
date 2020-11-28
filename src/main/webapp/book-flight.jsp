<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@include file="header.html" %>

<div id="navbar">
  <ul>
     <li><a href="home.jsp">Hi User </a> </li>
     <li><a href="my-profile.jsp">MY PROFILE</a> </li>
     <li><a href="LogoutServlet" onclick="if(!(confirm('Are you sure you want to logout?')))return false">LOGOUT </a></li>
  </ul>
</div>
<h2 style="color:white"> BOOK YOUR FLIGHT</h2>

<div id="book-data-container" style="border:2px solid black;background-color:white;opacity:0.8;margin: auto;width:80%;padding:15px;">
<form method="post" action="BookingControllerServlet">
            <input type="hidden" name="command" value="CONFIRM">
            <h3> Fill your details to Register:</h3>
             <!-- Put new button: Clear Results -->
      <input type="button" value="Reset" onclick="window.location.href='home.jsp';return false;"class="reset-search-button" style="float:right">
            <div class="inputBox">
		               <label>Full Name</label>
		               <input class="input-field" type="text" name="fullName" placeholder="Enter your Full name" id="fullName">
		         </div><br>
		          <div class="inputBox">
		               
		               <label>Age</label>
		               <input class="input-field" type="text" name="age" placeholder="Enter your age" id="age">
		         </div><br>   
		         <div class="inputBox">
		               
		               <label>Email ID</label>
		               <input class="input-field" type="email" name="email" placeholder="Enter your email" id="email">
		         </div><br>
		          <div class="inputBox">
		              
		               <label>Address</label>
		               <textarea class="input-field" type="text" name="address" placeholder="Enter your address" id="address"></textarea>
		         </div><br>	
		         
<c:if test = "${book_no_of_ppl}"> 1>
 <%
    int count=(int)session.getAttribute("book_no_of_ppl");
    
    for(int i=0; i<count ;i++){
    	out.print("Add Additional Passenger Details");
    	out.println("Name:<input type='text' class='input-field'><br>Age:<input type='text'  class='input-field'><br>");
    }
 
 %>
          
</c:if>         
		         	              		             
		         <input type="submit" value="CONTINUE" class="login-btn" />
       
           
        </form>
</div>

<%@include file="footer.html" %>