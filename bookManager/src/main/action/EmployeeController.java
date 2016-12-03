package main.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

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
		if ("/empwork".equals(path)) {
			request.getRequestDispatcher("../jsp/emp/empwork.jsp");
		}else if("/list".equals(path)){
			List<Emp> list = new EmployeeBizImpl().empList();
			response.getWriter().append(Tools.json(list));
			response.getWriter().close();
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if ("/empwork".equals(path)) {
//			request.setAttribute("page", "manager");
			ManagerBizImpl mbi = new ManagerBizImpl();
			try {
				mbi.LastLoginTime(((HashMap<String, String>)request.getSession().getAttribute("emp")).get("MUID"));
			} catch (SQLException e) {
				response.getWriter().append("网络连接异常");
				response.getWriter().close();
			}
//			response.sendRedirect("../jsp/manager/main.jsp");
			request.getRequestDispatcher("../jsp/emp/empwork.jsp").forward(request, response);
		}else if("/findById".equals(path)){
			String EUID = request.getParameter("EUID");
			Emp emp = new EmployeeBizImpl().findById(EUID);
			response.getWriter().append(new Gson().toJson(emp));
			response.getWriter().close();
		}else if("/add".equals(path)){
			Emp emp = new Emp(Tools.UUID(), request.getParameter("UNAME"), request.getParameter("NAME"), Tools.MD5(request.getParameter("PASSWORD")), request.getParameter("PHONE"), request.getParameter("QQ"), request.getParameter("ID"), Integer.valueOf(request.getParameter("AGE")), null, Integer.valueOf(request.getParameter("QUAN")), 0);
			JsonObject json = new JsonObject();
			if(new EmployeeBizImpl().addEmp(emp)){
				json.addProperty("result", "0");
				json.addProperty("msg", "新增用户完成");
			}else{
				json.addProperty("result", "-1");
				json.addProperty("msg", "新增用户失败");
			}
			response.getWriter().println(json.toString());
			response.getWriter().close();
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
