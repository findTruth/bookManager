package main.tool.json;

import java.util.HashMap;
import java.util.Iterator;

public class JsonObject {
	private HashMap<String, String> map = new HashMap<>();
	private StringBuffer sb = new StringBuffer();
	public void put(String key,String value){
		map.put(key, value);
	}
	public String getJSON(){
		Iterator<String> set = map.keySet().iterator();
		String a;
		sb.append("{");
		while (set.hasNext()) {
			a = set.next();
			sb.append("\""+a+"\":\""+ map.get(a));  
            sb.append("\",");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));  // 删去最后一个逗号  
        sb.append("}");
		return sb.toString();
	}
}
