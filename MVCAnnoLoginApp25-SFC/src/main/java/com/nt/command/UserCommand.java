package com.nt.command;

import java.util.Date;

public class UserCommand {
	private String uname;
	private String pwd;
	private String[] dmns;
	private Date dob;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String[] getDmns() {
		return dmns;
	}

	public void setDmns(String[] dmns) {
		this.dmns = dmns;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
}
