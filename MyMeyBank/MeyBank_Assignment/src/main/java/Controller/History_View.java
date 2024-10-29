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
import AppDBContext.api_Transaction;
import AppDBContext.api_User;
import Models.*;

/**
 * Servlet implementation class History_View
 */
public class History_View extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_User api_user = new api_User();
	public static api_Account api_acc = new api_Account();
	public static api_Transaction api_tr = new api_Transaction();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public History_View() {
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
		Account acc = (Account)session.getAttribute("Account");
		String trid = request.getParameter("trid");
		int id = Integer.valueOf(trid);
		
		try {
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			Transaction tr = api_tr.gettr_Byid(id);
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			BankAccount OtherBank = api_bank.getBankAccount_ByCardnum(tr.getCredit());
			Account OtherAcc = null;
			User u = null;
			BankAccount Bank = null;
			if(OtherBank != null) {
				Bank = api_bank.getBankAccount_Bydebit(tr.getDebit());
				OtherAcc = api_acc.getAccount_Byid(OtherBank.getAccountID());
				int uid = Integer.valueOf(OtherAcc.getUserID());
				u = api_user.getUser_By_ID2(uid);
			}
			
			
			session.setAttribute("tr1", tr);
			session.setAttribute("tr1Bank", Bank);
			session.setAttribute("OtherBankAccount", OtherBank);
			session.setAttribute("OtherAccount", OtherAcc);
			session.setAttribute("OtherUser", u);
			
			response.sendRedirect("MeyBank_User/page/view.jsp");
			return;
			
			
			
		}catch(Exception e) {
			response.sendRedirect("MeyBank_User/page/index.jsp");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				doGet(request, response);
	}

}
