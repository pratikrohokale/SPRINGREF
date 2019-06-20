package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import com.nt.bo.ProfileBO;

@Repository("profilesDAO")
public class ListProfileDAOImpl implements ListProfilesDAO {
	
	private static final String GET_ALL_PROFILES="SELECT PROFILEID,PROFILENAME,POSTSCOUNT,FOLLOWERSCOUNT,FRIENDSCOUNT FROM FACEBOOK_PROFILE";
	
	@Autowired
	private JdbcTemplate jt;
    private List<ProfileBO> listBO=new ArrayList();

	@Override
	public List<ProfileBO> getAllProfiles() {
		
		jt.query(GET_ALL_PROFILES, new ProfileRowCallbackHandler());
		return listBO;
	}
	
	private class ProfileRowCallbackHandler implements RowCallbackHandler{
         
		@Override
		public void processRow(ResultSet rs) throws SQLException {
		   ProfileBO bo=null;
		   bo=new ProfileBO();
		   bo.setProfileId(rs.getInt(1));
		   bo.setProfileName(rs.getString(2));
		   bo.setPostsCount(rs.getInt(3));
		   bo.setFollowersCount(rs.getInt(4));
		   bo.setFriendsCount(rs.getInt(5));
		   listBO.add(bo);
		}//processRow
	  }//innner class

}//outer class
