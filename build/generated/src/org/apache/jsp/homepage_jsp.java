package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <title>Happy Programming</title>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <style>\r\n");
      out.write("        *{\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("        #main{\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("        #header{\r\n");
      out.write("            position: fixed;\r\n");
      out.write("            top: 0;\r\n");
      out.write("            left: 0;\r\n");
      out.write("            right: 0;\r\n");
      out.write("            height: 50px;\r\n");
      out.write("            background-color: #5993a6;\r\n");
      out.write("        }\r\n");
      out.write("        #nav{\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("        #nav li{\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("        }\r\n");
      out.write("        #nav li a{\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("            line-height: 50px;\r\n");
      out.write("            padding: 0 25px;\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("\r\n");
      out.write("        }\r\n");
      out.write("        #nav li:hover a{\r\n");
      out.write("            color: #000;\r\n");
      out.write("            background-color: #ccc;\r\n");
      out.write("        }\r\n");
      out.write("        html{\r\n");
      out.write("            font-family: Arial;\r\n");
      out.write("        }\r\n");
      out.write("        #slider{\r\n");
      out.write("            position: relative;\r\n");
      out.write("            margin-top: 50px;\r\n");
      out.write("            padding-top: 65%;\r\n");
      out.write("            background: url(images/1.jpg) top center / cover no-repeat;\r\n");
      out.write("        }\r\n");
      out.write("        #slider .text-content{\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            bottom: 700px;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            left: 0;\r\n");
      out.write("            right: 0;\r\n");
      out.write("\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        #slider .text-heading{\r\n");
      out.write("            font-weight: 500;\r\n");
      out.write("            font-size: 30px;\r\n");
      out.write("        }\r\n");
      out.write("        #slider .text-description{\r\n");
      out.write("            font-size: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        #footer{\r\n");
      out.write("            padding: 60px 20px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            background-color: #5993a6;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </style>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"main\">\r\n");
      out.write("            <div id=\"header\">\r\n");
      out.write("                <ul id=nav>\r\n");
      out.write("                    <li><a href=\"#\">Happy Programming</a></li>\r\n");
      out.write("                    <li><a href=\"login.jsp\">Login</a></li>\r\n");
      out.write("                    <li><a href=\"signup.jsp\">Signup</a></li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=slider>\r\n");
      out.write("                <div class=\"text-content\">\r\n");
      out.write("                    <h2 class=\"text-heading\">C#</h2>\r\n");
      out.write("                    <div class=\"text-description\">C# (C-Sharp) is a programming language developed by Microsoft that runs on the .NET Framework.\r\n");
      out.write("                        C# is used to develop web apps, desktop apps, mobile apps, games and much more.</div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"content\">\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"footer\">\r\n");
      out.write("                <div>©2021 Web học lập trình uy tín hàng đầu Việt Nam - Được tài trợ bởi SWP291</div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
