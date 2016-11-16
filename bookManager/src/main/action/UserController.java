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
				String pwd=request.getParameter("pwd");
				String MD5pwd=Tools.MD5(pwd);
				String yzm=request.getParameter("yzm");
				String yzm2= (String) request.getSession().getAttribute("codeValue");
				if (yzm.equals(yzm2)) {
					User user1=userbizimpl.check(user, MD5pwd);
					if (user1.getUUID()!=null) {
						response.setHeader("refresh", "1;url=../jsp/user/Regist.jsp");
					}else{
						String message="账号或者密码错误，请重新输入";
						request.setAttribute("loginmessage", message);
						request.getRequestDispatcher("../jsp/user/login.jsp").forward(request, response);	
					}
				}else {
					String message="验证码错误，请认真填写";
					request.setAttribute("loginmessage", message);
					request.getRequestDispatcher("../jsp/user/login.jsp").forward(request, response);
				}
		}else if("/find".equals(path)){
			 String d=request.getParameter("D1");
			 String phone =request.getParameter("phone");
			 String email =request.getParameter("email");
			 String niceng =request.getParameter("niceng");
			 String question =request.getParameter("question1");
			 String answer =request.getParameter("answer");
			 String pwd=request.getParameter("password2");
			 String MD5pwd=Tools.MD5(pwd);
			 if (d.equals("1")) {
				 String UUID=userbizimpl.checkphone(phone);
				 if (UUID!=null) {
					 if (userbizimpl.update(UUID, MD5pwd)) {
						response.sendRedirect("../jsp/user/main.jsp?UUID="+UUID+"");
					}
				}else {
					String message="你输入的手机号码不存在，请仔细想想";
					request.setAttribute("findmessage", message);
					request.getRequestDispatcher("../jsp/user/find.jsp").forward(request, response);
				}			
			}else if (d.equals("2")) {
				String UUID=userbizimpl.checkemail(email);
				 if (UUID!=null) {
					 System.out.println("222");
					 if (userbizimpl.update(UUID, MD5pwd)) {
						 response.sendRedirect("../jsp/user/main.jsp?UUID="+UUID+"");
						}
				}else {
					String message="你输入的邮箱不存在，请仔细想想";
					request.setAttribute("findmessage", message);
					request.getRequestDispatcher("../jsp/user/find.jsp").forward(request, response);
				}
			}else if (d.equals("3")) {
				String UUID=userbizimpl.checkNCMB(niceng, question, answer);
				if (UUID!=null) {
					System.out.println("333");
					 if (userbizimpl.update(UUID, MD5pwd)) {
						 response.sendRedirect("../jsp/user/main.jsp?UUID="+UUID+"");
						}
				}else {
					String message="您还没有设置昵称或者您输入密保问题有误，请选择其它方式找回密码或者仔细想想";
					request.setAttribute("findmessage", message);
					request.getRequestDispatcher("../jsp/user/find.jsp").forward(request, response);
				}		
			}
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
