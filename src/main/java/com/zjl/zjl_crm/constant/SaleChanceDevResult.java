package com.zjl.zjl_crm.constant;

public enum SaleChanceDevResult { 
	
	UN_DEVELOPE(0), // 未开发
	
	DEVELOPING(1), // 开发中
	
	DEVELOPED(2), // 开发成功
	
	DEVELOPED_FAILURE(3); // 开发失败
	
	private SaleChanceDevResult(){}
	
	private SaleChanceDevResult(int type) {
		this.type = type;
	}
	
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
