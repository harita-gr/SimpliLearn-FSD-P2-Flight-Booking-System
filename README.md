# FLYAWAY AIRLINE TICKET BOOKING PORTAL
This is a flight ticket booking  application developed for **Flyaway Airline Booking**

## About the application
The application is designed to assist the user by providing service to book flight tickets.They requirements of the application are:

a) User view (Frontend) which enables user to: 
  - Sign Up/Sign In
  - Search for flights by providing source,destination, date, no.of passengers
  - Book Flight
  - Make Payment and confirm booking
  - View Order Details
  
b) Admin Backend which enables admin to:
  - Login
  - View master lists for flights,airline,source,destination
  - Change Password

Flow Chart is given below for application workflow reference:
USER FRONT END:

![Untitled Document (1)](https://user-images.githubusercontent.com/61909695/100521840-2c39b180-31cc-11eb-9c05-b9df0fbf6249.png)

ADMIN BACKEND:

![Untitled Document (2)](https://user-images.githubusercontent.com/61909695/100521798-ee3c8d80-31cb-11eb-8db4-1ecf22ab8252.png)

## Tools & Technnology
- Backend Programming Language: Core Java.
   The software backend is completely developed in Java EE. Key concepts and Technologies  implemented are:
     1. JSP
     2. Servlets
     3. JDBC
     
   Along with this, following  critical Java concepts are also used:
     1. Collections - List as a data structure
     2. Exception Handling
     3. Sorting
     4. Loops and Control statements - Switch, if..else
     
 - Front End : HTML5,CSS3,Javascript    
 - Database:  MySQL  is used for creating DB
 - IDE: Eclipse
 - Build Tool: Maven (Webapp Archetype)
 - Version Control: Git and GitHub
 - Project Management and Sprint Planning: JIRA
 
 ## SetUp and Installation
 **Prerequisites**
 
 To run the code, system must be equipped with the following
 - JDKv8 or above
 - Eclipse IDE (EE)
 - Git
 - MySQL workbench
 - Tomcat Server

**How to Run**

Through Eclipse IDE
1. Clone the code from GitHub
    ````
    git clone https://github.com/haritaToboso/SimpliLearn-FSD-P2-Flight-Booking-System.git
    ````
2. Configure Database using the SQL files attached. This is used to create DB along with required table containg user & flight data.    
3. Open the folder containg code as Java Project via Eclipse
4. Go to src/main/webapp/index.html and select: 

     Run As -> Run on Server -> Start Tomcat server             // To start from welcome page
     
                      OR 
                      
     Go to src/main/webapp/home.jsp and select: 
     
     Run As -> Run on Server -> Start Tomcat server             // To start from HOME page without login   
     
     
## Author
Harita Ravindranath

*Company Lockers Private Ltd.*
