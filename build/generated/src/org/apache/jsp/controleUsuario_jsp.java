package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Actions.UsuarioSQL;
import DataBases.MysqlCommand;
import Beans.UsuarioBean;

public final class controleUsuario_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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

    try {
        String action = request.getParameter("action");

        // variavel para uso do controle
        String mensagens = null;
        boolean r;
        UsuarioBean u = new UsuarioBean();
        MysqlCommand cm = new MysqlCommand();
        UsuarioSQL us = new UsuarioSQL();

        if (action.equalsIgnoreCase("incluir")) {
            u.setPk_usuario(Integer.valueOf(request.getParameter("pkusuario")));
            u.setNome_usuario(request.getParameter("nome"));
            u.setEmail(request.getParameter("email"));

            if (u.getPk_usuario() <= 0) {
                if (us.usuarioConsulta(u.getEmail()) == null) {
                    request.setAttribute("msg", "E-mail em uso por outro Usuário.");
                    request.getRequestDispatcher("usuarioCadastro.jsp").forward(request, response);
                    return;
                }

                try {
                    r = cm.insert(us.incluirUsuario(u));
                    if (r) {
                        cm.comitComando();
                        cm.fecharComando();
                        request.setAttribute("msg", "Usuário cadastrado com sucesso!");
                    } else {
                        request.setAttribute("msg", "Usuário não foi cadastrado!");
                    }
                    request.getRequestDispatcher("usuarioCadastro.jsp").forward(request, response);

                } catch (Exception e) {
                    out.print("Erro usuário cadastrado: \n" + e.getMessage());
                    cm.rollbackComando();
                    cm.fecharComando();
                }
            } else {
                try {
                    r = cm.insert(us.alteraUsuario(u));
                    if (r) {
                        cm.comitComando();
                        cm.fecharComando();
                        request.setAttribute("msg", "Usuário alterar com sucesso!");
                    } else {
                        request.setAttribute("msg", "Usuário não foi alterado!");
                    }
                    request.getRequestDispatcher("usuarioCadastro.jsp").forward(request, response);
                } catch (Exception e) {
                    out.print("Erro usuário alterar: \n" + e.getMessage());
                }
            }
        } else if (action.equalsIgnoreCase("deleta")) {
            try {
                r = cm.insert(us.usuarioDeleta(Integer.valueOf(request.getParameter("pkusuario"))));
                if (r) {
                    cm.comitComando();
                    cm.fecharComando();
                    request.setAttribute("msg", "Usuário excluido com sucesso!");
                } else {
                    request.setAttribute("msg", "Usuário não foi excluido!");
                }
                request.getRequestDispatcher("usuarioConsulta.jsp").forward(request, response);
            } catch (Exception e) {
                out.print("Erro ao mudar o status do usuário: \n" + e.getMessage());
            }
        } else if (action.equalsIgnoreCase("ativo")) {
            try {
                r = cm.insert(us.ativaUsuario(Integer.valueOf(request.getParameter("pkusuario"))));
                if (r) {
                    cm.comitComando();
                    cm.fecharComando();
                    request.setAttribute("msg", "Status alterar com sucesso!");
                } else {
                    request.setAttribute("msg", "Status não foi alterado!");
                }
                request.getRequestDispatcher("usuarioConsulta.jsp").forward(request, response);
            } catch (Exception e) {
                out.print("Erro ao mudar o status do usuário: \n" + e.getMessage());
            }
        } else if (action.equalsIgnoreCase("recupera")) {
            try {
                r = cm.insert(us.recuperaSenhaUsuario(request.getParameter("email")));

                if (r) {
                    cm.comitComando();
                    cm.fecharComando();
                    UsuarioSQL us1 = new UsuarioSQL();
                    String link = "usuarioCadastrarSenha.jsp?pass=" + us1.recuperaLinkSenhaUsuario(request.getParameter("email"));
                    request.setAttribute("msg", "E-mail com link de recuperação enviado! </br> " + link);
                } else {
                    request.setAttribute("msg", "Usuário não pode recupera a senha!");
                }
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (Exception e) {
                out.print("Erro ao mudar o status do usuário: \n" + e.getMessage());
            }
        } else if (action.equalsIgnoreCase("incluirSenha")) {
            int pkusuario = Integer.valueOf(request.getParameter("pkusuario"));
            String senha1 = request.getParameter("senha1");
            String senha2 = request.getParameter("senha2");

            if (senha1.isEmpty()) {
                request.setAttribute("msg", "Senha1 esta vazia!");
                request.getRequestDispatcher("usuarioCadastrarSenha.jsp").forward(request, response);
                return;
            }
            if (senha2.isEmpty()) {
                request.setAttribute("msg", "Senha2 esta vazia!");
                request.getRequestDispatcher("usuarioCadastrarSenha.jsp").forward(request, response);
                return;
            }
            if (!senha1.equals(senha2)) {
                request.setAttribute("msg", "Senhas são diferente!");
                request.getRequestDispatcher("usuarioCadastrarSenha.jsp").forward(request, response);
                return;
            }

            try {
                r = cm.insert(us.incluirSenhaUsuario(pkusuario, senha1));
                if (r) {
                    cm.comitComando();
                    cm.fecharComando();
                    request.setAttribute("msg", "Senha cadastrada com sucesso!");
                } else {
                    request.setAttribute("msg", "Senha não foi cadastrado!");
                }
                request.getRequestDispatcher("usuarioCadastrarSenha.jsp").forward(request, response);

            } catch (Exception e) {
                out.print("Erro ao cadastra a senha: \n" + e.getMessage());
                cm.rollbackComando();
                cm.fecharComando();
            }
        } else if (action.equalsIgnoreCase("validaUsuario")) {
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");

            if (email.isEmpty()) {
                request.setAttribute("msgLogin", "e-mail esta vazia!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
            if (senha.isEmpty()) {
                request.setAttribute("msgLogin", "Senha esta vazia!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
            try {
                if (us.validaUsuario(email, senha)) {
                    request.getRequestDispatcher("principal.jsp").forward(request, response);
                } else {
                    request.setAttribute("msgLogin", "e-mail ou senha invalidos!");
                }

                request.getRequestDispatcher("index.jsp").forward(request, response);

            } catch (Exception e) {
                out.print("Erro na validação de e-mail e senha: \n" + e.getMessage());
            }
        }
    } catch (NullPointerException nexp) {
        out.print("Retorne para pagina inicial..." + nexp.getMessage());

    }

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
