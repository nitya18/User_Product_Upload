package com.cc2.cc2.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PKey  implements Serializable{
	
    private  Integer BASKET_NUM;
    private Integer HSHD_NUM;
    private Integer PRODUCT_NUM;
    
    
	public Integer getPRODUCT_NUM() {
		return PRODUCT_NUM;
	}
	public void setPRODUCT_NUM(Integer pRODUCT_NUM) {
		PRODUCT_NUM = pRODUCT_NUM;
	}
	public Integer getBASKET_NUM() {
		return BASKET_NUM;
	}
	public void setBASKET_NUM(Integer bASKET_NUM) {
		BASKET_NUM = bASKET_NUM;
	}
	public Integer getHSHD_NUM() {
		return HSHD_NUM;
	}
	public void setHSHD_NUM(Integer hSHD_NUM) {
		HSHD_NUM = hSHD_NUM;
	}
    
    
    /** Your getters and setters **/
}