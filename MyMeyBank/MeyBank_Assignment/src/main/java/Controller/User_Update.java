package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import AppDBContext.api_Account;
import AppDBContext.api_BankAccount;
import AppDBContext.api_Transaction;
import AppDBContext.api_User;
import Models.Account;
import Models.User;

@MultipartConfig()
public class User_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_User api_user = new api_User();
	public static api_Transaction api_tr = new api_Transaction();
	public static api_Account api_acc = new api_Account();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_Update() {
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
		String fullname = request.getParameter("fullname");
		String gmail = request.getParameter("gmail");
		String password = request.getParameter("password");
		User u = (User)session.getAttribute("User");
		Account account = (Account) session.getAttribute("Account");
		
		try {
			String pass = account.getPassword();
			
//			if(password != "") {
//				password = null;
//			}
			
			if(password != "" && password.length() != 0) {
				
				if(password.length() != 6) {
					session.setAttribute("updateusererror", "Password must be 6 digits");
					response.sendRedirect("MeyBank_User/page/User_Update.jsp");
					return;
				}
				
				api_acc.getKEY(account.getUsername(), account.getPassword());
				boolean bp = api_acc.Checking_By_password2(password);
				
				if(bp == true) {
					session.setAttribute("updateusererror", "Please enter another password.");
					response.sendRedirect("MeyBank_User/page/User_Update.jsp");
					return;
				}else {
					
					String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
					
					account.setPassword(hashedPassword);
					api_acc.getKEY(account.getUsername(), pass);
					api_acc.UpdateAccount(account, "account");
					session.setAttribute("Account", account);
				}
			}
			
			
			if(!u.getEmail().equals(gmail)) {
				
				boolean b = api_user.Checking_By_Email(gmail, account.getUsername(), pass, "account");
				if(b == false) {
					
					Part photoPart = request.getPart("Photo");
					String fileName = photoPart.getSubmittedFileName();
					if(fileName != "") {
						String savePath = "C:\\Users\\Hoo\\Desktop\\MyMeyBank\\MeyBank_Assignment\\src\\main\\webapp\\image\\User\\"+u.getEmail()+fileName;
						File saveFile = new File(savePath);
						photoPart.write(savePath);
						
						u.setIMG(u.getEmail()+fileName);
						u.setFullName(fullname);
						u.setEmail(gmail);
						api_Account.getKEY(account.getUsername(), pass);
						api_user.UpdateAccount(u);
						session.setAttribute("User", u);
						session.setAttribute("updateusererror", "");
						response.sendRedirect("MeyBank_User/page/profile_index.jsp");
						return;
					}else {
						u.setFullName(fullname);
						u.setEmail(gmail);
						api_Account.getKEY(account.getUsername(), pass);
						api_user.UpdateAccount(u);
						session.setAttribute("User", u);
						session.setAttribute("updateusererror", "");
						response.sendRedirect("MeyBank_User/page/profile_index.jsp");
						return;
					}	
				}else {
					session.setAttribute("updateusererror", "Please enter another email.");
					response.sendRedirect("MeyBank_User/page/User_Update.jsp");
					return;
				}
			}else {
				Part photoPart = request.getPart("Photo");
				String fileName = photoPart.getSubmittedFileName();
				if(fileName != "") {
					String savePath = "C:\\Users\\Hoo\\Desktop\\MyMeyBank\\MeyBank_Assignment\\src\\main\\webapp\\image\\User\\"+u.getEmail()+fileName;
					File saveFile = new File(savePath);
					photoPart.write(savePath);
					
					u.setIMG(u.getEmail()+fileName);
					u.setFullName(fullname);
					api_Account.getKEY(account.getUsername(), pass);
					api_user.UpdateAccount(u);
					session.setAttribute("User", u);
					session.setAttribute("updateusererror", "");
					response.sendRedirect("MeyBank_User/page/profile_index.jsp");
					return;
				}else {
					u.setFullName(fullname);
					api_Account.getKEY(account.getUsername(), pass);
					api_user.UpdateAccount(u);
					session.setAttribute("User", u);
					session.setAttribute("updateusererror", "");
					response.sendRedirect("MeyBank_User/page/profile_index.jsp");
					return;
				}	
			}

		}catch(Exception e) {
			e.getMessage();
			session.setAttribute("updateusererror", "Update Error.");
			response.sendRedirect("MeyBank_User/page/User_Update.jsp");
			return;
		}
		
	}

}
