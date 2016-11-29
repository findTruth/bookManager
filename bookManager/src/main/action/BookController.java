package main.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.biz.impl.BookBizImpl;
import main.biz.impl.ManagerBizImpl;
import main.tool.Tools;
import main.tool.UUIDUtils;
import main.tool.json.BookJsonList;


/**
 * Servlet implementation class BookController
 */
@WebServlet("/book/*")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = Tools.cut(request.getRequestURI());
//		request.getRequestDispatcher("../404.jsp").forward(request, response);
		if ("/bookmanager".equals(path)) {
			request.getRequestDispatcher("../jsp/book/bookList.jsp").forward(request, response);
		}else if ("/bookkindmanager".equals(path)) {
			
		}else if ("/bookrecordmanager".equals(path)) {
			
		}else if("/list".equals(path)){
			BookBizImpl bbi = new BookBizImpl();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/plain"); 
			response.getWriter().append(BookJsonList.getBookPage(bbi.bookList()));
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		if ("/borrow".equals(path)) {
			ManagerBizImpl mbi = new ManagerBizImpl();
			try {
				mbi.LastLoginTime(((HashMap<String, String>)request.getSession().getAttribute("emp")).get("MUID"));
			} catch (SQLException e) {
				response.getWriter().append("网络连接异常");
				response.getWriter().close();
			}
			request.getRequestDispatcher("../jsp/emp/borrow.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}
	

}
