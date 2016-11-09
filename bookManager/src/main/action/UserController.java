package main.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.biz.impl.UserBizImpl;
import main.entity.User;
import main.tool.Tools;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBizImpl userbizimpl=new UserBizImpl();
	
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
		String QUESTION=request.getParameter("question1");
		String ANSWER=request.getParameter("answer"); 
		User user=new User(PHONE, EMAIL, PASSWORD, ANSWER, QUESTION);
		if ("/regist".equals(path)) {
			if (userbizimpl.add(user)) {			
				response.setHeader("refresh","1;url=http://localhost:8080/bookManager/jsp/user/login.jsp");
			}else {
				request.getRequestDispatcher("../404.jsp").forward(request, response);
			}
		}else if ("/login".equals(path)) {
			System.out.println("info:"+Tools.getDate()+" user:"+request.getParameter("user")+" Login action");
			
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
