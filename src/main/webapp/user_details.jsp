<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page import="com.*"%>

<%@include file="header.html" %>
<div id="navbar">
  <ul>
     <li><a href="home.jsp">Hi User </a> </li>
     <li><a href="my-profile.jsp">MY PROFILE</a> </li>
     <li><a href="LogoutServlet" onclick="if(!(confirm('Are you sure you want to logout?')))return false">LOGOUT </a></li>
  </ul>
</div>
 
 <% User user= (User)session.getAttribute("USER_DETAILS"); %>
         
 <div id="option-container" style="border:2px solid black;background-color:white;opacity:0.9;margin: auto;width:50%;padding:15px;">
 <h2>MY DETAILS</h2>
     
     <table>
        <tr>
           <td>First Name:</td>
           <td><%= user.getFname() %></td>
        </tr>
         <tr>
           <td>Last Name:</td>
           <td><%=user.getLname() %></td>
        </tr>
         <tr>
           <td>Email:</td>
           <td><%=user.getEmail() %></td>
        </tr>
         <tr>
           <td>Phone Number:</td>
           <td><%=user.getPhoneno() %></td>
        </tr>     
     </table>
    
 <button  style="margin-left:40px;padding: 10px 24px;font-size: 16px;background-color: #00cc00;cursor:pointer;border-radius:12px" onclick="window.location.href='my-profile.jsp';return false;">BACK TO PROFILE</button>     <button  style="margin-left:40px" onclick="window.location.href='my-profile.jsp';return false;">BACK TO PROFILE</button>      
       
 
 </div>
 
 <%@include file="footer.html" %>