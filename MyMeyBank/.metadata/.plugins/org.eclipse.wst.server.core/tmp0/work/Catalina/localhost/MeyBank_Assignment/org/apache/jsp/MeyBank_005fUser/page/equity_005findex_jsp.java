/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.27
 * Generated at: 2023-02-28 03:44:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.MeyBank_005fUser.page;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import Models.*;
import Models.*;

public final class equity_005findex_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/MeyBank_User/page/../../Layout/User_Index.jsp", Long.valueOf(1677477346171L));
    _jspx_dependants.put("/MeyBank_User/page/../../Layout/Checking_Login.jsp", Long.valueOf(1677049913234L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_packages.add("Models");
    _jspx_imports_classes = null;
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"../assets/bootstrap.min.css\" />\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css\" integrity=\"sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n");
      out.write("<!--     <link rel=\"stylesheet\" href=\"../MeyBank_User/css/account_index.css\"> -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css\" integrity=\"sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n");
      out.write("    <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>\r\n");
      out.write("    \r\n");
      out.write("  </head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <!-- Hero section -->\r\n");
      out.write("	<section id=\"infinite2\" class=\"text-white tm-font-big tm-parallax\">\r\n");
      out.write("    <!-- Navigation -->\r\n");
      out.write("    <nav class=\"navbar navbar-expand-md tm-navbar2\" id=\"tmNav\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"tm-next\">\r\n");
      out.write("          <a href=\"index.jsp\" class=\"navbar-brand\"><img src=\"../../image/meybank-logo.png\" width=\"30px\">Meybank</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\r\n");
      out.write("          aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("          <i class=\"fas fa-bars navbar-toggler-icon\"></i>\r\n");
      out.write("        </button>\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("          <div class=\"navbar-nav ml-auto\">\r\n");
      out.write("            <a href=\"../../Logout\" class=\"logout-key\"><i class=\"fa-solid fa-unlock-keyhole\"></i>Logout</a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("  <section id=\"infinite2\" class=\"text-white\">\r\n");
      out.write("    <!-- Navigation -->\r\n");
      out.write("    <nav class=\"navbar tm-navbar2 navbar-select\">\r\n");
      out.write("      <div class=\"container-list\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"div-item\" id=\"box-0\">\r\n");
      out.write("        	<a href=\"index.jsp\" style=\"padding:10px 10px 0px 10px;\r\n");
      out.write("  					display:flex;\r\n");
      out.write("  					flex-direction: column;\r\n");
      out.write("  					transition: all .3s linear;\r\n");
      out.write("  					cursor: pointer;\r\n");
      out.write("  					color:white;\r\n");
      out.write("  					font-size:0.7rem\">\r\n");
      out.write("        		<i class=\"fa-solid fa-house\"></i>\r\n");
      out.write("            	<p>HOME</p>\r\n");
      out.write("        	</a> \r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"div-item\" id=\"box-1\" style=\"\r\n");
      out.write("        	display:flex;\r\n");
      out.write("    		flex-direction: column;\r\n");
      out.write("    		width: 170px;\r\n");
      out.write("    		transition: all .3s linear;\r\n");
      out.write("    		cursor: pointer;\r\n");
      out.write("    		border-right:1px solid #ced4da;\">\r\n");
      out.write("        <a href=\"account_index.jsp\" style=\"padding:10px 10px 0px 10px;\r\n");
      out.write("  					display:flex;\r\n");
      out.write("  					flex-direction: column;\r\n");
      out.write("  					transition: all .3s linear;\r\n");
      out.write("  					cursor: pointer;\r\n");
      out.write("  					color:white;\">\r\n");
      out.write("            <i class=\"fa-sharp fa-solid fa-file\"></i>\r\n");
      out.write("            <p>ACCOUNT</p>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"div-item\" id=\"box-2\" style=\"display:flex;\r\n");
      out.write("    		flex-direction: column;\r\n");
      out.write("    		width: 170px;\r\n");
      out.write("    		transition: all .3s linear;\r\n");
      out.write("    		cursor: pointer;\r\n");
      out.write("    		border-right:1px solid #ced4da;\">\r\n");
      out.write("        <a href=\"transaction_index.jsp\" style=\"padding:10px 10px 0px 10px;\r\n");
      out.write("  					display:flex;\r\n");
      out.write("  					flex-direction: column;\r\n");
      out.write("  					transition: all .3s linear;\r\n");
      out.write("  					cursor: pointer;\r\n");
      out.write("  					color:white;\">\r\n");
      out.write("            <i class=\"fa-solid fa-arrow-right-arrow-left\"></i>\r\n");
      out.write("            <p>FUND TRANSFER</p>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"div-item\" id=\"box-3\" style=\"display:flex;\r\n");
      out.write("    		flex-direction: column;\r\n");
      out.write("    		width: 170px;\r\n");
      out.write("    		transition: all .3s linear;\r\n");
      out.write("    		cursor: pointer;\r\n");
      out.write("    		border-right:1px solid #ced4da;\">\r\n");
      out.write("        <a href=\"payment_index.jsp\" style=\"padding:10px 10px 0px 10px;\r\n");
      out.write("  					display:flex;\r\n");
      out.write("  					flex-direction: column;\r\n");
      out.write("  					transition: all .3s linear;\r\n");
      out.write("  					cursor: pointer;\r\n");
      out.write("  					color:white;\">\r\n");
      out.write("            <i class=\"fa-solid fa-dollar-sign\"></i>\r\n");
      out.write("            <p>PAYMENT</p>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"div-item\" id=\"box-4\" style=\"display:flex;\r\n");
      out.write("    		flex-direction: column;\r\n");
      out.write("    		width: 170px;\r\n");
      out.write("    		transition: all .3s linear;\r\n");
      out.write("    		cursor: pointer;\r\n");
      out.write("    		border-right:1px solid #ced4da;\"> \r\n");
      out.write("        <a href=\"investment_index.jsp\" style=\"padding:10px 10px 0px 10px;\r\n");
      out.write("  					display:flex;\r\n");
      out.write("  					flex-direction: column;\r\n");
      out.write("  					transition: all .3s linear;\r\n");
      out.write("  					cursor: pointer;\r\n");
      out.write("  					color:white;\">\r\n");
      out.write("            <i class=\"fa-sharp fa-solid fa-arrow-trend-up\"></i>\r\n");
      out.write("            <p>INVESTMENT</p>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"div-item\" id=\"box-5\" style=\"display:flex;\r\n");
      out.write("    		flex-direction: column;\r\n");
      out.write("    		transition: all .3s linear;\r\n");
      out.write("    		cursor: pointer;\r\n");
      out.write("    		border-right:1px solid #ced4da;\">\r\n");
      out.write("        <a href=\"profile_index.jsp\" style=\"padding:10px 0px 0px 0px;\r\n");
      out.write("  					display:flex;\r\n");
      out.write("  					flex-direction: column;\r\n");
      out.write("  					transition: all .3s linear;\r\n");
      out.write("  					cursor: pointer;\r\n");
      out.write("  					color:white;\">\r\n");
      out.write("            <i class=\"fa-regular fa-user\"></i>\r\n");
      out.write("            <p>PROFILE MAINTENANCE</p>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"div-item\" id=\"box-6\" style=\"display:flex;\r\n");
      out.write("    		flex-direction: column;\r\n");
      out.write("    		width: 170px;\r\n");
      out.write("    		transition: all .3s linear;\r\n");
      out.write("    		cursor: pointer;\r\n");
      out.write("    		border-right:1px solid #ced4da;\">\r\n");
      out.write("        <a href=\"equity_index.jsp\" style=\"padding:10px 10px 0px 10px;\r\n");
      out.write("  					display:flex;\r\n");
      out.write("  					flex-direction: column;\r\n");
      out.write("  					transition: all .3s linear;\r\n");
      out.write("  					cursor: pointer;\r\n");
      out.write("  					color:white;\">\r\n");
      out.write("            <i class=\"fa-sharp fa-solid fa-layer-group\"></i>\r\n");
      out.write("            <p>EQUITY RESEARCH</p>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"div-item\" id=\"box-7\" style=\"display:flex;\r\n");
      out.write("    		flex-direction: column;\r\n");
      out.write("    		width: 170px;\r\n");
      out.write("    		transition: all .3s linear;\r\n");
      out.write("    		cursor: pointer;\r\n");
      out.write("    		border-right:1px solid #ced4da;\">\r\n");
      out.write("        <a href=\"mailbox_index.jsp\" style=\"padding:10px 10px 0px 10px;\r\n");
      out.write("  					display:flex;\r\n");
      out.write("  					flex-direction: column;\r\n");
      out.write("  					transition: all .3s linear;\r\n");
      out.write("  					cursor: pointer;\r\n");
      out.write("  					color:white;\">\r\n");
      out.write("            <i class=\"fa-solid fa-envelope\"></i>\r\n");
      out.write("            <p>MAILBOX</p>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"div-item\" id=\"box-8\" style=\"display:flex;\r\n");
      out.write("    		flex-direction: column;\r\n");
      out.write("    		width: 170px;\r\n");
      out.write("    		transition: all .3s linear;\r\n");
      out.write("    		cursor: pointer;\r\n");
      out.write("    		border-right:1px solid #ced4da;\">\r\n");
      out.write("        <a href=\"contact_index.jsp\" style=\"padding:10px 10px 0px 10px;\r\n");
      out.write("  					display:flex;\r\n");
      out.write("  					flex-direction: column;\r\n");
      out.write("  					transition: all .3s linear;\r\n");
      out.write("  					cursor: pointer;\r\n");
      out.write("  					color:white;\">\r\n");
      out.write("            <i class=\"fa-solid fa-phone\"></i>\r\n");
      out.write("            <p>CONTACT US</p>\r\n");
      out.write("            </a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("    \r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");

		Account acc = (Account)session.getAttribute("Account");
 		User user = (User)session.getAttribute("User");
 		String time = (String)session.getAttribute("lastlogintime");
		if(acc == null || acc == null || time == null){
			response.sendRedirect("../../MeyBank_Home/page/home.jsp");
			return;
		}

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>Document</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../../assets/bootstrap.min.css\" />\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css\"\r\n");
      out.write("	integrity=\"sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==\"\r\n");
      out.write("	crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"../css/accountindex.css\" />\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css\"\r\n");
      out.write("	integrity=\"sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==\"\r\n");
      out.write("	crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n");
      out.write("<link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css'\r\n");
      out.write("	rel='stylesheet'>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<section class=\"context-nei\">\r\n");
      out.write("\r\n");
      out.write("		<div class=\"select-option\">\r\n");
      out.write("\r\n");
      out.write("			<div class=\"select-menu\">\r\n");
      out.write("				<div class=\"select-btn\">\r\n");
      out.write("					<span class=\"sBtn-text\">Equity Research</span> <i\r\n");
      out.write("						class=\"bx bx-chevron-down\"></i>\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("				<ul class=\"options\">\r\n");
      out.write("					<li><a class=\"option option-text\" href=\"equity_view.jsp\"\r\n");
      out.write("						id=\"contact\">View stock progress</a></li>\r\n");
      out.write("				</ul>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("		<div class=\"input-box\">\r\n");
      out.write("			<i class=\"fa-sharp fa-solid fa-layer-group\"></i>\r\n");
      out.write("			<h1>Equity Research</h1>\r\n");
      out.write("			<p>Contact us to solve the problem</p>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("	</section>\r\n");
      out.write("\r\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.6.3.min.js\"></script>\r\n");
      out.write("	<script src=\"../script/main.js\"></script>\r\n");
      out.write("	<script>\r\n");
      out.write("  	$(function(){\r\n");
      out.write("  		$(\"#box-6\").css(\"background\",\"red\");\r\n");
      out.write("  	})\r\n");
      out.write("  </script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
