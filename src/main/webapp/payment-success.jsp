<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@include file="header.html" %>
<div id="navbar">
  <ul>
     <li><a href="home.jsp">Hi User </a> </li>
     <li><a href="my-profile.jsp">MY PROFILE</a> </li>
     <li><a href="LogoutServlet" onclick="if(!(confirm('Are you sure you want to logout?')))return false">LOGOUT </a></li>
  </ul>
</div>
<div id="msg-container" style="border:2px solid black;background-color:white;opacity:0.8;margin: auto;width:60%;padding:15px;">
   <div style="margin-left:150px;">
   <img src="images/thank-you.png">
   <h2 style="margin-left:70px;">PAYMENT SUCCESSFUL!</h2>
   <h4 style="margin-left:50px;"> Congratulations! Your booking is confirmed!</h4>
   <button  style="margin-left:-40px" onclick="window.location.href='home.jsp';return false;">Back to Home Page</button>
   <button style="float:right;margin-right:150px" onclick="window.location.href='my-profile.jsp';return false;">View My Order</button>
   </div>
</div>   
<%@include file="footer.html" %>