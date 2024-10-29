package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import AppDBContext.api_Account;
import AppDBContext.api_BankAccount;
import AppDBContext.api_User;
import Models.Account;
import Models.BankAccount;
import Models.User;

/**
 * Servlet implementation class signin
 */
public class signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Account api_acc = new api_Account();
	public static api_User api_user = new api_User();
	public static api_BankAccount api_bank = new api_BankAccount();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signin() {
        super();
        // TODO Auto-generated constructor stub
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
		String userid = request.getParameter("id");
		session.setAttribute("passworderror", "");
		try {
			boolean b = api_acc.Checking_By_username(userid,"Hoo123","$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC","admin");
			if(b == true) {
				session.setAttribute("loginerror", "");
				Account acc = api_acc.Get_Account_username(userid,"Hoo123","$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC","admin");
				
				if(acc == null) {
					session.setAttribute("loginerror", "Login failed.");
					response.sendRedirect("MeyBank_SignIn/page/signin.jsp");
					return;
				}
				
				User us = api_user.getUser_By_ID(acc.getUserID(),"Hoo123","$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC","admin");
				
				if(us.isActive() == false) {
					session.setAttribute("loginerror", "This Account have blocked!");
					response.sendRedirect("MeyBank_SignIn/page/signin.jsp");
					return;
				}
				
				session.setAttribute("verifycode", acc.getVerifyWord());
				session.setAttribute("Account", acc);
				session.setAttribute("id", userid);
				api_acc.getKEY(acc.getUsername(), acc.getPassword());
				List<BankAccount> b_list = api_bank.getListBankAccount_By_AccountID(acc.getAccountID());
				session.setAttribute("banklist", b_list);
				
				String[] banktype_list = {"Public Bank","BNP Paribas Malaysia","CIMB BANK BERHAD","RHB BANK","HONG LEONG BANK"};
				session.setAttribute("banktype_list", banktype_list);
				response.sendRedirect("MeyBank_SignIn/page/verifyword.jsp");
				return;
			}else {
				session.setAttribute("loginerror", "Login failed.");
				response.sendRedirect("MeyBank_SignIn/page/signin.jsp");
				return;
			}
		}catch(Exception e) {
			session.setAttribute("loginerror", "Login failed.");
			response.sendRedirect("MeyBank_SignIn/page/signin.jsp");
			return;
		}
		
	}

}
