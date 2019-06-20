package com.nt.command;

import java.util.Arrays;

public class ReferenceDataCommand {
	private String name;
	private String addrs;
	private String country;
	private String[] hobies;
	private String[] courses;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String[] getHobies() {
		return hobies;
	}
	public void setHobies(String[] hobies) {
		this.hobies = hobies;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
	
	@Override
	public String toString() {
		return "ReferenceDataCommand [name=" + name + ", addrs=" + addrs + ", country=" + country + ", hobies="
				+ Arrays.toString(hobies) + ", courses=" + Arrays.toString(courses) + "]";
	}

}
