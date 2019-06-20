package com.nt.command;

import java.util.Date;


import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserCommand {
	@NotEmpty(message="username is mandatory")
	private String uname;
	@NotEmpty(message="password is required")
	@Size(min=4,max=10,message="password should have proper length")
	private String pwd;

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

}
