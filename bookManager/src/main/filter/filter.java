package main.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.entity.Emp;
import main.entity.Manager;
import main.entity.User;

/**
 * Servlet Filter implementation class filter
 */
public class filter implements Filter {

    /**
     * Default constructor. 
     */
    public filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		response.setCharacterEncoding("utf-8");
		HttpServletResponse resp = (HttpServletResponse)response;
		resp.setCharacterEncoding("utf-8");
		String url=req.getRequestURL().toString();
		HttpSession hs = req.getSession();
		Object manager =  hs.getAttribute("manager");
		Emp emp = (Emp) hs.getAttribute("emp");
		String user = (String) hs.getAttribute("User");
		String path = req.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		if (url.endsWith("find.jsp")||url.endsWith("readagree.jsp")||url.endsWith("Regist.jsp")||url.endsWith("Panduanregist.do")||url.endsWith("regist.do")||url.equals(basePath)||url.endsWith("getUUID.do")||url.endsWith("404.jsp")||url.endsWith(".html")||url.endsWith("VerifyImage.do")||url.endsWith("index.jsp")||url.endsWith("login.jsp")||url.endsWith("adminLogin.do")||url.endsWith("login.do")||manager!=null||emp!=null||user!=null||url.endsWith(".css") || url.endsWith(".js")|| url.endsWith(".gif")|| url.endsWith(".png")|| url.endsWith(".jpg")) {
			chain.doFilter(request, response);
		}else{
			PrintWriter out=resp.getWriter();
			out.println("<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /></head>");
			out.print("<script>alert('请登录！…………');top.location.href='"+req.getContextPath()+"/index.jsp'</script>");
//			resp.sendRedirect(req.getContextPath() + "/index.jsp");
			out.close();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
