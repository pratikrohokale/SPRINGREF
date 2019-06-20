package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.ListEmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class ListEmployeeServiceImpl implements ListEmployeeService {
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
}//class
