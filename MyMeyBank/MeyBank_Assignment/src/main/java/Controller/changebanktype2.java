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
import AppDBContext.api_BankAccount;
import Models.Account;
import Models.BankAccount;

/**
 * Servlet implementation class changebanktype2
 */
public class changebanktype2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_BankAccount api_bankaccount = new api_BankAccount();
	public static api_Account api_account = new api_Account();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changebanktype2() {
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
		String type = request.getParameter("changebanktype");
		BankAccount bank = (BankAccount) session.getAttribute("changebanktype");
		Account acc = (Account)session.getAttribute("Account");
		
		if(!bank.getAccountType().equals(type)) {
			
			double balance = bank.getBalance() - 0.20;			
			if(type.equals("Saving Account")) {
				boolean b = CheckingSaving(acc,type,balance,bank,session,request,response);
				if(b == true) {
					session.setAttribute("changeerror", "Your amount is insufficient to proceed with the conversion.");
					response.sendRedirect("MeyBank_User/page/changebanktype3.jsp");
				}else {
					response.sendRedirect("MeyBank_User/page/changebanktype1.jsp");
					return;
				}
				
			}else if(type.equals("Current Account")) {
				boolean b = CheckingCurrent(acc,type,balance,bank,session,request,response);
				if(b == true) {
					session.setAttribute("changeerror", "Your amount is insufficient to proceed with the conversion.");
					response.sendRedirect("MeyBank_User/page/changebanktype3.jsp");
				}else {
					response.sendRedirect("MeyBank_User/page/changebanktype1.jsp");
					return;
				}
			}
		}else {
			session.setAttribute("changeerror", "");
			response.sendRedirect("MeyBank_User/page/changebanktype3.jsp");
			return;
		}
		
	}
	
	public static boolean CheckingSaving(Account acc,String type,double balance,BankAccount bank,HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean b = false;
		if(balance < 20) {
			b = true;
			return b;
		}else {
			b = false;
			bank.setAccountType(type);
			SaveData(bank,acc);
			return b;
		}
	}
	
	public static boolean CheckingCurrent(Account acc,String type,double balance,BankAccount bank,HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean b = false;
		if(balance < 250) {
			b = true;
			return b;
		}else {
			b = false;
			bank.setAccountType(type);
			SaveData(bank,acc);
			return b; 
		}
	}
	
	public static void SaveData(BankAccount bank,Account acc) {
		try {
			api_account.getKEY(acc.getUsername(), acc.getPassword());
			api_bankaccount.UpdateBankAccountID(bank);
			return;
		}catch(Exception e) {
			return;
		}
	}

}
