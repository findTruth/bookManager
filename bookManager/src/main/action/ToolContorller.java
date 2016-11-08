package main.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.tool.Tools;

/**
 * Servlet implementation class ToolContorller
 */
@WebServlet("/tool/*")
public class ToolContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		if ("/VerifyImage".equals(path)) {
			Tools.getVerifyImage(request, response);
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = Tools.cut(request.getRequestURI());
		if ("/adminLogin".equals(path)) {
			
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}

}
