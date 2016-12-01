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
		} else if ("/upload".equals(path)) {
			try{  
		        final long MAX_SIZE = 3 * 1024 * 1024;// 设置上传文件最大为 3M  
		        // 允许上传的文件格式的列表  
		        final String[] allowedExt = new String[] { "jpg", "jpeg", "gif", "txt",  
		                "doc", "docx", "mp3", "wma", "m4a" };  
		        response.setContentType("text/html");  
		        // 设置字符编码为UTF-8, 这样支持汉字显示  
		        response.setCharacterEncoding("UTF-8");  
		        // 实例化一个硬盘文件工厂,用来配置上传组件ServletFileUpload  
		        DiskFileItemFactory dfif = new DiskFileItemFactory();  
		        dfif.setSizeThreshold(4096);// 设置上传文件时用于临时存放文件的内存大小,这里是4K.多于的部分将临时存在硬盘  
		        dfif.setRepository(new File(request.getRealPath("/")  
		                + "res/book"));// 设置存放临时文件的目录,web根目录下的imgs目录  
		        // 用以上工厂实例化上传组件  
		        ServletFileUpload sfu = new ServletFileUpload(dfif);  
		        // 设置最大上传尺寸  
		        sfu.setSizeMax(MAX_SIZE);  
		        PrintWriter out = response.getWriter();  
		        // 从request得到 所有 上传域的列表  
		        List fileList = null;  
		        try {  
		            fileList = sfu.parseRequest(request);  
		        } catch (FileUploadException e) {// 处理文件尺寸过大异常  
		            if (e instanceof SizeLimitExceededException) {  
		                out.println("文件尺寸超过规定大小:" + MAX_SIZE + "字节<p />");  
		                return;  
		            }  
		            e.printStackTrace();  
		        }  
		        // 没有文件上传  
		        if (fileList == null || fileList.size() == 0) {  
		            out.println("请选择上传文件<p />");  
		            return;  
		        }  
		        // 得到所有上传的文件  
		        Iterator fileItr = fileList.iterator();  
		        // 循环处理所有文件  
		        while (fileItr.hasNext()) {  
		            FileItem fileItem = null;  
		            String path1 = null;  
		            long size = 0;  
		            // 得到当前文件  
		            fileItem = (FileItem) fileItr.next();  
		            // 忽略简单form字段而不是上传域的文件域(<input type="text" />等)  
		            if (fileItem == null || fileItem.isFormField()) {  
		                continue;  
		            }  
		            // 得到文件的完整路径  
		            path1 = fileItem.getName();  
		            // 得到文件的大小  
		            size = fileItem.getSize();  
		            if ("".equals(path1) || size == 0) {  
		                out.println("请选择上传文件<p />");  
		                return;  
		            }  
		            // 得到去除路径的文件名  
		            String t_name = path1.substring(path1.lastIndexOf("//") + 1);  
		            // 得到文件的扩展名(无扩展名时将得到全名)  
		            String t_ext = t_name.substring(t_name.lastIndexOf(".") + 1);  
		            // 拒绝接受规定文件格式之外的文件类型  
		            int allowFlag = 0;  
		            int allowedExtCount = allowedExt.length;  
		            for (; allowFlag < allowedExtCount; allowFlag++) {  
		                if (allowedExt[allowFlag].equals(t_ext))  
		                    break;  
		            }  
		            if (allowFlag == allowedExtCount) {  
		                out.println("请上传以下类型的文件<p />");  
		                for (allowFlag = 0; allowFlag < allowedExtCount; allowFlag++)  
		                    out.println("*." + allowedExt[allowFlag]  + "   ");  
		                return;  
		            }  
		            long now = System.currentTimeMillis();  
		            // 根据系统时间生成上传后保存的文件名  
		            String prefix = String.valueOf(now);  
		            // 保存的最终文件完整路径,保存在web根目录下的ImagesUploaded目录下  
		            String u_name = request.getRealPath("/") + "res/book/"  
		                    + prefix + "." + t_ext;  
		            try {  
		                File file = new File(u_name);  
//		              if(!file.exists()){  
//		                  System.out.print(file.mkdirs());  
//		                  System.out.print(file.mkdir());  
//		              }  
		                // 保存文件  
		                fileItem.write(file);  
		                out.println("文件上传成功. 已保存为: " + prefix + "." + t_ext  
		                        + "   文件大小: " + size + "字节<p />");  
		            } catch (Exception e) {  
		                e.printStackTrace();  
		            }  
		        }  
		        }catch(Exception e){  
		            e.printStackTrace();  
		        }  
		} else {
			request.getRequestDispatcher("../404.jsp").forward(request, response);
		}
	}
	

}
