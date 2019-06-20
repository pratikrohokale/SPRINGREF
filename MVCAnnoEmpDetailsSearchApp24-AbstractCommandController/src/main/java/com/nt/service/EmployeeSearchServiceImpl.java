package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.bo.EmployeeResultBO;
import com.nt.dao.EmployeeSearchDAO;
import com.nt.dto.EmployeeDTO;
import com.nt.dto.EmployeeResultDTO;

@Service("empSearch")
public class EmployeeSearchServiceImpl implements EmployeeSearchService {
	@Autowired
	private  EmployeeSearchDAO dao;
	
	
	@Override
	public List<EmployeeResultDTO> search(EmployeeDTO dto) {
		List<EmployeeResultDTO> listRDTO=null;
		List<EmployeeResultBO> listRBO=null;
		EmployeeResultDTO rdto=null;
		
		EmployeeBO bo=null;
		//Convert DTO to BO
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		listRBO=dao.find(bo);
		//Convert ListRBO to ListRDTO
		listRDTO=new ArrayList();
		for(EmployeeResultBO rbo:listRBO){
			rdto=new EmployeeResultDTO();
			BeanUtils.copyProperties(rbo,rdto);
			listRDTO.add(rdto);
		}//for
		return listRDTO;
	}//method
}//class
