/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-06-22 06:51:44 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class readxml_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <link rel=\"stylesheet\" href=\"/static/js/bootstrap.min.js\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"page-header\">\r\n");
      out.write("            <h3>Ajax读取XMl</h3>\r\n");
      out.write("        </div>\r\n");
      out.write("        <button id=\"readBtn\">Read</button>\r\n");
      out.write("        <div id=\"userBox\">\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script>\r\n");
      out.write("        (function(){\r\n");
      out.write("            function createXmlHttp(){\r\n");
      out.write("                var xmlHttp = null;\r\n");
      out.write("                if (window.ActiveXObject){\r\n");
      out.write("                    xmlHttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("                }else {\r\n");
      out.write("                    xmlHttp = new XMLHttpRequest();\r\n");
      out.write("                }\r\n");
      out.write("                return xmlHttp;\r\n");
      out.write("            }\r\n");
      out.write("            function creatUserDiv(id,username,address){\r\n");
      out.write("                var div = document.createElement(\"div\");\r\n");
      out.write("                var h4 = document.createElement(\"h4\");\r\n");
      out.write("                var small = document.createElement(\"small\");\r\n");
      out.write("                var p = document.createElement(\"p\");\r\n");
      out.write("                var idText = document.createTextNode(id);\r\n");
      out.write("                var addressText = document.createTextNode(address);\r\n");
      out.write("                var nameText = document.createTextNode(username);\r\n");
      out.write("                p.appendChild(addressText);\r\n");
      out.write("                small.appendChild(idText);\r\n");
      out.write("                h4.appendChild(nameText);\r\n");
      out.write("                h4.appendChild(small);\r\n");
      out.write("                div.appendChild(h4);\r\n");
      out.write("                div.appendChild(p);\r\n");
      out.write("                document.getElementById(\"userBox\").appendChild(div);\r\n");
      out.write("            }\r\n");
      out.write("            document.querySelector(\"#readBtn\").onclick=function(){\r\n");
      out.write("                var xmlHttp = createXmlHttp();\r\n");
      out.write("                xmlHttp.open(\"get\",\"/user.xml\",true);\r\n");
      out.write("                xmlHttp.onreadystatechange = function(){\r\n");
      out.write("                    if (xmlHttp.readyState==4){\r\n");
      out.write("                        if (xmlHttp.status==200){\r\n");
      out.write("                            document.querySelector(\"#userBox\").innerText=\"\";\r\n");
      out.write("                            var xmlDoc = xmlHttp.responseXML;\r\n");
      out.write("                            var userArry = xmlDoc.getElementsByTagName(\"user\");\r\n");
      out.write("                            for (var i=0;i<userArry.length;i++){\r\n");
      out.write("                                var user = userArry[i];\r\n");
      out.write("                                var id = user.getAttribute(\"id\");\r\n");
      out.write("                                var username = user.getElementsByTagName(\"username\")[0].childNodes[0].nodeValue;\r\n");
      out.write("                                var address = user.getElementsByTagName(\"address\")[0].childNodes[0].nodeValue;\r\n");
      out.write("                                creatUserDiv(id,username,address);\r\n");
      out.write("                            }\r\n");
      out.write("                        }else {\r\n");
      out.write("                            alert(\"请求服务器异常:\" + status);\r\n");
      out.write("                        }\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("                xmlHttp.send();\r\n");
      out.write("            };\r\n");
      out.write("        })();\r\n");
      out.write("    </script>\r\n");
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