package main.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.biz.impl.BookBizImpl;
import main.biz.impl.ManagerBizImpl;
import main.biz.impl.UserBizImpl;
import main.entity.User;
import main.javaBean.Bookrecord;
import main.tool.Tools;
import main.tool.json.BookJsonList;
import main.tool.json.userJieShu;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserBizImpl userbizimpl=new UserBizImpl();
	String longUUID;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		if ("/top".equals(path)) {	
			request.getRequestDispatcher("../jsp/user/top.jsp").forward(request, response);
		}else if ("/left".equals(path)) {
			request.getRequestDispatcher("../jsp/user/left.jsp").forward(request, response);
		}else if ("/index".equals(path)) {
			request.getRequestDispatcher("../jsp/user/home.jsp").forward(request, response);
		}else if ("/BookCentre".equals(path)) {
			request.getRequestDispatcher("../book/bookmanager.do").forward(request, response);
		}else if ("/userGeRen".equals(path)) {
			User user=userbizimpl.find(longUUID);
			request.setAttribute("Nicname", user.getNICNAME());
			request.setAttribute("Action1", user.getATION1());
			request.setAttribute("Action2", user.getATION2());
			request.setAttribute("Action3", user.getATION3());
			request.setAttribute("Sex", user.getSEX());
			request.getRequestDispatcher("../jsp/user/userGeRen.jsp").forward(request, response);
		}else if ("/userShouCang".equals(path)) {
			request.getRequestDispatcher("../jsp/user/userShouCang.jsp").forward(request, response);
		}else if ("/userJieShu".equals(path)) {
			request.getRequestDispatcher("../jsp/user/userJieShu.jsp ").forward(request, response);		
		}else if ("/userJieShu2".equals(path)) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/plain");
			response.getWriter().append(userJieShu.getBookRecordPage(userbizimpl.bookrecordList(longUUID)));
		}else if ("/AddUser".equals(path)) {
			request.getRequestDispatcher("../jsp/user/login.jsp").forward(request, response);
		}else if ("/UserList".equals(path)) {
			List<User> list=userbizimpl.userList(); 
		}else{
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
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
		}else if ("/Panduanregist".equals(path)) {
			String UUID=userbizimpl.findYxSj(request.getParameter("email"), request.getParameter("mobile"));
			if (UUID==null) {
				out.println("{\"msg\":\"邮箱和手机号码可用\"}");
				out.close();
			}else {
				out.println("{\"msg\":\"邮箱或者手机号码已经存在\"}");
				out.close();
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
						String longUUID2=user1.getUUID();
						HttpSession UUIDsession=request.getSession();
						UUIDsession.setAttribute("UUID", longUUID2);
						longUUID=(String)UUIDsession.getAttribute("UUID");
						HttpSession session=request.getSession();
						session.setAttribute("User", user);
						request.getRequestDispatcher("../jsp/user/main.jsp").forward(request, response);	
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
						 request.getRequestDispatcher("../jsp/user/login.jsp").forward(request, response);	
					}
				}else {
					String message="你输入的手机号码不存在，请仔细想想";
					request.setAttribute("findmessage", message);
					request.getRequestDispatcher("../jsp/user/find.jsp").forward(request, response);
				}			
			}else if (d.equals("2")) {
				String UUID=userbizimpl.checkemail(email);
				 if (UUID!=null) {
					 if (userbizimpl.update(UUID, MD5pwd)) {
						 request.getRequestDispatcher("../jsp/user/login.jsp").forward(request, response);	
						}
				}else {
					String message="你输入的邮箱不存在，请仔细想想";
					request.setAttribute("findmessage", message);
					request.getRequestDispatcher("../jsp/user/find.jsp").forward(request, response);
				}
			}else if (d.equals("3")) {
				String UUID=userbizimpl.checkNCMB(niceng, question, answer);
				if (UUID!=null) {
					 if (userbizimpl.update(UUID, MD5pwd)) {
						 request.getRequestDispatcher("../jsp/user/login.jsp").forward(request, response);	
						}
				}else {
					String message="您还没有设置昵称或者您输入密保问题有误，请选择其它方式找回密码或者仔细想想";
					request.setAttribute("findmessage", message);
					request.getRequestDispatcher("../jsp/user/find.jsp").forward(request, response);
				}		
			}
		}else if ("/userGeRen2".equals(path)) {
			String Nicname=request.getParameter("nicheng");
			String Ation123=request.getParameter("province");
			String Ation1=request.getParameter("sheng");
			String Ation2=request.getParameter("shi");
			String Ation3=request.getParameter("xian");
			int Sex=Integer.parseInt(request.getParameter("sex"));
			String oldPwd=request.getParameter("yuanmima");
			String oldPwdMd5=Tools.MD5(oldPwd);
			String newPwd=request.getParameter("xinmima");
			String newPwdMd5=Tools.MD5(newPwd);
				if (userbizimpl.findNicname(Nicname,longUUID)) {
					if (oldPwd.equals("")||newPwd.equals("")) {
							userbizimpl.addndx(longUUID,Nicname, Ation1, Ation2, Ation3, Sex);
							User user=userbizimpl.find(longUUID);
							request.setAttribute("Nicname", user.getNICNAME());
							request.setAttribute("Action1", user.getATION1());
							request.setAttribute("Action2", user.getATION2());
							request.setAttribute("Action3", user.getATION3());
							request.setAttribute("Sex", user.getSEX());
							request.getRequestDispatcher("../jsp/user/userGeRen.jsp").forward(request, response);
						}else {			
								User user=userbizimpl.find(longUUID);
								userbizimpl.addndx(longUUID,Nicname, Ation1, Ation2, Ation3, Sex,newPwdMd5);
								request.setAttribute("Nicname", user.getNICNAME());
								request.setAttribute("Action1", user.getATION1());
								request.setAttribute("Action2", user.getATION2());
								request.setAttribute("Action3", user.getATION3());
								request.setAttribute("Sex", user.getSEX());
								request.getRequestDispatcher("../jsp/user/userGeRen.jsp").forward(request, response);								
					} 
				}else {
					String message="昵称以存在，请重新输入";
					User user=userbizimpl.find(longUUID);
					request.setAttribute("Nicname", user.getNICNAME());
					request.setAttribute("Action1", user.getATION1());
					request.setAttribute("Action2", user.getATION2());
					request.setAttribute("Action3", user.getATION3());
					request.setAttribute("Sex", user.getSEX());
					request.setAttribute("errmessage", message);
					request.getRequestDispatcher("../jsp/user/userGeRen.jsp").forward(request, response);
				}		
		}else if ("/PanduanGeRen".equals(path)) {
			String oldPwd=request.getParameter("oldPwd");
			String oldPwdMd5=Tools.MD5(oldPwd);
			User user=userbizimpl.find(longUUID);
			if (!user.getPASSWORD().equals(oldPwdMd5)) {
				out.println("{\"Pwdmsg\":\"原密码错误\"}");
				out.close();
			}
		}else if ("/userShouCang2".equals(path)) {
			request.getRequestDispatcher("../user/userShouCang.do").forward(request, response);
		}	
		else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
