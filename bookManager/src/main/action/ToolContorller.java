package main.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.biz.impl.EmployeeBizImpl;
import main.biz.impl.ManagerBizImpl;
import main.entity.Emp;
import main.entity.Manager;
import main.tool.Tools;

/**
 * Servlet implementation class ToolContorller
 */
@WebServlet("/tool/*")
public class ToolContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		if ("/VerifyImage".equals(path)) {
			Tools.getVerifyImage(request, response);
		}else if ("/getUUID".equals(path)) {
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println(Tools.cut(request.getRequestURI()));
			out.println("PASSWORD is 2:"+Tools.MD5("2"));
			out.println("UUID:"+Tools.UUID());
			out.close();
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if ("/adminLogin".equals(path)) {
			PrintWriter out = response.getWriter();
			System.out.println("user:"+request.getParameter("Name")+"  pwd:"+request.getParameter("Pwd")+"  yzm:"+request.getParameter("Yzm")+"  seyzm:"+request.getSession().getAttribute("codeValue"));
			if (!request.getParameter("Yzm").equals(request.getSession().getAttribute("codeValue"))) {
				request.setAttribute("Top", "验证码错误");
				request.getRequestDispatcher("../jsp/sys/login.jsp").forward(request, response);
			}else{
				ManagerBizImpl mbi = new ManagerBizImpl();
				EmployeeBizImpl ebi = new EmployeeBizImpl();
				Manager manager = mbi.findByName(request.getParameter("Name"));
				Emp emp = ebi.findByName(request.getParameter("Name"));
				if (manager!=null&&emp!=null) {
					if (Tools.MD5(request.getParameter("Pwd")).equals(manager.getPASSWORD())) {
						request.getSession().setAttribute("manager", new main.javaBean.Manager(manager).getHashmap());
						request.getRequestDispatcher("../manager/main.do").forward(request, response);
					}else if(Tools.MD5(request.getParameter("Pwd")).equals(emp.getPASSWORD())){
						out.append("eok");
						out.close();
					}else{
						request.setAttribute("Top", "密码错误");
						request.getRequestDispatcher("../jsp/sys/login.jsp").forward(request, response);
					}
				}else if (manager!=null) {
					System.out.println("req:"+Tools.MD5(request.getParameter("Pwd"))+"  sjk:"+manager.getPASSWORD());
					if (Tools.MD5(request.getParameter("Pwd")).equals(manager.getPASSWORD())) {
						request.getRequestDispatcher("../manager/main.do").forward(request, response);
					}else{
						request.setAttribute("Top", "密码错误");
						request.getRequestDispatcher("../jsp/sys/login.jsp").forward(request, response);
					}
				}else if (emp!=null) {
					if(Tools.MD5(request.getParameter("Pwd")).equals(emp.getPASSWORD())){
						out.append("2eok");
						out.close();
					}else{
						request.setAttribute("Top", "密码错误");
						request.getRequestDispatcher("../jsp/sys/login.jsp").forward(request, response);
					}
				}else{
					request.setAttribute("Top", "没有该账号错误");
					request.getRequestDispatcher("../jsp/sys/login.jsp").forward(request, response);
				}
			}
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
