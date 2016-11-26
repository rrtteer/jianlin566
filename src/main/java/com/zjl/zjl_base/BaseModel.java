package com.zjl.zjl_base;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
public class BaseModel implements Serializable {
	
    private Integer isValid;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date createDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date updateDate;
    
	public Integer getIsValid() {
		return isValid;
	}
	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
