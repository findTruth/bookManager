package main.entity;

public class User {
	private String UUID;
	private String UNAME;
	private String NICNAME;
	private String PASSWORD;
	private String PHONE;
	private String QQ;
	private int STATUS;
	
	public User() {
	}
	
	public User(String uUID, String uNAME, String nICNAME, String pASSWORD, String pHONE, String qQ, int sTATUS) {
		UUID = uUID;
		UNAME = uNAME;
		NICNAME = nICNAME;
		PASSWORD = pASSWORD;
		PHONE = pHONE;
		QQ = qQ;
		STATUS = sTATUS;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getUNAME() {
		return UNAME;
	}
	public void setUNAME(String uNAME) {
		UNAME = uNAME;
	}
	public String getNICNAME() {
		return NICNAME;
	}
	public void setNICNAME(String nICNAME) {
		NICNAME = nICNAME;
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
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	
}
