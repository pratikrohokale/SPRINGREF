package com.nt.command;

public class RegisterCommand {
	private String name;
	private String addrs;
	private int age;
	private String domain;
	private int experience;
	private int expectedSalary;
	private String prefferedLocation;
	public RegisterCommand() {
		System.out.println("RegisterCommand::0-param constructor");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getExpectedSalary() {
		return expectedSalary;
	}
	public void setExpectedSalary(int expectedSalary) {
		this.expectedSalary = expectedSalary;
	}
	public String getPrefferedLocation() {
		return prefferedLocation;
	}
	public void setPrefferedLocation(String prefferedLocation) {
		this.prefferedLocation = prefferedLocation;
	}
	
	@Override
	public String toString() {
		return "RegisterCommand [name=" + name + ", addrs=" + addrs + ", age=" + age + ", domain=" + domain
				+ ", experience=" + experience + ", expectedSalary=" + expectedSalary + ", prefferedLocation="
				+ prefferedLocation + "]";
	}
	

}
