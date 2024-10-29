package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import AppDBContext.api_Account;
import AppDBContext.api_BankAccount;
import AppDBContext.api_Transaction;
import AppDBContext.api_User;
import Models.Account;
import Models.BankAccount;
import Models.Transaction;
import Models.User;

/**
 * Servlet implementation class Loan1
 */
public class Loan1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_User api_user = new api_User();
	public static api_Transaction api_tr = new api_Transaction();
	public static api_Account api_acc = new api_Account();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loan1() {
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
		Account acc = (Account)session.getAttribute("Account");
		String From_Account = request.getParameter("m1");
		String Beneficiary_Account_No = request.getParameter("m2");
		String Amount = request.getParameter("m3");
		String email = request.getParameter("opt1");
		String sms = request.getParameter("opt2");
		
		String str = From_Account.substring(0, 8);
		try {
			BankAccount bank = api_bank.getBankAccount_ByBankAccount(str);
			if(bank.getCardNumber().equals(Beneficiary_Account_No)) {
				session.setAttribute("paymenterror", "You can't transfer money to yourself");
				response.sendRedirect("MeyBank_User/page/transaction1.jsp");
				return;
			}

			
			double bal = Double.valueOf(Amount);
			double smsplace = 0;
			if(email != null || sms != null) {
				smsplace = 0.20;
			}
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
			LocalDateTime now = LocalDateTime.now();
						
			double balance = (bank.getBalance() - smsplace) - bal;
			double cardlimit = bank.getCardLimit() - bal;
			
			if(bank.getAccountType().equals("Saving Account")) {
				if(balance < 20 || cardlimit <= 0) {
					session.setAttribute("paymenterror", "Your amount is not enough");
					response.sendRedirect("MeyBank_User/page/Loan_Payment1.jsp");
					return;
				}
			}else {
				if(balance < 250 || cardlimit <= 0) {
					session.setAttribute("paymenterror", "Your amount is not enough");
					response.sendRedirect("MeyBank_User/page/Loan_Payment1.jsp");
					return;
				}
			}
			
			BankAccount Otherbank = null;
			Account account = null;
			User user = null;
			
			Transaction tr = new Transaction();
			tr.setBankAccountID(bank.getBankAccountID());
			tr.setTransactionType("Payment Transfer");
			tr.setDebit(str);
			tr.setCredit(Beneficiary_Account_No);
			tr.setDescription("null");
			tr.setOtherDescription("null");
			tr.setAmount(bal);
			tr.setIsIBG(true);
			tr.setSMSNotification(smsplace);
			tr.setPhoneNumber(sms == null?"null":sms);
			tr.setEmail(email == null?"null":email);
			tr.setTransactionStatus("false");
			tr.setDate(dtf.format(now).toString());
			
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			api_tr.CreateTransaction(tr);
					
			session.setAttribute("tr1", tr);
			session.setAttribute("tr1Bank", bank);
			session.setAttribute("OtherBankAccount", Otherbank);
			session.setAttribute("OtherAccount", account);
			session.setAttribute("OtherUser", user);
			session.setAttribute("paymenterror", "");
			response.sendRedirect("MeyBank_User/page/Loan_Payment2.jsp");
			return;
			
		}catch(Exception e) {
			session.setAttribute("paymenterror", "Transfer input error");
			response.sendRedirect("MeyBank_User/page/Loan_Payment1.jsp");
			return;
		}
		
	}

}
