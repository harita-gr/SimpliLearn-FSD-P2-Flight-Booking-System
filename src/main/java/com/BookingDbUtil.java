package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class BookingDbUtil {
	
	private DataSource dataSource;
	
	public BookingDbUtil(DataSource theDataSource) {
		dataSource=theDataSource;
	}
	
	 //Close all connections
	  private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
       try {
    	   if(myRs !=null) {
    		   myRs.close();
    	   }
    	   if(myStmt !=null) {
    		   myStmt.close();
    	   }
    	   if(myRs !=null) {
    		   myRs.close();
    	   }
    	   
       }
       catch (Exception e){
    	 e.printStackTrace();
       }		
	}

	public List<Flight> searchFlight(String source,String destination) throws Exception {
	
		List<Flight> flights = new ArrayList<>();
		
		//JDBC Objects
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		String pass=null;
		
		try {
			
			//get connection to DB
			myConn = dataSource.getConnection();
			
			//create SQL to get selected student
			String sql =" SELECT * FROM flight_details WHERE source_place=? AND destination_place=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			//set params
			myStmt.setString(1, source);
			myStmt.setString(2, destination);
						
			///execute prepared statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			while(myRs.next()) {
				 String flightNo=myRs.getString("flightNo");
				 String airline=myRs.getString("airline");
//				 String source=myRs.getString("source_place");
//				 String destination=myRs.getString("destination_place");
				 String departure=myRs.getString("departure");
				 String arrival=myRs.getString("arrival");
				 String duration=myRs.getString("duration");
				 int duration_in_min=myRs.getInt("duration_in_min");				 
				 String airportName=myRs.getString("airportName");
				 int totalStops = myRs.getInt("totalStops");
				 int availableSeats=myRs.getInt("availableSeats");
				 float fare=myRs.getFloat("fare");
				
				//create new flight object
				Flight tempFlight = new Flight(flightNo,airline,source,destination,departure,arrival,duration,duration_in_min,airportName,totalStops,availableSeats,fare);
					//add it to the list of students
				flights.add(tempFlight);
				}
				
			    return flights;
		}
		finally {
			close(myConn,myStmt,myRs);
		}		
	}

	public void saveOrderDetails(BookingDetails order_success, String src, String dest, String fid, float fare,
			String aline, String date, int ppl) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
			
		try {		
			myConn = dataSource.getConnection();	
				String sql= "INSERT into order_details (book_date,fullName,age,o_email,address,flightNo,airline,source_place,destination_place,fare,no_of_ppl) values(?,?,?,?,?,?,?,?,?,?,?)";
				
				myStmt= myConn.prepareStatement(sql);
				
				myStmt.setString(1,date);
				myStmt.setString(2,order_success.getFullName());
				myStmt.setInt(3,order_success.getAge());
				myStmt.setString(4,order_success.getEmail());
				myStmt.setString(5,order_success.getAddress());		
				myStmt.setString(6,fid);			
				myStmt.setString(7,aline);
				myStmt.setString(8,src);	
				myStmt.setString(9,dest);	
				myStmt.setFloat(10,fare);	
				myStmt.setInt(11,ppl);	
				
				myStmt.execute();		
				System.out.println("SQL DONE 01");		
			}

	 finally {
			close(myConn,myStmt,null);
			System.out.println("SQL DONE 02");
			}		
	}

	public List<BookingDetails> getOrderDetails(String email) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		List<BookingDetails> bd = new ArrayList<>();
		
		try {		
			myConn = dataSource.getConnection();	
			// Get customer ID
			String sql="SELECT * from order_details WHERE o_email=?";
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1,email);
			myRs=myStmt.executeQuery();

				while(myRs.next()) {
					 String flightNo=myRs.getString("flightNo");
					 String airline=myRs.getString("airline");
					 String source=myRs.getString("source_place");
					 String destination=myRs.getString("destination_place");
					 String date=myRs.getString("book_date");
					 String fullName=myRs.getString("fullName");
					 int age=myRs.getInt("age");				 
					 int no=myRs.getInt("no_of_ppl");
					 float fare=myRs.getFloat("fare");

					 BookingDetails temp = new BookingDetails(no,fullName,age,email,null,date,new Flight(flightNo,airline,source,destination,fare));
					 bd.add(temp);
			   }
				return bd;			
        }
	 finally {
			close(myConn,myStmt,null);
	 }
	}
		
	

	
	
	

}
