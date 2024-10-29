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
 * Servlet implementation class transaction_own
 */
public class transaction_own extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_User api_user = new api_User();
	public static api_Transaction api_tr = new api_Transaction();
	public static api_Account api_acc = new api_Account();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public transaction_own() {
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
		String Amount = request.getParameter("selec5");
		
		String str = From_Account.substring(0, 8);
		try {
			BankAccount bank = api_bank.getBankAccount_ByBankAccount(str);
			BankAccount Otherbank = api_bank.getBankAccount_ByCardnum(Beneficiary_Account_No);
			if(bank.getAccountID() != Otherbank.getAccountID()) {
				session.setAttribute("transactionownerror", "you can only transfer money to yourself");
				response.sendRedirect("MeyBank_User/page/transaction_own1.jsp");
				return;
			}else if(bank.getCardNumber().equals(Beneficiary_Account_No)) {
				session.setAttribute("transactionownerror", "You cannot transfer money to the same bank account");
				response.sendRedirect("MeyBank_User/page/transaction_own1.jsp");
				return;
			}	
			
			if(Otherbank == null) {
				session.setAttribute("transactionownerror", "The bank account number does not exist");
				response.sendRedirect("MeyBank_User/page/transaction_own1.jsp");
				return;
			}
			
			double bal = Double.valueOf(Amount);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
			LocalDateTime now = LocalDateTime.now();
					
			double balance = bank.getBalance() - bal;
			double Otherbalance = Otherbank.getBalance() + bal;
			if(bank.getAccountType().equals("Saving Account")) {
				if(balance < 20) {
					session.setAttribute("transactionownerror", "Your amount is not enough");
					response.sendRedirect("MeyBank_User/page/transaction_own1.jsp");
					return;
				}
			}else {
				if(balance < 250) {
					session.setAttribute("transactionownerror", "Your amount is not enough");
					response.sendRedirect("MeyBank_User/page/transaction_own1.jsp");
					return;
				}
			}
			
		
			bank.setBalance(balance);
			Otherbank.setBalance(Otherbalance);
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			api_bank.UpdateBankAccountID(bank);
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			api_bank.UpdateBankAccountID(Otherbank);
			
			Transaction tr = new Transaction();
			tr.setBankAccountID(bank.getBankAccountID());
			tr.setTransactionType("Transfer Own Account");
			tr.setDebit(str);
			tr.setCredit(Beneficiary_Account_No);
			tr.setDescription("null");
			tr.setOtherDescription("null");
			tr.setAmount(bal);
			tr.setIsIBG(true);
			tr.setSMSNotification(0);
			tr.setPhoneNumber("null");
			tr.setEmail("null");
			tr.setTransactionStatus("true");
			tr.setDate(dtf.format(now).toString());
			
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			api_tr.CreateTransaction(tr);
					
			session.setAttribute("tr1own", tr);
			session.setAttribute("tr1Bankown", bank);
			session.setAttribute("OtherBankAccountown", Otherbank);
			session.setAttribute("transactionownerror", "");
			response.sendRedirect("MeyBank_User/page/transaction_own2.jsp");
			return;
			
		}catch(Exception e) {
			session.setAttribute("transaction1error", "Transfer input error");
			response.sendRedirect("MeyBank_User/page/transaction1.jsp");
			return;
		}
	}

}
