package Main;
import java.sql.*;

public class ValuesDbSiteCompareAdmin {
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		static final String DB_URL = "jdbc:mysql://localhost/MYSQL_USERS";
		 
		
		
		
		 //  Database credentials
		   static final String USER = "root";
		   static final String PASS = "test123";
		   boolean x;
		User u=new User();
		
		
		public boolean ValuesCompare(String n,String p) {
			Connection conn = null;
			   Statement stmt = null;
			   
			   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");

			      //STEP 3: Open a connection
			      System.out.println("Connecting to a selected database...");
			      conn = DriverManager.getConnection(DB_URL, USER, PASS);
			      System.out.println("Connected database successfully...");
			      
			      //STEP 4: Execute a query
			      System.out.println("Creating statement...");
			      stmt = conn.createStatement();

			      String sql = "SELECT * FROM Uadmin";
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
			   }finally{
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
