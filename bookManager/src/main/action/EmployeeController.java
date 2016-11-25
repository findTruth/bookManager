package main.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import main.biz.impl.EmployeeBizImpl;
import main.tool.Tools;
import main.tool.json.EmpJsonList;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/employee/*")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if ("/list".equals(path)) {
			out.println(EmpJsonList.getEmpPage(new EmployeeBizImpl().empList()));
			out.close();
		}else if("/employeemanager".equals(path)){
			request.getRequestDispatcher("../jsp/emp/emp_list.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if ("/findById".equals(path)) {
			String EUID = request.getParameter("EUID");
			out.println(new Gson().toJson(new EmployeeBizImpl().findById(EUID)));
			out.close();
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
