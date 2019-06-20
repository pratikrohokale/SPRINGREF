package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

@Service("stService")
public class StudentServiceImpl implements StudentService {
     @Autowired
	private StudentDAO dao;

	

	@Override
	public String register(StudentDTO dto) {
		int count=0;
		StudentBO bo=null;
		//convert dto to BO
		bo=new StudentBO();
		BeanUtils.copyProperties(dto,bo);
      //use DAO
		count=dao.insert(bo);
		//generate result
		if(count==0)
			return "Registration Failed";
		else
			return "Registration succeded";	
	}
}
