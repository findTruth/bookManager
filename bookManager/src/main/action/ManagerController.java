package main.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
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
import main.biz.impl.UserBizImpl;
import main.entity.Emp;
import main.entity.User;
import main.tool.Tools;

/**
 * Servlet implementation class ManagerController
 */
@WebServlet("/manager/*")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());

		if ("/top".equals(path)) {
			request.getRequestDispatcher("../jsp/manager/top.jsp").forward(request, response);
		} else if ("/left".equals(path)) {
			request.getRequestDispatcher("../jsp/manager/left.jsp").forward(request, response);
		} else if ("/index".equals(path)) {
			request.getRequestDispatcher("../jsp/manager/home.jsp").forward(request, response);
		} else if ("/home".equals(path)) {
			request.setAttribute("manager", request.getSession().getAttribute("manager"));
			request.getRequestDispatcher("../jsp/manager/main.jsp").forward(request, response);
		} else if ("/main".equals(path)) {
			// request.setAttribute("page", "manager");
			ManagerBizImpl mbi = new ManagerBizImpl();
			try {
				mbi.LastLoginTime(((HashMap<String, String>) request.getSession().getAttribute("manager")).get("MUID"));
			} catch (SQLException e) {
				response.getWriter().append("网络连接异常");
				response.getWriter().close();
			}
			// response.sendRedirect("../jsp/manager/main.jsp");
			request.getRequestDispatcher("../jsp/manager/main.jsp").forward(request, response);
		} else if ("/empList".equals(path)) {
			request.getRequestDispatcher("../jsp/manager/emp_list.jsp").forward(request, response);
		} else if ("/usermanager".equals(path)) {
			request.getRequestDispatcher("../jsp/manager/user_list.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if ("/main".equals(path)) {
			// request.setAttribute("page", "manager");
			ManagerBizImpl mbi = new ManagerBizImpl();
			try {
				mbi.LastLoginTime(((HashMap<String, String>) request.getSession().getAttribute("manager")).get("MUID"));
			} catch (SQLException e) {
				response.getWriter().append("网络连接异常");
				response.getWriter().close();
			}
			// response.sendRedirect("../jsp/manager/main.jsp");
			request.getRequestDispatcher("../jsp/manager/main.jsp").forward(request, response);
		} else if ("/changeEmpQuan".equals(path)) {
			String euid = request.getParameter("EUID");
			String quan = request.getParameter("QUAN");
			JsonObject json = new JsonObject();
			if (new ManagerBizImpl().changeEmpQuan(euid, Integer.valueOf(quan))) {
				json.addProperty("result", "0");
				json.addProperty("msg", "权限已经更改");
			} else {
				json.addProperty("result", "-1");
				json.addProperty("msg", "权限更改失败");
			}
			System.out.println(json.toString());
			out.println(json.toString());
			out.close();
		} else if ("/changeEmpStatus".equals(path)) {
			String euid = request.getParameter("EUID");
			String status = request.getParameter("STATUS");
			JsonObject json = new JsonObject();
			if (new ManagerBizImpl().changeEmpStatus(euid, Integer.valueOf(status))) {
				json.addProperty("result", "0");
				json.addProperty("msg", "状态已经更改");
			} else {
				json.addProperty("result", "-1");
				json.addProperty("msg", "状态更改失败");
			}
			out.println(json.toString());
			out.close();
		} else if ("/changeEmp".equals(path)) {
			Emp emp = new Emp(request.getParameter("EUID"), null, request.getParameter("NAME"), null,
					request.getParameter("PHONE"), request.getParameter("QQ"), request.getParameter("ID"),
					Integer.valueOf(request.getParameter("AGE")), null, Integer.valueOf(request.getParameter("QUAN")),
					0);
			boolean flag = new EmployeeBizImpl().changeAll(emp);
			JsonObject json = new JsonObject();
			if (flag) {
				json.addProperty("result", "0");
				json.addProperty("msg", "修改成功");
			} else {
				json.addProperty("result", "-1");
				json.addProperty("msg", "修改失败");
			}
			out.print(json.toString());
			out.close();
		} else if ("/delEmp".equals(path)) {
			List<String> list = new ArrayList<>();
			for (int i = 0; i < Integer.valueOf(request.getParameter("length")); i++) {
				list.add(request.getParameter("" + i));
			}
			JsonObject json = new JsonObject();
			if (new EmployeeBizImpl().delEmpList(list)) {
				json.addProperty("result", "0");
				json.addProperty("msg", "删除成功");
			} else {
				json.addProperty("result", "-1");
				json.addProperty("msg", "删除失败");
			}
			out.println(json.toString());
			out.close();
		} else if("/addEmp".equals(path)){
			Emp emp = new Emp(Tools.UUID(), request.getParameter("UNAME"), request.getParameter("NAME"), Tools.MD5(request.getParameter("PASSWORD")),
					request.getParameter("PHONE"), request.getParameter("QQ"), request.getParameter("ID"),
					Integer.valueOf(request.getParameter("AGE")), null, Integer.valueOf(request.getParameter("QUAN")),
					0);
			boolean flag = new EmployeeBizImpl().addEmp(emp);
			JsonObject json = new JsonObject();
			if (flag) {
				json.addProperty("result", "0");
				json.addProperty("msg", "增加成功");
			} else {
				json.addProperty("result", "-1");
				json.addProperty("msg", "增加失败");
			}
			out.print(json.toString());
			out.close();
		} else if ("/changeUser".equals(path)) {
			User user = new User(Tools.UUID(), request.getParameter("PHONE"),
					request.getParameter("EMAIL"), null, null, null, request.getParameter("NICNAME"), null,
					Integer.valueOf(request.getParameter("STATUS")), Integer.valueOf(request.getParameter("SEX")), null,
					null, null, null);
			JsonObject json = new JsonObject();
			if (new UserBizImpl().changeUser(user)) {
				json.addProperty("result", "0");
				json.addProperty("msg", "修改成功");
			} else {
				json.addProperty("result", "-1");
				json.addProperty("msg", "修改失败");
			}
			out.print(json.toString());
			out.close();
		} else if ("/delUser".equals(path)) {
			List<String> list = new ArrayList<>();
			for (int i = 0; i < Integer.valueOf(request.getParameter("length")); i++) {
				list.add(request.getParameter("" + i));
			}
			JsonObject json = new JsonObject();
			if (new UserBizImpl().delUserList(list)) {
				json.addProperty("result", "0");
				json.addProperty("msg", "删除成功");
			} else {
				json.addProperty("result", "-1");
				json.addProperty("msg", "删除失败");
			}
			out.println(json.toString());
			out.close();
		}else if("/findUserById".equals(path)){
			User user = new UserBizImpl().find(request.getParameter("UUID"));
			out.println(new Gson().toJson(user));
			out.close();
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
