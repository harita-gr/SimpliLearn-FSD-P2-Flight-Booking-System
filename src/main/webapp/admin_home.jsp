<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<%@include file="header.html" %>
<div id="navbar">
  <ul>
     <li><a href="admin_home.jsp">Hi Admin </a> </li>
     <li><a href="admin-profile.jsp">MY PROFILE</a> </li>
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
     <ul>
        <li><a href="${srcLocLink}"> <b>AVAILABLE PLACES </b> </a></li>
        <li><a href="${desLocLink}"><b>AVAILABLE DESTINATION</b></a> </li>
        <li><a href="${airlineLink}"><b>AIRLINES</b></a> </li>
        <li><a href="${flightLink}"><b>FLIGHT LIST </b></a></li>
   </ul> 
  </div>
</div>
 
   
<%@include file="footer.html" %>