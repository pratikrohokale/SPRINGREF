package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface ListEmployeeDAO {
  public List<EmployeeBO> retrieveEmployees();
  public EmployeeBO  getEmpDetails(int no);
  public int  updateEmployeeByNo(EmployeeBO bo);
  public int deleteEmployeeByNo(int no);
  public int insert(EmployeeBO bo);
}
