<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

label {
  display: inline-block;
  width: 180px;
  text-align: right;
  padding:3px;
  margin:2px;
}
​body{
  margin:auto;
  top:10%;
  }
#payment-box{
  border:1px solid black;
  margin:auto !important;
  width:40%;
  height:350px;
  }
#icons{
  float:right;
}  
input{
padding:3px;
margin:2px;
}
p,h3{
  margin-left:50px;
}
#pyt-btn{
margin-left:50px;
background:green;
color:white;
width:70%;
}
</style>
</head>

<body>
<div id="payment-container">

    <h2> CHECKOUT</h2>
    <div id="payment-box">
    <form action="BookingControllerServlet" method="get">
    <input type="hidden" name="command" value="PAY">
      <h3> DEBIT/CREDIT CARD PAYMENT</h3>
      <div id="icons"> <img src="https://img.icons8.com/color/36/000000/visa.png"> <img src="https://img.icons8.com/color/36/000000/mastercard.png"> <img src="https://img.icons8.com/color/36/000000/amex.png"> </div><br> <br>
      <br>
      <label>CARD NUMBER</label>
      <input type="text" placeholder="Valid 16 digit Card Number" required><br>
      
      <label>EXPIRATION DATE</label>
      <input type="text"  placeholder="MM/YY" required><br>
      
      <label>CVV CODE</label>
      <input type="text" placeholder="CVC" required><br>
      
      <label>COUPON CODE</label>
      <input type="text" placeholder=""><br>
      <% float fare=Float.parseFloat((String)session.getAttribute("book_fare"))* Integer.parseInt((String)session.getAttribute("book_no_of_ppl")) ; %>   
      <p>You are making a payment of: Rs.<b><%=fare %> </b></p>
      <input type="submit" value="MAKE PAYMENT" id="pyt-btn"> 
    </form>
    </div>
</div>

</body>
</html>