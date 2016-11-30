package main.javaBean;

import java.util.Date;

public class Bookrecord {
	private String RUID;
	private String Bname;
	private String STARTTIME;
	private String OVERTIME;
	private int STATUS;
	public Bookrecord(){}
	
	public Bookrecord(String rUID,String bname, String sTARTTIME, String oVERTIME, int sTATUS) {
		RUID=rUID;
		Bname = bname;
		STARTTIME = sTARTTIME;
		OVERTIME = oVERTIME;
		STATUS = sTATUS;
	}
	public String getRUID() {
		return RUID;
	}

	public void setRUID(String rUID) {
		RUID = rUID;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public String getSTARTTIME() {
		return STARTTIME;
	}
	public void setSTARTTIME(String sTARTTIME) {
		STARTTIME = sTARTTIME;
	}
	public String getOVERTIME() {
		return OVERTIME;
	}
	public void setOVERTIME(String oVERTIME) {
		OVERTIME = oVERTIME;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
}
