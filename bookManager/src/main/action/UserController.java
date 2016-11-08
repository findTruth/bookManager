package main.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.tool.Tools;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String path = Tools.cut(request.getRequestURI());
//		PrintWriter out=response.getWriter();
		String PHONE=request.getParameter("mobile");
		String EMAIL=request.getParameter("email");
		String PASSWORD=request.getParameter("password2");
		String QUESTION=request.getParameter("selected");
		String ANSWER=request.getParameter("answer"); 
		
		if ("/regist".equals(path)) {
			
		}else if ("/login".equals(path)) {
			System.out.println("info:"+Tools.getDate()+" user:"+request.getParameter("user")+" Login action");
			
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
