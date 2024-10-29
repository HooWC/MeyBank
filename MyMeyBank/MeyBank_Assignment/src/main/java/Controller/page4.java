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
import java.util.Random;

import org.mindrot.jbcrypt.BCrypt;

import AppDBContext.*;
import Models.*;

/**
 * Servlet implementation class page4
 */
public class page4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static api_User api_user = new api_User();
    public static api_Admin api_admin = new api_Admin();
    public static api_Account api_account = new api_Account();
    public static api_BankAccount api_bankaccount = new api_BankAccount();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public page4() {
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
		String fullname = (String)session.getAttribute("page1fullname");
		String gmail = (String)session.getAttribute("page1gmail");
		String nric = (String)session.getAttribute("page1nric");
		String agesession = (String)session.getAttribute("page1age");
		String birth = (String)session.getAttribute("page1birth");
		String gender = (String)session.getAttribute("page1gender");
		String userid = (String)session.getAttribute("page2userid");
		String password = (String)session.getAttribute("page2password");
		String verifyWord = (String)session.getAttribute("page2verifyWord");
		String cardName = (String)session.getAttribute("page3cardName");
		String BankAccNo = NumberCode(8);
		String CardNumber = NumberCode(16);
		String PinNumber = NumberCode(3);
		
		int age = Integer.valueOf(agesession);
		int pin = Integer.valueOf(PinNumber);
		
		User user = new User();
		user.setFullName(fullname);
		user.setIMG("defaultimg.jpeg");
		user.setNRIC(nric);
		user.setAge(age);
		user.setBirthDate(birth);
		user.setGender(gender);
		user.setEmail(gmail);
		user.setActive(true);
		
		try {
			api_admin.getKEY("Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
			api_user.CreateUser(user);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
			LocalDateTime now = LocalDateTime.now();
			
			String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
			User user_data = api_user.getUser_By_Email(gmail, "Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC", "admin");
			Account account = new Account();
			account.setUserID(user_data.getUserID());
			account.setUsername(userid);
			account.setPassword(hashedPassword);
			account.setAccountStatus("active");
			account.setLoginLimit(3);
			account.setVerifyWord(verifyWord);
			account.setBankType("MeyBank");
			account.setLoginTime(dtf.format(now).toString());
			
			api_admin.getKEY("Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
			api_account.CreateAccount(account);
			
			Account acc = api_account.getAccount_By_username_pass(userid, hashedPassword, "Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC", "admin");
			
			double balance = 0;
			double cardlimit = 0;
			if(cardName.equals("Saving Account")) {
				balance = 20.00;
				cardlimit = 10000.00;
			}else {
				balance = 250.00;
				cardlimit = 20000.00;
			}
			
			BankAccount Bacc = new BankAccount();
			Bacc.setAccountID(acc.getAccountID());
			Bacc.setAccountType(cardName);
			Bacc.setBankAccNo(BankAccNo);
			Bacc.setCardNumber(CardNumber);
			Bacc.setPinNumber(pin);
			Bacc.setBalance(balance);
			Bacc.setCardLimit(cardlimit);
			Bacc.setBankAcStatus(0);
			Bacc.setAllLimit(cardlimit);
			Bacc.setChange(false);
			
			api_admin.getKEY("Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
			api_bankaccount.CreateBankAccount(Bacc,"admin");
			
			response.sendRedirect("MeyBank_SignIn/page/signin.jsp");
			return;
			
			
		} catch (Exception e) {
			response.sendRedirect("MeyBank_SignUp/page/page1.jsp");
			return;
		}
		

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
