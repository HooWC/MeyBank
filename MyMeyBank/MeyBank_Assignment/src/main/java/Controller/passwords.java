package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import AppDBContext.api_Account;
import AppDBContext.api_User;
import Models.*;

/**
 * Servlet implementation class passwords
 */
public class passwords extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Account api_acc = new api_Account();
	public static api_User api_user = new api_User();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public passwords() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
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
		
		String userid = (String)session.getAttribute("id");
		String password = request.getParameter("pass");
		
		try {
			boolean b = api_acc.Checking_Account_Login(userid,password,"Hoo123","$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC","admin");
			
			if(b == true) {
				session.setAttribute("passworderror", "");
				Account acc = api_acc.Get_Account_Login(userid,password,"Hoo123","$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC","admin");
				session.setAttribute("Account", acc);
				User user = api_user.getUser_By_ID(acc.getUserID(),"Hoo123","$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC","admin");
				session.setAttribute("User", user);
				session.setAttribute("passworderror", "");
				response.sendRedirect("index");
				return;
			}else {
				session.setAttribute("passworderror", "Login failed.");
				response.sendRedirect("MeyBank_SignIn/page/password.jsp");
				return;
			}
		}catch(Exception e) {
			session.setAttribute("passworderror", "Login failed.");
			response.sendRedirect("MeyBank_SignIn/page/password.jsp");
			return;
		}
	}

}
