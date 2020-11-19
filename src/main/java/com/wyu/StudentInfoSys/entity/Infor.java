package com.wyu.StudentInfoSys.entity;

public class Infor {
	private String columnName;   //列名
	private Integer num;        //人数
	
	
	public Infor() {
		super();
	}
	@Override
	public String toString() {
		return "Infor [columnName=" + columnName + ", num=" + num + "]";
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	

	
	
	
}
