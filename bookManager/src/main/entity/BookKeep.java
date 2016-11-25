package main.entity;

import java.util.Date;

public class BookKeep {
	private String KUID;
	private String UUID;
	private String BUID;
	private Date TIME;
	public BookKeep() {	
	}
	
	
	public BookKeep(String kUID, String uUID, String bUID, Date tIME) {
		KUID = kUID;
		UUID = uUID;
		BUID = bUID;
		TIME = tIME;
	}


	public String getKUID() {
		return KUID;
	}
	public void setKUID(String kUID) {
		KUID = kUID;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getBUID() {
		return BUID;
	}
	public void setBUID(String bUID) {
		BUID = bUID;
	}
	public Date getTIME() {
		return TIME;
	}
	public void setTIME(Date tIME) {
		TIME = tIME;
	}
	
	
}
