package com.nt.service;

import org.springframework.beans.BeanUtils;

import com.nt.bo.RegisterBO;
import com.nt.dao.NaukriRegistrationDAO;
import com.nt.dto.RegisterDTO;

public class NaukriRegistrationServiceImpl implements NaukriRegistrationService {
  


private NaukriRegistrationDAO dao;

public void setDao(NaukriRegistrationDAO dao) {
	this.dao = dao;
}
   
   
	@Override
	public String register(RegisterDTO dto) {
		RegisterBO bo=null;
		int regId=0;
      //Convert DTO to BO
		bo=new RegisterBO();
		BeanUtils.copyProperties(dto,bo);
		//use dAO
		regId=dao.saveData(bo);
		
		return "Student is registered with "+regId;
	}

}
