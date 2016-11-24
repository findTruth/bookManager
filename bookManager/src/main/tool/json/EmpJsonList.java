package main.tool.json;

import java.util.List;

import main.entity.Emp;

public class EmpJsonList {
	public static String getEmpPage(List<Emp> list){
		StringBuffer sb = new StringBuffer();
		int totalRows = list.size();
		sb.append("{\"totalCount\":\""+totalRows+"\",");  
        sb.append("\"jsonRoot\":[");  
        for (int i=0;i<list.size();i++) {  
        	Emp emp = (Emp)list.get(i);  
            sb.append("{\"EUID\":\""+ emp.getEUID());  
            sb.append("\",");
            sb.append("\"UNAME\":\""+ emp.getUNAME());  
            sb.append("\",");
            sb.append("\"NAME\":\""+ emp.getNAME());  
            sb.append("\",");
            sb.append("\"PASSWORD\":\""+ emp.getPASSWORD());  
            sb.append("\",");
            sb.append("\"PHONE\":\""+ emp.getPHONE());  
            sb.append("\",");
            sb.append("\"QQ\":\""+ emp.getQQ());  
            sb.append("\",");
            sb.append("\"ID\":\""+ emp.getID());  
            sb.append("\",");
            sb.append("\"AGE\":\""+ emp.getAGE());  
            sb.append("\",");
            sb.append("\"LASTLOGIN\":\""+ emp.getLASTLOGIN());  
            sb.append("\",");
            sb.append("\"QUANNUM\":\""+ emp.getQUAN());
            sb.append("\",");
            switch(emp.getQUAN()){
	            case 0 :sb.append("\"QUAN\":\""+ "普通权限"); break;
	            case 1 :sb.append("\"QUAN\":\""+ "图书录入和修改权限"); break;
	            case 2 :sb.append("\"QUAN\":\""+ "图书管理权限"); break;
	            case 3 :sb.append("\"QUAN\":\""+ "用户修改权限"); break;
	            case 4 :sb.append("\"QUAN\":\""+ "用户管理权限"); break;
            }
              
            sb.append("\",");
            sb.append("\"STATUSNUM\":\""+ emp.getSTATUS());
            sb.append("\",");
            switch(emp.getSTATUS()){
            case 0 :sb.append("\"STATUS\":\""+ "未上线"); break;
            case 1 :sb.append("\"STATUS\":\""+ "是上班中"); break;
            case 2 :sb.append("\"STATUS\":\""+ "封号"); break;
         }
            
            sb.append("\"");
            sb.append("},");
        }  
        sb.deleteCharAt(sb.lastIndexOf(","));  // 删去最后一个逗号  
        sb.append("]}");  
		return sb.toString();
	}
}
