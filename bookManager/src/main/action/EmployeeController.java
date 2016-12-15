package main.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

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
import main.tool.Tools;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/employee/*")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		response.setCharacterEncoding("utf-8");
		if ("/top".equals(path)) {
			request.getRequestDispatcher("../jsp/emp/top.jsp").forward(request, response);
		}else if ("/left".equals(path)) {
			request.getRequestDispatcher("../jsp/emp/left.jsp").forward(request, response);
		}else if ("/index".equals(path)) {
			request.getRequestDispatcher("../jsp/emp/home.jsp").forward(request, response);
		}else if ("/home".equals(path)) {
			request.setAttribute("emp", request.getSession().getAttribute("emp"));
			request.getRequestDispatcher("../jsp/emp/main.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if ("/main".equals(path)) {
			ManagerBizImpl mbi = new ManagerBizImpl();
			try {
				mbi.LastLoginTime(((HashMap<String, String>)request.getSession().getAttribute("emp")).get("EUID"));
			} catch (SQLException e) {
				response.getWriter().append("网络连接异常");
				response.getWriter().close();
			}
			request.getRequestDispatcher("../jsp/emp/main.jsp").forward(request, response);
		}else if("/findById".equals(path)){
			String EUID = request.getParameter("EUID");
			Emp emp = new EmployeeBizImpl().findById(EUID);
			response.getWriter().append(new Gson().toJson(emp));
			response.getWriter().close();
		}else if("/list".equals(path)){
			List<Emp> list = new EmployeeBizImpl().empList();
			response.getWriter().append(Tools.json(list));
			response.getWriter().close();
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
