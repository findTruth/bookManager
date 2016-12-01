package main.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import main.biz.impl.UserBizImpl;
import main.entity.BookKeep;
import main.entity.BookRecord;
import main.entity.User;
import main.javaBean.Bookkeep;
import main.javaBean.Bookrecord;
import main.tool.Tools;

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
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if ("/top".equals(path)) {	
			request.getRequestDispatcher("../jsp/user/top.jsp").forward(request, response);
		}else if ("/left".equals(path)) {
			request.getRequestDispatcher("../jsp/user/left.jsp").forward(request, response);
		}else if ("/index".equals(path)) {
			String logintime=userbizimpl.FindUserLoginTime(longUUID);
			request.setAttribute("LoginTime", logintime);
			userbizimpl.UpdateUserLoginTime(longUUID);
			request.getRequestDispatcher("../jsp/user/home.jsp").forward(request, response);
		}else if ("/BookCentre".equals(path)) {
			request.getRequestDispatcher("../book/UserBook.do").forward(request, response);
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
		}else if ("/userShouCang2".equals(path)) {
			String Content=request.getParameter("Content");
			String Number=request.getParameter("NUMBER");
			int number;
			if (Number==null) {
				number=1;
			}else {
				number=Integer.parseInt(Number);
			}
			if (number==0&&Content!=null) {			
				List<Bookkeep> list=userbizimpl.listbookkeep(longUUID,Content);
				JsonObject json = new JsonObject();
				if (list!=null&&list.size()==0) {
					json.addProperty("msg", "你查找的内容不存在,请重新确认");
				}else {
					json.addProperty("totalCount",list.size());
					json.add("jsonRoot",new Gson().toJsonTree(list));	
					json.addProperty("msg", "查找成功");
				}
				out.append(json.toString());
				out.close();
			}else {
				List<Bookkeep> list=userbizimpl.listbookkeep(longUUID);
				JsonObject json = new JsonObject();
				if (list!=null||list.size()==0) {
					json.addProperty("totalCount",list.size());
					json.add("jsonRoot",new Gson().toJsonTree(list));						
				}
				out.append(json.toString());
				out.close();						
			}
		}else if ("/userJieShu".equals(path)) {
			request.getRequestDispatcher("../jsp/user/userJieShu.jsp").forward(request, response);
		}else if ("/userJieShu2".equals(path)) {
			String Content=request.getParameter("Content");
			String Number=request.getParameter("NUMBER");
			int number;
			if (Number==null) {
				number=1;
			}else {
				number=Integer.parseInt(Number);
			}
			if (number==0&&Content!=null) {			
				List<Bookrecord> list=userbizimpl.listbookrecord(longUUID,Content);
				JsonObject json = new JsonObject();
				if (list!=null&&list.size()==0) {
					json.addProperty("msg", "你查找的内容不存在,请重新确认");
				}else {
					json.addProperty("totalCount",list.size());
					json.add("jsonRoot",new Gson().toJsonTree(list));	
					json.addProperty("msg", "查找成功");
				}
				out.append(json.toString());
				out.close();
			}else {
				List<Bookrecord> list=userbizimpl.bookrecordList(longUUID);
				JsonObject json = new JsonObject();
				if (list!=null||list.size()==0) {
					json.addProperty("totalCount",list.size());
					json.add("jsonRoot",new Gson().toJsonTree(list));						
				}
				out.append(json.toString());
				out.close();						
			}			
		}else if ("/AddUser".equals(path)) {
			
		}else if ("/UserList".equals(path)) {
			List<User> list=userbizimpl.userList(); 
			JsonObject json = new JsonObject();
			if (list!=null) {
				json.addProperty("totalCount",list.size());
				json.add("jsonRoot",new Gson().toJsonTree(list));						
			}
			out.append(json.toString());
			out.close();	
		}else if ("/Addborrow".equals(path)) {
			JsonObject json = new JsonObject();
//			String uuid="610a4b8997964d4084ef15157951f093";
			String BUID=request.getParameter("BUID");
//			String BUID="af9e7629cf834dc083ce894391effa98";
				BookRecord bookrecord=new BookRecord(Tools.UUID(), BUID, longUUID, null, null, 0);
				if (userbizimpl.BookrecordCount(longUUID)) {
					boolean flag1=userbizimpl.FindBookrecord(BUID);
					if (!flag1) {					
						boolean flag=userbizimpl.addborrowbook(bookrecord);
						if (flag) {
							json.addProperty("msg", "借阅成功");
						}					
					}else {
						json.addProperty("msg", "借阅失败,你已经借阅该书籍");
					}
				}else {
					json.addProperty("msg", "借阅失败,超出借书上限");
				}
			out.append(json.toString());
			out.close();	
		}else if ("/Addbookkeep".equals(path)) {
			JsonObject json = new JsonObject();
			String BUID=request.getParameter("BUID");
//			String uuid="610a4b8997964d4084ef15157951f093";
//			String BUID="c4db15e0b31c494699cf992201333d0f";
				boolean flag=userbizimpl.FindBookkeep(BUID);
				if (!flag) {
					BookKeep bookkeep=new BookKeep(Tools.UUID(), longUUID, BUID,null);
					boolean flag1=userbizimpl.addbookkeep(bookkeep);
					if (flag1) {
						json.addProperty("msg", "收藏成功");
					}
				}else {
					json.addProperty("msg", "收藏失败,你已经收藏该书籍");
				}
			out.append(json.toString());
			out.close();	
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
			User user=new User(null, PHONE, EMAIL, MD5password, Tools.MD5(ANSWER), QUESTION, null, null, 0, 0, null, null, null, null);
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
						HttpSession session=request.getSession();
						session.setAttribute("UUID", longUUID2);
						longUUID=(String)session.getAttribute("UUID");
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
			 String niceng =request.getParameter("NICNAME");
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
				String UUID=userbizimpl.checkNCMB(niceng, question, Tools.MD5(answer));
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
		}else if ("/CheckUser".equals(path)) {
			String user=request.getParameter("user");
			if (!userbizimpl.FindUser(user)) {
				out.println("{\"Usermsg\":\"没有该账户，请注册一个新用户\"}");
				out.close();
			}
		}else if ("/deletebookkeep".equals(path)) {
			String KUID=request.getParameter("KUID");
			boolean flag=userbizimpl.deletebookkeep(KUID, longUUID);
			JsonObject json = new JsonObject();
			if (flag) {
				json.addProperty("msg", "删除成功");
			}else{
				json.addProperty("msg", "删除失败");
			}
			out.print(json.toString());
			out.close();
		}else if ("/borrowbookkeep".equals(path)) {
			JsonObject json = new JsonObject();
			String KUID=request.getParameter("KUID");
			String BUID=userbizimpl.findbyKUID(KUID);
			BookRecord bookrecord=new BookRecord(Tools.UUID(), BUID, longUUID, null, null, 0);
			if (userbizimpl.BookrecordCount(longUUID)) {
				boolean flag1=userbizimpl.FindBookrecord(BUID);
				if (!flag1) {
					boolean flag=userbizimpl.addborrowbook(bookrecord);
					boolean flag2=userbizimpl.deletebookkeep(KUID, longUUID);
					if (flag&&flag2) {
						json.addProperty("msg", "借阅成功");
					}										
				}else {
					json.addProperty("msg", "借阅失败,你已经借阅该书籍");
				}
			}else {
				json.addProperty("msg", "借阅失败,超出借书上限");
			}
			out.print(json.toString());
			out.close();
		}else if ("/returnbookrecord".equals(path)) {
			JsonObject json = new JsonObject();
			String RUID=request.getParameter("RUID");
			if (userbizimpl.returnbookrecord(longUUID, RUID)) {
				json.addProperty("msg", "还书成功");
			}
			out.print(json.toString());
			out.close();
		}	
		else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
