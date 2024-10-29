package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import AppDBContext.api_User;

/**
 * Servlet implementation class page1
 */
public class page1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_User api_user = new api_User();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public page1() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String FullName = request.getParameter("fullname");
		String Gmail = request.getParameter("Email");
		String NRIC = request.getParameter("NRIC");
		String age = request.getParameter("age");
		String birth = request.getParameter("birth");
		String gender = request.getParameter("gender");
		
		int age_check = Integer.valueOf(age);
		
		try {
			
			boolean b1 = api_User.Checking_By_Email(Gmail, "Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC", "admin");
			if(b1 == true) {
				session.setAttribute("errorpage1", "Please use another Email.");
				response.sendRedirect("MeyBank_SignUp/page/page1.jsp");
				return;
			}
			
			boolean b2 = api_User.Checking_By_NRIC(NRIC, "Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC", "admin");
			if(b2 == true) {
				session.setAttribute("errorpage1", "Please use another NRIC.");
				response.sendRedirect("MeyBank_SignUp/page/page1.jsp");
				return;
			}
			
			if(age_check < 18 || age_check > 60) {
				session.setAttribute("errorpage1", "Age must be between 18 - 60.");
				response.sendRedirect("MeyBank_SignUp/page/page1.jsp");
				return;
			}
			
			
		}catch (Exception e) {
			response.sendRedirect("MeyBank_SignUp/page/page1.jsp");
			return;
		}
		
		
		session.setAttribute("errorpage1", null);

		session.setAttribute("page1fullname", FullName);
		session.setAttribute("page1gmail", Gmail);
		session.setAttribute("page1nric", NRIC);
		session.setAttribute("page1age", age);
		session.setAttribute("page1birth", birth);
		session.setAttribute("page1gender", gender);
		session.setAttribute("page1", "done");
		response.sendRedirect("MeyBank_SignUp/page/page2.jsp");
		return;
	}

}
