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

import AppDBContext.api_Account;
import Models.Account;

/**
 * Servlet implementation class index
 */
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static api_Account api_acc = new api_Account();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
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
		Account acc = (Account)session.getAttribute("Account");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		session.setAttribute("lastlogintime", acc.getLoginTime());
		acc.setLoginTime(dtf.format(now).toString());
		
		try {
			api_acc.getKEY(acc.getUsername(), acc.getPassword());
			api_acc.UpdateAccount(acc,"account");
			response.sendRedirect("MeyBank_User/page/index.jsp");
			return;
		}catch(Exception e) {
			response.sendRedirect("MeyBank_User/page/index.jsp");
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
