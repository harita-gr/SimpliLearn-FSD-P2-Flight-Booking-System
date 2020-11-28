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
            <c:url var="detailsLink" value="ActivityControllerServlet">
             <c:param name="command" value="DETAILS"/>                            
            </c:url>
            <c:url var="ordersLink" value="ActivityControllerServlet">
             <c:param name="command" value="ORDERS"/>                            
            </c:url>
         
 <div id="option-container" style="border:2px solid black;background-color:white;opacity:0.9;margin: auto;width:50%;padding:15px;">
 <h2>MY PROFILE</h2>
    <div id="options">
      <div class="option" style="display: inline-block;margin-right:40px;margin-left:40px;">
         <img alt="details" src="images/67-512-removebg-preview.png"><br>
         <button style="margin-left:40px" onclick="window.location.href='${detailsLink}';return false;">MY DETAILS</button>      
      </div>
        <div class="option" style="display: inline-block;margin-right:40px;margin-left:40px;">
         <img alt="orders" src="images/plane-air-ticket-circle-icon-vector-8543584-removebg-preview.png"><br>
         <button  style="margin-left:50px" onclick="window.location.href='${ordersLink}';return false;">MY ORDERS</button>      
      </div>    
    </div>
 </div>
 
 <%@include file="footer.html" %>