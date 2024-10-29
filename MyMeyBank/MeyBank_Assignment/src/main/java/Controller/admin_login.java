package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import AppDBContext.api_Account;
import AppDBContext.api_Admin;
import AppDBContext.api_BankAccount;
import AppDBContext.api_Transaction;
import Models.Account;
import Models.Admin;
import Models.BankAccount;
import Models.Transaction;

/**
 * Servlet implementation class admin_login
 */
public class admin_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Admin api_admin = new api_Admin();
	public static api_Transaction api_tr = new api_Transaction();
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_Account api_acc = new api_Account();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_login() {
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
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");

		try {
			api_admin.getKEY("Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
			Admin admin = api_admin.getAdmin(userid, password);
			if(admin != null) {
				api_admin.getKEY("Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
				List<Admin> list = api_admin.getAdmin_list(admin.getAdminID());
				session.setAttribute("Admin", admin);
				session.setAttribute("Adminlist", list);
				session.setAttribute("adminlogin", "");
				
				new_Change();
				limit_Change();
				
				LocalDate localDate = LocalDate.now();
				Month month = localDate.getMonth();
				
				String[] str = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString().split("-");
				String day = str[2];
				
				Date date = new Date();
				
				session.setAttribute("month", month.toString());
				session.setAttribute("day", day.toString());
				session.setAttribute("mytime", date.toString());
				
				response.sendRedirect("Admin/page/admin_home.jsp");
				return;
			}else {
				session.setAttribute("adminlogin", "Login failed.");
				response.sendRedirect("Admin/page/Login.jsp");
				return;
			}
		}catch(Exception e) {
			session.setAttribute("adminlogin", "Login failed.");
			response.sendRedirect("Admin/page/Login.jsp");
			return;
		}
		
	}
	
	public static void new_Change() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();
			
			api_admin.getKEY("Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
			List<Transaction> tr = api_tr.getIBG();
			if(tr.size() != 0) {
				for(var i : tr) {
					String date = i.getDate().substring(0, 10);
					
					Date bt = sdf.parse(dtf.format(now).toString());
					Date et = sdf.parse(date);
					
					if(bt.before(et)) {}else{
						//加钱
						api_admin.getKEY("Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
						BankAccount bank = api_bank.getBankAccount_ByCardnum(i.getCredit());
						double balance = bank.getBalance() + i.getAmount();
						bank.setBalance(balance);
						api_admin.getKEY("Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
						api_bank.UpdateBankAccountID(bank);
						
						//IBG true
						i.setIsIBG(true);
						api_admin.getKEY("Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
						api_tr.UpdateTransaction(i);
					}
				}
			}
			return;
		}catch(Exception e) {
			return;
		}
	}

	public static void limit_Change() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDateTime now = LocalDateTime.now();
			
			api_admin.getKEY("Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
			List<Account> a = api_acc.getAllAccount();
			
			for(var i : a) {
				String date = i.getLoginTime().substring(0, 10);
				Date bt = sdf.parse(dtf.format(now).toString());
				Date et = sdf.parse(date);
				
				if(bt.before(et)) {}else{
					//变回limit
					//变回次数 false
					api_admin.getKEY("Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
					List<BankAccount> Allbank = api_bank.getListBankAccount_By_AccountID(i.getAccountID());
					for(var j : Allbank) {
						double limit = j.getAllLimit();
						j.setCardLimit(limit);
						j.setChange(false);
						api_admin.getKEY("Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
						api_bank.UpdateBankAccountID(j);
					}
				}
			}	
			return;
			
		}catch(Exception e) {
			return;
		}
	}

	
}
