package com.log4h.singletontrip.a.example;

public class ExampleVo {
	
	private int tableNo;
	private String tableName;
	
	public int getTableNo() {
		return tableNo;
	}
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	@Override
	public String toString() {
		return "ExampleVO [tableNo=" + tableNo + ", tableName=" + tableName + "]";
	}

}
