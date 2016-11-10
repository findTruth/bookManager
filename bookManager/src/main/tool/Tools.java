package main.tool;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.util.resources.CalendarData;


public class Tools {
	public final static String cut(String uri){
		return uri.substring(uri.lastIndexOf("/"),uri.lastIndexOf("."));
	}
	public final static String MD5(String pwd){
		return MD5Tools.MD5("bookManager@jerry"+pwd);
	}
	public final static String UUID(){
		return UUIDUtils.createUUID();
	}
	public final static boolean getVerifyImage(HttpServletRequest request,HttpServletResponse response){
		try {
			VerifyImage.getImage(request, response);
		} catch (Exception e) {
			return false;
		}
		return true;
		
	}
	
	public final static String getDate(){
		Calendar c1 = Calendar.getInstance();
        c1.setTime(new Date());
		return c1.getTime().toString();
	}
	
	public final static String formatDate(Date date){
		System.out.println(date.getTime());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (date!=null) {
			return format.format(date);
		} else {
			return "无数据";
		}
	}
	
}
