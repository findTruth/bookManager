package main.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.FileUploadException;  
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import main.biz.impl.BookBizImpl;
import main.biz.impl.ManagerBizImpl;
import main.entity.Book;
import main.tool.Tools;
import main.tool.UUIDUtils;



/**
 * Servlet implementation class BookController
 */
@WebServlet("/book/*")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = Tools.cut(request.getRequestURI());
		// request.getRequestDispatcher("../404.jsp").forward(request,
		// response);
		if ("/bookmanager".equals(path)) {
			request.getRequestDispatcher("../jsp/book/bookList.jsp").forward(request, response);
		} else if ("/bookkindmanager".equals(path)) {

		} else if ("/bookrecordmanager".equals(path)) {

		} else if ("/list".equals(path)) {
			BookBizImpl bbi = new BookBizImpl();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/plain");
			List<Book> list = bbi.bookList();
			response.getWriter().append(Tools.json(list));
		} else if ("/UserBook".equals(path)) {
			request.getRequestDispatcher("../jsp/book/worker.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/plain");
		if ("/borrow".equals(path)) {
			ManagerBizImpl mbi = new ManagerBizImpl();
			try {
				mbi.LastLoginTime(((HashMap<String, String>) request.getSession().getAttribute("emp")).get("MUID"));
			} catch (SQLException e) {
				response.getWriter().append("网络连接异常");
				response.getWriter().close();
			}
			request.getRequestDispatcher("../jsp/emp/borrow.jsp").forward(request, response);
		} else if ("/list".equals(path)) {
			BookBizImpl bbi = new BookBizImpl();
			if (request.getParameter("type") != null) {
				int type = Integer.valueOf(request.getParameter("type"));
			} else {
				int type = 0;
			}
			String keyword = request.getParameter("keyword");
			List<Book> list = bbi.bookList();
			response.getWriter().append(Tools.json(list));
			response.getWriter().close();
		} else if ("/add".equals(path)) {
			
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
		    
	}
	

}
