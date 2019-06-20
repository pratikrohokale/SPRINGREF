package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.ListEmployeeDAO;
import com.nt.dto.EmployeeDTO;

public  class ListEmployeeServiceImpl implements ListEmployeeService {
    private  ListEmployeeDAO dao;
    
	public void setDao(ListEmployeeDAO dao) {
		this.dao = dao;
	}

	public List<EmployeeDTO> getAllEmployees() {
		List<EmployeeDTO> listDTO=null;
		List<EmployeeBO> listBO=null;
		EmployeeDTO dto=null;
		//use DAO
		listBO=dao.retrieveEmployees();
		//Convert ListBO to ListDTO
		listDTO=new ArrayList();
		for(EmployeeBO bo:listBO){
			dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		}
		return listDTO;
	}//method

	public EmployeeDTO getEmployeeByNo(int no) {
		EmployeeBO bo=null;
		EmployeeDTO dto=null;
		//use DAO
		bo=dao.getEmpDetails(no);
		//Convert BO class obj to DTO class object
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}
	
	public String modifyEmployeeByNo(EmployeeDTO dto) {
		 EmployeeBO bo=null;
		 int count=0;
		//Convert DTO to BO 
		 bo=new EmployeeBO();
		 BeanUtils.copyProperties(dto,bo);
		//use DAO
		 count=dao.updateEmployeeByNo(bo);
		 if(count==0)
		    return "Employee Updation Failed";
		 else
			 return "Employee Updation Succeded";
	}
	public String removeEmployeeByNo(int no) {
	   int count=0;
	   //use DAO
	   count=dao.deleteEmployeeByNo(no);
	   if(count==0)
		   return "Employee Not Found for Deletion";
	   else
		   return "Employee Found for Deletion";
	}
	
	@Override
	public String register(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int count=0;
		//Convert DTO to BO
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto,bo);
		//Use DAO
		count=dao.insert(bo);
		if(count==0)
			return "registration failed";
		else
			return "registration succeded";
	}
	
}//class
