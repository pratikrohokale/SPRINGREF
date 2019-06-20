package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
import com.nt.bo.EmployeeResultBO;
@Repository("empDAO")
public class EmployeeSearchDAOImpl implements EmployeeSearchDAO {
	private static final String GET_EMPS_BY_INPUTS="SELECT EMPNO,ENAME,JOB,SAL,MGR,DEPTNO FROM EMP WHERE (EMPNO IS NOT NULL AND EMPNO=?) OR (ENAME IS NOT NULL AND ENAME=?) OR (JOB IS NOT NULL AND JOB=?) OR (SAL IS NOT NULL AND SAL=?)";
	
	@Autowired
	private JdbcTemplate jt;


	@Override
	public List<EmployeeResultBO> find(EmployeeBO bo) {
		List<EmployeeResultBO> listRBO=null;
		listRBO=jt.query(GET_EMPS_BY_INPUTS, new EmpExtractor(), bo.getEno(),bo.getEname(),bo.getDesg(),bo.getSalary());
		return listRBO;
	}
	
	private class EmpExtractor implements ResultSetExtractor<List<EmployeeResultBO>>{

		@Override
		public List<EmployeeResultBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
		    List<EmployeeResultBO> listRBO=null;
		    EmployeeResultBO rbo=null;
		    
		    listRBO=new ArrayList();
		    while(rs.next()){
		     	rbo=new EmployeeResultBO();
		     	rbo.setEno(rs.getInt(1));
		     	rbo.setEname(rs.getString(2));
		     	rbo.setDesg(rs.getString(3));
		     	rbo.setSalary(rs.getInt(4));
		     	rbo.setMgrNo(rs.getInt(5));
		     	rbo.setDeptNo(rs.getInt(6));
		     	listRBO.add(rbo);
		    }//while
			return listRBO;
		}//method
		
	}//inner class
}//outer class
