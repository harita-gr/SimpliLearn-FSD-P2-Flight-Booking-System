<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@include file="header.html" %>
<%@page import="com.BookingDetails"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%
    BookingDetails details= (BookingDetails)request.getAttribute("BookingUserDetail");
%>
<div id="navbar">
  <ul>
     <li><a href="home.jsp">Hi User </a> </li>
     <li><a href="my-profile.jsp">MY PROFILE</a> </li>
     <li><a href="LogoutServlet" onclick="if(!(confirm('Are you sure you want to logout?')))return false">LOGOUT </a></li>
  </ul>
</div>
   
           <c:url var="editLink" value="BookingControllerServlet">
             <c:param name="command" value="EDIT"/>        
         </c:url>
        
     <div id="confirm-details" style="border:2px solid black;background-color:white;opacity:0.8;margin: auto;width:30%;padding:15px;">
        <h2> Confirm your Details</h2>
        <table>
          <tr>
              <td>Full Name:</td>
              <td><%=details.getFullName() %></td>
          </tr>
          <tr>
              <td>Age:</td>
              <td><%=details.getAge() %></td>
          </tr>
          <tr>
              <td>Email:</td>
              <td><%=details.getEmail() %></td>
          </tr>
          <tr>
              <td>Address</td>
              <td><%=details.getAddress() %></td>
          </tr> 
          <tr>
              <td>Date</td>
              <td><%=session.getAttribute("book_date")%></td>
          </tr>  
          <tr>
              <td>No: of Tickets:</td>
              <td><%=session.getAttribute("book_no_of_ppl")%></td>
          </tr> 
          <tr>
              <td><hr></td>
          </tr>
          <tr>
              <td style="font-size:16px;"><b>FLIGHT DETAILS:</b></td>
          </tr>
              
          <tr>
               <td>Source:</td>
               <td><%=session.getAttribute("book_source")%></td>
          </tr>
           <tr>
               <td>Destination:</td>
               <td><%=session.getAttribute("book_dest")%></td>
          </tr>
           <tr>
               <td>Flight ID: </td>
               <td><%=session.getAttribute("book_flightID")%></td>
          </tr>
           <tr>
               <td>Airlines:</td>
               <td><%=session.getAttribute("book_airline")%></td>
          </tr>
           <tr>
               <td><b>Fare:</b></td>
               <td><b><%=session.getAttribute("book_fare")%></b></td>
          </tr>
       
           <tr>
              <td><hr style="width:70%'"></td>             
          </tr>        
        </table>       
 

  <button style="float:right;padding: 10px 24px;font-size: 16px;background-color: #00cc00;cursor:pointer;border-radius: 12px;" onclick="window.location.href='payment.jsp';return false;"> Proceed to Payment</button>
  
  </div>
  

<%@include file="footer.html" %>