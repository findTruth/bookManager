package main.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import main.entity.BookRecord;
import main.entity.Emp;
import main.javaBean.Bookrecord;
import main.tool.Tools;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/employee/*")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		response.setCharacterEncoding("utf-8");
		if ("/top".equals(path)) {
			request.getRequestDispatcher("../jsp/emp/top.jsp").forward(request, response);
		}else if ("/left".equals(path)) {
			request.getRequestDispatcher("../jsp/emp/left.jsp").forward(request, response);
		}else if ("/index".equals(path)) {
			request.getRequestDispatcher("../jsp/emp/home.jsp").forward(request, response);
		}else if ("/home".equals(path)) {
			request.setAttribute("emp", request.getSession().getAttribute("emp"));
			request.getRequestDispatcher("../jsp/emp/main.jsp").forward(request, response);
		}else if("/guihuan".equals(path)){
			request.getRequestDispatcher("../jsp/emp/guihuan.jsp").forward(request, response);
		}else if("/jieshu".equals(path)){
			request.getRequestDispatcher("../jsp/emp/jieshu.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		if ("/main".equals(path)) {
			ManagerBizImpl mbi = new ManagerBizImpl();
			try {
				mbi.LastLoginTime(((HashMap<String, String>)request.getSession().getAttribute("emp")).get("EUID"));
			} catch (SQLException e) {
				response.getWriter().append("网络连接异常");
				response.getWriter().close();
			}
			request.getRequestDispatcher("../jsp/emp/main.jsp").forward(request, response);
		}else if("/findById".equals(path)){
			String EUID = request.getParameter("EUID");
			Emp emp = new EmployeeBizImpl().findById(EUID);
			response.getWriter().append(new Gson().toJson(emp));
			response.getWriter().close();
		}else if("/list".equals(path)){
			List<Emp> list = new EmployeeBizImpl().empList();
			response.getWriter().append(Tools.json(list));
			response.getWriter().close();
		}else if("/HuanShu".equals(path)){
			int type = 0;
			String keyword = null;
			if(request.getParameter("type")==null){}else{
				type = Integer.valueOf(request.getParameter("type"));
			}
			if(request.getParameter("keyword")==null){}else{
				keyword = request.getParameter("keyword");
			}
			List<Bookrecord> list = null;
			list = new EmployeeBizImpl().bookrecordList(type, keyword);
			JsonObject json = new JsonObject();
			if(list==null){
				json.addProperty("result", "-1");
				json.addProperty("msg", "查询数据失败");
				response.getWriter().append(json.toString());
			}else{
				response.getWriter().append(Tools.json(list));
			}
			response.getWriter().close();
		}else if("/HuanShuAction".equals(path)){
			JsonObject json = new JsonObject();
			if(request.getParameter("RUID")==null){
				json.addProperty("result", "-1");
				json.addProperty("msg", "参数错误");
			}else{
				int day = new EmployeeBizImpl().huanshuaction(request.getParameter("RUID"));
				System.out.println(day);
				double money = 0;
				if(day>28){
					money = (day - 28)*0.1;
					day = day - 28;
				}else{
					day = 0;
				}
				json.addProperty("result", "0");
				json.addProperty("money", money);
				json.addProperty("msg", "还书成功，逾期"+day+"天，需支付"+money+"元");
			}
				
			response.getWriter().append(json.toString());
			response.getWriter().close();
		}else if("/JieChu".equals(path)){
			int type = 0;
			String keyword = null;
			if(request.getParameter("type")==null){}else{
				type = Integer.valueOf(request.getParameter("type"));
			}
			if(request.getParameter("keyword")==null){}else{
				keyword = request.getParameter("keyword");
			}
			List<Bookrecord> list = null;
			list = new EmployeeBizImpl().bookrecordList(type, keyword);
			JsonObject json = new JsonObject();
			if(list==null){
				json.addProperty("result", "-1");
				json.addProperty("msg", "查询数据失败");
				response.getWriter().append(json.toString());
			}else{
				response.getWriter().append(Tools.json(list));
			}
			response.getWriter().close();
		}else if("/JieChuAction".equals(path)){
			JsonObject json = new JsonObject();
			if(request.getParameter("RUID")==null){
				json.addProperty("result", "-1");
				json.addProperty("msg", "参数错误");
			}else{
				boolean flag = new EmployeeBizImpl().jieshuaction(request.getParameter("RUID"));
				if(flag){
					json.addProperty("result", "0");
					json.addProperty("msg", "借出成功");
				}else{
					json.addProperty("result", "-2");
					json.addProperty("msg", "数据库异常");
				}
			}
				
			response.getWriter().append(json.toString());
			response.getWriter().close();
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
