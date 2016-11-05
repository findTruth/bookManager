package main.tool;

import java.util.List;

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
	
}
