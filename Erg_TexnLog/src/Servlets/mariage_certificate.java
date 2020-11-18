package Servlets;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.CheckifRequestisAccepted;
import Main.DeleteRowFromValidateTable;
import Main.TakeCredentials;

/**
 * Servlet implementation class eplatform_menu
 */
@WebServlet("/mariage_certificate")
public class mariage_certificate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TakeCredentials tc =new TakeCredentials();
	CheckifRequestisAccepted CheckifReqIsAccept=new CheckifRequestisAccepted();
	DeleteRowFromValidateTable DelRowFrValidat=new DeleteRowFromValidateTable();
	   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mariage_certificate() {
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
	
	String update="";
	 
	 
	String validation="";

	validation=CheckifReqIsAccept.RequestCheck(c[0], c[1]);
	boolean x=false;
	
	if(validation.equals("ACCEPTED")) {
		    
		update="Όνομα"+c[2]+"Το αιτημα σας έχει εγκριθεί Μπορείτε να εκτυπώσετε το πιστοποιητικό ";
		x=true;
		 
	}
	if(validation.equals("DECLINED")){
		update="Όνομα"+c[2]+"Το αίτημα σας εχει απορριφθεί ";
		DelRowFrValidat.DeleteRowValidate(c[0], c[1]);
	}
		 try{
		if(x==true) {
			DelRowFrValidat.DeleteRowValidate(c[0], c[1]);
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
				" <title>Ηλεκτρονική Πλατφόρμα Εξυπηρέτησης Πελατών</title>  \r\n"
				+ "<h1>"+update+"</h1>" + 
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
				"  div{\r\n" + 
				" border: 1px solid #007DB1;\r\n" + 
				" }\r\n" + 
				"  \r\n" + 
				" table{\r\n" + 
				"    text-align:left\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				"</style>\r\n" + 
				" \r\n" + 
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
				" <h1>Ληξιαρχική Πράξη Γάμου</h1>\r\n" + 
				" \r\n" + 
				" <table>\r\n" + 
				" <tr>\r\n" + 
				"    <th><h3>Στοιχεία Ζεύγους</h3></th>\r\n" + 
				"	<th><h3>Άνδρας</h3></th>\r\n" + 
				"	<th><h3>Γυναίκα</h3></th>\r\n" + 
				" </tr>\r\n" + 
				" <tr>\r\n" + 
				"    <th>Επώνυμο:</th>\r\n" + 
				"	<td>"+c[3]+"</td>\r\n" + 
				"	<td>*</td>\r\n" + 
				" </tr>\r\n" + 
				" <tr>	\r\n" + 
				"    <th>Όνομα:</th>\r\n" + 
				"    <td>"+c[2]+"</td>	\r\n" + 
				"	<td>*</td>\r\n" + 
				" </tr>	\r\n" + 
				" <tr>\r\n" + 
				"	<th>Πατρώνυμο:</th>\r\n" + 
				"	<td>"+c[4]+"</td>\r\n" + 
				"	<td>*</td>\r\n" + 
				" </tr>	\r\n" + 
				" <tr>\r\n" + 
				"	<th>Μητρώνυμο:</th>\r\n" + 
				"    <td>"+c[5]+"</td>\r\n" + 
				"	<td>*</td>\r\n" + 
				" </tr>	\r\n" + 
				" <tr>\r\n" + 
				"	<th>Ημερομηνία Γέννησης:</th> \r\n" + 
				"    <td>"+c[6]+"</td>\r\n" + 
				"	<td>*</td>\r\n" + 
				" </tr>	\r\n" + 
				" <tr>\r\n" + 
				"	<th>Χώρα Γέννησης:</th>\r\n" + 
				"	<td>Ελλάδα</td>\r\n" + 
				"	<td>*</td>\r\n" + 
				" </tr>	\r\n" + 
				" <tr>\r\n" + 
				"	<th>Ιθαγένεια:</th> \r\n" + 
				"	<td>Ελληνική</td>\r\n" + 
				"	<td>*</td>\r\n" + 
				" </tr>	\r\n" + 
				" <tr>\r\n" + 
				"	<th>Διεύθυνση Διαμονής:</th> \r\n" + 
				"	<td>"+c[10]+"</td>\r\n" + 
				"	<td>*</td>\r\n" + 
				" </tr>\r\n" + 
				" <tr>\r\n" + 
				"	<th>Αριθμός Αστυνομικής Ταυτότητας:</th> \r\n" + 
				"	<td>"+c[7]+"</td>\r\n" + 
				"	<td>*</td>\r\n" + 
				" </tr>\r\n" + 
				" <tr>\r\n" + 
				"	<th>Α.Φ.Μ.:</th> \r\n" + 
				"	<td>"+c[9]+"</td>\r\n" + 
				"	<td>*</td>\r\n" + 
				" </tr>\r\n" + 
				" <tr>\r\n" + 
				"	<th>Α.Μ.Κ.Α.:</th> \r\n" + 
				"	<td>"+c[8]+"</td>\r\n" + 
				"	<td>*</td>\r\n" + 
				" </tr>\r\n" + 
				" </table>\r\n" + 
				" \r\n" + 
				" <br><a href=\"eplatform.html\"><img src=\"esignature.png\" alt=\"\" width=\"300\" height=\"84\" /></a><br><br>\r\n" + 
				" \r\n" + 
				" </div>\r\n" + 
				" \r\n" + 
				" <button onclick=\"myFunction()\">Εκτύπωση</button>\r\n" + 
				"<form action=\"EplatformMenuAfterValidationorDecline\"  >\r\n" + 
				"      <input type=\"submit\" value=\"Επιστροφή\"/>\r\n" + 
				"     </form>" +
				" \r\n" + 
				"<script type=\"text/javascript\">\r\n" + 
				"\r\n" + 
				"  function myFunction() {\r\n" + 
				"    window.print();\r\n" + 
				" } \r\n" + 
				" \r\n" + 
				"</script>\r\n" + 
				"\r\n" + 
				"</body>  \r\n" + 
				"\r\n" + 
				"</html>");
		}else {
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
					" <title>Ηλεκτρονική Πλατφόρμα Εξυπηρέτησης Πελατών</title>  \r\n"
					+ "<h1>"+update+"</h1>" + 
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
					"  div{\r\n" + 
					" border: 1px solid #007DB1;\r\n" + 
					" }\r\n" + 
					"  \r\n" + 
					" table{\r\n" + 
					"    text-align:left\r\n" + 
					" }\r\n" + 
					"\r\n" + 
					"</style>\r\n" + 
					" \r\n" + 
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
					" <h1>Ληξιαρχική Πράξη Γάμου</h1>\r\n" + 
					" \r\n" + 
					" <table>\r\n" + 
					" <tr>\r\n" + 
					"    <th><h3>Στοιχεία Ζεύγους</h3></th>\r\n" + 
					"	<th><h3>Άνδρας</h3></th>\r\n" + 
					"	<th><h3>Γυναίκα</h3></th>\r\n" + 
					" </tr>\r\n" + 
					" <tr>\r\n" + 
					"    <th>Επώνυμο:</th>\r\n" + 
					"	<td>"+c[3]+"</td>\r\n" + 
					"	<td>*</td>\r\n" + 
					" </tr>\r\n" + 
					" <tr>	\r\n" + 
					"    <th>Όνομα:</th>\r\n" + 
					"    <td>"+c[2]+"</td>	\r\n" + 
					"	<td>*</td>\r\n" + 
					" </tr>	\r\n" + 
					" <tr>\r\n" + 
					"	<th>Πατρώνυμο:</th>\r\n" + 
					"	<td>"+c[4]+"</td>\r\n" + 
					"	<td>*</td>\r\n" + 
					" </tr>	\r\n" + 
					" <tr>\r\n" + 
					"	<th>Μητρώνυμο:</th>\r\n" + 
					"    <td>"+c[5]+"</td>\r\n" + 
					"	<td>*</td>\r\n" + 
					" </tr>	\r\n" + 
					" <tr>\r\n" + 
					"	<th>Ημερομηνία Γέννησης:</th> \r\n" + 
					"    <td>"+c[6]+"</td>\r\n" + 
					"	<td>*</td>\r\n" + 
					" </tr>	\r\n" + 
					" <tr>\r\n" + 
					"	<th>Χώρα Γέννησης:</th>\r\n" + 
					"	<td>Ελλάδα</td>\r\n" + 
					"	<td>*</td>\r\n" + 
					" </tr>	\r\n" + 
					" <tr>\r\n" + 
					"	<th>Ιθαγένεια:</th> \r\n" + 
					"	<td>Ελληνική</td>\r\n" + 
					"	<td>*</td>\r\n" + 
					" </tr>	\r\n" + 
					" <tr>\r\n" + 
					"	<th>Διεύθυνση Διαμονής:</th> \r\n" + 
					"	<td>"+c[10]+"</td>\r\n" + 
					"	<td>*</td>\r\n" + 
					" </tr>\r\n" + 
					" <tr>\r\n" + 
					"	<th>Αριθμός Αστυνομικής Ταυτότητας:</th> \r\n" + 
					"	<td>"+c[7]+"</td>\r\n" + 
					"	<td>*</td>\r\n" + 
					" </tr>\r\n" + 
					" <tr>\r\n" + 
					"	<th>Α.Φ.Μ.:</th> \r\n" + 
					"	<td>"+c[9]+"</td>\r\n" + 
					"	<td>*</td>\r\n" + 
					" </tr>\r\n" + 
					" <tr>\r\n" + 
					"	<th>Α.Μ.Κ.Α.:</th> \r\n" + 
					"	<td>"+c[8]+"</td>\r\n" + 
					"	<td>*</td>\r\n" + 
					" </tr>\r\n" + 
					" </table>\r\n" + 
					" \r\n" +					
					" \r\n" + 
					" </div>\r\n" + 
					" \r\n" + 
					" <button onclick=\"myFunction()\">Εκτύπωση</button>\r\n" + 
					" \r\n" + 
					"<form action=\"SendRequestCertificate\"  >\r\n" + 
					"      <input type=\"submit\" value=\"Αίτημα Έγκρισης\"/>\r\n" + 
					"     </form>"
					+ " <form action=\"EplatformMenuAfterValidationorDecline\"  >\r\n" + 
					"      <input type=\"submit\" value=\"Επιστροφή\"/>\r\n" + 
					"     </form>"+
					"<script type=\"text/javascript\">\r\n" + 
					"\r\n" + 
					"  function myFunction() {\r\n" + 
					"    window.print();\r\n" + 
					" } \r\n" + 
					" \r\n" + 
					"</script>\r\n" + 
					"\r\n" + 
					"</body>  \r\n" + 
					"\r\n" + 
					"</html>");
		}
		
		}catch(Exception e)
		 {
			System.out.println(e);
			}
		
		
	}

}
