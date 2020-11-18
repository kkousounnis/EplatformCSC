package Servlets;

import java.sql.*;

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Main.CheckDbexists;
import Main.Citizen;


/**
 * Servlet implementation class Login
 */
@WebServlet("/servlet2")

public class Db_SignupForm extends HttpServlet{
	
	
	
	CheckDbexists Dbe=new CheckDbexists();
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/MYSQL_USERS";//at first we might dont have a database
	   
	//  Database credentials
		   static final String USER = "root";
		   static final String PASS = "test123";
		   
		   /**
		     * @see HttpServlet#HttpServlet()
		     */
		   
		   
		   Citizen c=new Citizen();
		   
		   
		   
		   public void doGet(HttpServletRequest request, HttpServletResponse response){
				try{
					
				Dbe.dbcheckifexists();
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
				//i assign to the values of the site to variables
				
				
				c.setUsername(request.getParameter("uname"));
				c.setPassword(request.getParameter("psw"));
				c.setFirstname(request.getParameter("firstname"));
				c.setLastname(request.getParameter("lastname"));
				c.setFathersname(request.getParameter("fathersname"));
				c.setMothersname(request.getParameter("mothersname"));
				c.setBirth(request.getParameter("birthdate"));
				c.setCardIdnumber(request.getParameter("idnumber"));
				c.setAmka(request.getParameter("amka"));
				c.setAfm(request.getParameter("afm"));
				c.setStreetaddress(request.getParameter("streetaddress"));
				c.setPhonenumber(request.getParameter("phonenumber"));
				c.setEmail(request.getParameter("email"));
				
				
				
				
				
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
				      System.out.println("Inserting records into the table...");
				      stmt = conn.createStatement();
				      /*
				      String sql = "INSERT INTO USERS " +
				              "VALUES ('kwnstantinos','pappoulis13','Kwnstantinos','kousounnis','Nikos','Matoula','2008-02-03','AH5610','141219961',12345678,'xristianoupoleos61',6986783675,'kwstas@gmail.com')";
				      stmt.executeUpdate(sql);
				      System.out.println("Inserted records into the table...");
				      */
				      
				      
				       String sql = "INSERT INTO USERS " +
				              "VALUES ('"+c.getUsername()+"','"+c.getPassword()+"','"+c.getFirstname()+"','"+c.getLastname()+"','"+c.getFathersname()+"','"+c.getMothersname()+"','"+c.getBirth()+"','"+c.getCardIdnumber()+"','"+c.getAmka()+"','"+c.getAfm()+"','"+c.getStreetaddress()+"','"+c.getPhonenumber()+"','"+c.getEmail()+"')";
				      stmt.executeUpdate(sql);
				      
				      
				      System.out.println("Inserted records into the table...");

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
				
				
				
				
				
				out.print("Succesful");
				out.print("<meta http-equiv=\"refresh\" content=\"5; URL='eplatform.html'\" />");
				
				
				
				HttpSession session=request.getSession();
				session.setAttribute("uname",c.getUsername());
				}catch(Exception e){System.out.println(e);}
				
			}
	   
	   
}
