package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import AppDBContext.api_Account;
import AppDBContext.api_Admin;
import AppDBContext.api_BankAccount;
import AppDBContext.api_Contact;
import AppDBContext.api_Transaction;
import AppDBContext.api_User;
import Models.Admin;
import Models.Contact;
import Models.Transaction;

/**
 * Servlet implementation class getallhistory
 */
public class getallhistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Account api_account = new api_Account();
	public static api_Admin api_admin = new api_Admin();
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_User api_user = new api_User();
	public static api_Contact api_contact = new api_Contact();
	public static api_Transaction api_tr = new api_Transaction();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getallhistory() {
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
		Admin admin = (Admin)session.getAttribute("Admin");
		try {
			api_admin.getKEY(admin.getUsername(), admin.getPassword());
			List<Transaction> list = api_tr.getBankAccount_ByBankAccountID_All();
			
			Collections.sort(list, new Comparator<Transaction>() {
				  @Override
				  public int compare(Transaction u1, Transaction u2) {
				  return -(u1.getTransactionID() -u2.getTransactionID());
				 }});
			
			session.setAttribute("alltrlist", list);
			response.sendRedirect("Admin/page/history.jsp");
			return;
		}catch(Exception e) {
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
