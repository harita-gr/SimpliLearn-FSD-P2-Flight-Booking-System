<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@include file="header.html" %>

<div id="navbar">
  <ul>
    <li><a href="home.jsp">Hi User </a> </li>
     <li><a href="#">MY PROFILE</a> </li>
     <li><a href="LogoutServlet" onclick="if(!(confirm('Are you sure you want to logout?')))return false">LOGOUT </a></li>
  </ul>
</div>
<h2 style="color:white">ADD NEW FLIGHT</h2>

<div id="data-container" style="border:2px solid black;background-color:white;opacity:0.8;margin: auto;width:80%;padding:15px;">
<form method="get" action="AdminControllerServlet">
            <input type="hidden" name="command" value="ADDFLIGHT">
            <h3> Fill details:</h3>
             <!-- Put new button: Clear Results -->
      <input type="button" value="Reset" onclick="window.location.href='add-flight.jsp';return false;"class="reset-search-button" style="float:right">
            <div class="inputBox">
		               <label>Flight ID:</label><br>
		               <input class="input-field" type="text" name="flightID" placeholder="XX-XXX" id="flightID" required>
		         </div><br>
		         
		          <div class="inputBox">		               
		               <label>Airline:</label><br>
		               <input class="input-field" type="text" name="airline" placeholder="Enter airline" id="airline" required>
		         </div><br>   
		         
		         <div class="inputBox">
		               
		               <label>Source:</label><br>
		               <input class="input-field" type="text" name="src" placeholder="Enter source location" id="src" required>
		         </div><br>
		          <div class="inputBox">
		               
		               <label>Destination:</label><br>
		               <input class="input-field" type="text" name="dest" placeholder="Enter destination location" id="dest" required>
		         </div><br>
		         <div class="inputBox">
		               
		               <label>Airport:</label><br>
		               <input class="input-field" type="text" name="ap" placeholder="Enter airport" id="ap" required>
		         </div><br>
		     
		         <div class="inputBox">
		               
		               <label>Total Seats:</label><br>
		               <input class="input-field" type="text" name="seats" placeholder="Enter seats available" id="seats" required>
		         </div><br>
		         <div class="inputBox">
		               
		               <label>Fare:</label><br>
		               <input class="input-field" type="text" name="fare" placeholder="Enter ticket price" id="fare" required>
		         </div><br>
		         
		         <div class="inputBox">
		              <label>Duration:</label><br>
		               <input class="input-field" type="text" name="dur" placeholder="0h 0min" id="dur" required>
		         </div><br>
		                 <div class="inputBox">
		               <label>Duration in Minutes:</label><br>
		               <input class="input-field" type="text" name="dur_min" placeholder="000" id="dur_min" required>
		         </div><br>
		         <div class="inputBox">
		               
		               <label>Departure Time:</label><br>
		               <input class="input-field" type="text" name="dep" placeholder="00:00:00" id="dep" required>
		         </div><br>
		         <div class="inputBox">
		               
		               <label>Arrival Time:</label><br>
		               <input class="input-field" type="text" name="arr" placeholder="00:00:00" id="arr" required>
		         </div><br>
		         <div class="inputBox">
		               
		               <label>Total Stops:</label><br>
		               <input class="input-field" type="text" name="stops" placeholder="Enter total Stops" id="stops" required>
		         </div><br>
		 		          		         	              		             
		         <input type="submit" value="CONTINUE" class="login-btn" />
       
           
        </form>
</div>

<%@include file="footer.html" %>