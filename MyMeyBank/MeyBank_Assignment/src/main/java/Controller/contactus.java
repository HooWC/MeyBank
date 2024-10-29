package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import AppDBContext.*;
import Models.Account;
import Models.Contact;

/**
 * Servlet implementation class contactus
 */
public class contactus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Contact api_c = new api_Contact();
	public static api_Account api_acc = new api_Account();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactus() {
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
		String content = request.getParameter("content");
		
		try {
			Contact c = new Contact();
			c.setFullName(fullname);
			c.setEmail(email);
			c.setPhone(phone);
			c.setNRIC(nric);
			c.setContent(content);
			c.setHandle(false);
			
			Account acc = (Account)session.getAttribute("Account");
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			api_c.CreateContact(c);
			response.sendRedirect("MeyBank_User/page/contact_index.jsp");
			return;
			
		}catch(Exception e) {
			response.sendRedirect("MeyBank_User/page/contact_index.jsp");
			return;
		}
		
	}

}
