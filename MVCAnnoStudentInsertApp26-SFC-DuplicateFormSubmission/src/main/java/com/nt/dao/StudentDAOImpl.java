package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.StudentBO;

@Repository("stDAO")
public class StudentDAOImpl implements StudentDAO {
	private static final String STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(?,?,?)";
	private static final String STNO_SEQ_QUERY="SELECT STNO_SEQ.NEXTVAL FROM DUAL";
	@Autowired
	private JdbcTemplate jt;

	private int getStudentNoUsingSequence(){
		int no=0;
		no=jt.queryForObject(STNO_SEQ_QUERY,Integer.class);
		return no;
	}

	@Override
	public int insert(StudentBO bo) {
		int count=0;
		count=jt.update(STUDENT_INSERT_QUERY,getStudentNoUsingSequence(),bo.getSname(),bo.getSadd());
		return count;
	}
}//class
