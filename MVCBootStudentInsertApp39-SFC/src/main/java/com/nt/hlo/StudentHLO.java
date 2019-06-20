package com.nt.hlo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Student")
public class StudentHLO {
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	private int sno;
	private String sname;
	private String sadd;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
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
	@Override
	public String toString() {
		return "StudentHLO [sno=" + sno + ", sname=" + sname + ", sadd=" + sadd + "]";
	}
	
	
	

}
