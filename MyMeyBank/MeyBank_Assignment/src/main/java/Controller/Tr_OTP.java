package Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Servlet implementation class Tr_OTP
 */
public class Tr_OTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tr_OTP() {
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
		String Action = request.getParameter("Action");
		String num = NumberCode(4);
		email_OTP(num);
		
		if(Action.equals("MBTR")) {
			session.setAttribute("MBTROTHER", "true");
			session.setAttribute("MBTROTHEROTP", num);
			response.sendRedirect("MeyBank_User/page/transaction2.jsp");
			return;
		}else if(Action.equals("IBG")) {
			session.setAttribute("MBTROTHER", "true");
			session.setAttribute("MBTROTHEROTP", num);
			response.sendRedirect("MeyBank_User/page/transaction_IBG2.jsp");
			return;
		}else if(Action.equals("limit")) {
			session.setAttribute("MBTROTHER", "true");
			session.setAttribute("MBTROTHEROTP", num);
			response.sendRedirect("MeyBank_User/page/changelimit2.jsp");
			return;
		}else if(Action.equals("Payment")) {
			session.setAttribute("MBTROTHER", "true");
			session.setAttribute("MBTROTHEROTP", num);
			response.sendRedirect("MeyBank_User/page/Loan_Payment2.jsp");
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
	

	public String NumberCode(int num) {
		Random r = new Random();
		char[] word = new char[num];
		for (int i = 0; i < num; i++)
		{
			int ran = r.nextInt(3);
			if (ran == 0)
				word[i] = (char)r.nextInt(49, 58);
			else
				word[i] = (char)r.nextInt(48, 58);

		}
		String str = new String(word);
		return str;
	}
	
	public static void email_OTP(String otp) {
		
		final String username = "wengchin1234567@gmail.com";
		final String password = "drwzhcsmtskejbeq";
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable","true");
		
		Session session = Session.getDefaultInstance(props,
				new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username,password);
			}
		});
		
		
		try {
			MimeMessage message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress("wengchin1234567@gmail.com"));//from
			
			message.setRecipients(
					Message.RecipientType.TO, 
					InternetAddress.parse("wengchin123456@gmail.com")
			);//to email
			
			message.setSubject("MeyBank Transfer OTP");
			message.setText("OTP : "+otp);
			
			Transport.send(message);
		
		}catch(MessagingException e) {
			e.printStackTrace();
		}
		
	}
	

}
