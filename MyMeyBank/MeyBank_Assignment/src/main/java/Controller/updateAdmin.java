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
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import AppDBContext.api_Account;
import AppDBContext.api_Admin;
import AppDBContext.api_BankAccount;
import AppDBContext.api_User;
import Models.Account;
import Models.Admin;


@MultipartConfig()
public class updateAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Account api_account = new api_Account();
	public static api_Admin api_admin = new api_Admin();
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_User api_user = new api_User();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateAdmin() {
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
		String password = request.getParameter("password");
		Admin admin = (Admin)session.getAttribute("Admin");
		
		try {
			
			String pass = admin.getPassword();
			if(password.length() != 6) {
				session.setAttribute("updateadmin", "Password must be 6 digits.");
				response.sendRedirect("Admin/page/update_admin.jsp");
				return;
			}
			
			boolean b = api_admin.getAdmin__Checkpassword(password);
			if(b == true) {
				session.setAttribute("updateadmin", "Please use another password.");
				response.sendRedirect("Admin/page/update_admin.jsp");
				return;
			}
			
			String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
			Part photoPart = request.getPart("Photo");
			String fileName = photoPart.getSubmittedFileName();
			if(fileName != "") {
				String savePath = "C:\\Users\\Hoo\\Desktop\\MyMeyBank\\MeyBank_Assignment\\src\\main\\webapp\\image\\Admin\\"+fileName;
				File saveFile = new File(savePath);
				photoPart.write(savePath);
				
				admin.setIMG(fileName);
				admin.setPassword(hashedPassword);
				api_admin.getKEY(admin.getUsername(), pass);
				api_admin.UpdateAccount(admin);
				session.setAttribute("Admin", admin);
				
			}else {
				admin.setPassword(hashedPassword);
				api_admin.getKEY(admin.getUsername(), pass);
				api_admin.UpdateAccount(admin);
				session.setAttribute("Admin", admin);
			}
			
			session.setAttribute("updateadmin", "");
			response.sendRedirect("Admin/page/admin_home.jsp");
			return;
			
			
		
		}catch(Exception e) {
			return;
		}
	}

}
