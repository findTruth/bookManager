package main.entity;

import java.util.Date;

public class BookRecord {
	private String RUID;
	private String BUID;
	private String UUID;
	private Date STARTTIME;
	private Date OVERTIME;
	private int STATUS;
	

	public BookRecord() {
	}
	
	public BookRecord(String rUID, String bUID, String uUID, Date sTARTTIME, Date oVERTIME, int sTATUS) {
		RUID = rUID;
		BUID = bUID;
		UUID = uUID;
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
	public String getBUID() {
		return BUID;
	}
	public void setBUID(String bUID) {
		BUID = bUID;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
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
