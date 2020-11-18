package Servlets;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Main.CheckDbexists;
import Main.CreateDbStatusForms;
import Main.DBAdminTableCreate;
import Main.TakeValuesFromStatusForm;
import Main.User;
import Main.ValuesDbSiteCompareAdmin;

/**
 * Servlet implementation class eplatform_menu
 */
@WebServlet("/Db_Login_Check_Admin")
public class Db_Login_Check_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CheckDbexists Dbe=new CheckDbexists();
	ValuesDbSiteCompareAdmin CompA=new ValuesDbSiteCompareAdmin();
	TakeValuesFromStatusForm ValuesFromForm=new TakeValuesFromStatusForm();
	CreateDbStatusForms CreatDbStatForms=new CreateDbStatusForms();
	User u =new User();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Db_Login_Check_Admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    DBAdminTableCreate Dba=new DBAdminTableCreate();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
	u.setUsername(request.getParameter("uname"));
	u.setPassword(request.getParameter("psw"));
	
	Dbe.dbcheckifexists();
	Dba.dbcheckifadminTableexists();
	boolean x=false;
	x=CompA.ValuesCompare(u.getUsername(), u.getPassword());
	 
		 try{
			 response.setContentType("text/html; charset=UTF-8");
			 
				PrintWriter out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
		if(x==true) {
			CreatDbStatForms.CreateDbStatusF();
			
			String info=ValuesFromForm.TakeValues();
			
		 String[] I=info.split(",");
		 
		 
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
				"\r\n" + 
				"\r\n"
				+ "li a:hover:not(.active) {\r\n" + 
				"    background-color: #ffffff;\r\n" + 
				"    color: black;\r\n" + 
				" }"
				+ " li a.active {\r\n" + 
				"    background-color: #ffffff;\r\n" + 
				"    color: black;\r\n" + 
				" }"
				+ "li a {\r\n" + 
				"    display: block;\r\n" + 
				"    color: #000;\r\n" + 
				"    padding: 8px 16px;\r\n" + 
				"    text-decoration: none;\r\n" + 
				" }" + 
				"body {\r\n" + 
				"  font-weight: 100;\r\n" + 
				"  line-height: 10px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".container {\r\n" + 
				"  max-width: 4000px;\r\n" + 
				"  width: 75%;\r\n" + 
				"  margin: 100 auto;\r\n" + 
				"  position: relative;\r\n" + 
				"}\r\n" + 
				"    \r\n" + 
				"\r\n" + 
				"#contact {\r\n" + 
				"  background: #F9F9F9;\r\n" + 
				"  padding: 25px;\r\n" + 
				"  margin: 50px 0;\r\n" + 
				"  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"fieldset {\r\n" + 
				"  border: medium none !important;\r\n" + 
				"  margin: 0 0 10px;\r\n" + 
				"  min-width: 60%;/*αλλαζει το μέγεθος του κουτιού*/\r\n" + 
				"  padding: 100;\r\n" + 
				"  width: 0%;\r\n" + 
				"}\r\n" + 
				" \r\n" + 
				"#contact textarea {\r\n" + 
				"  width: 100%;\r\n" + 
				"  border: 1px solid #ccc;\r\n" + 
				"  background: #FFF;\r\n"+
				"  margin: 0 0 5px;\r\n" + 
				"  padding: 10px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				" \r\n"
				+ "\r\n" + 
				 "ul {\r\n" + 
				 "    list-style-type: none;\r\n" + 
				 "    margin: 0;\r\n" + 
				 "    padding: 0;\r\n" + 
				 "    width: 20%;\r\n" + 
				 "    background-color: #007DB1;\r\n" + 
				 "}" + 
				"" + 
				" }" + 
				" \r\n" + 
				" \r\n" + 
				"\r\n" + 
				" \r\n" + 
				" \r\n" + 
				"\r\n" + 
				".copyright {\r\n" + 
				"  text-align: center;\r\n" + 
				"}\r\n" + 
				" \r\n" + 
				"\r\n" + 
				" \r\n" + 
				"</style>\r\n" + 
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
				"\r\n" + 
				"    <div class=\"container\" id=\"contact\">\r\n" + 
				"        <form  action=\"GiveOfficialCertificateToUser \" >\r\n" + 
				"\r\n" + 
				"            <fieldset>\r\n" + 
				"                <textarea  tabindex=\"5\" name=\"subject\" required> "+I[2]+I[3]+I[4]+"</textarea>\r\n" + 
				"              \r\n" + 
				"            </fieldset>\r\n" + 
				"            <fieldset>\r\n" + 
				"                <button name=\"submit\" type=\"submit\" id=\"contact-submit\" >Έγκριση</button>\r\n" + 
				"            </fieldset>\r\n" + 
				"             \r\n" + 
				"        </form>\r\n"
				+ "<form action=\"DeclineCertificate\"  >\r\n"
				+ "<fieldset>" + 
				"      <input type=\"submit\" value=\"Απόρριψη\"/>\r\n"
				+ "</fieldset>" + 
				"     </form>"
				+ "<ul>"
				+ "<li>"
				+ "<a href=\"eplatform.html\"><h3>Αποσύνδεση</h3></a>"
				+ "</li>"
				+ "</ul>"+
				 "        \r\n" + 
				"    </div>\r\n" + 
				"\r\n"
				+ "<meta http-equiv=\"refresh\" content=\"1;/>" + 
				"</body>  \r\n" + 
				"\r\n" + 
				"</html>");
		}else {
			out.print("wrong password");
			 out.print("<meta http-equiv=\"refresh\" content=\"5; URL='eplatform_admin.html'\" />");
		}
		
		}catch(Exception e)
		 {
			System.out.println(e);
			}
		
		
	}

}
