package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminAllSkill_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("        <meta name=\"description\" content=\"\">\r\n");
      out.write("        <meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("        <title>Admin | Danh sách kỹ năng</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom fonts for this template -->\r\n");
      out.write("        <link href=\"vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("        <link\r\n");
      out.write("            href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\"\r\n");
      out.write("            rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom styles for this template -->\r\n");
      out.write("        <link href=\"css/sb-admin-2.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom styles for this page -->\r\n");
      out.write("        <link href=\"vendor/datatables/dataTables.bootstrap4.min.css\" rel=\"stylesheet\">\r\n");
      out.write("        <style>\r\n");
      out.write("            button{width: 110px;}\r\n");
      out.write("            td{\r\n");
      out.write("                text-align: center;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body id=\"page-top\">\r\n");
      out.write("\r\n");
      out.write("        <!-- Page Wrapper -->\r\n");
      out.write("        <div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("\r\n");
      out.write("            <!-- Content Wrapper -->\r\n");
      out.write("            <div id=\"content-wrapper\" class=\"d-flex flex-column\">\r\n");
      out.write("\r\n");
      out.write("                <!-- Main Content -->\r\n");
      out.write("                <div id=\"content\">\r\n");
      out.write("\r\n");
      out.write("                    <!-- Topbar -->\r\n");
      out.write("                  \r\n");
      out.write("                    <!-- End of Topbar -->\r\n");
      out.write("\r\n");
      out.write("                    <!-- Begin Page Content -->\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"container-fluid\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <!-- DataTales Example -->\r\n");
      out.write("                        <div class=\"card shadow mb-4\">\r\n");
      out.write("                            <div class=\"card-header py-3\">\r\n");
      out.write("                                <h6 class=\"m-0 font-weight-bold text-primary\">Danh sách kỹ năng</h6>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"card-body\">\r\n");
      out.write("                                <div class=\"table-responsive\">\r\n");
      out.write("                                    <table border=\"1\" class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">\r\n");
      out.write("                                        <thead>\r\n");
      out.write("                                            <tr>\r\n");
      out.write("                                                <th>STT</th>\r\n");
      out.write("                                                <th>ID</th>\r\n");
      out.write("                                                <th>TÊN</th>\r\n");
      out.write("                                                <th>CẬP NHẬT</th>\r\n");
      out.write("                                            </tr>\r\n");
      out.write("                                        </thead>\r\n");
      out.write("                                        <tbody>\r\n");
      out.write("                                            ");
int stt = 1;
      out.write("\r\n");
      out.write("                                            ");
      //  c:forEach
      org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
      _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
      _jspx_th_c_forEach_0.setParent(null);
      _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${all}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
      _jspx_th_c_forEach_0.setVar("o");
      int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
      try {
        int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
        if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                                                <tr>\r\n");
            out.write("                                                    <td>");
out.println(stt++);
            out.write("</td>\r\n");
            out.write("                                                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                                                    <td>");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("</td>\r\n");
            out.write("                                                    \r\n");
            out.write("                                                    <td><a href=\"SkillController?action=adminUpdateSkill&skillID=");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${o.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
            out.write("\">Cập nhật</a></td>\r\n");
            out.write("                                                    \r\n");
            out.write("                                                </tr>\r\n");
            out.write("                                            ");
            int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return;
        }
      } catch (Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_forEach_0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_forEach_0.doFinally();
        _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
      }
      out.write("\r\n");
      out.write("                                        </tbody>\r\n");
      out.write("                                    </table>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /.container-fluid -->\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- End of Main Content -->\r\n");
      out.write("                <a href=\"adminCreateSkill.jsp\">\r\n");
      out.write("                    Create Skill\r\n");
      out.write("                </a>\r\n");
      out.write("                <!-- Footer -->\r\n");
      out.write("                <footer class=\"sticky-footer bg-white\">\r\n");
      out.write("                    <div class=\"container my-auto\">\r\n");
      out.write("                      \r\n");
      out.write("                    </div>\r\n");
      out.write("                </footer>\r\n");
      out.write("                <!-- End of Footer -->\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <!-- End of Content Wrapper -->\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- End of Page Wrapper -->\r\n");
      out.write("\r\n");
      out.write("        <!-- Scroll to Top Button-->\r\n");
      out.write("        <a class=\"scroll-to-top rounded\" href=\"#page-top\">\r\n");
      out.write("            <i class=\"fas fa-angle-up\"></i>\r\n");
      out.write("        </a>\r\n");
      out.write("\r\n");
      out.write("        <!-- Logout Modal-->\r\n");
      out.write("        <div class=\"modal fade\" id=\"logoutModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\"\r\n");
      out.write("             aria-hidden=\"true\">\r\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("                <div class=\"modal-content\">\r\n");
      out.write("                    <div class=\"modal-header\">\r\n");
      out.write("                      \r\n");
      out.write("                        <button class=\"close\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\">\r\n");
      out.write("                            <a href=\"login.jsp\">logout</a>\r\n");
      out.write("                        </button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                  \r\n");
      out.write("                    <div class=\"modal-footer\">\r\n");
      out.write("                     \r\n");
      out.write("                   \r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!-- Bootstrap core JavaScript-->\r\n");
      out.write("        <script src=\"vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Core plugin JavaScript-->\r\n");
      out.write("        <script src=\"vendor/jquery-easing/jquery.easing.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Custom scripts for all pages-->\r\n");
      out.write("        <script src=\"js/sb-admin-2.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Page level plugins -->\r\n");
      out.write("        <script src=\"vendor/datatables/jquery.dataTables.min.js\"></script>\r\n");
      out.write("        <script src=\"vendor/datatables/dataTables.bootstrap4.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("        <!-- Page level custom scripts -->\r\n");
      out.write("        <script src=\"js/demo/datatables-demo.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("                                                            var table, select;\r\n");
      out.write("                                                            $(document).ready(addFilter());\r\n");
      out.write("                                                            function addFilter() {\r\n");
      out.write("                                                                table = $('#dataTable').DataTable({\r\n");
      out.write("                                                                    initComplete: function () {\r\n");
      out.write("                                                                        this.api().columns([3]).every(function () {\r\n");
      out.write("                                                                            var column = this;\r\n");
      out.write("                                                                            select = $('<select class=\"w-auto custom-select custom-select-sm form-control form-control-sm\">\\n\\\r\n");
      out.write("                                                    <option value=\"\"><th>Tất cả trạng thái<th></option>\\n\\\r\n");
      out.write("                                                </select>').on('change', function () {\r\n");
      out.write("                                                                                var val = $.fn.dataTable.util.escapeRegex($(this).val());\r\n");
      out.write("                                                                                column.search(val ? '^' + val + '$' : '', true, false).draw();\r\n");
      out.write("                                                                            });\r\n");
      out.write("                                                                            select.append('<option value=\"Kích hoạt\">Kích hoạt</option>');\r\n");
      out.write("                                                                            select.append('<option value=\"Không kích hoạt\">Không kích hoạt</option>');\r\n");
      out.write("                                                                            $('<label id=\"myLabel\" class=\" mr-4\">Trạng thái: </label>').prependTo($('#dataTable_filter'));\r\n");
      out.write("                                                                            $(select).appendTo($('#myLabel'));\r\n");
      out.write("                                                                        });\r\n");
      out.write("                                                                    }\r\n");
      out.write("                                                                });\r\n");
      out.write("                                                            }\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("       \r\n");
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
