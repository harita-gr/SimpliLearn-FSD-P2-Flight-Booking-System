<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ page session="false" %> 
<%@include file="header.html" %>

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
  <form method="POST" action="BookingControllerServlet">
    <input type="hidden" name="command" value="SEARCH">
<!--   <input type="radio" name="flight-class" value="Business"> Business
     <input type="radio"  name="flight-class" value="Economy"> Economy <br><br> -->   
     <label>Source</label>
     <input type="text" name="source" id="source" placeholder="New Delhi" required>
     <label>Destination</label>
     <input type="text" name="destination" id="destination" placeholder="Bangalore" required>
     <label>Date</label>
     <input type="date" name="date" id="date" required>
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
  
<%@include file="footer.html" %>