package com.cc2.cc2.entity;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "products")
public class Products {
	
	@Id
	private Integer PRODUCT_NUM;
	private String DEPARTMENT;
	private String COMMODITY; 
	private String BRAND_TY;
	private String NATURAL_ORGANIC_FLAG;

	
	
	public String getBRAND_TY() {
		return BRAND_TY;
	}
	public void setBRAND_TY(String bRAND_TY) {
		BRAND_TY = bRAND_TY;
	}
	public Integer getPRODUCT_NUM() {
		return PRODUCT_NUM;
	}
	public void setPRODUCT_NUM(Integer pRODUCT_NUM) {
		PRODUCT_NUM = pRODUCT_NUM;
	}
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}
	public String getCOMMODITY() {
		return COMMODITY;
	}
	public void setCOMMODITY(String cOMMODITY) {
		COMMODITY = cOMMODITY;
	}
	public String getNATURAL_ORGANIC_FLAG() {
		return NATURAL_ORGANIC_FLAG;
	}
	public void setNATURAL_ORGANIC_FLAG(String nATURAL_ORGANIC_FLAG) {
		NATURAL_ORGANIC_FLAG = nATURAL_ORGANIC_FLAG;
	}
}
