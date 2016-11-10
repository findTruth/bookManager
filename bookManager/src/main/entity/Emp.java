package main.entity;

import java.util.Date;

public class Emp {
	private String EUID;
	private String UNAME;
	private String NAME;
	private String PASSWORD;
	private String PHONE;
	private String QQ;
	private String ID;
	private int AGE;
	private Date LASTLOGIN;
	private int QUAN;
	private int STATUS;
	
	public Emp() {
	}
	
	public Emp(String eUID, String uNAME, String nAME, String pASSWORD, String pHONE, String qQ, String iD, int aGE,
			Date lASTLOGIN, int qUAN, int sTATUS) {
		EUID = eUID;
		UNAME = uNAME;
		NAME = nAME;
		PASSWORD = pASSWORD;
		PHONE = pHONE;
		QQ = qQ;
		ID = iD;
		AGE = aGE;
		LASTLOGIN = lASTLOGIN;
		QUAN = qUAN;
		STATUS = sTATUS;
	}
	public String getEUID() {
		return EUID;
	}
	public void setEUID(String eUID) {
		EUID = eUID;
	}
	public String getUNAME() {
		return UNAME;
	}
	public void setUNAME(String uNAME) {
		UNAME = uNAME;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getAGE() {
		return AGE;
	}
	public void setAGE(int aGE) {
		AGE = aGE;
	}
	public Date getLASTLOGIN() {
		return LASTLOGIN;
	}
	public void setLASTLOGIN(Date lASTLOGIN) {
		LASTLOGIN = lASTLOGIN;
	}
	public int getQUAN() {
		return QUAN;
	}
	public void setQUAN(int qUAN) {
		QUAN = qUAN;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	
}
