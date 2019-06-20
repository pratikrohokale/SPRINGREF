package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface ListEmployeeService {
	public List<EmployeeDTO>  getAllEmployees();
	public EmployeeDTO  getEmployeeByNo(int no);
	public  String modifyEmployeeByNo(EmployeeDTO dto);
	public String  removeEmployeeByNo(int no);
	public String  register(EmployeeDTO dto);

}
