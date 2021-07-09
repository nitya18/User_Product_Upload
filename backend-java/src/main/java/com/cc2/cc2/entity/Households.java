package com.cc2.cc2.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "households")
public class Households {
	@Id
	private Integer HSHD_NUM;
	private String L;
	private String AGE_RANGE; 
	private String MARITAL;
	private String INCOME_RANGE;
	private String HOMEOWNER;
	private String HSHD_COMPOSITION;
	private String HH_SIZE;
	private String CHILDREN;
	
	
	public Integer getHSHD_NUM() {
		return HSHD_NUM;
	}
	public void setHSHD_NUM(Integer hSHD_NUM) {
		HSHD_NUM = hSHD_NUM;
	}
	public String getL() {
		return L;
	}
	public void setL(String l) {
		L = l;
	}
	public String getAGE_RANGE() {
		return AGE_RANGE;
	}
	public void setAGE_RANGE(String aGE_RANGE) {
		AGE_RANGE = aGE_RANGE;
	}
	public String getMARITAL() {
		return MARITAL;
	}
	public void setMARITAL(String mARITAL) {
		MARITAL = mARITAL;
	}
	public String getINCOME_RANGE() {
		return INCOME_RANGE;
	}
	public void setINCOME_RANGE(String iNCOME_RANGE) {
		INCOME_RANGE = iNCOME_RANGE;
	}
	public String getHOMEOWNER() {
		return HOMEOWNER;
	}
	public void setHOMEOWNER(String hOMEOWNER) {
		HOMEOWNER = hOMEOWNER;
	}
	public String getHSHD_COMPOSITION() {
		return HSHD_COMPOSITION;
	}
	public void setHSHD_COMPOSITION(String hSHD_COMPOSITION) {
		HSHD_COMPOSITION = hSHD_COMPOSITION;
	}
	public String getHH_SIZE() {
		return HH_SIZE;
	}
	public void setHH_SIZE(String hH_SIZE) {
		HH_SIZE = hH_SIZE;
	}
	public String getCHILDREN() {
		return CHILDREN;
	}
	public void setCHILDREN(String cHILDREN) {
		CHILDREN = cHILDREN;
	}

	

}
