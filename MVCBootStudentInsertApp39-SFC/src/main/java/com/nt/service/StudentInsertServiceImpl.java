package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.StudentInsertDAO;
import com.nt.dto.StudentDTO;
import com.nt.hlo.StudentHLO;

@Service("stService")
@Transactional(propagation=Propagation.REQUIRED,readOnly=false,transactionManager="hbTxMgmr")
public class StudentInsertServiceImpl implements StudentInsertService {
    @Autowired
	private StudentInsertDAO dao;
    
	@Override
	public String registerStudent(StudentDTO dto) {
		System.out.println(dto);
		StudentHLO hlo=null;
		int id=0;
		//Convert DTO to HLO
		hlo=new StudentHLO();
		//BeanUtils.copyProperties(dto,hlo);
		hlo.setSname(dto.getSname());
		hlo.setSadd(dto.getSadd());
		//use DAO
		id=dao.insert(hlo);
		if(id<=0)
			return "registration failed";
		else
			return id+" student registered successfully"; 
	}
}
