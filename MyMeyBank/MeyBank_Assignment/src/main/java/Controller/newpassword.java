package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import AppDBContext.api_Account;
import AppDBContext.api_Admin;
import Models.Account;

/**
 * Servlet implementation class newpassword
 */
public class newpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Account api_acc = new api_Account();
	public static api_Admin api_admin = new api_Admin();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newpassword() {
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
		String newpassword = request.getParameter("newpassword");
		
		try {
			boolean b = api_acc.Checking_By_password(newpassword,"Hoo123","$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC","admin");
			
			if(b == true) {
				session.setAttribute("newpassworderror", "Please enter another password.");
				response.sendRedirect("MeyBank_SignIn/page/newpassword.jsp");
				return;
			}
			
			String id_string = session.getAttribute("forgetAccountID").toString();
			int id = Integer.valueOf(id_string);
			Account acc = api_acc.getAccount(id,"Hoo123","$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC","admin");
			Account new_acc = new Account();
			String hashedPassword = BCrypt.hashpw(newpassword, BCrypt.gensalt());
			new_acc.setPassword(hashedPassword);
			new_acc.setAccountID(acc.getAccountID());
			new_acc.setUserID(acc.getUserID());
			new_acc.setUsername(acc.getUsername());
			new_acc.setAccountStatus(acc.getAccountStatus());
			new_acc.setLoginLimit(acc.getLoginLimit());
			new_acc.setVerifyWord(acc.getVerifyWord());
			new_acc.setBankType(acc.getBankType());
			new_acc.setLoginTime(acc.getLoginTime());
			
			api_admin.getKEY("Hoo123","$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
			api_acc.UpdateAccount(new_acc,"admin");
			response.sendRedirect("MeyBank_SignIn/page/signin.jsp");
			return;
			
		}catch(Exception e) {
			session.setAttribute("newpassworderror", "Error password.");
			response.sendRedirect("MeyBank_SignIn/page/newpassword.jsp");
			return;
		}
		
		
		
	}

}
