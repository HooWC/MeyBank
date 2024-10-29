package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Random;

import AppDBContext.api_Account;
import AppDBContext.api_BankAccount;
import Models.Account;
import Models.BankAccount;

/**
 * Servlet implementation class newbankaccount
 */
public class newbankaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Account api_account = new api_Account();
    public static api_BankAccount api_bankaccount = new api_BankAccount();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newbankaccount() {
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
		String newbankaccount = request.getParameter("newbankaccount");
		String BankAccNo = NumberCode(8);
		String CardNumber = NumberCode(16);
		String PinNumber = NumberCode(3);
		
		Account acc = (Account)session.getAttribute("Account");
		int pin = Integer.valueOf(PinNumber);
		double balance = 0;
		double cardlimit = 0;
		if(newbankaccount.equals("Saving Account")) {
			balance = 20.00;
			cardlimit = 10000.00;
		}else {
			balance = 250.00;
			cardlimit = 20000.00;
		}
		
		BankAccount Bacc = new BankAccount();
		Bacc.setAccountID(acc.getAccountID());
		Bacc.setAccountType(newbankaccount);
		Bacc.setBankAccNo(BankAccNo);
		Bacc.setCardNumber(CardNumber);
		Bacc.setPinNumber(pin);
		Bacc.setBalance(balance);
		Bacc.setCardLimit(cardlimit);
		Bacc.setBankAcStatus(0);
		Bacc.setAllLimit(cardlimit);
		Bacc.setChange(false);
		
		try {
			api_account.getKEY(acc.getUsername(), acc.getPassword());
			api_bankaccount.CreateBankAccount(Bacc,"account");
		}catch(Exception e) {
			return;
		}
		
		response.sendRedirect("MeyBank_User/page/account.jsp");
		return;
		
	}
	
	public String NumberCode(int num) {
		Random r = new Random();
		char[] word = new char[num];
		for (int i = 0; i < num; i++)
		{
			int ran = r.nextInt(3);
			if (ran == 0)
				word[i] = (char)r.nextInt(49, 58);
			else
				word[i] = (char)r.nextInt(48, 58);

		}
		String str = new String(word);
		return str;
	}

}
