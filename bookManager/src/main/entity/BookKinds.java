package main.entity;

public class BookKinds {
	private String KINDNO;
	private String KINDNAME;
	
	public BookKinds() {
	}
	
	public BookKinds(String kINDNO, String kINDNAME) {
		KINDNO = kINDNO;
		KINDNAME = kINDNAME;
	}
	public String getKINDNO() {
		return KINDNO;
	}
	public void setKINDNO(String kINDNO) {
		KINDNO = kINDNO;
	}
	public String getKINDNAME() {
		return KINDNAME;
	}
	public void setKINDNAME(String kINDNAME) {
		KINDNAME = kINDNAME;
	}
	
}
