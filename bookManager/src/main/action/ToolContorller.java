package main.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
		}else if ("/clear".equals(path)) {
			request.getSession().invalidate();
			response.sendRedirect("../");
		}else if ("/getUUID".equals(path)) {
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println(Tools.cut(request.getRequestURI()));
			out.println("PASSWORD is 2:"+Tools.MD5("2"));
			out.println("UUID:"+Tools.UUID());
			out.close();
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Pragma","No-cache"); 
		response.setHeader("Cache-Control","no-cache"); 
		response.setDateHeader("Expires", 0);
		if ("/adminLogin".equals(path)) {
			PrintWriter out = response.getWriter();
			System.out.println("user:"+request.getParameter("Name")+"  pwd:"+request.getParameter("Pwd")+"  yzm:"+request.getParameter("Yzm")+"  seyzm:"+request.getSession().getAttribute("codeValue"));
			if (!request.getParameter("Yzm").equals(request.getSession().getAttribute("codeValue"))) {
				JsonObject json = new JsonObject();
				json.addProperty("result", "1");
				json.addProperty("msg", "验证码错误");
				out.println(json.toString());
				out.close();
			}else{
				ManagerBizImpl mbi = new ManagerBizImpl();
				EmployeeBizImpl ebi = new EmployeeBizImpl();
				Manager manager = null;
				try {
					manager = mbi.findByName(request.getParameter("Name"));
				} catch (SQLException e) {
					JsonObject json = new JsonObject();
					json.addProperty("result", "1");
					json.addProperty("msg", "网络连接错误");
					out.print(json.toString());
					out.close();
				}
				Emp emp = ebi.findByName(request.getParameter("Name"));
				if (manager!=null&&emp!=null) {
					if (Tools.MD5(request.getParameter("Pwd")).equals(manager.getPASSWORD())) {
						request.getSession().setAttribute("manager", new main.javaBean.Manager(manager).getHashmap());
						JsonObject json = new JsonObject();
						json.addProperty("result", "0");
						json.addProperty("msg", "登陆成功");
						out.print(json.toString());
						out.close();
					}else if(Tools.MD5(request.getParameter("Pwd")).equals(emp.getPASSWORD())){
						JsonObject json = new JsonObject();
						json.addProperty("result", "2");
						json.addProperty("msg", "登陆成功");
						out.print(json.toString());
						out.close();
					}else{
						System.out.println("m!ok e!ok");
						JsonObject json = new JsonObject();
						json.addProperty("result", "1");
						json.addProperty("msg", "密码错误");
						out.print(json.toString());
						out.close();
					}
				}else if (manager!=null) {
					System.out.println("req:"+Tools.MD5(request.getParameter("Pwd"))+"  sjk:"+manager.getPASSWORD());
					if (Tools.MD5(request.getParameter("Pwd")).equals(manager.getPASSWORD())) {
						request.getRequestDispatcher("../manager/main.do").forward(request, response);
					}else{
						JsonObject json = new JsonObject();
						json.addProperty("result", "1");
						json.addProperty("msg", "密码错误");
						out.print(json.toString());
						out.close();
					}
				}else if (emp!=null) {
					if(Tools.MD5(request.getParameter("Pwd")).equals(emp.getPASSWORD())){
						JsonObject json = new JsonObject();
						json.addProperty("result", "2");
						json.addProperty("msg", "登陆成功");
						out.print(json.toString());
						out.close();
					}else{
						JsonObject json = new JsonObject();
						json.addProperty("result", "1");
						json.addProperty("msg", "密码错误");
						out.print(json.toString());
						out.close();
					}
				}else{
					System.out.println("else");
					JsonObject json = new JsonObject();
					json.addProperty("result", "1");
					json.addProperty("msg", "密码错误");
					out.print(json.toString());
					out.close();
				}
			}
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
