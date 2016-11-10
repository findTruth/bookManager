package main.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.tool.Tools;

/**
 * Servlet implementation class ManagerController
 */
@WebServlet("/manager/*")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		if ("/main".equals(path)) {
			request.getRequestDispatcher("../jsp/sys/main.jsp").forward(request, response);
		}else if ("/top".equals(path)) {
			request.getRequestDispatcher("../jsp/sys/top.jsp").forward(request, response);
		}else if ("/left".equals(path)) {
			request.getRequestDispatcher("../jsp/sys/left.jsp").forward(request, response);
		}else if ("/index".equals(path)) {
			request.getRequestDispatcher("../jsp/sys/index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		System.out.println(path);
		if ("/main".equals(path)) {
			request.setAttribute("page", "manager");
			request.getRequestDispatcher("../jsp/sys/main.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
