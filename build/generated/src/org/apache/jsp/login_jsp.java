package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/customtags.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_mma_ifEmptyMark_field_color_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_mma_ifEmptyMark_field_color_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_mma_ifEmptyMark_field_color_nobody.release();
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>Product Maintenance</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"styles/style.css\" type=\"text/css\"/>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Login Form</h1>\n");
      out.write("    <p>Please enter a username and password to continue</p>\n");
      out.write("    \n");
      out.write("   <p>");
      if (_jspx_meth_mma_ifEmptyMark_0(_jspx_page_context))
        return;
      out.write(" marks required fields</p>\n");
      out.write("        <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>\n");
      out.write("        <form action=\"login\" method=\"POST\">\n");
      out.write("            <div class=\"block\">\n");
      out.write("            <label for=\"username\"> Username: </label>\n");
      out.write("            <input type=\"text\" name=\"username\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/> \n");
      out.write("            ");
      if (_jspx_meth_mma_ifEmptyMark_1(_jspx_page_context))
        return;
      out.write("<br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"block\">\n");
      out.write("            <label for=\"password\">Password: </label>\n");
      out.write("            <input type=\"text\" name=\"password\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/> \n");
      out.write("            ");
      if (_jspx_meth_mma_ifEmptyMark_2(_jspx_page_context))
        return;
      out.write("<br>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"buttons\">\n");
      out.write("            <input type=\"submit\" name=\"action\" value=\"Login\"/>\n");
      out.write("            </div>\n");
      out.write("          </form>\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_mma_ifEmptyMark_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mma:ifEmptyMark
    project.tags.IfEmptyMarkTag _jspx_th_mma_ifEmptyMark_0 = (project.tags.IfEmptyMarkTag) _jspx_tagPool_mma_ifEmptyMark_field_color_nobody.get(project.tags.IfEmptyMarkTag.class);
    _jspx_th_mma_ifEmptyMark_0.setPageContext(_jspx_page_context);
    _jspx_th_mma_ifEmptyMark_0.setParent(null);
    _jspx_th_mma_ifEmptyMark_0.setColor("red");
    _jspx_th_mma_ifEmptyMark_0.setField("");
    int _jspx_eval_mma_ifEmptyMark_0 = _jspx_th_mma_ifEmptyMark_0.doStartTag();
    if (_jspx_th_mma_ifEmptyMark_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_mma_ifEmptyMark_field_color_nobody.reuse(_jspx_th_mma_ifEmptyMark_0);
      return true;
    }
    _jspx_tagPool_mma_ifEmptyMark_field_color_nobody.reuse(_jspx_th_mma_ifEmptyMark_0);
    return false;
  }

  private boolean _jspx_meth_mma_ifEmptyMark_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mma:ifEmptyMark
    project.tags.IfEmptyMarkTag _jspx_th_mma_ifEmptyMark_1 = (project.tags.IfEmptyMarkTag) _jspx_tagPool_mma_ifEmptyMark_field_color_nobody.get(project.tags.IfEmptyMarkTag.class);
    _jspx_th_mma_ifEmptyMark_1.setPageContext(_jspx_page_context);
    _jspx_th_mma_ifEmptyMark_1.setParent(null);
    _jspx_th_mma_ifEmptyMark_1.setColor("red");
    _jspx_th_mma_ifEmptyMark_1.setField((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_mma_ifEmptyMark_1 = _jspx_th_mma_ifEmptyMark_1.doStartTag();
    if (_jspx_th_mma_ifEmptyMark_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_mma_ifEmptyMark_field_color_nobody.reuse(_jspx_th_mma_ifEmptyMark_1);
      return true;
    }
    _jspx_tagPool_mma_ifEmptyMark_field_color_nobody.reuse(_jspx_th_mma_ifEmptyMark_1);
    return false;
  }

  private boolean _jspx_meth_mma_ifEmptyMark_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  mma:ifEmptyMark
    project.tags.IfEmptyMarkTag _jspx_th_mma_ifEmptyMark_2 = (project.tags.IfEmptyMarkTag) _jspx_tagPool_mma_ifEmptyMark_field_color_nobody.get(project.tags.IfEmptyMarkTag.class);
    _jspx_th_mma_ifEmptyMark_2.setPageContext(_jspx_page_context);
    _jspx_th_mma_ifEmptyMark_2.setParent(null);
    _jspx_th_mma_ifEmptyMark_2.setColor("red");
    _jspx_th_mma_ifEmptyMark_2.setField((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_mma_ifEmptyMark_2 = _jspx_th_mma_ifEmptyMark_2.doStartTag();
    if (_jspx_th_mma_ifEmptyMark_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_mma_ifEmptyMark_field_color_nobody.reuse(_jspx_th_mma_ifEmptyMark_2);
      return true;
    }
    _jspx_tagPool_mma_ifEmptyMark_field_color_nobody.reuse(_jspx_th_mma_ifEmptyMark_2);
    return false;
  }
}
