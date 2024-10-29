package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import AppDBContext.api_Admin;
import AppDBContext.api_Contact;
import Models.Contact;

/**
 * Servlet implementation class contact
 */
public class contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Admin api_admin = new api_Admin();
	public static api_Contact api_con = new api_Contact();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contact() {
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
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String nric = request.getParameter("nric");
		String text = request.getParameter("text");
		
		Contact con = new Contact();
		con.setFullName(fullname);
		con.setEmail(email);
		con.setPhone(phone);
		con.setNRIC(nric);
		con.setContent(text);
		con.setHandle(false);
		
		try {
			api_admin.getKEY("Hoo123", "$2a$10$DlgC8wjFMWO0f1uYCyuKPeu3ADtNZNFmNJNBPglE1/NVCwWohERdC");
			api_con.CreateContact(con);
			response.sendRedirect("MeyBank_Home/page/contact.jsp");
			return;
		}catch(Exception e) {
			response.sendRedirect("MeyBank_Home/page/contact.jsp");
			return;
		}
		
		
	}

}
