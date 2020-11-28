package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class AdminDBUtil {
	
	private DataSource dataSource;

	public AdminDBUtil(DataSource theDataSource) {
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
	  
//********************************************************************************************
//	public boolean changePassword(String oldpassword, String newpassword, String username) throws Exception {
//		//JDBC Objects
//		Connection myConn = null;
//		PreparedStatement myStmt = null;
//		ResultSet myRs = null;
//		String pass=null;
//		
//		try {		
//				myConn = dataSource.getConnection();
//		
//				String sql="SELECT a_password from admin WHERE a_username=?";
//				myStmt = myConn.prepareStatement(sql);				
//				myStmt.setString(1,username);				
//				myRs=myStmt.executeQuery();
//				if(!myRs.next())
//				{
//					return false;
//				}	
//				
//			    pass=myRs.getString("a_password");
//					
//				if(!pass.equals(oldpassword)) {		
//				   return false;
//	           }
//				else {
//					executeSQLUnsafeMode();
//					sql="UPDATE admin SET a_password =? WHERE a_username=?";
//					myStmt = myConn.prepareStatement(sql);
//					myStmt.setString(1,newpassword);
//					myStmt.setString(2,username);
//					myStmt.execute(sql);
//					return true;
//				}
//				
//				}
//				
//		 finally {
//			//clean up JDBC objects
//			     executeSQLSafeMode();
//				close(myConn,myStmt,myRs);
//				}
//		  }
//********************************************************************************************
	private void executeSQLSafeMode() throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		System.out.println("Executing in SQL Safe Mode...");
				
		try {
				myConn = dataSource.getConnection();
				String sql="SET SQL_SAFE_UPDATES = 1;";
				myStmt = myConn.prepareStatement(sql);
				myStmt.execute(sql);
		}	
		 finally {
				close(myConn,myStmt,null);
				}		
	}

	private void executeSQLUnsafeMode() throws SQLException {
		Connection myConn = null;
		Statement myStmt = null;
		System.out.println("Executing in SQL UnSafe Mode");
				
		try {
				myConn = dataSource.getConnection();
				String sql="SET SQL_SAFE_UPDATES = 0;";
				myStmt = myConn.prepareStatement(sql);
				myStmt.execute(sql);
		}	
		 finally {
				close(myConn,myStmt,null);
				}
		  }

	public List<String> getSourceLocationList() throws SQLException {	
		
		//JDBC Objects 
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
	  try {	
		List<String> source=new ArrayList<>();
		
				
				myConn = dataSource.getConnection();
				String sql="SELECT DISTINCT source_place from flight_details ORDER BY source_place;";
				
				myStmt = myConn.createStatement();
				myRs = myStmt.executeQuery(sql);
				while(myRs.next())
				{
					String temploc = myRs.getString("source_place");
					source.add(temploc);
				}
		
		       return source;
	}
	  finally {
			//clean up JDBC objects
				close(myConn,myStmt,null);
				}
		  
   }
     public List<String> getDestinationLocationList() throws SQLException {		
		
		List<String> dest=new ArrayList<>();
		//JDBC Objects 
				Connection myConn = null;
				PreparedStatement myStmt = null;
				ResultSet myRs = null;
				String pass=null;
			try {	
				myConn = dataSource.getConnection();
				String sql="SELECT DISTINCT destination_place from flight_details ORDER BY destination_place";
				
				myStmt = myConn.prepareStatement(sql);
				myRs = myStmt.executeQuery();
				while(myRs.next())
				{
					String temploc = myRs.getString("destination_place");
					dest.add(temploc);
			    }
		       return dest;
		
	   }
		finally {
			//clean up JDBC objects
				close(myConn,myStmt,null);
				}
	}
     
     public List<String> getAirlineList() throws SQLException {		
 		
 		List<String> airlines=new ArrayList<>();
 		//JDBC Objects 
 				Connection myConn = null;
 				PreparedStatement myStmt = null;
 				ResultSet myRs = null;
 				String pass=null;
 			try {	
 				myConn = dataSource.getConnection();
 				String sql="SELECT DISTINCT airline from flight_details ORDER BY airline";
 				
 				myStmt = myConn.prepareStatement(sql);
 				myRs = myStmt.executeQuery();
 				while(myRs.next())
 				{
 					String temp = myRs.getString("airline");
 					airlines.add(temp);
 				}
 		
 		          return airlines;
 			}
 		finally {
			//clean up JDBC objects
				close(myConn,myStmt,null);
				}
 	}
     
     public List<Flight> getLFlightDetailsList() throws SQLException {		
  		
  		List<Flight> flights=new ArrayList<>();
  		//JDBC Objects 
  				Connection myConn = null;
  				PreparedStatement myStmt = null;
  				ResultSet myRs = null;
  				String pass=null;
  		try {		
  				myConn = dataSource.getConnection();
  				String sql="SELECT * from flight_details";
  				
  				myStmt = myConn.prepareStatement(sql);
  				myRs = myStmt.executeQuery();
  				while(myRs.next())
  				{
  					 String flightNo=myRs.getString("flightNo");
  					 String airline=myRs.getString("airline");
  					 String source=myRs.getString("source_place");
  					 String destination=myRs.getString("destination_place");
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
			//clean up JDBC objects
				close(myConn,myStmt,null);
			}
     }

	public void addFlight(String fno, String al, String src, String dest, String arr, String dep, String dur,
			int dur_min, int fare, int seats, int stops,String airport) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
			
		try {		
			myConn = dataSource.getConnection();	
				String sql= "INSERT into flight_details (flightNo,airline,source_place,destination_place,departure,arrival,duration,duration_in_min,airportName,totalStops,availableSeats,fare) values(?,?,?,?,?,?,?,?,?,?,?,?)";
				
				myStmt= myConn.prepareStatement(sql);
				
				myStmt.setString(1,fno);
				myStmt.setString(2,al);
				myStmt.setString(3,src);
				myStmt.setString(4,dest);
				myStmt.setString(5,dep);		
				myStmt.setString(6,arr);			
				myStmt.setString(7,dur);
				myStmt.setInt(8,dur_min);
				myStmt.setString(9,airport);
				myStmt.setInt(10,stops);	
				myStmt.setInt(11,seats);	
				myStmt.setInt(12,fare);	
				
				myStmt.execute();		
				System.out.println("SQL DONE 01");		
			}

	    finally {
			close(myConn,myStmt,null);
			System.out.println("SQL DONE 02");
			}		
	}

	public boolean changePassword(String oldpassword, String newpassword, String username) throws Exception,SQLException {
	
	    Connection myConn = null;
		PreparedStatement myStmt = null;
		String sql=null;
		UserDbUtil udb = new UserDbUtil(dataSource);
		AdminUser a= new AdminUser(username,oldpassword);
     try {
    	 
		String db_password = udb.validateAdminLogin(a);
		
		
		if(!db_password.equals(oldpassword)) {
			return false;
		}
		
		else {
			
			executeSQLUnsafeMode();
			myConn = dataSource.getConnection();
			
		    sql = "UPDATE admin SET a_password=?";
			
			myStmt = myConn.prepareStatement(sql);
			myStmt.setString(1,newpassword);
//			myStmt.setString(2,username);
			int status =myStmt.executeUpdate();	
			System.out.println("Update Status: "+status);
			return true;
		}
	  }
	
	finally {
		System.out.println("AT PASSWORD UPDATION");		
		executeSQLSafeMode();
		close(myConn,myStmt,null);
		
		}		
	
    }
	
} 

