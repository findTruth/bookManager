package main.javaBean;

import java.util.Date;

public class Bookrecord {
	private String Bname;
	private Date STARTTIME;
	private Date OVERTIME;
	private int STATUS;
	public Bookrecord(){}
	
	public Bookrecord(String bname, Date sTARTTIME, Date oVERTIME, int sTATUS) {
		Bname = bname;
		STARTTIME = sTARTTIME;
		OVERTIME = oVERTIME;
		STATUS = sTATUS;
	}
	public String getBname() {
		return Bname;
	}
	public void setBname(String bname) {
		Bname = bname;
	}
	public Date getSTARTTIME() {
		return STARTTIME;
	}
	public void setSTARTTIME(Date sTARTTIME) {
		STARTTIME = sTARTTIME;
	}
	public Date getOVERTIME() {
		return OVERTIME;
	}
	public void setOVERTIME(Date oVERTIME) {
		OVERTIME = oVERTIME;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
}
