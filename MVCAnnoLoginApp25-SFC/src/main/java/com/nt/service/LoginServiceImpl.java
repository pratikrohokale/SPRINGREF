package com.nt.service;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.BeanUtils;

import com.nt.bo.UserBO;
import com.nt.dao.LoginDAO;
import com.nt.dto.UserDTO;

@Named("loginService")
public class LoginServiceImpl implements LoginService {
	@Inject
    private LoginDAO dao;
	
	@Override
	public String authenticate(UserDTO dto) {
		UserBO bo=null;
		int count=0;
		//Convert dto to BO
		bo=new UserBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.validate(bo);
		if(count==0)
		  return "Invalid Credentials";
		else
			return "Valid Credentials";	
	}//authenticate

}//class
