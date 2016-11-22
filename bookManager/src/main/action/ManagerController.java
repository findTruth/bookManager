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

import main.biz.impl.ManagerBizImpl;
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
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
