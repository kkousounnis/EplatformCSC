package Main;

import java.sql.*;

public class CredentialsDb {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/MYSQL_USERS";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "test123";
   
   public void InsertCredentials(String n,String p) {
   Connection conn = null;
   Statement stmt = null;
   
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      System.out.println("Deleting table in given database...");
      stmt = conn.createStatement();
      
      String sql = "DROP TABLE if exists Credentials ";
 
      stmt.executeUpdate(sql);
      System.out.println("Table  deleted in given database...");
      
      
      
      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      
      String sql1 =  "CREATE TABLE  Credentials " +
                   "(USERNAME VARCHAR(25), " +
                   " PASSWORD VARCHAR(25) )"; 

      stmt.executeUpdate(sql1);
      System.out.println("Created table in given database...");
      
      System.out.println("Insert records into Credentials");
      stmt = conn.createStatement();
       String sql2 = "INSERT INTO Credentials " +
              "VALUES ('"+n+"','"+p+"')";
      stmt.executeUpdate(sql2);
      System.out.println("Records inserted");
      
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
}//end main
}//end JDBCExample