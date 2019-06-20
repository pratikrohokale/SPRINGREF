package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.nt.domain.UserHLO;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO {
	private static final String HQL_AUTH_QUERY="SELECT COUNT(*) FROM UserHLO WHERE uname=? and pwd=?";

	@Autowired
	private HibernateTemplate ht;

	@Override
	public long validate(UserHLO hlo) {
	    List<Long> list=null;
		long count=0;
	  list=(List<Long>) ht.find(HQL_AUTH_QUERY, hlo.getUname(),hlo.getPwd());
	 count=list.get(0);
		return count;
	}

}
