package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Beans.GrupoBean;
import Actions.GrupoSQL;

public final class grupoCadastro_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

    GrupoBean bean = new GrupoBean();
    try {
        if (!request.getParameter("pkgrupo").isEmpty()) {
            Integer id = new Integer(request.getParameter("pkgrupo"));
            GrupoSQL gs = new GrupoSQL();
            bean = gs.grupoConsulta(id);
        }
    } catch (Exception e) {
    }

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <title>Cadastro/Alteração de grupo</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap/css/bootstrap.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"font-awesome/css/font-awesome.min.css\" />\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-1.10.2.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <!-- Form - START -->\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-12\">\n");
      out.write("                        <div class=\"well well-sm\">\n");
      out.write("                            <form class=\"form-horizontal\" method=\"post\" action=\"controleGrupo.jsp?action=incluir\">\n");
      out.write("                                <fieldset>\n");
      out.write("                                    <legend class=\"text-center header\">\n");
      out.write("                                        ");
 if (bean.getPk_grupo() <= 0) {
      out.write("\n");
      out.write("                                        Inclusão de grupo \n");
      out.write("                                        ");
} else {
      out.write("\n");
      out.write("                                        Alteração de grupo");
 }
      out.write("\n");
      out.write("                                    </legend> \n");
      out.write("                                    \n");
      out.write("                                    <h4><span class=\"label label-default\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span></h4>\n");
      out.write("                                    <input type=\"hidden\"  id=\"fpkgrupo\" name=\"pkgrupo\" value=\"");
      out.print( bean.getPk_grupo());
      out.write("\"/>\n");
      out.write("\n");
      out.write("                                    <div class=\"form-group\">              \n");
      out.write("                                        <span class=\"col-md-1 col-md-offset-2 text-center\"><i class=\"fa fa-user bigicon\"></i></span>              \n");
      out.write("                                        <div class=\"col-md-8\">\n");
      out.write("                                            Nome do usuário\n");
      out.write("                                            <input id=\"fnome\" name=\"nome\" type=\"text\" placeholder=\"Nome do grupo\" class=\"form-control\" value=\"");
      out.print( bean.getNome_grupo() );
      out.write("\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>    \n");
      out.write("\n");
      out.write("                                    <div class=\"form-group\">\n");
      out.write("                                        <div class=\"col-md-12 text-center\">\n");
      out.write("                                            <button type=\"submit\" class=\"btn btn-primary btn-lg\">Enviar dados</button>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </fieldset>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <style>\n");
      out.write("                .header {\n");
      out.write("                    color:#36A0FF;\n");
      out.write("                    font-size:27px;\n");
      out.write("                    padding:10px;\n");
      out.write("                }\n");
      out.write("                .bigicon {\n");
      out.write("                    font-size:35px;\n");
      out.write("                    color:#36A0FF;\n");
      out.write("                }\n");
      out.write("            </style>\n");
      out.write("            <!-- Contact Form - END -->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
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
