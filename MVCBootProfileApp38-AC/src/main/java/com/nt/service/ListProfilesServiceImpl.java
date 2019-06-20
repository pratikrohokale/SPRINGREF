package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.service.ListProfilesService;
import com.nt.bo.ProfileBO;
import com.nt.dao.ListProfileDAOImpl;
import com.nt.dao.ListProfilesDAO;
import com.nt.dto.ProfileDTO;

@Service("profileService")
public class ListProfilesServiceImpl implements ListProfilesService {
	@Autowired
 private ListProfilesDAO dao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,transactionManager="dsTxMgmr",readOnly=true)
	public List<ProfileDTO> getProfiles() {
		List<ProfileBO> listBO=null;
		List<ProfileDTO> listDTO=new ArrayList();
		
		//use DAO
		listBO=dao.getAllProfiles();
		//Copy ListBO to ListDTO
		listBO.forEach(bo->{
			ProfileDTO dto=null;
			dto=new ProfileDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}

}
