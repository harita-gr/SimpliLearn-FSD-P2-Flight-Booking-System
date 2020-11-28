<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page import="java.util.*,com.Flight" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@include file="header.html" %>
<%@ page session="false" %> 
<div id="navbar">
  <ul>
     <li><a href="home.jsp">Hi User </a> </li>
     <li><a href="my-profile.jsp">MY PROFILE</a> </li>
     <li><a href="LogoutServlet" onclick="if(!(confirm('Are you sure you want to logout?')))return false">LOGOUT </a></li>
  </ul>
</div>
    <!-- Flight Details -->
  <h2 style="margin-left:40px;color:white"> DOMESTIC FLIGHTS</h2>
  <div id="search-container" style="border:2px solid black;background-color:white;opacity:0.8;margin: auto;width:80%;padding:15px;">
  <h3> Search your Flight</h3>
  <form method="get" action="BookingControllerServlet">
    <input type="hidden" name="command" value="SEARCH">
<!-- <input type="radio" name="flight-class" value="Business"> Business
     <input type="radio"  name="flight-class" value="Economy"> Economy <br><br> -->   
     <label>Source</label>
     <input type="text" name="source" id="source" placeholder="New Delhi">
     <label>Destination</label>
     <input type="text" name="destination" id="destination" placeholder="Bangalore">
     <label>Date</label>
     <input type="date" name="date" id="date">
     <label>Number of Passengers</label>
     <select name="no-of-people">
         <option value="1">Select</option>
        <c:forEach varStatus="loop" begin = "1" end = "15">
         <option value="${loop.index}">${loop.index} </option>
      </c:forEach>
     </select><br><br>
     <input type="submit" name="submit" id="submit" value="Search" style="padding: 10px 24px;font-size: 16px;background-color: #00cc00;cursor:pointer;border-radius: 12px;"><br><br>
     
  </form><br>
 
    
  <span id="error" style="text-align: center;"></span><br>
  </div>
  
   <!-- /Flight Details -->
  
  <!-- Search Results Table -->
   <div id="data-container" style="border:2px solid black;background-color:white;opacity:0.8;margin: auto;width:80%;padding:15px;">
     <!-- Put new button: Clear Results -->
      <input type="button" value="Reset" onclick="window.location.href='home.jsp';return false;"class="reset-search-button">
    
      <table border="1" style="margin: auto;">
        <thead>
         <tr>
            <th>Flight ID </th>
            <th>Airlines </th>
            <th>Source</th>
            <th>Destination</th>
            <th>Arrival </th>
            <th>Departure </th>
            <th>Duration</th>
            <th>Airport Name </th>
            <th>Total No.of Stops </th>
            <th>Available Seats</th>
            <th>Price</th>
            <th>Action</th>
         </tr>  
         </thead>
         <tbody>
         
         <c:forEach var="flight" items="${FLIGHT_LIST}">
        
         <!-- Set up a unique link for each flight (using Flight ID)-->
         
         <tr>
         <c:url var="tempLink" value="BookingControllerServlet">
             <c:param name="command" value="BOOK"/>
             <c:param name="flightID" value="${flight.flightNo}"/>
             <c:param name="fare" value="${flight.fare}"/> 
             <c:param name="source" value="${flight.source}"/>
             <c:param name="destination" value="${flight.destination}"/> 
             <c:param name="airline" value="${flight.airline}"/>                     
         </c:url>
  <%
       List<Flight> fl = new ArrayList<>();
       fl= (List<Flight>)request.getAttribute("FLIGHT_LIST");
	   for(int i=0; i< fl.size() ;i++)
	   {
		   System.out.println("from jsp");
		System.out.println(fl.get(i));
	   }
  
  %>        
            <td>${flight.flightNo}</td>
            <td>  ${flight.airline}</td>
            <td> ${flight.source} </td>
             <td> ${flight.destination}</td>
            <td>  ${flight.departure}</td>
            <td> ${flight.arrival} </td>
             <td> ${flight.duration}</td>
            <td> ${flight.airportName} </td>
             <td> ${flight.totalStops}</td>
            <td>  ${flight.availableSeats}</td>
            <td> ${flight.fare} </td>
            <td><input type="button" value="BOOK NOW!" style="background-color: #008CBA;color:white;cur" onclick="window.location.href='${tempLink}';return false;"
             class="book-now-button"> </td>
         </tr>
     </c:forEach>
     </tbody> 
     </table>
    
    </div>
   
   
<%@include file="footer.html" %>