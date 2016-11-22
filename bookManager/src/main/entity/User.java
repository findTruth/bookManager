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
	private int SEX;
	private String ATION1;
	private String ATION2;
	private String ATION3;
	
	public int getSEX() {
		return SEX;
	}

	public void setSEX(int sEX) {
		SEX = sEX;
	}

	

	public String getATION1() {
		return ATION1;
	}

	public void setATION1(String aTION1) {
		ATION1 = aTION1;
	}

	public String getATION2() {
		return ATION2;
	}

	public void setATION2(String aTION2) {
		ATION2 = aTION2;
	}

	public String getATION3() {
		return ATION3;
	}

	public void setATION3(String aTION3) {
		ATION3 = aTION3;
	}

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
