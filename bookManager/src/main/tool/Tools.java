package main.tool;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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
	
	
	
	public final static String formatDate(Date date){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (date!=null) {
			return format.format(date);
		} else {
			return "无数据";
		}
	}
	
	public final static String json(List<Object> list){
		JsonObject json = new JsonObject();
		json.addProperty("totalCount", list.size());
		json.add("jsonRoot", new Gson().toJsonTree(list));
		return json.toString();
	}
}
