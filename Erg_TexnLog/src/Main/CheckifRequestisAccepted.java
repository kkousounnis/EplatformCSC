package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CheckifRequestisAccepted {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/MYSQL_USERS";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "test123";
   
   User u=new User();
   Citizen c=new Citizen();
   String validation="";
   String ReturnValidation="";
   
   public String RequestCheck(String n,String p) {
   
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
      System.out.println("Creating statement connect to validateform ...");
      stmt = conn.createStatement();

      String sql = "SELECT * FROM validateform where USERNAME='"+n+"' and PASSWORD='"+p+"'";
      ResultSet rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set 
      while(rs.next()){  
         //Retrieve by column name
         
    	u.setUsername(rs.getString("USERNAME"));  
	    u.setPassword(rs.getString("PASSWORD"));
	     validation=rs.getString("VALIDATION");
        

         
         
      }
       
      
      System.out.println("Records selected..."+"djdshdiush"+""+validation+n+p+u.getUsername()+u.getPassword());
      
      System.out.println(n+p+u.getUsername());
      
      		
      
      
      rs.close();
      ReturnValidation="";
      if(u.getUsername().equals(n) &&  u.getPassword().equals(p) ) {
    	 
    		ReturnValidation=validation;
    		
    		 
   
      }
      else {
   	   ReturnValidation="";
      } 
      
       
      
      
      
      
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
return ReturnValidation;
}//end main
}//end JDBCExample