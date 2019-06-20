package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.StudentDAO;
import com.nt.domain.SpStudentHLO;
import com.nt.dto.SpStudentDTO;


@Service("stService")
@Transactional(propagation=Propagation.REQUIRED)
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAO dao;

	

	@Override
	public SpStudentDTO getStudentByNo(int no) {
		SpStudentHLO hlo=null;
		SpStudentDTO dto=null;
		//use DAO
		hlo=dao.findStudentByNo(no);
		//Convert HLO to DTO
		dto=new SpStudentDTO();
		BeanUtils.copyProperties(hlo,dto);
		
		return dto;
	}

	@Override
	public String register(SpStudentDTO dto) {
		int idVal=0;
		SpStudentHLO hlo=null;
		hlo=new SpStudentHLO();
		//Convert dto to HLO
		BeanUtils.copyProperties(dto,hlo);
		//use DAO
		idVal=dao.insert(hlo);
		//process the result
		if(idVal<=0)
			return "Registration failed";
		else
			return "Registration succeded:: id-->"+idVal;
	}

	@Override
	public String changeAddrs(int sno, String newAddrs) {
		int count=0;
		//use DAO
		count=dao.update(sno, newAddrs);
		if(count==0)
			return "Student Addrs not modified";
		else
			return "Student Addrs  modified to"+newAddrs;
	}//method

	@Override
	public String fireStudent(int sno) {
		int count=0;
		//use DAO
		count=dao.remove(sno);
		if(count==0)
  		  return "Student not fired";
		else
			return "Student  fired";
	}
	
	@Override
	public List<SpStudentDTO> getStudentsByAddrs(String addrs) {
		final List<SpStudentDTO> listDTO=new ArrayList();
		List<SpStudentHLO> listHLO=null;
		//use DAO
		listHLO=dao.findStudentsByAddrs(addrs);
		//copy listHLO to listDTO
		listHLO.forEach(hlo->{
			SpStudentDTO dto=null;
			dto=new SpStudentDTO();
			BeanUtils.copyProperties(hlo,dto);
			listDTO.add(dto);
		});
		
		return listDTO;
	}//method
	
	@Override
	public List<SpStudentDTO> getStudentsByNames(String name1, String name2) {
		List<SpStudentHLO> listHLO=null;
		final List<SpStudentDTO> listDTO=new ArrayList();
		//use DAO
		listHLO=dao.findStudentsByNames(name1, name2);
		//copy listHLO to listDTO
				listHLO.forEach(hlo->{
					SpStudentDTO dto=null;
					dto=new SpStudentDTO();
					BeanUtils.copyProperties(hlo,dto);
					listDTO.add(dto);
				});
		return listDTO;
	}//method
	
	@Override
	public List<SpStudentDTO> getStudentsByRange(int start, int end) {
		List<SpStudentHLO> listHLO=null;
		final List<SpStudentDTO> listDTO=new ArrayList();
		//use DAO
		listHLO=dao.findStudentByRange(start, end);
		//copy listHLO to listDTO
				listHLO.forEach(hlo->{
					SpStudentDTO dto=null;
					dto=new SpStudentDTO();
					BeanUtils.copyProperties(hlo,dto);
					listDTO.add(dto);
				});
		return listDTO;
	}
	
 @Override
 	public List<SpStudentDTO> fetchStudentsByRange(int start, int end) {
	 List<SpStudentHLO> listHLO=null;
		final List<SpStudentDTO> listDTO=new ArrayList();
		//use DAO
		listHLO=dao.findStudentsByRange(start, end);
		//copy listHLO to listDTO
				listHLO.forEach(hlo->{
					SpStudentDTO dto=null;
					dto=new SpStudentDTO();
					BeanUtils.copyProperties(hlo,dto);
					listDTO.add(dto);
				});
		return listDTO;
 	}//method
 
 @Override
public String deleteStudentsByAddrs(String addrs) {
	 int count=0;
	//use dAO
	 count=dao.deleteStudentsByAddrs(addrs);
	 if(count==0)
	    return "records not found to delete";
	 else
		 return count+" no.of records are deleted";
 }//method
	
}//class
