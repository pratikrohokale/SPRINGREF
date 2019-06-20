package com.nt.command;

public class UserCommand {
	private int uid;
	private String uname;
	private String addrs;
	private String mail;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "UserCommand [uid=" + uid + ", uname=" + uname + ", addrs=" + addrs + ", mail=" + mail + "]";
	}
	
	

}
