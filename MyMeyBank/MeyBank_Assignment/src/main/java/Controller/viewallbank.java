package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import AppDBContext.api_Account;
import AppDBContext.api_Admin;
import AppDBContext.api_BankAccount;
import AppDBContext.api_User;
import Models.Account;
import Models.Admin;
import Models.BankAccount;

/**
 * Servlet implementation class viewallbank
 */
public class viewallbank extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Account api_account = new api_Account();
	public static api_Admin api_admin = new api_Admin();
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_User api_user = new api_User();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewallbank() {
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
		String id = request.getParameter("id");
		Admin admin = (Admin)session.getAttribute("Admin");
		try {
			api_admin.getKEY(admin.getUsername(), admin.getPassword());
			int mid = Integer.valueOf(id);
			List<BankAccount> list = api_bank.getListBankAccount_By_AccountID(mid);
			session.setAttribute("allbankacc", list);
			response.sendRedirect("Admin/page/ViewallBankAccount.jsp");
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
