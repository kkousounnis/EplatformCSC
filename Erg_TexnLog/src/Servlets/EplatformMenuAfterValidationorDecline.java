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
import Main.TakeValuesFromStatusForm;
import Main.User;
import Main.ValuesDbSiteCompareAdmin;

/**
 * Servlet implementation class eplatform_menu
 */
@WebServlet("/EplatformMenuAfterValidationorDecline")
public class EplatformMenuAfterValidationorDecline extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CheckDbexists Dbe=new CheckDbexists();
	ValuesDbSiteCompareAdmin CompA=new ValuesDbSiteCompareAdmin();
	TakeValuesFromStatusForm ValuesFromForm=new TakeValuesFromStatusForm();
	CreateDbStatusForms CreatDbStatForms=new CreateDbStatusForms();
	User u =new User();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EplatformMenuAfterValidationorDecline() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
	 
	
	Dbe.dbcheckifexists();
	 
	 
		 try{
			 response.setContentType("text/html; charset=UTF-8");
			 
				PrintWriter out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
		 
			 
		 
		 
		out.print(" <!DOCTYPE html>\r\n" + 
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
				" body {\r\n" + 
				"    margin: 0;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" ul {\r\n" + 
				"    list-style-type: none;\r\n" + 
				"    margin: 0;\r\n" + 
				"    padding: 0;\r\n" + 
				"    width: 15%;\r\n" + 
				"    background-color: #007DB1;\r\n" + 
				"    position: fixed;\r\n" + 
				"	right: 0px;\r\n" + 
				"    height: 100%;\r\n" + 
				"    overflow: auto;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" li a {\r\n" + 
				"    display: block;\r\n" + 
				"    color: #000;\r\n" + 
				"    padding: 8px 16px;\r\n" + 
				"    text-decoration: none;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" li a.active {\r\n" + 
				"    background-color: #ffffff;\r\n" + 
				"    color: black;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" li a:hover:not(.active) {\r\n" + 
				"    background-color: #ffffff;\r\n" + 
				"    color: black;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				"\r\n" + 
				" .dropbtn {\r\n" + 
				"\r\n" + 
				"    background-color: #007DB1;\r\n" + 
				"    color: black;\r\n" + 
				"    padding: 8px 16px;\r\n" + 
				"    border: none;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" .dropdown {\r\n" + 
				"    position: relative;\r\n" + 
				"    display: inline-block;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" .dropdown-content {\r\n" + 
				"    display: none;\r\n" + 
				"    position: absolute;\r\n" + 
				"    background-color: #e6f7ff;\r\n" + 
				"    min-width: 200px;\r\n" + 
				"    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\r\n" + 
				"    z-index: 1;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" .dropdown-content a {\r\n" + 
				"    color: black;\r\n" + 
				"    padding: 12px 16px;\r\n" + 
				"    text-decoration: none;\r\n" + 
				"    display: block;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				"\r\n" + 
				" .dropdown:hover .dropdown-content {\r\n" + 
				"    display: block;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" .dropdown:hover .dropbtn {\r\n" + 
				"    background-color: #FFFFFF;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" .dropdown-content a:hover {background-color: #FFFFFF}\r\n" + 
				"\r\n" + 
				"\r\n" + 
				" body {\r\n" + 
				"  \r\n" + 
				"  font-family: 'proxima-nova-soft', sans-serif;\r\n" + 
				"  font-size: 14px;\r\n" + 
				"  -webkit-font-smoothing: antialiased;\r\n" + 
				"  -moz-osx-font-smoothing: grayscale;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" .post-module {\r\n" + 
				"  position: relative;\r\n" + 
				"  z-index: 1;\r\n" + 
				"  display: block;\r\n" + 
				"  background: #FFFFFF;\r\n" + 
				"  min-width: 270px;\r\n" + 
				"  height: 470px;\r\n" + 
				"  -webkit-box-shadow: 0px 1px 2px 0px rgba(0, 0, 0, 0.15);\r\n" + 
				"  -moz-box-shadow: 0px 1px 2px 0px rgba(0, 0, 0, 0.15);\r\n" + 
				"  box-shadow: 0px 1px 2px 0px rgba(0, 0, 0, 0.15);\r\n" + 
				"  -webkit-transition: all 0.3s linear 0s;\r\n" + 
				"  -moz-transition: all 0.3s linear 0s;\r\n" + 
				"  -ms-transition: all 0.3s linear 0s;\r\n" + 
				"  -o-transition: all 0.3s linear 0s;\r\n" + 
				"  transition: all 0.3s linear 0s;\r\n" + 
				" }\r\n" + 
				" \r\n" + 
				" .post-module:hover,\r\n" + 
				" .hover {\r\n" + 
				"  -webkit-box-shadow: 0px 1px 35px 0px rgba(0, 0, 0, 0.3);\r\n" + 
				"  -moz-box-shadow: 0px 1px 35px 0px rgba(0, 0, 0, 0.3);\r\n" + 
				"  box-shadow: 0px 1px 35px 0px rgba(0, 0, 0, 0.3);\r\n" + 
				" }\r\n" + 
				" \r\n" + 
				" .post-module:hover .thumbnail img,\r\n" + 
				" .hover .thumbnail img {\r\n" + 
				"  -webkit-transform: scale(1.1);\r\n" + 
				"  -moz-transform: scale(1.1);\r\n" + 
				"  transform: scale(1.1);\r\n" + 
				"  opacity: .6;\r\n" + 
				" }\r\n" + 
				" \r\n" + 
				" .post-module .thumbnail {\r\n" + 
				"  background: #000000;\r\n" + 
				"  height: 400px;\r\n" + 
				"  overflow: hidden;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" .post-module .thumbnail img {\r\n" + 
				"  display: block;\r\n" + 
				"  width: 120%;\r\n" + 
				"  -webkit-transition: all 0.3s linear 0s;\r\n" + 
				"  -moz-transition: all 0.3s linear 0s;\r\n" + 
				"  -ms-transition: all 0.3s linear 0s;\r\n" + 
				"  -o-transition: all 0.3s linear 0s;\r\n" + 
				"  transition: all 0.3s linear 0s;\r\n" + 
				" }\r\n" + 
				" \r\n" + 
				" .post-module .post-content {\r\n" + 
				"  position: absolute;\r\n" + 
				"  bottom: 0;\r\n" + 
				"  background: #FFFFFF;\r\n" + 
				"  width: 100%;\r\n" + 
				"  padding: 30px;\r\n" + 
				"  -webkti-box-sizing: border-box;\r\n" + 
				"  -moz-box-sizing: border-box;\r\n" + 
				"  box-sizing: border-box;\r\n" + 
				"  -webkit-transition: all 0.3s cubic-bezier(0.37, 0.75, 0.61, 1.05) 0s;\r\n" + 
				"  -moz-transition: all 0.3s cubic-bezier(0.37, 0.75, 0.61, 1.05) 0s;\r\n" + 
				"  -ms-transition: all 0.3s cubic-bezier(0.37, 0.75, 0.61, 1.05) 0s;\r\n" + 
				"  -o-transition: all 0.3s cubic-bezier(0.37, 0.75, 0.61, 1.05) 0s;\r\n" + 
				"  transition: all 0.3s cubic-bezier(0.37, 0.75, 0.61, 1.05) 0s;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" .post-module .post-content .title {\r\n" + 
				"  margin: 0;\r\n" + 
				"  padding: 0 0 10px;\r\n" + 
				"  color: #333333;\r\n" + 
				"  font-size: 26px;\r\n" + 
				"  font-weight: 700;\r\n" + 
				" }\r\n" + 
				" \r\n" + 
				" .post-module .post-content .sub_title {\r\n" + 
				"  margin: 0;\r\n" + 
				"  padding: 0 0 20px;\r\n" + 
				"  color: #e74c3c;\r\n" + 
				"  font-size: 20px;\r\n" + 
				"  font-weight: 400;\r\n" + 
				" }\r\n" + 
				"\r\n" + 
				" .hover .post-content .description {\r\n" + 
				"  display: block !important;\r\n" + 
				"  height: auto !important;\r\n" + 
				"  opacity: 1 !important;\r\n" + 
				" }\r\n" + 
				" \r\n" + 
				" .container {\r\n" + 
				"  max-width: 800px;\r\n" + 
				"  min-width: 640px;\r\n" + 
				"  margin: 0 auto;\r\n" + 
				" }\r\n" + 
				" \r\n" + 
				" .container:before,\r\n" + 
				" .container:after {\r\n" + 
				"  content: '';\r\n" + 
				"  display: block;\r\n" + 
				"  clear: both;\r\n" + 
				" }\r\n" + 
				" \r\n" + 
				" .container .column {\r\n" + 
				"  width: 50%;\r\n" + 
				"  padding: 0 25px;\r\n" + 
				"  -webkti-box-sizing: border-box;\r\n" + 
				"  -moz-box-sizing: border-box;\r\n" + 
				"  box-sizing: border-box;\r\n" + 
				"  float: left;\r\n" + 
				" }\r\n" + 
				" \r\n" + 
				"</style>\r\n" + 
				" \r\n" + 
				"<script>\r\n" + 
				"\r\n" + 
				" $(window).load(function() {\r\n" + 
				"  $(\".post-module\").hover(function() {\r\n" + 
				"    $(this)\r\n" + 
				"      .find(\".description\")\r\n" + 
				"      .stop()\r\n" + 
				"      .animate(\r\n" + 
				"      {\r\n" + 
				"        height: \"toggle\",\r\n" + 
				"        opacity: \"toggle\"\r\n" + 
				"      },\r\n" + 
				"      300\r\n" + 
				"    );\r\n" + 
				"  });\r\n" + 
				" });\r\n" + 
				"\r\n" + 
				"</script> \r\n" + 
				" \r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>  \r\n" + 
				"<meta http-equiv=\\\"refresh\\\" content=\\\"1; URL='eplatform_menu.html'\\\" />\r\n" + 
				" <ul>\r\n" + 
				"  <br>\r\n" + 
				"  <li><a class=\"active\" href=\"eplatform_menu.html\"><h3>Αρχική Σελίδα</h3></a></li>\r\n" + 
				"  <div class=\"dropdown\"> \r\n" + 
				"  <button class=\"dropbtn\"><h3>Στοιχεία Χρήστη</h3></button>\r\n" + 
				"  <div class=\"dropdown-content\" style=\"float:right;\">\r\n" + 
				"   <form action=\"eplatform_userdata\"  >\r\n" + 
				"      <input type=\"submit\" value=\"Στοιχεία Χρήστη\"/>\r\n" + 
				"     </form>\r\n" + 
				"  </div>\r\n" + 
				"  </div>\r\n" + 
				"     \r\n" + 
				"  <div class=\"dropdown\">\r\n" + 
				"  <button class=\"dropbtn\"><h3>Βεβαιώσεις</h3></button>\r\n" + 
				"  <div class=\"dropdown-content\" style=\"float:right;\">\r\n" + 
				"  <form action=\"Family_certificate_status\"  >\r\n" + 
				"      <input type=\"submit\" value=\"Πιστοποιητικό Οικογενειακής Κατάστασης\"/>\r\n" + 
				"     </form>\r\n" + 
				"     <form action=\"birth_certificate\"  >\r\n" + 
				"      <input type=\"submit\" value=\"Πιστοποιητικό Γέννησης\"/>\r\n" + 
				"     </form>	\r\n" + 
				"      <form action=\"mariage_certificate\"  >\r\n" + 
				"      <input type=\"submit\" value=\"Ληξιαρχική Πράξη Γάμου\"/>\r\n" + 
				"     </form>\r\n" + 
				"     <form action=\"death_certificate\"  >\r\n" + 
				"      <input type=\"submit\" value=\"Ληξιαρχική Πράξη Θανάτου\"/>\r\n" + 
				"     </form> \r\n" + 
				"     <form action=\"insurance_broker_certificate\"  >\r\n" + 
				"      <input type=\"submit\" value=\"Βεβαίωση Ασφαλιστικής Ενημερότητας\"/>\r\n" + 
				"     </form>  \r\n" + 
				"     <form action=\"Certificate_of_Citizenship\"  >\r\n" + 
				"      <input type=\"submit\" value=\"Βεβαίωση Ιθαγένειας\"/>\r\n" + 
				"     </form> \r\n" + 
				"     <form action=\"locality_certificate\"  >\r\n" + 
				"      <input type=\"submit\" value=\"Βεβαίωση Εντοπιότητας\"/>\r\n" + 
				"     </form>\r\n" + 
				"      \r\n" + 
				"  </div>\r\n" + 
				"  </div>\r\n" + 
				"  <li><a href=\"eplatform_message.html\"><h3>Επικοινωνία</h3></a></li>\r\n" + 
				"  \r\n" + 
				"   \r\n" + 
				"  <li><a href=\"eplatform.html\"><h3>Αποσύνδεση</h3></a></li>\r\n" + 
				" </ul>\r\n" + 
				"\r\n" + 
				" <div style=\"margin-right:15%;padding:1px 16px;height:1000px;\">\r\n" + 
				" <p><a href=\"eplatform.html\"><img style=\"float: left;\" src=\"logo.png\" alt=\"\" width=\"300\" height=\"84\" /></a></p>\r\n" + 
				" <p>&nbsp;</p>\r\n" + 
				" <p>&nbsp;</p>\r\n" + 
				" <p>&nbsp;</p>\r\n" + 
				" <p>&nbsp;</p>\r\n" + 
				"\r\n" + 
				" <div class=\"container\">\r\n" + 
				"  \r\n" + 
				"  <div class=\"column\">\r\n" + 
				"    <!-- Post-->\r\n" + 
				"    <div class=\"post-module\">\r\n" + 
				"      <!-- Thumbnail-->\r\n" + 
				"      <div class=\"thumbnail\">\r\n" + 
				"        <img src=\"article1.jpeg\"/>\r\n" + 
				"      </div>\r\n" + 
				"      <!-- Post Content-->\r\n" + 
				"      <div class=\"post-content\">\r\n" + 
				"        <h1 class=\"title\">Άρθρο Ένα</h1>\r\n" + 
				"        <h2 class=\"sub_title\">Υπότιτλος Ένα</h2>\r\n" + 
				"        <p class=\"description\">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"\r\n" + 
				"  <div class=\"column\">\r\n" + 
				"    <!-- Post-->\r\n" + 
				"    <div class=\"post-module\">\r\n" + 
				"      <!-- Thumbnail-->\r\n" + 
				"      <div class=\"thumbnail\">\r\n" + 
				"        <img src=\"article2.jpg\"/>\r\n" + 
				"      </div>\r\n" + 
				"      <!-- Post Content-->\r\n" + 
				"      <div class=\"post-content\">\r\n" + 
				"        <h1 class=\"title\">Άρθρο Δύο</h1>\r\n" + 
				"        <h2 class=\"sub_title\">Υπότιτλος Δύο</h2>\r\n" + 
				"        <p class=\"description\">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>\r\n" + 
				"      </div>\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				" \r\n" + 
				" </div>\r\n" + 
				" \r\n" + 
				" </div> \r\n" + 
				"\r\n" + 
				" </body>  \r\n" + 
				"\r\n" + 
				"</html>");
		
		
		}catch(Exception e)
		 {
			System.out.println(e);
			}
		
		
	}

}
