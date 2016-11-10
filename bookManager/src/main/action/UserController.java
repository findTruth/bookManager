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
		PrintWriter out=response.getWriter();
		if ("/regist".equals(path)) {
			String PHONE=request.getParameter("mobile");
			String EMAIL=request.getParameter("email");
			String PASSWORD=request.getParameter("password2");
			String MD5password=Tools.MD5(PASSWORD);
			String QUESTION=request.getParameter("question1");
			String ANSWER=request.getParameter("answer"); 
			User user=new User(PHONE, EMAIL, MD5password, ANSWER, QUESTION);
			if (userbizimpl.add(user)) {			
				response.setHeader("refresh","1;url=http://localhost:8080/bookManager/jsp/user/login.jsp");
			}else {
				request.getRequestDispatcher("../404.jsp").forward(request, response);
			}
		}else if ("/login".equals(path)) {
				String user=request.getParameter("user");
				System.out.println(user);
				String pwd=request.getParameter("pwd");
				System.out.println(pwd);
				String MD5pwd=Tools.MD5(pwd);
				System.out.println(MD5pwd);
				String yzm=request.getParameter("yzm");
				String yzm2= (String) request.getSession().getAttribute("codeValue");
				if (yzm.equals(yzm2)) {
					System.out.println("111");
					if (userbizimpl.check(user, MD5pwd)!=null) {
						response.setHeader("refresh", "1;url=http://localhost:8080/bookManager/jsp/user/Regist.jsp");
					}else{
						String message="账号或者密码错误，请重新输入";
						request.setAttribute("loginmessage", message);
						request.getRequestDispatcher("/user/login.jsp").forward(request, response);	
					}
				}else {
					
				}
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
