package Main;
import java.sql.*;


public class TakeValuesFromStatusForm {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/MYSQL_USERS";
	Citizen c1=new Citizen(); 
	
	
	
	 //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "test123";
	  
	 
	  String sendrequest;
	  String columnforsplit;
	  String all;
	   boolean x;
	User u=new User();
	
	
	public String TakeValues() {
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

		      String sql = "SELECT * FROM userforms";
		      ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      x=false;
		      while(rs.next()){
		         //Retrieve by column name
		         
		         
		         
		         u.setUsername(rs.getString("USERNAME"));
		         u.setPassword(rs.getString("PASSWORD"));
		         c1.setFirstname(rs.getString("FIRSTNAME"));
		         c1.setLastname(rs.getString("LASTNAME"));
		         sendrequest=(rs.getString("SENDREQUEST"));
		    	   columnforsplit=rs.getString("COLUMNFORSPLIT");
		       
					 
		          all=u.getUsername()+","+u.getPassword()+","+c1.getFirstname()+","+c1.getLastname()+","+sendrequest+columnforsplit+all;   
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
		   
		
		return all;
		
	}

}
