package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TakeCredentials {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/MYSQL_USERS";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "test123";
   
   User u=new User();
   Citizen c=new Citizen();
   
   public String mycredentials() {
  String credentials="";
   Connection conn = null;
   Statement stmt = null;
   Statement stmt1 = null;
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

      String sql = "SELECT * FROM Credentials";
      ResultSet rs = stmt.executeQuery(sql);
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         
    	  
	     u.setUsername(rs.getString("USERNAME"));
	     u.setPassword(rs.getString("PASSWORD"));
        

         
         
      }
       
      
      System.out.println("Created table in given database...");
      
      
      System.out.println("Creating statement...");
      stmt1 = conn.createStatement();

      String sql1 = "SELECT FIRSTNAME,LASTNAME,FATHERSNAME,MOTHERSNAME,BIRTH,IDNUMBER,AMKA,AFM,STREETADDRESSE,PHONENUMBER,EMAIL FROM USERS where USERNAME='"+u.getUsername()+"' and password='"+u.getPassword()+"'";
      		
       rs = stmt1.executeQuery(sql1);
      //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         
    	 
	     c.setFirstname(rs.getString("FIRSTNAME"));
	     c.setLastname(rs.getString("LASTNAME"));
        c.setFathersname(rs.getString("FATHERSNAME"));
        c.setMothersname(rs.getString("MOTHERSNAME"));
        c.setBirth(rs.getString("BIRTH"));
        c.setCardIdnumber(rs.getString("IDNUMBER"));
        c.setAmka(rs.getString("AMKA"));
        c.setAfm(rs.getString("AFM"));
        c.setStreetaddress(rs.getString("STREETADDRESSE"));
        c.setPhonenumber(rs.getString("PHONENUMBER"));
        c.setEmail(rs.getString("EMAIL"));

         
         
      }
      credentials=u.getUsername()+","+u.getPassword()+","+c.getFirstname()+","+c.getLastname()+","+c.getFathersname()+","+c.getMothersname()+","+c.getBirth()+","+c.getCardIdnumber()+","+c.getAmka()+","+c.getAfm()+","+c.getStreetaddress()+","+c.getPhonenumber()+","+c.getEmail();
      rs.close();
      System.out.println("Created table in given database...");
      
      
      
      
      
      
      
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
return credentials;
}//end main
}//end JDBCExample