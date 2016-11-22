package main.tool.json;

import java.util.List;

import main.entity.Book;

public class BookJsonList {
	public static String getBookPage(List<Book> list){
		StringBuffer sb = new StringBuffer();
		int totalRows = list.size();
		sb.append("{\"totalCount\":\""+totalRows+"\",");  
        sb.append("\"jsonRoot\":[");  
        for (int i=0;i<list.size();i++) {  
        	Book book = (Book)list.get(i);  
            sb.append("{\"BUID\":\""+ book.getBUID());  
            sb.append("\",");    
            sb.append("\"NAME\":\""+ book.getNAME());
            sb.append("\",");
            sb.append("\"DATE\":\""+ book.getDATE());
            sb.append("\",");
            sb.append("\"PRESS\":\""+ book.getPRESS());
            sb.append("\",");
            sb.append("\"AUTHOR\":\""+ book.getAUTHOR());
            sb.append("\",");
            sb.append("\"VALUE\":\""+ book.getVALUE());
            sb.append("\",");
            sb.append("\"KINDNO\":\""+ book.getKINDNO());
            sb.append("\",");
            sb.append("\"STATUS\":\""+ book.getSTATUS());
            sb.append("\"");
            sb.append("},");
        }  
        sb.deleteCharAt(sb.lastIndexOf(","));  // 删去最后一个逗号  
        sb.append("]}");  
		return sb.toString();
	}
}
