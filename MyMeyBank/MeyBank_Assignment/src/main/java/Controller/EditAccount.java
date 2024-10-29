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
 * Servlet implementation class EditAccount
 */
public class EditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Account api_account = new api_Account();
	public static api_Admin api_admin = new api_Admin();
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_User api_user = new api_User();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAccount() {
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
			int mid = Integer.valueOf(id);
			api_admin.getKEY(admin.getUsername(), admin.getPassword());
			Account ad = api_account.getAccount_Byid(mid);
			session.setAttribute("editaccountadmin", ad);
			response.sendRedirect("Admin/page/EditAccount.jsp");
			return;
		}catch(Exception e) {
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String Username = request.getParameter("Username");
		String VerifyWord = request.getParameter("VerifyWord");
		Admin admin = (Admin)session.getAttribute("Admin");
		Account account = (Account)session.getAttribute("editaccountadmin");
		try {
			
			
			if(!account.getUsername().equals(Username)) {
				api_admin.getKEY(admin.getUsername(), admin.getPassword());
				boolean b = api_account.Checking_By_username2(Username);
				if(b == true) {
					session.setAttribute("editaccountwrong", "Please use another Username");
					response.sendRedirect("Admin/page/EditAccount.jsp");
					return;
				}else {
					account.setUsername(Username);
				}
			}
			if(!account.getVerifyWord().equals(VerifyWord)) {
				api_admin.getKEY(admin.getUsername(), admin.getPassword());
				boolean b = api_account.Checking_V(VerifyWord);
				
				if(b == true || VerifyWord.length() != 16) {
					session.setAttribute("editaccountwrong", "Please use another VerifyWord");
					response.sendRedirect("Admin/page/EditAccount.jsp");
					return;
				}else {
					account.setVerifyWord(VerifyWord);
				}
			}
			
			api_admin.getKEY(admin.getUsername(), admin.getPassword());
			api_account.UpdateAccount(account, "admin");
			
			api_admin.getKEY(admin.getUsername(), admin.getPassword());
			List<Account> list = api_account.getAllAccount_MB();
			session.setAttribute("allaccount", list);
			
			session.setAttribute("editaccountwrong", "");
			response.sendRedirect("Admin/page/manageaccount.jsp");
			return;
		}catch(Exception e) {
			return;
		}
	}

}
