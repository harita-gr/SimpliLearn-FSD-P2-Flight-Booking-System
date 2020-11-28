<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<%@include file="header.html" %>
<div id="navbar">
  <ul>
     <li><a href="admin_home.jsp">Hi Admin </a> </li>
     <li><a href="admin_profile.html">MY PROFILE</a> </li>
     <li><a href="LogoutServlet" onclick="if(!(confirm('Are you sure you want to logout?')))return false">LOGOUT </a></li>
  </ul>
</div>

<c:url var="srcLocLink" value="AdminControllerServlet">
             <c:param name="command" value="VIEWSRCLOC"/>                    
</c:url>
<c:url var="desLocLink" value="AdminControllerServlet">
             <c:param name="command" value="VIEWDESTLOC"/>                    
</c:url>
<c:url var="airlineLink" value="AdminControllerServlet">
             <c:param name="command" value="VIEWAIRLINE"/>                    
</c:url>
<c:url var="flightLink" value="AdminControllerServlet">
             <c:param name="command" value="VIEWFLIGHT"/>                    
</c:url>

<div id="search-container" style="border:2px solid black;background-color:white;opacity:0.8;margin: auto;width:80%;padding:15px;">
  <div id="rights_navbar">
             <h2 style="margin-left:10%">VIEW   MASTER   DATA   LIST</h2> 
             <button style="margin-left:40px;padding: 10px 15px;font-size: 14px;background-color: #00cc00;cursor:pointer;border-radius:12px" onclick="window.location.href='add-flight.jsp';return false;">Add Flight</button>        
     <ul>
        <li><a href="${srcLocLink}"> <b>AVAILABLE PLACES </b> </a></li>
        <li><a href="${desLocLink}"><b>AVAILABLE DESTINATION</b></a> </li>
        <li><a href="${airlineLink}"><b>AIRLINES</b></a> </li>
        <li><a href="${flightLink}"><b>FLIGHT LIST </b></a></li>
   </ul> 
  
    <div>
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
         </tr>  
         </thead>
         <tbody>
     
   
    <c:forEach var="flight" items="${F_LIST}" >
      <tr>
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
      </tr>
     </c:forEach>
     </tbody>   
     </table>   
     </div> 
   
 </div>
 </div>

<%@include file="footer.html" %>