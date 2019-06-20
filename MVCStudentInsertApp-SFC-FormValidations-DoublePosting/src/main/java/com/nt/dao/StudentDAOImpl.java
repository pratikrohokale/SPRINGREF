package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?)";
	private static final String GET_STUDENT_NO="SELECT STID_SEQ.NEXTVAL FROM DUAL";
	
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	private int fetchSno(){
		int no=0;
		no=jt.queryForObject(GET_STUDENT_NO, Integer.class);
		return no;
	}

	@Override
	public int insert(StudentBO bo) {
		int count=0;
		count=jt.update(STUDENT_INSERT_QUERY,fetchSno(),bo.getSname(),bo.getSadd());
		return count;
	}
}//class
