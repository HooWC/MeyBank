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
import java.util.List;

import AppDBContext.api_Account;
import AppDBContext.api_BankAccount;
import AppDBContext.api_Transaction;
import AppDBContext.api_User;
import Models.Account;
import Models.BankAccount;
import Models.Transaction;
import Models.User;

/**
 * Servlet implementation class transaction1
 */
public class transaction1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_User api_user = new api_User();
	public static api_Transaction api_tr = new api_Transaction();
	public static api_Account api_acc = new api_Account();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transaction1() {
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
		String From_Account = request.getParameter("selec1");
		String Beneficiary_Account_No = request.getParameter("selec2");
		String Recipient_Reference = request.getParameter("selec3");
		String Other_Payment_Details = request.getParameter("selec4");
		String Amount = request.getParameter("selec5");
		String email = request.getParameter("opt1");
		String sms = request.getParameter("opt2");
		
		String str = From_Account.substring(0, 8);
		try {
			BankAccount bank = api_bank.getBankAccount_ByBankAccount(str);
			BankAccount Otherbank = api_bank.getBankAccount_ByCardnum(Beneficiary_Account_No);
			if(bank.getCardNumber().equals(Beneficiary_Account_No) || bank.getAccountID() == Otherbank.getAccountID()) {
				session.setAttribute("transaction1error", "You can't transfer money to yourself");
				response.sendRedirect("MeyBank_User/page/transaction1.jsp");
				return;
			}
		
			
			if(Otherbank == null) {
				session.setAttribute("transaction1error", "The other party's account number does not exist");
				response.sendRedirect("MeyBank_User/page/transaction1.jsp");
				return;
			}
			
			
			String pin = String.valueOf(Otherbank.getPinNumber());
			Account account = api_bank.getAccount_MB(Otherbank.getCardNumber(), pin, acc.getUsername(), acc.getPassword());
			if(account == null) {
				session.setAttribute("transaction1error", "Only transfer to MeyBank");
				response.sendRedirect("MeyBank_User/page/transaction1.jsp");
				return;
			}
			User user = api_user.getUser_By_ID(account.getUserID(),acc.getUsername(), acc.getPassword(),"account");
			
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
					session.setAttribute("transaction1error", "Your amount is not enough");
					response.sendRedirect("MeyBank_User/page/transaction1.jsp");
					return;
				}
			}else {
				if(balance < 250 || cardlimit <= 0) {
					session.setAttribute("transaction1error", "Your amount is not enough");
					response.sendRedirect("MeyBank_User/page/transaction1.jsp");
					return;
				}
			}
			
			Transaction tr = new Transaction();
			tr.setBankAccountID(bank.getBankAccountID());
			tr.setTransactionType("MB Other Account");
			tr.setDebit(str);
			tr.setCredit(Beneficiary_Account_No);
			tr.setDescription(Recipient_Reference);
			tr.setOtherDescription(Other_Payment_Details);
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
			session.setAttribute("transaction1error", "");
			response.sendRedirect("MeyBank_User/page/transaction2.jsp");
			return;
			
		}catch(Exception e) {
			session.setAttribute("transaction1error", "Transfer input error");
			response.sendRedirect("MeyBank_User/page/transaction1.jsp");
			return;
		}
		
		
	}
	
	public static void type(BankAccount bank,HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double balance = bank.getBalance() - 0.20;
		if(bank.getAccountType().equals("Saving Account")) {
			if(balance < 20) {
				session.setAttribute("transaction1error", "Your amount is not enough");
				response.sendRedirect("MeyBank_User/page/transaction1.jsp");
				return;
			}
		}else {
			if(balance < 250) {
				session.setAttribute("transaction1error", "Your amount is not enough");
				response.sendRedirect("MeyBank_User/page/transaction1.jsp");
				return;
			}
		}
		
	}

}
