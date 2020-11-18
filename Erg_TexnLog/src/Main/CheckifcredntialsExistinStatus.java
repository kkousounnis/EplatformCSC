package Main;
import java.sql.*;
public class CheckifcredntialsExistinStatus {

	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost";//at first we might dont have a database
	   static final String DB_URL1 = "jdbc:mysql://localhost/MYSQL_USERS";//here is the url fro the database

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "test123";
	   
	   User u=new User();
	
		public boolean CheckStatusF(String n,String p) {
			
			Connection conn = null;
			   Statement stmt = null;
			   boolean x = false;
			   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");
			      
			      
			      
			      // Open a connection with the database
			      System.out.println("Connecting to a selected database...");
			      conn = DriverManager.getConnection(DB_URL, USER, PASS);
			      System.out.println("Connected database successfully...");
			      
			      
			      
			      //STEP 4: Execute a query to create the database if it doesnt exist
			      
			      System.out.println("Creating database...");
			      stmt = conn.createStatement();
			      
			      String sql = "CREATE DATABASE if not exists MYSQL_USERS";
			      stmt.executeUpdate(sql);
			      System.out.println("Database created successfully...");
			      
			      conn.close();
			      
			      //Open a connection to the new database which has the new url with mysql_users
			      System.out.println("Connecting to a selected database...");
			      conn = DriverManager.getConnection(DB_URL1, USER, PASS);
			      System.out.println("Connected database successfully...");
			      
			      //create the table users
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();

			       sql = "SELECT * FROM userforms";
			      ResultSet rs = stmt.executeQuery(sql);
			      //STEP 5: Extract data from result set
			      x=false;
			      while(rs.next()){
			         //Retrieve by column name
			         
			         
			         
			         u.setUsername(rs.getString("USERNAME"));
			         u.setPassword(rs.getString("PASSWORD"));
			         System.out.println(u.getPassword()+u.getUsername());
			         
			       //edw kanw ton elegxo an auta pou edwse o xrhsths sthn selida einai idia me thw bashs dedomenvn
						if(n.equals(u.getUsername()) & p.equals(u.getPassword())) {
							 x=true;
							
						}
						 
			          
			      }
			      rs.close();
			      
			      
			      
			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }
			   finally{
				      //finally block used to close resources
				      try{
				         if(stmt!=null)
				            conn.close();
				      }catch(SQLException se){
				      }// do nothing
				      try{
				         if(conn!=null)
				            conn.close();
				      }catch(SQLException se){
				         se.printStackTrace();
				      }//end finally try
				   }//end try
				   System.out.println("Goodbye!");
				return x;
			
		}
	
	}

