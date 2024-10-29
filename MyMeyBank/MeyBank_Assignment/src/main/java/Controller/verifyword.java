package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Models.Account;

/**
 * Servlet implementation class verifyword
 */
public class verifyword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verifyword() {
        super();
        // TODO Auto-generated constructor stub
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
		Account acc = (Account)session.getAttribute("Account");
		session.setAttribute("verifyset", "done");
		String ss = acc.getVerifyWord();
		String v = session.getAttribute("verifycode").toString();
		if(acc.getVerifyWord().equals(v)) {
			response.sendRedirect("MeyBank_SignIn/page/password.jsp");
			return;
		}else {
			session.setAttribute("loginerror", "Login failed.");
			response.sendRedirect("MeyBank_SignIn/page/signin.jsp");
			return;
		}
		
		
	}

}
