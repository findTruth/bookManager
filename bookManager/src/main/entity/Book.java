package main.entity;

import java.util.Date;

public class Book {
	private String BUID;
	private String NAME;
	private String DATE;
	private String PRESS;
	private String AUTHOR;
	private String VALUE;
	private String KINDNO;
	private String ADDRESS;
	private int STATUS;
	private String PICTURE;
	
	public Book() {
	}
	
	
	public Book(String bUID, String nAME, String dATE, String pRESS, String aUTHOR, String vALUE, String kINDNO,
			String aDDRESS, int sTATUS,String pICTURE) {
		super();
		BUID = bUID;
		NAME = nAME;
		DATE = dATE;
		PRESS = pRESS;
		AUTHOR = aUTHOR;
		VALUE = vALUE;
		KINDNO = kINDNO;
		ADDRESS = aDDRESS;
		STATUS = sTATUS;
		PICTURE =pICTURE;
	}

	public String getBUID() {
		return BUID;
	}
	public void setBUID(String bUID) {
		BUID = bUID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getDATE() {
		return DATE;
	}
	public void setDATE(String dATE) {
		DATE = dATE;
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
	public String getKINDNO() {
		return KINDNO;
	}
	public void setKINDNO(String kINDNO) {
		KINDNO = kINDNO;
	}

	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	public String getPICTURE() {
		return PICTURE;
	}
	public void setPICTURE(String pICTURE) {
		PICTURE = pICTURE;
	}
	
}
