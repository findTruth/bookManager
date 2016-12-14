package main.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
import main.biz.impl.ManagerBizImpl;
import main.dao.impl.BookDaoImpl;
import main.entity.Book;
import main.tool.Tools;



/**
 * Servlet implementation class BookController
 */
@WebServlet("/book/*")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain"); 
		PrintWriter out =  response.getWriter();
		if ("/bookmanager".equals(path)) {
			request.getRequestDispatcher("../jsp/book/bookList.jsp").forward(request, response);
		} else if ("/bookkindmanager".equals(path)) {
			
		} else if ("/bookrecordmanager".equals(path)) {	
			
		} else if ("/list".equals(path)) {
			String type=request.getParameter("type");
			String content=request.getParameter("Content");
			List<Book> list=new ArrayList<Book>();
			if (type==null) {
				type="";
			}
			if (content==null) {
				content="";
			}
			BookDaoImpl bookdaoimpl=new BookDaoImpl(); 
			JsonObject json = new JsonObject();
			if (type!=""&&content.equals("类别查找")) {
				list=bookdaoimpl.findByKind(type);
				if (list.size()!=0) {
					json.addProperty("totalCount", list.size());
					json.add("jsonRoot", new Gson().toJsonTree(list));
					json.addProperty("msg", "查找成功");				
				}else {
					json.addProperty("msg", "查找失败，该类型的图书暂无");	
				}
				out.append(json.toString());
				out.close();
			}else if(type.equals("名字查找")&&content!=""){
				list=bookdaoimpl.findByName(content);
				if (list.size()!=0) {
					json.addProperty("totalCount", list.size());
					json.add("jsonRoot", new Gson().toJsonTree(list));
					json.addProperty("msg", "查找成功");					
				}else {
					json.addProperty("msg", "查找失败，请仔细想想图书名称或作者");	
				}
				out.append(json.toString());
				out.close();
			}else if(type==""&&content==""){
				list=bookdaoimpl.list();
				json.addProperty("totalCount", list.size());
				json.add("jsonRoot", new Gson().toJsonTree(list));
				out.append(json.toString());
				out.close();
			}else {
				json.addProperty("msg", "查找失败");
				out.append(json.toString());
				out.close();
			}						
		}else if ("/UserBook".equals(path)) {
			request.getRequestDispatcher("../jsp/book/worker.jsp").forward(request, response);

		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());	
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");	
		PrintWriter out =  response.getWriter();
		
		if ("/borrow".equals(path)) {
			ManagerBizImpl mangerbizimpl = new ManagerBizImpl();
			try { 
				mangerbizimpl.LastLoginTime(((HashMap<String, String>)request.getSession().getAttribute("emp")).get("MUID"));

				mangerbizimpl.LastLoginTime(((HashMap<String, String>) request.getSession().getAttribute("emp")).get("MUID"));
			} catch (SQLException e) {
				response.getWriter().append("网络连接异常");
				response.getWriter().close();
			}
			request.getRequestDispatcher("../jsp/emp/borrow.jsp").forward(request, response);
		}else if ("/deletebookhelp".equals(path)) {				
			BookBizImpl bookbizimpl= new BookBizImpl();
			String BUID =request.getParameter("BUID");
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
			response.getWriter().append(new Gson().toJson(book));
			response.getWriter().close();
		}else if ("/add".equals(path)) {
			JsonObject json = Tools.upload(request, response);
			String BADDRESS = json.get("src").getAsString();
			Book book = new Book(Tools.UUID(), request.getParameter("BNAME")
					, null, request.getParameter("BPRESS"), request.getParameter("BAUTHOR")
					, request.getParameter("BVALUE"),
					request.getParameter("BKINDNO"), BADDRESS, 0, BADDRESS);
		}else if ("/UserBook".equals(path)) {
			request.getRequestDispatcher("../jsp/book/worker.jsp").forward(request, response);	
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
		    
	}

}
