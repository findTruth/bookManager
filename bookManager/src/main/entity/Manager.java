package main.entity;

import java.sql.Date;

public class Manager {
	private String MUID;
	private String UNAME;
	private String PASSWORD;
	private String EMAIL;
	private Date LASTLOGINTIME;
	
	public Manager() {
	}
	
	
	
	
	public Manager(String mUID, String uNAME, String pASSWORD, String eMAIL, Date lASTLOGINTIME) {
		super();
		MUID = mUID;
		UNAME = uNAME;
		PASSWORD = pASSWORD;
		EMAIL = eMAIL;
		LASTLOGINTIME = lASTLOGINTIME;
	}




	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public Date getLASTLOGINTIME() {
		return LASTLOGINTIME;
	}

	public void setLASTLOGINTIME(Date lASTLOGINTIME) {
		LASTLOGINTIME = lASTLOGINTIME;
	}

	public String getMUID() {
		return MUID;
	}
	public void setMUID(String mUID) {
		MUID = mUID;
	}
	public String getUNAME() {
		return UNAME;
	}
	public void setUNAME(String uNAME) {
		UNAME = uNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
}
