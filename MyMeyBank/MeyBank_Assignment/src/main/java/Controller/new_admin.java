package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import AppDBContext.api_Admin;
import Models.Admin;

/**
 * Servlet implementation class new_admin
 */
public class new_admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Admin api_admin = new api_Admin();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public new_admin() {
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
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Admin admin = (Admin)session.getAttribute("Admin");
		
		try {
			api_admin.getKEY(admin.getUsername(), admin.getPassword());
			boolean b1 = api_admin.getAdmin_CheckFullname(fullname);
			if(b1 == true) {
				session.setAttribute("newadminerror", "Fullname cannot be repeated");
				response.sendRedirect("Admin/page/New_Admin.jsp");
				return;
			}
			boolean b2 = api_admin.getAdmin__Checkid(id);
			if(b2 == true) {
				session.setAttribute("newadminerror", "ID cannot be repeated");
				response.sendRedirect("Admin/page/New_Admin.jsp");
				return;
			}
			boolean b3 = api_admin.getAdmin__Checkpassword(password);
			if(b3 == true) {
				session.setAttribute("newadminerror", "Password cannot be repeated");
				response.sendRedirect("Admin/page/New_Admin.jsp");
				return;
			}
			
			String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
			Admin new_admin = new Admin();
			new_admin.setFullName(fullname);
			new_admin.setIMG("adminimg1.png");
			new_admin.setUsername(id);
			new_admin.setPassword(hashedPassword);
			
			api_admin.getKEY(admin.getUsername(), admin.getPassword());
			api_admin.CreateAdmin(new_admin);
			
			session.setAttribute("newadminerror", "");
			response.sendRedirect("Admin/page/admin_home.jsp");
			return;
		}catch(Exception e) {
			session.setAttribute("newadminerror", "Error Input");
			response.sendRedirect("Admin/page/New_Admin.jsp");
			return;
		}
	}

}
