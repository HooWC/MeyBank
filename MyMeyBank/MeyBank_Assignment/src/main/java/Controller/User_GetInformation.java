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
import java.util.ArrayList;
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
 * Servlet implementation class User_GetInformation
 */
public class User_GetInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_User api_user = new api_User();
	public static api_Transaction api_tr = new api_Transaction();
	public static api_Account api_acc = new api_Account();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_GetInformation() {
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
		List<BankAccount> b_list = new ArrayList<>();
		List<Transaction> tr_list = new ArrayList<>();
		List<User> user_list = new ArrayList<>();
		List<Integer> user_list_id = new ArrayList<>();
		Account acc = (Account)session.getAttribute("Account");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();
		try {
			b_list = api_bank.getListBankAccount_By_AccountID(acc.getAccountID());
			
			double amount = 0;
			double sen = 0;
			for(var i : b_list) {
				tr_list.addAll(api_tr.getBankAccount_ByList(i.getBankAccNo(),dtf.format(now).toString(),acc.getUsername(),acc.getPassword()));
			}
			
		
			boolean b = false;
			for(var i : tr_list) {
				BankAccount Otherbank = api_bank.getBankAccount_ByCardnum(i.getCredit());
				String pin = String.valueOf(Otherbank.getPinNumber());
				Account account = api_bank.getAccount(Otherbank.getCardNumber(), pin, acc.getUsername(), acc.getPassword());
				User us = api_user.getUser_By_ID(account.getUserID(),acc.getUsername(), acc.getPassword(),"account");
				
				if(!user_list_id.contains(us.getUserID())) {
					user_list_id.add(us.getUserID());
					user_list.add(us);
				}
				
				amount += i.getAmount();
				sen += i.getSMSNotification();
			}
			
			double count = user_list.size();
			session.setAttribute("amountUser", String.format("%.2f", amount).toString());
			session.setAttribute("senUser", String.format("%.2f", sen).toString());
			session.setAttribute("countUser", String.format("%.0f", count).toString());
			
			double amounts = (amount / 200);
			double sens = (amount / 20);
			double counts = (count / 0.20);
			
			
			session.setAttribute("amountUsers",String.format("%.1f", amounts).toString() );
			session.setAttribute("senUsers", String.format("%.1f", sens).toString());
			session.setAttribute("countUsers", String.format("%.1f", counts).toString());
			session.setAttribute("TodayUser", user_list);
			
			response.sendRedirect("MeyBank_User/page/User_Home.jsp");
			return;
		}catch(Exception e) {
			e.getMessage();
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
