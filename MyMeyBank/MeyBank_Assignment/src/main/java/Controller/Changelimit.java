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
import Models.BankAccount;

/**
 * Servlet implementation class Changelimit
 */
public class Changelimit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_BankAccount api_bankaccount = new api_BankAccount();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Changelimit() {
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
		HttpSession session = request.getSession();
		session.setAttribute("changeerror", "");
		String id = request.getParameter("id");
		int bankid = Integer.valueOf(id);
		try {
			BankAccount bank = api_bankaccount.getBankAccount(bankid);
			if(bank.isChange() == true) {
				session.setAttribute("limitdone", "You can no longer modify the limit of this bankaccount today");
				response.sendRedirect("MeyBank_User/page/changelimit.jsp");
				return;
			}
			
			
			session.setAttribute("changelimitbank", bank);
			response.sendRedirect("MeyBank_User/page/changelimit2.jsp");
			return;
		}catch(Exception e) {
			e.getMessage();
			return;		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		BankAccount mybank = (BankAccount) session.getAttribute("changelimitbank");
		String limit = request.getParameter("selec1");
		
		try {
			double money = Double.valueOf(limit);
			mybank.setCardLimit(money);
			mybank.setAllLimit(money);
			mybank.setChange(true);
			api_bankaccount.UpdateBankAccountID(mybank);
			response.sendRedirect("MeyBank_User/page/changelimit.jsp");
			return;
		}catch(Exception e) {
			e.getMessage();
			return;
		}
		
		
	}

}
