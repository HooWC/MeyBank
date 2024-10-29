package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import AppDBContext.api_Account;
import AppDBContext.api_BankAccount;
import AppDBContext.api_Transaction;
import AppDBContext.api_User;
import Models.Account;
import Models.BankAccount;
import Models.Transaction;

/**
 * Servlet implementation class gettimeofhistory
 */
public class gettimeofhistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_User api_user = new api_User();
	public static api_Account api_acc = new api_Account();
	public static api_Transaction api_tr = new api_Transaction();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gettimeofhistory() {
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
		String Action = request.getParameter("action");
		String sel1 = request.getParameter("sel1");
		String sel2 = request.getParameter("sel2");
		
		if(Action.equals("All")) {
			GetData1(sel1,sel2,session,request,response);
			response.sendRedirect("MeyBank_User/page/User_All_History.jsp");
			return;
		}else if(Action.equals("Own")) {
			GetData2(sel1,sel2,session,request,response);
			response.sendRedirect("MeyBank_User/page/User_All_History.jsp");
			return;
		}else if(Action.equals("Other")) {
			GetData3(sel1,sel2,session,request,response);
			response.sendRedirect("MeyBank_User/page/User_All_History.jsp");
			return;
		}else if(Action.equals("IBG")) {
			GetData4(sel1,sel2,session,request,response);
			response.sendRedirect("MeyBank_User/page/User_All_History.jsp");
			return;
		}else if(Action.equals("Payment")) {
			GetData5(sel1,sel2,session,request,response);
			response.sendRedirect("MeyBank_User/page/User_All_History.jsp");
			return;
		}
	}
	
	private static void GetData1(String sel1,String sel2,HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<BankAccount> b_list = new ArrayList<>();
		List<Transaction> tr_list = new ArrayList<>();
		Account acc = (Account)session.getAttribute("Account");
		try {
			if(sel1.equals("All")) {
				b_list = api_bank.getListBankAccount_By_AccountID(acc.getAccountID());
				
				for(var i : b_list) {
					tr_list.addAll(api_tr.getBankAccount_ByBankAccountID(i.getBankAccountID()));
				}
				
				Collections.sort(tr_list, new Comparator<Transaction>() {
					  @Override
					  public int compare(Transaction u1, Transaction u2) {
					  return -(u1.getTransactionID() -u2.getTransactionID());
					 }});
				
				session.setAttribute("AllHistory", tr_list);
				return;
			}else {
				b_list = api_bank.getListBankAccount_By_AccountID(acc.getAccountID());
				
				for(var i : b_list) {
					tr_list.addAll(api_tr.getBankAccount_ByBankAccountID_Select(sel1,sel2,i.getBankAccountID()));
				}
				
				Collections.sort(tr_list, new Comparator<Transaction>() {
					  @Override
					  public int compare(Transaction u1, Transaction u2) {
					  return -(u1.getTransactionID() -u2.getTransactionID());
					 }});
				
				session.setAttribute("AllHistory", tr_list);
				return;
			}
			
		}catch(Exception e) {
			e.getMessage();
			return;
		}
	}

	private static void GetData2(String sel1,String sel2,HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BankAccount> b_list = new ArrayList<>();
		List<Transaction> tr_list = new ArrayList<>();
		Account acc = (Account)session.getAttribute("Account");
		try {
			b_list = api_bank.getListBankAccount_By_AccountID(acc.getAccountID());
			if(sel1.equals("All")) {
				
				for(var i : b_list) {
					tr_list.addAll(api_tr.getBankAccount_ByBankAccountID_Own(i.getBankAccountID()));
				}
				
				Collections.sort(tr_list, new Comparator<Transaction>() {
					  @Override
					  public int compare(Transaction u1, Transaction u2) {
					  return -(u1.getTransactionID() -u2.getTransactionID());
					 }});
				
				session.setAttribute("AllHistory", tr_list);
				return;
			}else {
				
				for(var i : b_list) {
					tr_list.addAll(api_tr.getBankAccount_ByBankAccountID_Own_Select(sel1,sel2,i.getBankAccountID()));
				}
				
				Collections.sort(tr_list, new Comparator<Transaction>() {
					  @Override
					  public int compare(Transaction u1, Transaction u2) {
					  return -(u1.getTransactionID() -u2.getTransactionID());
					 }});
				
				session.setAttribute("AllHistory", tr_list);
				return;
			}
		}catch(Exception e) {
			e.getMessage();
			return;
		}
	}

	private static void GetData3(String sel1,String sel2,HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BankAccount> b_list = new ArrayList<>();
		List<Transaction> tr_list = new ArrayList<>();
		Account acc = (Account)session.getAttribute("Account");
		try {
			b_list = api_bank.getListBankAccount_By_AccountID(acc.getAccountID());
			
			if(sel1.equals("All")) {
				for(var i : b_list) {
					tr_list.addAll(api_tr.getBankAccount_ByBankAccountID_Other(i.getBankAccountID()));
				}
				
				Collections.sort(tr_list, new Comparator<Transaction>() {
					  @Override
					  public int compare(Transaction u1, Transaction u2) {
					  return -(u1.getTransactionID() -u2.getTransactionID());
					 }});
				
				session.setAttribute("AllHistory", tr_list);
				return;
			}else {
				for(var i : b_list) {
					tr_list.addAll(api_tr.getBankAccount_ByBankAccountID_Other_Select(sel1,sel2,i.getBankAccountID()));
				}
				
				Collections.sort(tr_list, new Comparator<Transaction>() {
					  @Override
					  public int compare(Transaction u1, Transaction u2) {
					  return -(u1.getTransactionID() -u2.getTransactionID());
					 }});
				
				session.setAttribute("AllHistory", tr_list);
				return;
			}
		}catch(Exception e) {
			e.getMessage();
			return;
		}
	}

	private static void GetData4(String sel1,String sel2,HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BankAccount> b_list = new ArrayList<>();
		List<Transaction> tr_list = new ArrayList<>();
		Account acc = (Account)session.getAttribute("Account");
		try {
			b_list = api_bank.getListBankAccount_By_AccountID(acc.getAccountID());
			
			if(sel1.equals("All")) {
				for(var i : b_list) {
					tr_list.addAll(api_tr.getBankAccount_ByBankAccountID_IBG(i.getBankAccountID()));
				}
				
				Collections.sort(tr_list, new Comparator<Transaction>() {
					  @Override
					  public int compare(Transaction u1, Transaction u2) {
					  return -(u1.getTransactionID() -u2.getTransactionID());
					 }});
				
				session.setAttribute("AllHistory", tr_list);
				return;
			}else {
				for(var i : b_list) {
					tr_list.addAll(api_tr.getBankAccount_ByBankAccountID_IBG_Select(sel1,sel2,i.getBankAccountID()));
				}
				
				Collections.sort(tr_list, new Comparator<Transaction>() {
					  @Override
					  public int compare(Transaction u1, Transaction u2) {
					  return -(u1.getTransactionID() -u2.getTransactionID());
					 }});
				
				session.setAttribute("AllHistory", tr_list);
				return;
			}
		}catch(Exception e) {
			e.getMessage();
			return;
		}
	}

	private static void GetData5(String sel1,String sel2,HttpSession session,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BankAccount> b_list = new ArrayList<>();
		List<Transaction> tr_list = new ArrayList<>();
		Account acc = (Account)session.getAttribute("Account");
		try {
			b_list = api_bank.getListBankAccount_By_AccountID(acc.getAccountID());
			
			if(sel1.equals("All")) {
				for(var i : b_list) {
					tr_list.addAll(api_tr.getBankAccount_ByBankAccountID_Payment(i.getBankAccountID()));
				}
				
				Collections.sort(tr_list, new Comparator<Transaction>() {
					  @Override
					  public int compare(Transaction u1, Transaction u2) {
					  return -(u1.getTransactionID() -u2.getTransactionID());
					 }});
				
				session.setAttribute("AllHistory", tr_list);
				return;
			}else {
				for(var i : b_list) {
					tr_list.addAll(api_tr.getBankAccount_ByBankAccountID_Payment_Select(sel1,sel2,i.getBankAccountID()));
				}
				
				Collections.sort(tr_list, new Comparator<Transaction>() {
					  @Override
					  public int compare(Transaction u1, Transaction u2) {
					  return -(u1.getTransactionID() -u2.getTransactionID());
					 }});
				
				session.setAttribute("AllHistory", tr_list);
				return;
			}
		}catch(Exception e) {
			e.getMessage();
			return;
		}
	}

	

}
