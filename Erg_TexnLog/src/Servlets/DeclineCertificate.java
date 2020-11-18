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
import Main.DeclineRequest;
import Main.DeleteRowFromUserFormsTable;
import Main.TakeValuesFromStatusForm;
 

/**
 * Servlet implementation class eplatform_menu
 */
@WebServlet("/DeclineCertificate")
public class DeclineCertificate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	CreateDbStatusForms CreateStatDb=new CreateDbStatusForms(); 
	CreateValidationDb CValDb=new CreateValidationDb();
	 
	 TakeValuesFromStatusForm TakeValForm=new TakeValuesFromStatusForm();
	 DeleteRowFromUserFormsTable DelRFromUserForms=new DeleteRowFromUserFormsTable();
	 DeclineRequest DeclineReq=new DeclineRequest();
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeclineCertificate() {
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
	DeclineReq.InsertDecline(I[0], I[1]);
	DelRFromUserForms.DeleteRowUserForms(I[0], I[1]);
	
	
	
		 try{
		
			response.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("UTF-8");
			out.print("<h1>It is done the request has been declined"
					+ "<form action=\"AdminmenuAfterRequestValidation\"  >\r\n" + 
					"      <input type=\"submit\" value=\" Επιστροφή\"/>\r\n" + 
					"     </form>" );
		
		
		}catch(Exception e)
		 {
			System.out.println(e);
			}
		
		
	}

}
