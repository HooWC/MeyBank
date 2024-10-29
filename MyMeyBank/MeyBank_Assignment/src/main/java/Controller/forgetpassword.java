package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import AppDBContext.api_BankAccount;
import Models.Account;

/**
 * Servlet implementation class forgetpassword
 */
public class forgetpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_BankAccount api_bankacc = new api_BankAccount();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgetpassword() {
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
		String forgetcard = request.getParameter("card");
		String forgetpin = request.getParameter("pin");
		
		try {
			boolean b = api_bankacc.Forget_CheckBankAccount(forgetcard, forgetpin, "Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
			if(b == true) {
				Account acc = api_bankacc.getAccount(forgetcard, forgetpin, "Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
				session.setAttribute("forgetAccountID", acc.getAccountID());
				response.sendRedirect("verify");
				return;
			}else {
				session.setAttribute("errorforgetpassword", "Please enter the correct card number and pin.");
				response.sendRedirect("MeyBank_SignIn/page/forgetpassword.jsp");
				return;
			}
		}catch(Exception e) {
			session.setAttribute("errorforgetpassword", "Please enter the correct card number and pin.");
			response.sendRedirect("MeyBank_SignIn/page/forgetpassword.jsp");
			return;
		}
		
		
		
	}

}
