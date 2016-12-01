package main.javaBean;

public class UserBen {
	private String UUID;
	private String PHONE;
	private String EMAIL;
	private String NICNAME;
	private String Action;
	private int SEX;
	private int STATUS;
	private String LOGINTIME;
	
	public UserBen() {
		
	}
	public UserBen(String uUID, String pHONE, String eMAIL, String nICNAME, String action, int sEX, int sTATUS,
			String lOGINTIME) {
		UUID = uUID;
		PHONE = pHONE;
		EMAIL = eMAIL;
		NICNAME = nICNAME;
		Action = action;
		SEX = sEX;
		STATUS = sTATUS;
		LOGINTIME = lOGINTIME;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getNICNAME() {
		return NICNAME;
	}
	public void setNICNAME(String nICNAME) {
		NICNAME = nICNAME;
	}
	public String getAction() {
		return Action;
	}
	public void setAction(String action) {
		Action = action;
	}
	public int getSEX() {
		return SEX;
	}
	public void setSEX(int sEX) {
		SEX = sEX;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	public String getLOGINTIME() {
		return LOGINTIME;
	}
	public void setLOGINTIME(String lOGINTIME) {
		LOGINTIME = lOGINTIME;
	}
	
}
