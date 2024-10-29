package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import AppDBContext.*;
import Models.Account;
import Models.Admin;
import Models.Contact;

/**
 * Servlet implementation class EditContent
 */
public class EditContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Account api_account = new api_Account();
	public static api_Admin api_admin = new api_Admin();
	public static api_BankAccount api_bank = new api_BankAccount();
	public static api_User api_user = new api_User();
	public static api_Contact api_c = new api_Contact();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditContent() {
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
		String id = request.getParameter("id");
		Admin admin = (Admin)session.getAttribute("Admin");
		try {
			int mid = Integer.valueOf(id);
			Contact c = api_c.getContact_Byid(mid);
			c.setHandle(true);
			api_admin.getKEY(admin.getUsername(), admin.getPassword());
			api_c.UpdateContact(c);
			
			api_admin.getKEY(admin.getUsername(), admin.getPassword());
			List<Contact> list = api_c.getContact_Admin();
			Collections.sort(list, new Comparator<Contact>() {
				  @Override
				  public int compare(Contact u1, Contact u2) {
				  return -(u1.getContactID() -u2.getContactID());
				 }});
			session.setAttribute("allcontact", list);
			
			
			response.sendRedirect("Admin/page/manafeContact.jsp");
			return;
		}catch(Exception e) {
			return;
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