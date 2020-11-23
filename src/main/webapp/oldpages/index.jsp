<!--<%@include file="header.html" %>  -->

<!-- Login/SignIn Page -->
         <header class="login">
        <h3><a href="index.jsp"> Sign Up </a>  |<a href="login.jsp">Sign In</a> </h3> <br><br>
         </header>
          <form method="post" action="ValidationControllerServlet">
            <input type="hidden" name="command" value="SIGNUP">
            <table border="1" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="firstName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lastName" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Phone Number</td>
                        <td><input type="text" name="phno" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered? <a href="login.html">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
        </form>

  
<!-- /Login/SignIn Page --> 
  
  <small> Sign in as <a href="admin_login.html"> Admin </a></small>


<!-- <%@include file="footer.html" %> -->