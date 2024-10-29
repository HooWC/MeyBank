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
 * Servlet implementation class ChangeBankTypestep1
 */
public class ChangeBankTypestep1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_BankAccount api_bankaccount = new api_BankAccount();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeBankTypestep1() {
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
		
		HttpSession session = request.getSession();
		session.setAttribute("changeerror", "");
		String id = request.getParameter("id");
		int bankid = Integer.valueOf(id);
		try {
			BankAccount bank = api_bankaccount.getBankAccount(bankid);
			session.setAttribute("changebanktype", bank);
			response.sendRedirect("MeyBank_User/page/changebanktype2.jsp");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
