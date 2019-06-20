package com.nt.command;

import java.util.Date;

public class RegisterCommand {
	private int no;
	private String name;
	private Date dob;
	private Date doj;
	private Date dom;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public Date getDom() {
		return dom;
	}
	public void setDom(Date dom) {
		this.dom = dom;
	}
	
	@Override
	public String toString() {
		return "RegisterCommand [no=" + no + ", name=" + name + ", dob=" + dob + ", doj=" + doj + ", dom=" + dom + "]";
	}
}//class
