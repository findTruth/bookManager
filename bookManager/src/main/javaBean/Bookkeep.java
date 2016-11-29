package main.javaBean;

import java.util.Date;

public class Bookkeep {
	private String KUID;
	private String NAME;
	private String PRESS;
	private String AUTHOR;
	private String VALUE;
	private Date TIME;
	public Bookkeep() {	
	}
	
	

	public Bookkeep(String kUID, String nAME, String pRESS, String aUTHOR, String vALUE, Date tIME) {
		super();
		KUID = kUID;
		NAME = nAME;
		PRESS = pRESS;
		AUTHOR = aUTHOR;
		VALUE = vALUE;
		TIME = tIME;
	}



	public String getKUID() {
		return KUID;
	}



	public void setKUID(String tUID) {
		KUID = tUID;
	}



	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPRESS() {
		return PRESS;
	}
	public void setPRESS(String pRESS) {
		PRESS = pRESS;
	}
	public String getAUTHOR() {
		return AUTHOR;
	}
	public void setAUTHOR(String aUTHOR) {
		AUTHOR = aUTHOR;
	}
	public String getVALUE() {
		return VALUE;
	}
	public void setVALUE(String vALUE) {
		VALUE = vALUE;
	}
	public Date getTIME() {
		return TIME;
	}
	public void setTIME(Date tIME) {
		TIME = tIME;
	}
	
}
