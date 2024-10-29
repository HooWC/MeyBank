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
import java.util.List;

import com.google.gson.Gson;

import AppDBContext.api_Account;
import AppDBContext.api_Admin;
import AppDBContext.api_BankAccount;
import AppDBContext.api_User;
import Models.Admin;
import Models.BankAccount;
import Models.User;

/**
 * Servlet implementation class AjaxFunction
 */
public class AjaxFunction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Account api_account = new api_Account();
	public static api_Admin api_admin = new api_Admin();
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_User api_user = new api_User();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxFunction() {
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
		
		String Action = request.getParameter("Action");
		if(Action.equals("getAllBankAccount_To_View")) {
			getAllBankAccount_To_View(request,response);
			return;
		}else if(Action.equals("getAllUser")) {
			getAllUser(request,response);
			return;
		}else if(Action.equals("SearchAllUser")) {
			SearchAllUser(request,response);
			return;
		}else if(Action.equals("update")) {
			HttpSession session = request.getSession();
			session.setAttribute("updateuseradmin", "");
			String Fullname = request.getParameter("Fullname");
			String email = request.getParameter("email");
			String nric = request.getParameter("nric");
			String age = request.getParameter("age");
			String gender = request.getParameter("gender");
			String birth = request.getParameter("birth");
			
			Admin admin = (Admin)session.getAttribute("Admin");
			User u = (User)session.getAttribute("upuser");
			Gson gson = new Gson();
			
			List<User> b_list = new ArrayList<>();
			try {
				api_admin.getKEY(admin.getUsername(), admin.getPassword());
				b_list = api_user.getAllUser();
				
				if(!u.getFullName().equals(Fullname)) {
					for(var i : b_list) {
						if(i.getFullName().equals(Fullname)) {
							session.setAttribute("updateuseradmin", "This fullname is already in use");
//							response.sendRedirect("Admin/page/user_select.jsp");
//							return;
							String json = gson.toJson(false);
							response.getWriter().write(json);
							return;
						}
					}
					u.setFullName(Fullname);
				}
				
				if(!u.getEmail().equals(email)) {
					for(var i : b_list) {
						if(i.getEmail().equals(email)) {
							session.setAttribute("updateuseradmin", "This email is already in use");
//							response.sendRedirect("Admin/page/user_select.jsp");
//							return;
							String json = gson.toJson(false);
							response.getWriter().write(json);
							return;
						}
					}
					u.setEmail(email);
				}
				
				if(!u.getNRIC().equals(nric)) {
					
					for(var i : b_list) {
						if(i.getNRIC().equals(nric)) {
							session.setAttribute("updateuseradmin", "This nric is already in use");
//							response.sendRedirect("Admin/page/user_select.jsp");
//							return;
							String json = gson.toJson(false);
							response.getWriter().write(json);
							return;
						}
					}
					
					int ageint = Integer.valueOf(age);
					if(age != null) {
						if(ageint < 18 && ageint > 60) {
							session.setAttribute("updateuseradmin", "Age must be 18 - 60");
//							response.sendRedirect("Admin/page/user_select.jsp");
//							return;
							String json = gson.toJson(false);
							response.getWriter().write(json);
							return;
						}else {
							u.setNRIC(nric);
							u.setEmail(email);
							u.setAge(ageint);
							u.setGender(gender);
							u.setBirthDate(birth);
						}
					}
					
				}
				
				
				
				api_admin.getKEY(admin.getUsername(), admin.getPassword());
				api_user.UpdateAccount(u);
				session.setAttribute("upuser", u);
				session.setAttribute("updateuseradmin", "");

				
			}catch(Exception e) {
				e.getMessage();
			}
			
			String json = gson.toJson(true);
			response.getWriter().write(json);
			return;
			
		}else if(Action.equals("blocked")) {
			Block(request,response);
			return;
		}
		
		return;
		
	}
	
	private void getAllBankAccount_To_View(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dataUsername = request.getParameter("AccountData");
		Gson gson = new Gson();
		List<BankAccount> b_list = new ArrayList<>();
		int id = Integer.valueOf(dataUsername);
		try {
			b_list = api_bank.getListBankAccount_By_AccountID(id);
		}catch(Exception e) {
			e.getMessage();
		}
		String json = gson.toJson(b_list);
		response.getWriter().write(json);
	}
	
	private void getAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Admin admin = (Admin)session.getAttribute("Admin");
		Gson gson = new Gson();
		List<User> b_list = new ArrayList<>();
		try {
			api_admin.getKEY(admin.getUsername(), admin.getPassword());
			b_list = api_user.getAllUser();
		}catch(Exception e) {
			e.getMessage();
		}
		String json = gson.toJson(b_list);
		response.getWriter().write(json);
	}
	
	private void SearchAllUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String dataUsername = request.getParameter("Value");
		Admin admin = (Admin)session.getAttribute("Admin");
		Gson gson = new Gson();
		List<User> b_list = new ArrayList<>();
		try {
			api_admin.getKEY(admin.getUsername(), admin.getPassword());
			b_list = api_user.getUser_list(dataUsername);
			if(b_list.size() == 0) {
				api_admin.getKEY(admin.getUsername(), admin.getPassword());
				b_list = api_user.getAllUser();
			}
			
		}catch(Exception e) {
			e.getMessage();
		}
		String json = gson.toJson(b_list);
		response.getWriter().write(json);
	}

	private void Block(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		Admin admin = (Admin)session.getAttribute("Admin");
		Gson gson = new Gson();
		List<User> b_list = new ArrayList<>();
		try {
			api_admin.getKEY(admin.getUsername(), admin.getPassword());
			b_list = api_user.getAllUser();
			User u = new User();
			int mid = Integer.valueOf(id);
			for(var i : b_list) {
				if(i.getUserID() == mid) {
					u = i;
					break;
				}
			}
			
			if(u.isActive() == true) {
				u.setActive(false);
			}else {
				u.setActive(true);
			}
			
			api_admin.getKEY(admin.getUsername(), admin.getPassword());
			api_user.UpdateAccount(u);
			
		}catch(Exception e) {
			e.getMessage();
		}
		String json = gson.toJson(b_list);
		response.getWriter().write(json);
		return;
	}


}
