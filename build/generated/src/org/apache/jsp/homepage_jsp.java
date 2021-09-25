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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("        <!-- <title>@ViewData[\"Title\"] - Exercise</title> -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"~/lib/bootstrap/dist/css/bootstrap.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"~/css/classlayout.css\" />\n");
      out.write("        <link\n");
      out.write("            href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css\"\n");
      out.write("            rel=\"stylesheet\"\n");
      out.write("            integrity=\"sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU\"\n");
      out.write("            crossorigin=\"anonymous\"\n");
      out.write("            />\n");
      out.write("        <script src=\"../Jquery/Jquery_core/jquery_min/jquery-3.6.0.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("      #sign{\n");
      out.write("        clear: both;\n");
      out.write("        display: flex;\n");
      out.write("      }\n");
      out.write("      #login {\n");
      out.write("        \n");
      out.write("      }\n");
      out.write("      #signup{\n");
      out.write("        background-color: chocolate;\n");
      out.write("        color: white;\n");
      out.write("      }\n");
      out.write("\n");
      out.write("    </style>\n");
      out.write("    <nav\n");
      out.write("      style=\"border: 5px solid white;background-color: #c1c9d6 \"\n");
      out.write("      class=\"navbar navbar-expand-lg navbar-light\"\n");
      out.write("    >\n");
      out.write("      <div class=\"container-fluid\">\n");
      out.write("        <div style=\"border-right: 5px solid white;\">\n");
      out.write("          <a class=\"navbar-brand m-5\" href=\"#\">Logo</a>\n");
      out.write("        </div>\n");
      out.write("        <button\n");
      out.write("          class=\"navbar-toggler\"\n");
      out.write("          type=\"button\"\n");
      out.write("          data-bs-toggle=\"collapse\"\n");
      out.write("          data-bs-target=\"#navbarSupportedContent\"\n");
      out.write("          aria-controls=\"navbarSupportedContent\"\n");
      out.write("          aria-expanded=\"false\"\n");
      out.write("          aria-label=\"Toggle navigation\"\n");
      out.write("        >\n");
      out.write("          <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("        </button>\n");
      out.write("        <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("          <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("              <a class=\"nav-link \" aria-current=\"page\" href=\"#\">Mentor</a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("              <a class=\"nav-link\" href=\"#\">Chia sẻ</a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"nav-item\">\n");
      out.write("              <a class=\"nav-link\" href=\"#\">Trở thành mentor</a>\n");
      out.write("            </li>\n");
      out.write("            <div id=\"sign\" class=\"bg-light\">\n");
      out.write("            <li id=\"login\" class=\"nav-item\">\n");
      out.write("              <a class=\"nav-link\" href=\"#\">Đăng nhập</a>\n");
      out.write("            </li>\n");
      out.write("            <li id=\"signup\" class=\"nav-item\">\n");
      out.write("              <a class=\"nav-link\" href=\"#\">Đăng kí</a>\n");
      out.write("            </li>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("          </ul>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </nav>\n");
      out.write("    <div\n");
      out.write("      style=\"height: 300px; border: 5px solid white; background-color: #c1c9d6\"\n");
      out.write("      class=\"slide col-lg-12\"\n");
      out.write("    >\n");
      out.write("      slider\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"content d-flex\">\n");
      out.write("      <div\n");
      out.write("        style=\"height: 300px;border: 5px solid white; background-color: #c1c9d6\"\n");
      out.write("        class=\"left col-lg-9\"\n");
      out.write("      >\n");
      out.write("        featured post\n");
      out.write("      </div>\n");
      out.write("      <div\n");
      out.write("        style=\"height: 300px;border: 5px solid white; background-color: #c1c9d6\"\n");
      out.write("        class=\"right col-lg-3\"\n");
      out.write("      >\n");
      out.write("        slider\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div\n");
      out.write("      style=\"height: 70px;border: 5px solid white; background-color: #c1c9d6\"\n");
      out.write("      class=\"footer col-lg-12\"\n");
      out.write("    >\n");
      out.write("      Footer\n");
      out.write("    </div>\n");
      out.write("    <script src=\"~/lib/jquery/dist/jquery.min.js\"></script>\n");
      out.write("    <script src=\"~/lib/bootstrap/dist/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("    <script src=\"~/js/site.js\" asp-append-version=\"true\"></script>\n");
      out.write("    <!-- @await RenderSectionAsync(\"Scripts\", required: false) -->\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
