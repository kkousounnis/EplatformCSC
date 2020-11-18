package Main;
import java.sql.*;
public class DBAdminTableCreate {

	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost";//at first we might dont have a database
	   static final String DB_URL1 = "jdbc:mysql://localhost/MYSQL_USERS";//here is the url fro the database

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "test123";
	   
	   
	
		public void dbcheckifadminTableexists() {
			
			Connection conn = null;
			   Statement stmt = null;
			   Statement stmt1=null;			 
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
			    
			     
			    
			      System.out.println("Creating table in given database...");
			      stmt = conn.createStatement();
			      
			      sql = "CREATE TABLE if not exists Uadmin " 
			                 + "(USERNAME VARCHAR(25),"
			    		      +"PASSWORD VARCHAR(25),"
			    		      + "PRIMARY KEY (USERNAME,PASSWORD))";                
			                       
			      
			      stmt.executeUpdate(sql);
			      System.out.println("Created tables in given database...");
			      
			      
			      
			      System.out.println("Insert records into admin");
			      stmt1 = conn.createStatement();
			        sql = "INSERT INTO  Uadmin " +
			              "VALUES ('kwstas','123')";
			      stmt1.executeUpdate(sql);
			      System.out.println("Records inserted");
			      
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
			
		}
	
	}

