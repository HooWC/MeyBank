package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import AppDBContext.api_Account;
import AppDBContext.api_Admin;
import AppDBContext.api_User;
import Models.Admin;
import Models.User;

/**
 * Servlet implementation class getUserData
 */
public class getUserData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Admin api_admin = new api_Admin();
	public static api_User api_user = new api_User();
	public static api_Account api_acc = new api_Account();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getUserData() {
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
		String userid = request.getParameter("id");
		int mid = Integer.valueOf(userid);
		Admin admin = (Admin)session.getAttribute("Admin");
		
		try {
			api_admin.getKEY(admin.getUsername(), admin.getPassword());
			User u = api_user.getUser_By_ID2(mid);

			session.setAttribute("upuser", u);
			response.sendRedirect("Admin/page/user_select.jsp");
			return;
			
		}catch(Exception e) {
			response.sendRedirect("Admin/page/m_user_home.jsp");
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
