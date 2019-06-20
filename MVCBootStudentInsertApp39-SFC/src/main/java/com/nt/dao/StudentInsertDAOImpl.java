package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.hlo.StudentHLO;

@Repository("stDAO")
public class StudentInsertDAOImpl implements StudentInsertDAO {
	@Autowired
   private HibernateTemplate ht;
	
	@Override
	public int insert(StudentHLO hlo) {
		int id=0;
		ht.setCheckWriteOperations(false);
		id=(int)ht.save(hlo);
		System.out.println(hlo);
		return id;
	}

}
