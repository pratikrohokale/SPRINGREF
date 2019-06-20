package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.LoginDAO;
import com.nt.domain.UserHLO;
import com.nt.dto.UserDTO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
     @Autowired
	private LoginDAO dao;
	
	@Override
	public String authenticate(UserDTO dto) {
		UserHLO hlo=null;
		long count=0;
		//Convert DTO to HLO
		hlo=new UserHLO();
		BeanUtils.copyProperties(dto,hlo);
		//use DAO
		count=dao.validate(hlo);
		if(count==0)
		  return "Invalid Credentials";
		else
		  return "Valid Credentials";	
	}

}
