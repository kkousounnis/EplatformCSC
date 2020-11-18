package Servlets;

//STEP 1. Import required packages

import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import Main.CheckDbexists;
import Main.CredentialsDb;
import Main.User;
import Main.ValuesDbSiteCompare;

import javax.servlet.http.*;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Db_Login_check")

public class Db_Login_check extends HttpServlet{
			/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	   CheckDbexists Dbe=new CheckDbexists();  
	   ValuesDbSiteCompare 	Comp=new ValuesDbSiteCompare();
	   CredentialsDb addCredentials=new CredentialsDb();
	   User u=new User();
	   
	   /**
	     * @see HttpServlet#HttpServlet()
	     */
	     public void doGet(HttpServletRequest request, HttpServletResponse response){
		   try{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				
				
				
				u.setUsername(request.getParameter("uname"));//i take the variable from the site username
				u.setPassword(request.getParameter("psw"));//i take the variable from the site password
				
				Dbe.dbcheckifexists();
				
				 
				
				
				boolean x;
				x=Comp.ValuesCompare(u.getUsername(), u.getPassword());
				
				 //edw kanw ton elegxo an auta pou edwse o xrhsths sthn selida einai idia me thw bashs dedomenvn
				if(x==true) {
					addCredentials.InsertCredentials(u.getUsername(),u.getPassword()); 
					out.print("<meta http-equiv=\"refresh\" content=\"0; URL='eplatform_menu.html'\" />");
					
				}
				else {
					
					 out.print("wrong password");
					 out.print("<meta http-equiv=\"refresh\" content=\"5; URL='eplatform_citizen.html'\" />");
					//εδω πρεπει να μπει ο ελγχος
					
				}
				
				
				 
				
				
				HttpSession session=request.getSession();
				session.setAttribute("uname",u.getUsername());
				}catch(Exception e){System.out.println(e);}
				
			}
			
		}
	
	
	

