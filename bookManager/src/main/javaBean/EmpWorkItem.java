package main.javaBean;

import java.util.Date;

public class EmpWorkItem {
	private String WEUID;
	private String EUID;
	private Date TIME;
	private String ENAME;
	
	
	public EmpWorkItem() {
	}


	public EmpWorkItem(String wEUID, String eUID, Date tIME, String eNAME) {
		WEUID = wEUID;
		EUID = eUID;
		TIME = tIME;
		ENAME = eNAME;
	}


	public String getWEUID() {
		return WEUID;
	}


	public void setWEUID(String wEUID) {
		WEUID = wEUID;
	}


	public String getEUID() {
		return EUID;
	}


	public void setEUID(String eUID) {
		EUID = eUID;
	}


	public Date getTIME() {
		return TIME;
	}


	public void setTIME(Date tIME) {
		TIME = tIME;
	}


	public String getENAME() {
		return ENAME;
	}


	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}
	
	
}
