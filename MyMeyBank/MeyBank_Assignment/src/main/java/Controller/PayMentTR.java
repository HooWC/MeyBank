package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import AppDBContext.api_Account;
import AppDBContext.api_BankAccount;
import AppDBContext.api_Transaction;
import AppDBContext.api_User;
import Models.*;

/**
 * Servlet implementation class PayMentTR
 */
public class PayMentTR extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_User api_user = new api_User();
	public static api_Account api_acc = new api_Account();
	public static api_Transaction api_tr = new api_Transaction();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayMentTR() {
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
		String Action = request.getParameter("Action");
		if(Action.equals("MBTR")) {
			boolean b = SaveData1(request,response);
			if(b == true) {
				response.sendRedirect("MeyBank_User/page/view.jsp");
				return;
			}else {
				response.sendRedirect("MeyBank_User/page/transaction_index.jsp");
				return;
			}
			
		}else if(Action.equals("IBG")) {
			boolean b = SaveData2(request,response);
			if(b == true) {
				response.sendRedirect("MeyBank_User/page/view.jsp");
				return;
			}else {
				response.sendRedirect("MeyBank_User/page/transaction_index.jsp");
				return;
			}
			
		}else if(Action.equals("Payment")) {
			boolean b = SaveData3(request,response);
			if(b == true) {
				response.sendRedirect("MeyBank_User/page/view.jsp");
				return;
			}else {
				response.sendRedirect("MeyBank_User/page/payment_index.jsp");
				return;
			}
			
		}
		
		
	}
	
	private boolean SaveData1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute("Account");
		Account Otheracc = (Account)session.getAttribute("OtherAccount");
		BankAccount Otherbank = (BankAccount)session.getAttribute("OtherBankAccount");
		User Otheruser = (User)session.getAttribute("OtherUser");
		Transaction tr = (Transaction)session.getAttribute("tr1");
		User user = (User)session.getAttribute("User");

		boolean b = false;
		
		try {
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			BankAccount bank = api_bank.getBankAccount_ByBankAccount(tr.getDebit());
			double balance = (bank.getBalance() - tr.getSMSNotification()) - tr.getAmount();
			double cardlimit = bank.getCardLimit() - tr.getAmount();
			bank.setBalance(balance);
			bank.setCardLimit(cardlimit);
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			api_bank.UpdateBankAccountID(bank);
			
			double otherbalance = Otherbank.getBalance() + tr.getAmount();
			Otherbank.setBalance(otherbalance);
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			api_bank.UpdateBankAccountID(Otherbank);

			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			Transaction new_tr = api_tr.getBankAccount_ByCardnum(tr.getDate(), tr.getDescription(), tr.getCredit());
			
			new_tr.setTransactionStatus("true");
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			api_tr.UpdateTransaction(new_tr);
			session.setAttribute("tr1", new_tr);
			b = true;
			
			email(new_tr,Otheruser);
			email2(new_tr,user);
			
			
		}catch(Exception e) {
			b = false;
		}
		return b;
		
		
	}
	
	private boolean SaveData2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute("Account");
		Account Otheracc = (Account)session.getAttribute("OtherAccount");
		BankAccount Otherbank = (BankAccount)session.getAttribute("OtherBankAccount");
		User Otheruser = (User)session.getAttribute("OtherUser");
		Transaction tr = (Transaction)session.getAttribute("tr1");
		User user = (User)session.getAttribute("User");

		boolean b = false;
		
		try {
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			BankAccount bank = api_bank.getBankAccount_ByBankAccount(tr.getDebit());
			double balance = (bank.getBalance() - tr.getSMSNotification()) - tr.getAmount();
			double cardlimit = bank.getCardLimit() - tr.getAmount();
			bank.setCardLimit(cardlimit);
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			api_bank.UpdateBankAccountID(bank);
			
			//IBG 加钱 admin  IsIBG == true

			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			Transaction new_tr = api_tr.getBankAccount_ByCardnum(tr.getDate(), tr.getDescription(), tr.getCredit());
			
			new_tr.setTransactionStatus("true");
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			api_tr.UpdateTransaction(new_tr);
			session.setAttribute("trIBG", new_tr);
			b = true;
			
			email(new_tr,Otheruser);
			
		}catch(Exception e) {
			b = false;
		}
		return b;
		
		
	}
	
	private boolean SaveData3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account acc = (Account)session.getAttribute("Account");
		Account Otheracc = (Account)session.getAttribute("OtherAccount");
		BankAccount Otherbank = (BankAccount)session.getAttribute("OtherBankAccount");
		User Otheruser = (User)session.getAttribute("OtherUser");
		Transaction tr = (Transaction)session.getAttribute("tr1");

		boolean b = false;
		
		try {
			
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			BankAccount bank = api_bank.getBankAccount_ByBankAccount(tr.getDebit());
			double balance = (bank.getBalance() - tr.getSMSNotification()) - tr.getAmount();
			double cardlimit = bank.getCardLimit() - tr.getAmount();
			bank.setBalance(balance);
			bank.setCardLimit(cardlimit);
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			api_bank.UpdateBankAccountID(bank);

			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			Transaction new_tr = api_tr.getBankAccount_ByCardnum(tr.getDate(), tr.getDescription(), tr.getCredit());
			
			new_tr.setTransactionStatus("true");
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			api_tr.UpdateTransaction(new_tr);
			session.setAttribute("tr1", new_tr);
			b = true;
			
			
		}catch(Exception e) {
			b = false;
		}
		return b;
		
		
	}
	
	
	public static void email(Transaction tr,User user) {
		
		final String username = "wengchin1234567@gmail.com";
		final String password = "drwzhcsmtskejbeq";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable","true");
		
		Session session = Session.getDefaultInstance(props,
				new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		
		try {
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress("wengchin1234567@gmail.com"));//from
			
			message.setRecipients(
					Message.RecipientType.TO, 
					InternetAddress.parse("wengchin123456@gmail.com")
			);//to email
			
			message.setSubject("MeyBank Forget Password OTP");
			String sb = "<p>"+"Transfer : Success"+"</p>"+"<br/>"+
						"<p>"+"Beneficialy User : "+user.getFullName()+"</p>"+"<br/>"+
						"<p>"+"Beneficialy Email : "+user.getEmail()+"</p>"+"<br/>"+
						"<p>"+"Amount : RM"+String.format("%.2f", tr.getAmount()).toString()+"</p>"+"<br/>";
			
            message.setContent(sb, "text/html; charset=utf-8");
            message.saveChanges();
			
			Transport.send(message);
		
		}catch(MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void email2(Transaction tr,User user) {
		
		final String username = "wengchin1234567@gmail.com";
		final String password = "drwzhcsmtskejbeq";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable","true");
		
		Session session = Session.getDefaultInstance(props,
				new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		
		try {
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress("wengchin1234567@gmail.com"));//from
			
			message.setRecipients(
					Message.RecipientType.TO, 
					InternetAddress.parse(user.getEmail())
			);//to email
			
			message.setSubject("MeyBank Forget Password OTP");
			String sb = "<p>"+"Transfer : Success"+"</p>"+"<br/>"+
						"<p>"+"Transfer Person : "+user.getFullName()+"</p>"+"<br/>"+
						"<p>"+"Transfer Email : "+user.getEmail()+"</p>"+"<br/>"+
						"<p>"+"Amount : RM"+String.format("%.2f", tr.getAmount()).toString()+"</p>"+"<br/>";
			
            message.setContent(sb, "text/html; charset=utf-8");
            message.saveChanges();
			
			Transport.send(message);
		
		}catch(MessagingException e) {
			e.printStackTrace();
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
