package com.wyu.StudentInfoSys.entity;

public class Student {
	private int id;                 //序号
	private String studentNumber;  //学号
	private String name;           //姓名
	private String birth;          //出生年月
	private String sex;            //男
	private String className;     //姓名
	private String phoneNumber;   //手机号码
	private String department;   //系部
	private String photo;       //照片
	private String entryTime;
	
	


	@Override
	public String toString() {
		return "Student [id=" + id + ", studentNumber=" + studentNumber + ", name=" + name + ", birth=" + birth
				+ ", sex=" + sex + ", className=" + className + ", phoneNumber=" + phoneNumber + ", department="
				+ department + ", photo=" + photo + ", entryTime=" + entryTime + "]";
	}
	public String getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Student() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
}
