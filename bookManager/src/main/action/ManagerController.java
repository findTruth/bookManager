package main.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

import main.biz.impl.EmployeeBizImpl;
import main.biz.impl.ManagerBizImpl;
import main.entity.Emp;
import main.tool.Tools;

/**
 * Servlet implementation class ManagerController
 */
@WebServlet("/manager/*")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		
		if ("/top".equals(path)) {
			request.getRequestDispatcher("../jsp/manager/top.jsp").forward(request, response);
		}else if ("/left".equals(path)) {
			request.getRequestDispatcher("../jsp/manager/left.jsp").forward(request, response);
		}else if ("/index".equals(path)) {
			request.getRequestDispatcher("../jsp/manager/home.jsp").forward(request, response);
		}else if ("/home".equals(path)) {
			request.setAttribute("manager", request.getSession().getAttribute("manager"));
			request.getRequestDispatcher("../jsp/manager/main.jsp").forward(request, response);
		}
		else if ("/main".equals(path)) {
//			request.setAttribute("page", "manager");
			ManagerBizImpl mbi = new ManagerBizImpl();
			try {
				mbi.LastLoginTime(((HashMap<String, String>)request.getSession().getAttribute("manager")).get("MUID"));
			} catch (SQLException e) {
				response.getWriter().append("网络连接异常");
				response.getWriter().close();
			}
//			response.sendRedirect("../jsp/manager/main.jsp");
			request.getRequestDispatcher("../jsp/manager/main.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if ("/main".equals(path)) {
//			request.setAttribute("page", "manager");
			ManagerBizImpl mbi = new ManagerBizImpl();
			try {
				mbi.LastLoginTime(((HashMap<String, String>)request.getSession().getAttribute("manager")).get("MUID"));
			} catch (SQLException e) {
				response.getWriter().append("网络连接异常");
				response.getWriter().close();
			}
//			response.sendRedirect("../jsp/manager/main.jsp");
			request.getRequestDispatcher("../jsp/manager/main.jsp").forward(request, response);
		}else if("/changeEmpQuan".equals(path)){
			String euid = request.getParameter("EUID");
			String quan = request.getParameter("QUAN");
			JsonObject json = new JsonObject();
			if (new ManagerBizImpl().changeEmpQuan(euid, Integer.valueOf(quan))) {
				json.addProperty("result", "0");
				json.addProperty("msg", "权限已经更改");
			}else{
				json.addProperty("result", "-1");
				json.addProperty("msg", "权限更改失败");
			}
			System.out.println(json.toString());
			out.println(json.toString());
			out.close();
		}else if("/changeEmpStatus".equals(path)){
			String euid = request.getParameter("EUID");
			String status = request.getParameter("STATUS");
			JsonObject json = new JsonObject();
			if (new ManagerBizImpl().changeEmpStatus(euid, Integer.valueOf(status))) {
				json.addProperty("result", "0");
				json.addProperty("msg", "状态已经更改");
			}else{
				json.addProperty("result", "-1");
				json.addProperty("msg", "状态更改失败");
			}
			out.println(json.toString());
			out.close();
		}else if("/changeEmp".equals(path)){
			Emp emp = new Emp(request.getParameter("EUID"), null, request.getParameter("NAME"),
					null, request.getParameter("PHONE"), request.getParameter("QQ"), request.getParameter("ID"), 
					Integer.valueOf(request.getParameter("AGE")), null, Integer.valueOf(request.getParameter("QUAN")), 0);
			boolean flag = new EmployeeBizImpl().changeAll(emp);
			JsonObject json = new JsonObject();
			if (flag) {
				json.addProperty("result", "0");
				json.addProperty("msg", "修改成功");
			}else{
				json.addProperty("result", "-1");
				json.addProperty("msg", "修改失败");
			}
			out.print(json.toString());
			out.close();
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
