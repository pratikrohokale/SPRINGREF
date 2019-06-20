package com.nt.dao;


import org.springframework.orm.hibernate3.HibernateTemplate;

import com.nt.bo.RegisterBO;

public class NaukriRegistrationDAOImpl implements NaukriRegistrationDAO {
  private HibernateTemplate ht;
  
	public void setHt(HibernateTemplate ht) {
	this.ht = ht;
}

	@Override
	public int saveData(RegisterBO bo) {
		int idVal=0;
		idVal=(int) ht.save(bo);
		return idVal;
	}

}
