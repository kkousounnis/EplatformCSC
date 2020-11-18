package Servlets;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.TakeCredentials;

/**
 * Servlet implementation class eplatform_menu
 */
@WebServlet("/eplatform_userdata")
public class eplatform_userdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TakeCredentials tc =new TakeCredentials();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eplatform_userdata() {
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
				" body {font-family: Arial, Helvetica, sans-serif;}\r\n" + 
				" form {margin: 0 auto; border: 10px solid #f1f1f1; width: 40%;}\r\n" + 
				"\r\n" + 
				" input[type=text], input[type=password] {\r\n" + 
				"    width: 100%;\r\n" + 
				"    padding: 12px 20px;\r\n" + 
				"    margin: 8px 0;\r\n" + 
				"    display: inline-block;\r\n" + 
				"    border: 1px solid #ccc;\r\n" + 
				"    box-sizing: border-box;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" button {\r\n" + 
				"    background-color: #007DB1;\r\n" + 
				"    color: white;\r\n" + 
				"    padding: 14px 20px;\r\n" + 
				"    margin: 8px 0;\r\n" + 
				"    border: none;\r\n" + 
				"    cursor: pointer;\r\n" + 
				"    width: 100%;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" button:hover {\r\n" + 
				"    opacity: 0.8;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				"\r\n" + 
				" .container {\r\n" + 
				"    padding: 16px;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" span.uname {\r\n" + 
				"    float: right;\r\n" + 
				"    padding-top: 16px;\r\n" + 
				" }\r\n" + 
				" \r\n" + 
				" table{\r\n" + 
				"    text-align:left\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"</style>\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>  \r\n" + 
				"\r\n" + 
				" <p><a href=\"eplatform.html\"><img style=\"float: left;\" src=\"logo.png\" alt=\"\" width=\"300\" height=\"84\" /></a></p>\r\n" + 
				" <p>&nbsp;</p>\r\n" + 
				" <p>&nbsp;</p>\r\n" + 
				" <p>&nbsp;</p>\r\n" + 
				" <p>&nbsp;</p>\r\n" + 
				" <h2 style=\"text-align: center;\">Στοιχεία Χρήστη</h2>\r\n" + 
				" <p>&nbsp;</p>\r\n" + 
				"\r\n" + 
				" <form action=\"/action_page.php\">\r\n" + 
				"\r\n" + 
				"  <div class=\"container\">\r\n" + 
				"  \r\n" + 
				" <table>\r\n" + 
				" <tr>\r\n" + 
				"    <th>Όνομα:</th>\r\n" + 
				"	<td>"+c[3]+"</td>\r\n" + 
				" </tr>\r\n" + 
				" <tr>	\r\n" + 
				"    <th>Επώνυμο:</th>\r\n" + 
				"    <td>"+c[2]+"</td>	\r\n" + 
				" </tr>\r\n" + 
				" <tr>\r\n" + 
				"	<th>Πατρώνυμο:</th> \r\n" + 
				"	<td>"+c[4]+"</td>\r\n" + 
				" </tr>\r\n" + 
				" <tr>\r\n" + 
				"	<th>Μητρώνυμο:</th> \r\n" + 
				"	<td>"+c[5]+"</td>\r\n" + 
				" </tr>\r\n" + 
				" <tr>\r\n" + 
				"	<th>Ημερομηνία Γέννησης:</th> \r\n" + 
				"	<td>"+c[6]+"</td>\r\n" + 
				" </tr>\r\n" + 
				" <tr>\r\n" + 
				"	<th>Αριθμός Αστυνομικής Ταυτότητας:</th> \r\n" + 
				"	<td>"+c[7]+"</td>\r\n" + 
				" </tr>\r\n" + 
				" <tr>\r\n" + 
				"	<th>Α.Μ.Κ.Α.:</th> \r\n" + 
				"	<td>"+c[8]+"</td>\r\n" + 
				" </tr>\r\n" + 
				" <tr>\r\n" + 
				"	<th>Α.Φ.Μ.:</th> \r\n" + 
				"	<td>"+c[9]+"</td>\r\n" + 
				" </tr>\r\n" + 
				" <tr>\r\n" + 
				"	<th>Διεύθυνση Διαμονής:</th> \r\n" + 
				"	<td>"+c[10]+"</td>\r\n" + 
				" </tr>\r\n" + 
				" <tr>\r\n" + 
				"	<th>Τηλέφωνο:</th> \r\n" + 
				"	<td>"+c[11]+"</td>\r\n" + 
				" </tr>\r\n" + 
				" <tr>\r\n" + 
				"	<th>E-mail:</th> \r\n" + 
				"	<td>"+c[12]+"</td>\r\n" + 
				" </tr>\r\n" + 
				" </table>\r\n" + 
				"     \r\n" + 
				"  </div>\r\n" + 
				"\r\n" + 
				" </form>\r\n" + 
				" \r\n" + 
				"</body>  \r\n" + 
				"\r\n" + 
				"</html>");
		
		}catch(Exception e)
		 {
			System.out.println(e);
			}
		
		
	}

}
