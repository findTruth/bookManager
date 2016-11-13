package main.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.tool.Tools;
import main.tool.UUIDUtils;


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
			
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	

}
