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

import main.biz.impl.BookBizImpl;
import main.biz.impl.EmployeeBizImpl;
import main.biz.impl.ManagerBizImpl;
import main.entity.Book;
import main.entity.Emp;
import main.tool.Tools;
import main.tool.UUIDUtils;


/**
 * Servlet implementation class BookController
 */
@WebServlet("/book/*")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String path = Tools.cut(request.getRequestURI());
//		System.out.println(path);
//		
//		
//	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = Tools.cut(request.getRequestURI());
//		request.getRequestDispatcher("../404.jsp").forward(request, response);
		
		System.out.println(path);
		
		if ("/bookmanager".equals(path)) {
			request.getRequestDispatcher("../jsp/book/bookList.jsp").forward(request, response);
		}else if ("/bookkindmanager".equals(path)) {
			
		}else if ("/bookrecordmanager".equals(path)) {
			
		}else if("/list".equals(path)){
			BookBizImpl bookbizimpl = new BookBizImpl();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/plain"); 
			List<Book> list = bookbizimpl.bookList();
			JsonObject json = new JsonObject();
			json.addProperty("totalCount", list.size());
			json.add("jsonRoot", new Gson().toJsonTree(list));
			response.getWriter().append(json.toString());
		}else if ("/UserBook".equals(path)) {
			request.getRequestDispatcher("../jsp/book/worker.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		System.out.println(path);
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain"); 
		if ("/borrow".equals(path)) {
			ManagerBizImpl mangerbizimpl = new ManagerBizImpl();
			try {
				mangerbizimpl.LastLoginTime(((HashMap<String, String>)request.getSession().getAttribute("emp")).get("MUID"));
			} catch (SQLException e) {
				response.getWriter().append("网络连接异常");
				response.getWriter().close();
			}
			request.getRequestDispatcher("../jsp/emp/borrow.jsp").forward(request, response);
		}else if("/list".equals(path)){
			BookBizImpl bookbizimpl = new BookBizImpl();
			int type = Integer.valueOf(request.getParameter("type"));
			String keyword = request.getParameter("keyword");
			List<Book> list = bookbizimpl.bookList();
			JsonObject json = new JsonObject();
			json.addProperty("totalCount", list.size());
			json.add("jsonRoot", new Gson().toJsonTree(list));
			response.getWriter().append(json.toString());
			
			
		}else if ("/deletebookhelp".equals(path)) {
			
			
			
			
			BookBizImpl bookbizimpl= new BookBizImpl();
			String BUID =request.getParameter("BUID");
			System.out.println(BUID);
			boolean flag=bookbizimpl.deletebookhelp(BUID);
			JsonObject json = new JsonObject();
			if (flag) {
				json.addProperty("msg", "删除成功");
			}else{
				json.addProperty("msg", "删除失败");
		}
			out.print(json.toString());
		    out.close();
		}else if("/findById".equals(path)){
			
			String BUID = request.getParameter("BUID");
			
			Book book = new BookBizImpl().findById(BUID);
			
			System.out.println(book.getNAME()+"55555");
			response.getWriter().append(new Gson().toJson(book));
			response.getWriter().close();
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
		    
	}

}
