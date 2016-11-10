package main.entity;

public class User {
	private String UUID;
	private String PHONE;
	private String EMAIL;
	private String PASSWORD;
	private String ANSWER;
	private String QUESTION;
	private String NICNAME;
	private String UNAME;
	private int STATUS;
	
	
	public User() {
		
	}
	
	public User(String pHONE, String eMAIL, String pASSWORD, String aNSWER, String qUESTION) {
		super();
		PHONE = pHONE;
		EMAIL = eMAIL;
		PASSWORD = pASSWORD;
		ANSWER = aNSWER;
		QUESTION = qUESTION;
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
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getANSWER() {
		return ANSWER;
	}
	public void setANSWER(String aNSWER) {
		ANSWER = aNSWER;
	}
	public String getNICNAME() {
		return NICNAME;
	}
	public void setNICNAME(String nICNAME) {
		NICNAME = nICNAME;
	}
	public String getUNAME() {
		return UNAME;
	}
	public void setUNAME(String uNAME) {
		UNAME = uNAME;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	public String getQUESTION() {
		return QUESTION;
	}
	public void setQUESTION(String qUESTION) {
		QUESTION = qUESTION;
	}

	
}
