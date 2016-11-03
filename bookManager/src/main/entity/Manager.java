package main.entity;

public class Manager {
	private String MUID;
	private String UNAME;
	private String PASSWORD;
	
	public Manager() {
	}
	
	public Manager(String mUID, String uNAME, String pASSWORD) {
		MUID = mUID;
		UNAME = uNAME;
		PASSWORD = pASSWORD;
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
