package com.nt.command;

public class StudentCommand {
	private String sname;
	private String sadd="hyd";
	
	public StudentCommand() {
		System.out.println("StudentCommand::0-param constructor");
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	
}
