package Servlets;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.CheckifcredntialsExistinStatus;
import Main.CreateDbStatusForms;
import Main.InsertIntoStatusFamilyCertificate;
import Main.TakeCredentials;

/**
 * Servlet implementation class eplatform_menu
 */
@WebServlet("/SendRequestCertificate")
public class SendRequestCertificate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TakeCredentials tc =new TakeCredentials();
	CreateDbStatusForms CreateStatDb=new CreateDbStatusForms();
	CheckifcredntialsExistinStatus CheckifCrStatusExis=new 	CheckifcredntialsExistinStatus();
	InsertIntoStatusFamilyCertificate InsIntoStatFamilCert=new InsertIntoStatusFamilyCertificate(); 
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendRequestCertificate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String credentials=tc.mycredentials();
	String[] c = credentials.split(",");
	CreateStatDb.CreateDbStatusF();
	boolean l=false;
	l=CheckifCrStatusExis.CheckStatusF(c[0], c[1]);
	System.out.println(l);
	if(l==false) {
		InsIntoStatFamilCert.CheckStatusF(c[0], c[1],c[2],c[3]);
	}
	 
	
		 try{
		 
			 response.setContentType("text/html; charset=UTF-8");
		 
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		out.print("<!DOCTYPE html>\r\n" + 
				"\r\n" + 
				"<html>  \r\n" + 
				"\r\n" + 
				"<head>  \r\n" + 
				"\r\n" + 
				" <meta http-equiv=\"Content-Type\" content=\"text/html\">\r\n" + 
				" <meta charset=\"UTF-8\">\r\n" + 
				" \r\n" + 
				" <title>Ηλεκτρονική Πλατφόρμα Εξυπηρέτησης Πελατών</title>  \r\n" + 
				"\r\n" + 
				"<style>\r\n" + 
				"\r\n" + 
				" button{\r\n" + 
				"  background-color: #007DB1;\r\n" + 
				"  border: none;\r\n" + 
				"  color: white;\r\n" + 
				"  padding: 16px 32px;\r\n" + 
				"  text-align: center;\r\n" + 
				"  font-size: 16px;\r\n" + 
				"  margin: 4px 2px;\r\n" + 
				"  transition: 0.3s;\r\n" + 
				"  display: inline-block;\r\n" + 
				"  text-decoration: none;\r\n" + 
				"  cursor: pointer;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" .button:hover {opacity: 0.6;}\r\n" + 
				" \r\n" + 
				" div{\r\n" + 
				" border: 2px solid #007DB1;\r\n" + 
				" }\r\n" + 
				" \r\n" + 
				"    div{\r\n" + 
				" border: 1px solid #007DB1;\r\n" + 
				" }\r\n" + 
				" \r\n" + 
				" table{\r\n" + 
				"    text-align:left\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" div{\r\n" + 
				" border: 1px solid #007DB1;\r\n" + 
				" }\r\n" + 
				" \r\n" + 
				" table{\r\n" + 
				"    text-align:left\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				"</style>\r\n" + 
				" \r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>  \r\n" + 
				"\r\n" + 
				" <p><a href=\"eplatform_menu.html\"><img style=\"float: left;\" src=\"logo.png\" alt=\"\" width=\"300\" height=\"84\" /></a></p>\r\n" + 
				" <p>&nbsp;</p>\r\n" + 
				" <p>&nbsp;</p>\r\n" + 
				" <p>&nbsp;</p>\r\n" + 
				" <p>&nbsp;</p>\r\n" + 
				" \r\n" + 
				" <div>\r\n" + 
				" \r\n" + 
				" <h1> Ευχαριστούμε πολυ έχουμε λάβει το αίτημα σας.\r\n" + 
				"     <br>\r\n" + 
				"     Θα πρέπει να περιμένετε κάποιος απο τους διαχειριστές  της υπηρεσίας  να εγκρίνει αυτο το αίτημα !!!\r\n"
				+ "Παρακαλώ περιμένετε ναγυρίσει η οθόνη αυτόματα " + 
				" </h1>\r\n" + 
				"\r\n" + 
				" \r\n" + 
				" \r\n" + 
				"\r\n"
				+ "\"<meta http-equiv=\"refresh\" content=\"5; URL='eplatform_menu.html'\" />\"" + 
				"</body>  \r\n" + 
				"\r\n"
				+  
				"</html>");
		
		
		
		}catch(Exception e)
		 {
			System.out.println(e);
			}
		
		
	}

}
