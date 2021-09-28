package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class homepage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      out.write("            color: #fff;\r\n");
      out.write("        }\r\n");
      out.write("        .avatar {\r\n");
      out.write("            vertical-align: middle;\r\n");
      out.write("            width: 30px;\r\n");
      out.write("            height: 30px;\r\n");
      out.write("            border-radius: 50%;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"main\">\r\n");
      out.write("            <div id=\"header\">\r\n");
      out.write("                <ul id=nav>\r\n");
      out.write("                    <li><a href=\"#\">Happy Programming</a></li>\r\n");
      out.write("                        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user==null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                        <li><a href=\"login.jsp\">Login</a></li>\r\n");
        out.write("                        <li><a href=\"signup.jsp\">Signup</a></li>\r\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                        <li><a href=\"#\" style=\"padding-right:0\">Hello: ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.account}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("                              \r\n");
        out.write("                            </a></li>\r\n");
        out.write("                        <li><a href=\"UserController?service=userProfile&user=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.account}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\"\r\n");
        out.write("                               style=\"padding: 0 8px\"><img src=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.ava}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\" alt=\"Avatar\" class=\"avatar\"></a></li>\r\n");
        out.write("                        <!-- Phân quyền cho mentee-->\r\n");
        out.write("                        ");
        if (_jspx_meth_c_if_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                        <!-- Phân quyền cho mentor-->\r\n");
        out.write("                        ");
        if (_jspx_meth_c_if_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                        <!-- Phân quyền cho admin--> \r\n");
        out.write("                        ");
        if (_jspx_meth_c_if_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\r\n");
        out.write("                        <li><a href=\"UserController?service=logout\">Logout</a></li>\r\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.role==1}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                            <li><a href=\"userProfile.jsp\">Become Mentor</a></li>\r\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.role==0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                            <li><a href=\"#\">Request of student</a></li>\r\n");
        out.write("                            <li><a href=\"#\">Request</a></li>\r\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }

  private boolean _jspx_meth_c_if_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_4 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_4.setPageContext(_jspx_page_context);
    _jspx_th_c_if_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_if_4.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.role==2}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_4 = _jspx_th_c_if_4.doStartTag();
    if (_jspx_eval_c_if_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                            <li><a href=\"#\">Manager User</a></li>\r\n");
        out.write("                            <li><a href=\"#\">Request</a></li>\r\n");
        out.write("                            <li><a href=\"#\">Contact</a></li>\r\n");
        out.write("                            \r\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_4.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_4);
    return false;
  }
}
