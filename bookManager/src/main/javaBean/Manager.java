package main.javaBean;

import java.util.HashMap;

import main.tool.Tools;

public class Manager {
	
	private HashMap<String, String> map = new HashMap<>();
	
	public HashMap<String, String> getHashmap(){
		return map;
	}
	
	public Manager(main.entity.Manager manager) {
		map.put("MUID", manager.getMUID());
		map.put("UNAME", manager.getUNAME());
		map.put("PASSWORD", manager.getPASSWORD());
		map.put("EMAIL", manager.getEMAIL());
		map.put("LASTLOGINTIME", Tools.formatDate(manager.getLASTLOGINTIME()));
	}
	
}
