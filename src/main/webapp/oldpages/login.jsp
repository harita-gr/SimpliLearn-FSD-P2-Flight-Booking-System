<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--<%@include file="header.html" %>  -->
<!-- Login/SignIn Page -->

<h3><a href="index.jsp"> Sign Up </a>  |<a href="login.jsp">Sign In</a> </h3> <br><br>
        <form method="post" action="ValidationControllerServlet">
        <input type="hidden" name="command" value="LOGIN">
            
            <table border="1"  width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Login Page</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">New User? <a href="register.jsp">Register Here</a></td>
                    </tr>
                </tbody>
            </table>
          
        </form>
<!-- /Login/SignIn Page -->
<small> Sign in as <a href="admin_login.html"> Admin </a></small>

<!-- <%@include file="footer.html" %> -->