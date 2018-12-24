package com.ext.user.po;

import com.ext.util.DatabaseUtils;

public class MyActivityView {

	private int id;
	private String userAct;
	private String imageUrl;
	private String ACTTIME;
	private String ADDRESS;
	private String TOPIC;
	private String DISCRIBE;
	private String PICTURE;
	private int PERSONID;
	private int STATE;
	private String PLAYTIME;
	private String DEADLINE;
	private int LIMITNUMBER;
	private int REMAINNUMBER;
	
	private MyActivityView()
	{
		this.id = DatabaseUtils.INVALID_INT_ID;		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserAct() {
		return userAct;
	}

	public void setUserAct(String userAct) {
		this.userAct = userAct;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getACTTIME() {
		return ACTTIME;
	}

	public void setACTTIME(String aCTTIME) {
		ACTTIME = aCTTIME;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getTOPIC() {
		return TOPIC;
	}

	public void setTOPIC(String tOPIC) {
		TOPIC = tOPIC;
	}

	public String getDISCRIBE() {
		return DISCRIBE;
	}

	public void setDISCRIBE(String dISCRIBE) {
		DISCRIBE = dISCRIBE;
	}

	public String getPICTURE() {
		return PICTURE;
	}

	public void setPICTURE(String pICTURE) {
		PICTURE = pICTURE;
	}

	public int getPERSONID() {
		return PERSONID;
	}

	public void setPERSONID(int pERSONID) {
		PERSONID = pERSONID;
	}

	public int getSTATE() {
		return STATE;
	}

	public void setSTATE(int sTATE) {
		STATE = sTATE;
	}

	public String getPLAYTIME() {
		return PLAYTIME;
	}

	public void setPLAYTIME(String pLAYTIME) {
		PLAYTIME = pLAYTIME;
	}

	public String getDEADLINE() {
		return DEADLINE;
	}

	public void setDEADLINE(String dEADLINE) {
		DEADLINE = dEADLINE;
	}

	public int getLIMITNUMBER() {
		return LIMITNUMBER;
	}

	public void setLIMITNUMBER(int lIMITNUMBER) {
		LIMITNUMBER = lIMITNUMBER;
	}

	public int getREMAINNUMBER() {
		return REMAINNUMBER;
	}

	public void setREMAINNUMBER(int rEMAINNUMBER) {
		REMAINNUMBER = rEMAINNUMBER;
	}

	@Override
	public String toString() {
		return "MyActivityView [id=" + id + ", userAct=" + userAct
				+ ", imageUrl=" + imageUrl + ", ACTTIME=" + ACTTIME
				+ ", ADDRESS=" + ADDRESS + ", TOPIC=" + TOPIC + ", DISCRIBE="
				+ DISCRIBE + ", PICTURE=" + PICTURE + ", PERSONID=" + PERSONID
				+ ", STATE=" + STATE + ", PLAYTIME=" + PLAYTIME + ", DEADLINE="
				+ DEADLINE + ", LIMITNUMBER=" + LIMITNUMBER + ", REMAINNUMBER="
				+ REMAINNUMBER + "]";
	}

	
	
}
