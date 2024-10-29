package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import AppDBContext.*;

/**
 * Servlet implementation class page2
 */
public class page2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Account api_account = new api_Account();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public page2() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String verifyWord = request.getParameter("verifyWord");
		
		try {
			
			boolean b1 = api_account.Checking_By_username(userid, "Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC", "admin");
			if(b1 == true) {
				session.setAttribute("errorpage2", "Please use another user id.");
				response.sendRedirect("MeyBank_SignUp/page/page2.jsp");
				return;
			}
			
			boolean b2 = api_account.Checking_By_password(password, "Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC", "admin");
			if(b2 == true) {
				session.setAttribute("errorpage2", "Please use another password.");
				response.sendRedirect("MeyBank_SignUp/page/page2.jsp");
				return;
			}
			
			boolean b3 = api_account.Checking_By_ver(verifyWord, "Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC", "admin");
			if(b3 == true) {
				session.setAttribute("errorpage2", "Please use another verifyWord.");
				response.sendRedirect("MeyBank_SignUp/page/page2.jsp");
				return;
			}
			
			
		}catch (Exception e) {
			response.sendRedirect("MeyBank_SignUp/page/page2.jsp");
			return;
		}
		
		session.setAttribute("errorpage2", null);
		
		session.setAttribute("page2userid", userid);
		session.setAttribute("page2password", password);
		session.setAttribute("page2verifyWord", verifyWord);
		session.setAttribute("page2", "done");
		response.sendRedirect("MeyBank_SignUp/page/page3.jsp");
		return;
	}

}
