/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.0.27
 * Generated at: 2023-02-21 00:56:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.MeyBank_005fHome.page;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;

public final class whatwedo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\" />\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\r\n");
      out.write("  <title>Infinix | PRAROZ</title>\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"../../assets/bootstrap.min.css\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"../css/style.css\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css\" integrity=\"sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("  <!-- Hero section -->\r\n");
      out.write("  <section id=\"infinite2\" class=\"text-white tm-font-big tm-parallax\">\r\n");
      out.write("    <!-- Navigation -->\r\n");
      out.write("    <nav class=\"navbar navbar-expand-md tm-navbar2\" id=\"tmNav\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("        <div class=\"tm-next\">\r\n");
      out.write("          <a href=\"home.jsp\" class=\"navbar-brand\"><img src=\"../../image/meybank-logo.png\" width=\"30px\">Meybank</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\r\n");
      out.write("          aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("          <i class=\"fas fa-bars navbar-toggler-icon\"></i>\r\n");
      out.write("        </button>\r\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("          <ul class=\"navbar-nav ml-auto\">\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("              <a class=\"nav-link tm-nav-link\" href=\"home.jsp\">Home</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\" style=\"background-color: rgb(153, 51, 80);border-radius: 5px;color: #FFF;\">\r\n");
      out.write("              <a class=\"nav-link tm-nav-link\" href=\"whatwedo.jsp\">What We Do</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("              <a class=\"nav-link tm-nav-link\" href=\"policy.jsp\">Policy</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("              <a class=\"nav-link tm-nav-link\" href=\"faqs.jsp\">FAQ's</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("              <a class=\"nav-link tm-nav-link\" href=\"contact.jsp\">Contact</a>\r\n");
      out.write("            </li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </nav>\r\n");
      out.write("  </section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("  <!-- What we do -->\r\n");
      out.write("  <section id=\"whatwedo\" class=\"tm-section-pad-top\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"row tm-content-box\">\r\n");
      out.write("        <!-- first row -->\r\n");
      out.write("        <div class=\"col-lg-12 col-xl-12\">\r\n");
      out.write("          <div class=\"tm-intro-text-container\">\r\n");
      out.write("            <h2 class=\"tm-text-primary mb-4 tm-section-title\">What We Do</h2>\r\n");
      out.write("            <p class=\"mb-4 tm-intro-text\">\r\n");
      out.write("                Meybank Online Banking (S) MOB, a licensed Labuan bank, was incorporated under the Labuan Companies Act 1990 on 13 October 1990. It is a wholly owned subsidiary of Meybank Online Banking and was officially declared open by our former Prime Minister, Y.A. Bhg. Tun Dr Mahathir Mohamad on 14 October 1990. It is a pioneer Labuan bank and commenced operations on 15 October 1990.\r\n");
      out.write("              <a href=\"#\">PRAROZ FACEBOOK PAGE</a>.\r\n");
      out.write("            </p>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!--first row-->\r\n");
      out.write("      <div class=\"row tm-content-box\">\r\n");
      out.write("        <!-- second row -->\r\n");
      out.write("        <div class=\"col-lg-1\">\r\n");
      out.write("          <i class=\"far fa-3x fa-chart-bar text-center tm-icon\"></i>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-lg-5\">\r\n");
      out.write("          <div class=\"tm-intro-text-container\">\r\n");
      out.write("            <h2 class=\"tm-text-primary mb-4\">Humanising Financial Services</h2>\r\n");
      out.write("            <p class=\"mb-4 tm-intro-text\">\r\n");
      out.write("                Humanising Financial Services has always been in our DNA. It is our mission to embed it in everything we do, from the initiatives to uplift communities close to our hearts to the continuous innovation of financial solutions that are simple, intuitive, and centered around the human experience, within the region and beyond. Above all, we understand our responsibility in ensuring that no one gets left behind.\r\n");
      out.write("            </p>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-lg-1\">\r\n");
      out.write("          <i class=\"far fa-3x fa-comment-alt text-center tm-icon\"></i>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-lg-5\">\r\n");
      out.write("          <div class=\"tm-intro-text-container\">\r\n");
      out.write("            <h2 class=\"tm-text-primary mb-4\">We Make Time For Good.</h2>\r\n");
      out.write("            <p class=\"mb-4 tm-intro-text\">\r\n");
      out.write("                People are the driving force behind everything we do, and it is our constant endeavor to equip and empower our communities for the betterment of all. This means creating positive and sustainable growth in the communities we care about, within Southeast Asia and beyond.\r\n");
      out.write("            </p>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-lg-1\">\r\n");
      out.write("          <i class=\"fas fa-3x fa-fingerprint text-center tm-icon\"></i>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-lg-5\">\r\n");
      out.write("          <div class=\"tm-intro-text-container\">\r\n");
      out.write("            <h2 class=\"tm-text-primary mb-4\">Top Security</h2>\r\n");
      out.write("            <p class=\"mb-4 tm-intro-text\">\r\n");
      out.write("                As part of our ongoing effort to strengthen your online banking security, starting 20 October 2022, the Secure2u feature on the MAE app will be enhanced with a 12-hour activation period to prevent unauthorised transaction approvals.\r\n");
      out.write("            </p>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"col-lg-1\">\r\n");
      out.write("          <i class=\"fas fa-3x fa-users text-center tm-icon\"></i>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-lg-5\">\r\n");
      out.write("          <div class=\"tm-intro-text-container\">\r\n");
      out.write("            <h2 class=\"tm-text-primary mb-4\">Social Work</h2>\r\n");
      out.write("            <p class=\"mb-4 tm-intro-text\">\r\n");
      out.write("                Advantages of MayBank Online Banking. Pay a bill: Electronic bill payment service allows a depositor to send money from his or her online account to a creditor or merchant, for example to a public utility or a department store. There is no need to stand in a long line on a weekend morning to handle your transactions.\r\n");
      out.write("            </p>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- third row -->\r\n");
      out.write("    </div>\r\n");
      out.write("  </section>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <section class=\"services\" id=\"services\">\r\n");
      out.write("\r\n");
      out.write("    <h1 class=\"heading\">\r\n");
      out.write("        <span>S</span>\r\n");
      out.write("        <span>E</span>\r\n");
      out.write("        <span>R</span>\r\n");
      out.write("        <span>V</span>\r\n");
      out.write("        <span>I</span>\r\n");
      out.write("        <span>C</span>\r\n");
      out.write("        <span>E</span>\r\n");
      out.write("        <span>S</span>\r\n");
      out.write("    </h1>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"box-container\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"box\">\r\n");
      out.write("            <i class=\"fas fa-hotel\"></i>\r\n");
      out.write("            <h3>full service</h3>\r\n");
      out.write("            <p>Public Bank currently offers a comprehensive range of financial products and services which include personal banking, commercial banking, Islamic banking, investment banking, share broking, trustee services, nominee services, sale and management of unit trust funds, bancassurance and general insurance products.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"box\">\r\n");
      out.write("            <i class=\"fas fa-utensils\"></i>\r\n");
      out.write("            <h3>InterBank GIRO (IBG)</h3>\r\n");
      out.write("            <p>Transfer funds to IBG participating banks free of charge via PBe. </p>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"box\">\r\n");
      out.write("            <i class=\"fas fa-hotel\"></i>\r\n");
      out.write("            <h3>DuitNow Transfer (Transfer to Account Number)</h3>\r\n");
      out.write("            <p>Transfer funds instanty to other bank’s account.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"box\">\r\n");
      out.write("            <i class=\"fas fa-hotel\"></i>\r\n");
      out.write("            <h3>DuitNow Transfer (Transfer to Proxy)</h3>\r\n");
      out.write("            <p>Transfer funds directly to any DuitNow ID (Mobile Number, NRIC, Passport Number, Business Registration Number, Army/Police ID).</p>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"box\">\r\n");
      out.write("            <i class=\"fas fa-hotel\"></i>\r\n");
      out.write("            <h3>Foreign Remittance</h3>\r\n");
      out.write("            <p>​Remit funds internationally via Foreign Telegraphic Transfer</p>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"box\">\r\n");
      out.write("            <i class=\"fas fa-hotel\"></i>\r\n");
      out.write("            <h3>PB Visa Direct</h3>\r\n");
      out.write("            <p>Send money directly to any eligible Visa card</p>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write(" <!-- Benefits-->\r\n");
      out.write(" <section class=\"py-5 my-lg-2 my-xl-2 my-xxl-5 color-change\" id=\"branding\">\r\n");
      out.write("    <h1 class=\"heading\">\r\n");
      out.write("        <span>O</span>\r\n");
      out.write("        <span>U</span>\r\n");
      out.write("        <span>R</span>\r\n");
      out.write("        <span class=\"space\"></span>\r\n");
      out.write("        <span>B</span>\r\n");
      out.write("        <span>E</span>\r\n");
      out.write("        <span>N</span>\r\n");
      out.write("        <span>E</span>\r\n");
      out.write("        <span>F</span>\r\n");
      out.write("        <span>I</span>\r\n");
      out.write("        <span>T</span>\r\n");
      out.write("        <span>S</span>\r\n");
      out.write("    </h1>\r\n");
      out.write("    <div class=\"row row-cols-1 row-cols-sm-2 row-cols-lg-4 gy-4 gy-sm-5 gx-4 pb-3 pb-md-4 pb-lg-5 mb-md-3 mb-lg-0\">\r\n");
      out.write("        <!-- Item-->\r\n");
      out.write("        <div class=\"col text-center benefits-box\">\r\n");
      out.write("            <div class=\"ratio ratio-1x1 position-relative mx-auto \" style=\"width: 68px;\"><i\r\n");
      out.write("                    class=\"ai-search-settings text-primary fs-1 d-flex align-items-center justify-content-center position-absolute start-0\"></i>\r\n");
      out.write("                <i class=\"bi bashes bi-gear-wide-connected\"></i>\r\n");
      out.write("            </div>\r\n");
      out.write("            <h3 class=\"h4 pb-2 mb-1\">Online support</h3>\r\n");
      out.write("            <p class=\"fs-sm mb-0\">Pharetra morbi quis is massa maecenas vulputate elit non nullage a duis tortor mi\r\n");
      out.write("                massa pharetra.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Item-->\r\n");
      out.write("        <div class=\"col text-center benefits-box\">\r\n");
      out.write("            <div class=\"ratio ratio-1x1 position-relative mx-auto \" style=\"width: 68px;\"><i\r\n");
      out.write("                    class=\"ai-bulb-alt text-primary fs-1 d-flex align-items-center justify-content-center position-absolute start-0\"></i>\r\n");
      out.write("                <i class=\"bi bashes bi-lightbulb\"></i>\r\n");
      out.write("            </div>\r\n");
      out.write("            <h3 class=\"h4 pb-2 mb-1\">100% guarantee</h3>\r\n");
      out.write("            <p class=\"fs-sm mb-0\">Sapien ultrices egestas at faucibus eu diam velit diam id amet nibh quam rutrum\r\n");
      out.write("                diam diam natoque scelerisque.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Item-->\r\n");
      out.write("        <div class=\"col text-center benefits-box\">\r\n");
      out.write("            <div class=\"ratio ratio-1x1 position-relative mx-auto \" style=\"width: 68px;\"><i\r\n");
      out.write("                    class=\"ai-circle-check-filled text-primary fs-2 d-flex align-items-center justify-content-center position-absolute start-0\"></i>\r\n");
      out.write("                <i class=\"bi bashes bi-check-circle\"></i>\r\n");
      out.write("            </div>\r\n");
      out.write("            <h3 class=\"h4 pb-2 mb-1\">Work on time</h3>\r\n");
      out.write("            <p class=\"fs-sm mb-0\">Morbi et massa fames ac scelerisque sit commodo dignissim faucibus vel quisque\r\n");
      out.write("                proin lectus orbi et massa fames.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- Item-->\r\n");
      out.write("        <div class=\"col text-center benefits-box\">\r\n");
      out.write("            <div class=\"ratio ratio-1x1 position-relative mx-auto \" style=\"width: 68px;\"><i\r\n");
      out.write("                    class=\"ai-rocket text-primary fs-2 d-flex align-items-center justify-content-center position-absolute start-0\"></i>\r\n");
      out.write("                <i class=\"bi bashes bi-arrow-repeat\"></i>\r\n");
      out.write("            </div>\r\n");
      out.write("            <h3 class=\"h4 pb-2 mb-1\">Free consultation</h3>\r\n");
      out.write("            <p class=\"fs-sm mb-0\">Consectetur adipiscing elit proin volutpat mollis egestas nam luctus facilisis\r\n");
      out.write("                ultrices pellentesque volutpat ligula est.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("<section class=\"section\" id=\"schedule\">\r\n");
      out.write("  <div class=\"Contain-time\">\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("          <div class=\"col-lg-6 offset-lg-3\">\r\n");
      out.write("              <div class=\"section-heading dark-bg\">\r\n");
      out.write("                  <h2>Meybank work <em>Schedule</em></h2>\r\n");
      out.write("                  <img src=\"assets/images/line-dec.png\" alt=\"\">\r\n");
      out.write("                  <p>6-Day Banking , For your convenience, these branches are open six days a week (including on public holidays).</p>\r\n");
      out.write("              </div>\r\n");
      out.write("          </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"row\">\r\n");
      out.write("          <div class=\"col-lg-12\">\r\n");
      out.write("              <div class=\"filters\">\r\n");
      out.write("                  <ul class=\"schedule-filter\">\r\n");
      out.write("                      <li class=\"active\" data-tsfilter=\"monday\">Monday</li>\r\n");
      out.write("                      <li data-tsfilter=\"tuesday\">Tuesday</li>\r\n");
      out.write("                      <li data-tsfilter=\"wednesday\">Wednesday</li>\r\n");
      out.write("                      <li data-tsfilter=\"thursday\">Thursday</li>\r\n");
      out.write("                      <li data-tsfilter=\"friday\">Friday</li>\r\n");
      out.write("                      <li data-tsfilter=\"saturday\">Saturday</li>\r\n");
      out.write("                  </ul>\r\n");
      out.write("              </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-lg-10 offset-lg-1\">\r\n");
      out.write("              <div class=\"schedule-table filtering\">\r\n");
      out.write("                  <table>\r\n");
      out.write("                      <tbody>\r\n");
      out.write("                          <tr class=\"tr-item\">\r\n");
      out.write("                              <td class=\"day-time\">Work Time</td>\r\n");
      out.write("                              <td class=\"monday ts-item show\" data-tsmeta=\"monday\" style=\"font-family: 'Poppins', sans-serif;\">9:30AM - 1:00PM</td>\r\n");
      out.write("                              <td class=\"monday ts-item show\" data-tsmeta=\"monday\" style=\"font-family: 'Poppins', sans-serif;\">2:00PM - 5:30PM</td>\r\n");
      out.write("                              <td>Malaysia Area</td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          <tr class=\"tr-item\" style=\"display:none\">\r\n");
      out.write("                              <td class=\"day-time\">Work Time</td>\r\n");
      out.write("                              <td class=\"tuesday ts-item show\" data-tsmeta=\"tuesday\" style=\"font-family: 'Poppins', sans-serif;\">9:30AM - 1:00PM</td>\r\n");
      out.write("                              <td class=\"tuesday ts-item\" data-tsmeta=\"tuesday\" style=\"font-family: 'Poppins', sans-serif;\">2:00PM - 5:30PM</td>\r\n");
      out.write("                              <td>Malaysia Area</td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          <tr class=\"tr-item\" style=\"display:none\">\r\n");
      out.write("                              <td class=\"day-time\">Work Time</td>\r\n");
      out.write("                              <td class=\"wednesday ts-item show\" data-tsmeta=\"wednesday\" style=\"font-family: 'Poppins', sans-serif;\">9:30AM - 1:00PM</td>\r\n");
      out.write("                              <td class=\"wednesday ts-item\" data-tsmeta=\"wednesday\" style=\"font-family: 'Poppins', sans-serif;\">2:00PM - 5:30PM</td>\r\n");
      out.write("                              <td>Malaysia Area</td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          <tr class=\"tr-item\" style=\"display:none\">\r\n");
      out.write("                              <td class=\"day-time\">Work Time</td>\r\n");
      out.write("                              <td class=\"thursday ts-item show\" data-tsmeta=\"thursday\" style=\"font-family: 'Poppins', sans-serif;\">9:30AM - 1:00PM</td>\r\n");
      out.write("                              <td class=\"thursday ts-item\" data-tsmeta=\"thursday\" style=\"font-family: 'Poppins', sans-serif;\">2:30PM - 5:30PM</td>\r\n");
      out.write("                              <td>Malaysia Area</td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          <tr class=\"tr-item\" style=\"display:none\">\r\n");
      out.write("                              <td class=\"day-time\">Work Time</td>\r\n");
      out.write("                              <td class=\"friday ts-item show\" data-tsmeta=\"friday\" style=\"font-family: 'Poppins', sans-serif;\">9:30AM - 1:00PM</td>\r\n");
      out.write("                              <td class=\"friday ts-item\" data-tsmeta=\"friday\" style=\"font-family: 'Poppins', sans-serif;\">2:30PM - 4:30PM</td>\r\n");
      out.write("                              <td>Malaysia Area</td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                          <tr class=\"tr-item\" style=\"display:none\">\r\n");
      out.write("                              <td class=\"day-time\">Work Time</td>\r\n");
      out.write("                              <td class=\"saturday ts-item show\" data-tsmeta=\"saturday\" style=\"font-family: 'Poppins', sans-serif;\">11:00AM - 12:30AM</td>\r\n");
      out.write("                              <td class=\"saturday ts-item\" data-tsmeta=\"saturday\" style=\"font-family: 'Poppins', sans-serif;\">2:00PM - 3:30PM</td>\r\n");
      out.write("                              <td>Malaysia Area</td>\r\n");
      out.write("                          </tr>\r\n");
      out.write("                      </tbody>\r\n");
      out.write("                  </table>\r\n");
      out.write("              </div>\r\n");
      out.write("          </div>\r\n");
      out.write("      </div>\r\n");
      out.write("  </div>\r\n");
      out.write("</section>\r\n");
      out.write("\r\n");
      out.write("	<script src=\"../../assets/jquery-2.1.0.min.js\"></script>\r\n");
      out.write("    <script src=\"../script/whatwedo.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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