package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.nt.bo.EmployeeBO;


public class ListEmployeeDAOImpl implements ListEmployeeDAO {
  private static final String GET_ALL_EMPS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP";
  private static final String GET_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
  private static final String UPDATE_EMP_BY_NO="UPDATE EMP SET ENAME=?,JOB=?,SAL=? WHERE EMPNO=?";
  private static final String  DELETE_EMP_BY_NO="DELETE FROM EMP WHERE EMPNO=?";
  private static final String  GET_EMPNO_BY_SEQ="SELECT EMPNO_SEQ.NEXTVAL FROM DUAL";
  private static final String INSERT_EMP="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(?,?,?,?)";
  private JdbcTemplate jt;
  
  public void setJt(JdbcTemplate jt) {
	this.jt = jt;
}

public List<EmployeeBO> retrieveEmployees() {
	List<EmployeeBO> listBO=null;
	listBO=jt.query(GET_ALL_EMPS, new EmpListExtractor());
		return listBO;
	}//method

 private class EmpListExtractor implements ResultSetExtractor<List<EmployeeBO>>{

	public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
		 List<EmployeeBO> listBO=null;
		 EmployeeBO bo=null;
		 listBO=new ArrayList();
		//Copy ResultSet obj records to ListBO
		 while(rs.next()){
			 bo=new EmployeeBO();
			 //copy each record to 1 BO class object
			 bo.setEno(rs.getInt(1));
			 bo.setEname(rs.getString(2));
			 bo.setDesg(rs.getString(3));
			 bo.setSalary(rs.getInt(4));
			 //Add BO obj ListBO
			 listBO.add(bo);
		 }//while
		return listBO;
	}//method
 }//inner class
 
 public EmployeeBO getEmpDetails(int no) {
	 EmployeeBO bo=null;
	 //execute Query
	 bo=jt.queryForObject(GET_EMP_BY_NO, new EmployeeRowMapper(), no);
	 return bo;
	}
 private class EmployeeRowMapper implements RowMapper<EmployeeBO>{

	public EmployeeBO mapRow(ResultSet rs, int index) throws SQLException {
		 EmployeeBO bo=null;
	  //Copy the record of ResultObjct to BOm class object
		 bo=new EmployeeBO();
		 bo.setEno(rs.getInt(1));
		 bo.setEname(rs.getString(2));
		 bo.setDesg(rs.getString(3));
		 bo.setSalary(rs.getInt(4));
		return bo;
	}//mapRow(-,-)
   }//inner class
 
   public int updateEmployeeByNo(EmployeeBO bo) {
	 int count=0;
	 count=jt.update(UPDATE_EMP_BY_NO,bo.getEname(),bo.getDesg(),bo.getSalary(),bo.getEno());
		return count;
	}
   
   public int deleteEmployeeByNo(int no) {
	 int count=0;
	 count=jt.update(DELETE_EMP_BY_NO,no);
		return count;
	}
   
   private int fetchEmpNo(){
		int no=0;
		no=jt.queryForObject(GET_EMPNO_BY_SEQ, Integer.class);
		return no;
	}

   
	@Override
	public int insert(EmployeeBO bo) {
		int count=0;
		count=jt.update(INSERT_EMP,fetchEmpNo(),bo.getEname(),bo.getDesg(),bo.getSalary());
		return count;
	}
   
 
 }//outer class
