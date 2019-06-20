package com.nt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="spStudent")
@NamedQueries(value={@NamedQuery(name="GET_ALL_STUDENTS_BY_RANGE", query = "FROM SpStudentHLO WHERE sno>=? AND sno<=?"),
                     @NamedQuery(name="GET_STUDENTS_BY_RANGE",query=" FROM SpStudentHLO  WHERE sno>=:start AND sno<=:end"),
                     @NamedQuery(name="DELETE_STUDENTS_BY_ADDRS",query="DELETE FROM  SpStudentHLO WHERE sadd=:addrs")
                     })

public class SpStudentHLO {
	@Id
	@Column(name="sno")
	private int sno;
	@Column(name="sname")
	private String sname;
	@Column(name="sadd")
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
}
