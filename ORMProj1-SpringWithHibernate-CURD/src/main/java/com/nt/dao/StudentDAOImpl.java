package com.nt.dao;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.nt.domain.SpStudentHLO;

public class StudentDAOImpl implements StudentDAO {
	private HibernateTemplate ht;
	private static final String HQL_UPDATE_STUDENT = "UPDATE SpStudentHLO SET sadd=? WHERE sno=?";
	private static final String HQL_DELETE_STUDENT = "DELETE FROM  SpStudentHLO WHERE sno=?";
	private static final String HQL_GET_STUDENTS_BY_ADDRS = "FROM SpStudentHLO WHERE sadd=:city";
	private static final String HQL_GET_STUDENTS_BY_NAMES = "FROM SpStudentHLO WHERE sname in(?,?)";

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	public SpStudentHLO findStudentByNo(int no) {
		return ht.get(SpStudentHLO.class, no);
	}

	@Override
	public int insert(SpStudentHLO hlo) {
		int idVal = 0;
		ht.setCheckWriteOperations(false);
		idVal = (int) ht.save(hlo);

		return idVal;
	}

	@Override
	public int update(int sno, String newAddrs) {
		int count = 0;
		ht.setCheckWriteOperations(false);
		count = ht.bulkUpdate(HQL_UPDATE_STUDENT, newAddrs, sno);
		return count;
	}

	@Override
	public int remove(int sno) {
		int count = 0;
		ht.setCheckWriteOperations(false);
		count = ht.bulkUpdate(HQL_DELETE_STUDENT, sno);
		return count;
	}

	@Override
	public List<SpStudentHLO> findStudentsByAddrs(String addrs) {
		List<SpStudentHLO> listHLO = null;
		listHLO = (List<SpStudentHLO>) ht.findByNamedParam(HQL_GET_STUDENTS_BY_ADDRS, new String[] { "city" },
				new String[] { addrs });

		return listHLO;
	}

	@Override
	public List<SpStudentHLO> findStudentsByNames(String name1, String name2) {
		List<SpStudentHLO> listHLO = null;
		listHLO = (List<SpStudentHLO>) ht.find(HQL_GET_STUDENTS_BY_NAMES, name1, name2);
		return listHLO;
	}
	
	@Override
	public List<SpStudentHLO> findStudentByRange(int start, int end) {
		List<SpStudentHLO> listHLO = null;
		listHLO = (List<SpStudentHLO>) ht.findByNamedQuery("GET_ALL_STUDENTS_BY_RANGE",start,end);
		return listHLO;
	}
	
	@Override
	public List<SpStudentHLO> findStudentsByRange(int start, int end) {
		List<SpStudentHLO> listHLO = null;
		listHLO = (List<SpStudentHLO>) ht.findByNamedQueryAndNamedParam("GET_STUDENTS_BY_RANGE",
				                                                         new String[]{"start","end"},
				                                                         new Integer[]{start,end});
		return listHLO;
	}
	
	@Override
	public int deleteStudentsByAddrs(String addrs) {
/*		int count=0;
		count=ht.execute(new HibernateCallback<Integer>() {

			@Override
			public Integer doInHibernate(Session ses) throws HibernateException {
				Query query=null;
				int cnt=0;
				query=ses.getNamedQuery("DELETE_STUDENTS_BY_ADDRS");
				query.setString("addrs", addrs);
				cnt=query.executeUpdate();
				return cnt;
			}//doInHibernate(-)
		});
		return count;
*/
		int count=0;
		count=ht.execute(ses->{
			Query query=null;
			int cnt=0;
			query=ses.getNamedQuery("DELETE_STUDENTS_BY_ADDRS");
			query.setString("addrs", addrs);
			cnt=query.executeUpdate();
			return cnt;
		 });
		 return count;
		}//method

}// class
