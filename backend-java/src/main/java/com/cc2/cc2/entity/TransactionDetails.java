package com.cc2.cc2.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "test1")
public class TransactionDetails {
	
	@EmbeddedId
	private PKey pkey;
	private String PURCHASE;	
	private Double SPEND;
	private Double UNITS;
	private String STORE_R;
	private Integer WEEK_NUM;
	private Integer YEAR;
	
	public PKey getPkey() {
		return pkey;
	}
	public void setPkey(PKey pkey) {
		this.pkey = pkey;
	}
	public String getPURCHASE() {
		return PURCHASE;
	}
	public void setPURCHASE(String pURCHASE) {
		PURCHASE = pURCHASE;
	}
	public Double getSPEND() {
		return SPEND;
	}
	public void setSPEND(Double sPEND) {
		SPEND = sPEND;
	}
	public Double getUNITS() {
		return UNITS;
	}
	public void setUNITS(Double uNITS) {
		UNITS = uNITS;
	}
	public String getSTORE_R() {
		return STORE_R;
	}
	public void setSTORE_R(String sTORE_R) {
		STORE_R = sTORE_R;
	}
	public Integer getWEEK_NUM() {
		return WEEK_NUM;
	}
	public void setWEEK_NUM(Integer wEEK_NUM) {
		WEEK_NUM = wEEK_NUM;
	}
	public Integer getYEAR() {
		return YEAR;
	}
	public void setYEAR(Integer yEAR) {
		YEAR = yEAR;
	}
	
	
}
