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
 
 <div id=container" style="border:2px solid black;background-color:white;opacity:0.8;margin: auto;width:80%;padding:15px;">
 <h2> ADMIN PROFILE</h2> 

 <form action="AdminControllerServlet" method="get">
 <input type="hidden" name="command" value="CHANGE"> 
   <div class="inputfield">
       <span id="success" style="color:green;text-align:center;font-size:15px;"></span>
       <span id="error" style="color:red;text-align:center;font-size:15px;padding-bottom:5px;"></span> <br>
       <label> Enter Username</label> <br>
       <input type="text" name="username" required>
   </div><br>
   <div class="inputfield">
       <label> Enter Current Password</label> <br>
       <input type="text" name="password1" required>
   </div><br>
   <div class="inputfield">
       <label> Enter New Password</label> <br>
       <input type="text" name="password2" required> 
   </div><br>
   <input type="submit" value="CHANGE PASSWORD" id="change-pwd-btn" onclick="if(!(confirm('Are you sure you want to change password?')))return false;"  style="margin-left:0px;padding: 7px 12px;font-size: 14px;background-color: #00cc00;cursor:pointer;border-radius:12px"> 
 </form>
 </div> <br>

  
 <%@include file="footer.html" %> 