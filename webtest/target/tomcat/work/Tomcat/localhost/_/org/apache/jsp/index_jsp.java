/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-06-29 14:14:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Title</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/css/bootstrap.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/static/css/test.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"aw-top-menu-wrap\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <!-- logo -->\r\n");
      out.write("        <div class=\"aw-logo hidden-xs\">\r\n");
      out.write("            <a href=\"http://wenda.ghostchina.com\"></a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- end logo -->\r\n");
      out.write("        <!-- 搜索框 -->\r\n");
      out.write("        <div class=\"aw-search-box  hidden-xs hidden-sm\">\r\n");
      out.write("            <form class=\"navbar-search\" action=\"http://wenda.ghostchina.com/search/\" id=\"global_search_form\" method=\"post\">\r\n");
      out.write("                <input class=\"form-control search-query\" type=\"text\" placeholder=\"搜索问题、话题或人\" autocomplete=\"off\" name=\"q\" id=\"aw-search-query\">\r\n");
      out.write("                <span title=\"搜索\" id=\"global_search_btns\" onclick=\"$('#global_search_form').submit();\"><i class=\"icon icon-search\"></i></span>\r\n");
      out.write("                <div class=\"aw-dropdown\">\r\n");
      out.write("                    <div class=\"mod-body\">\r\n");
      out.write("                        <p class=\"title\">输入关键字进行搜索</p>\r\n");
      out.write("                        <ul class=\"aw-dropdown-list hide\"></ul>\r\n");
      out.write("                        <p class=\"search\"><span>搜索:</span><a onclick=\"$('#global_search_form').submit();\"></a></p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"mod-footer\">\r\n");
      out.write("                        <a href=\"\" onclick=\"$('#header_publish').click();\" class=\"pull-right btn btn-mini btn-success publish\">发起问题</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- end 搜索框 -->\r\n");
      out.write("        <!-- 导航 -->\r\n");
      out.write("        <div class=\"aw-top-nav navbar\">\r\n");
      out.write("            <div class=\"navbar-header\">\r\n");
      out.write("                <button class=\"navbar-toggle pull-left\">\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                    <span class=\"icon-bar\"></span>\r\n");
      out.write("                </button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <nav role=\"navigation\" class=\"collapse navbar-collapse bs-navbar-collapse\">\r\n");
      out.write("                <ul class=\"nav navbar-nav\">\r\n");
      out.write("                    <li><a href=\"\" class=\"active\"><i class=\"icon icon-ul\"></i> 发现</a></li>\r\n");
      out.write("\r\n");
      out.write("                    <!-- <li><a href=\"http://wenda.ghostchina.com/question/\" class=\"\">问题</a></li>\r\n");
      out.write("\r\n");
      out.write("                    <li><a href=\"http://wenda.ghostchina.com/article/\" class=\"\">文章</a></li> -->\r\n");
      out.write("\r\n");
      out.write("                    <li><a href=\"http://wenda.ghostchina.com/topic/\"><i class=\"icon icon-topic\"></i> 话题</a></li>\r\n");
      out.write("\r\n");
      out.write("                </ul>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- end 导航 -->\r\n");
      out.write("        <!-- 用户栏 -->\r\n");
      out.write("        <div class=\"aw-user-nav\">\r\n");
      out.write("            <!-- 登陆&注册栏 -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"register btn btn-normal btn-success\" href=\"http://wenda.ghostchina.com/account/register/\">注册</a>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"login btn btn-normal btn-primary\" href=\"http://wenda.ghostchina.com/login/\">登录</a>\r\n");
      out.write("\t\t\t\t\t</span>\r\n");
      out.write("            <!-- end 登陆&注册栏 -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- end 用户栏 -->\r\n");
      out.write("        <!-- 发起 -->\r\n");
      out.write("        <!-- end 发起 -->\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
