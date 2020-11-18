package Servlets;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Main.CreateDbStatusForms;
import Main.CreateValidationDb;
import Main.DeleteRowFromUserFormsTable;
import Main.TakeValuesFromStatusForm;
import Main.ValidateStatusForm;

/**
 * Servlet implementation class eplatform_menu
 */
@WebServlet("/GiveOfficialCertificateToUser")
public class GiveOfficialCertificateToUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	CreateDbStatusForms CreateStatDb=new CreateDbStatusForms(); 
	CreateValidationDb CValDb=new CreateValidationDb();
	ValidateStatusForm ValStForm=new ValidateStatusForm();
	 TakeValuesFromStatusForm TakeValForm=new TakeValuesFromStatusForm();
	 DeleteRowFromUserFormsTable DelRFromUserForms=new DeleteRowFromUserFormsTable();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GiveOfficialCertificateToUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CValDb.CreateDbValidation(); 
	CreateStatDb.CreateDbStatusF();
	String Info;
	Info=TakeValForm.TakeValues();

	String[] I=Info.split(",");
	System.out.println(I[0]);
	ValStForm.InsertAccept(I[0], I[1]);
	DelRFromUserForms.DeleteRowUserForms(I[0], I[1]);
	
	
	
		 try{
		
			response.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.print("<h1>It is done the request has been accepted</h1>"
					+ "<form action=\"AdminmenuAfterRequestValidation\"  >\r\n" + 
					"      <input type=\"submit\" value=\"Επιστροφή\"/>\r\n" + 
					"     </form>" );
		
		
		}catch(Exception e)
		 {
			System.out.println(e);
			}
		
		
	}

}
