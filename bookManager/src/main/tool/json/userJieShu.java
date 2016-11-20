package main.tool.json;

import java.util.List;

import main.entity.BookRecord;

public class userJieShu {
	public static String getBookRecordPage(List<BookRecord> list){
		StringBuffer sb = new StringBuffer();
		int totalRows = list.size();
		sb.append("{\"totalCount\":\""+totalRows+"\",");  
        sb.append("\"jsonRoot\":[");  
        for (int i=0;i<list.size();i++) {  
        	BookRecord book = (BookRecord)list.get(i);  
            sb.append("{\"BNAME\":\""+ book.getBname());  
            sb.append("\",");    
            sb.append("\"STARTTIME\":\""+ book.getSTARTTIME());
            sb.append("\",");
            sb.append("\"OVERTIME\":\""+ book.getOVERTIME());
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
