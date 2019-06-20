package com.nt.bo;

public class ProfileBO {
   private int profileId;
   private String profileName;
   private int postsCount;
   private int followersCount;
   private int friendsCount;
public int getProfileId() {
	return profileId;
}
public void setProfileId(int profileId) {
	this.profileId = profileId;
}
public String getProfileName() {
	return profileName;
}
public void setProfileName(String profileName) {
	this.profileName = profileName;
}
public int getPostsCount() {
	return postsCount;
}
public void setPostsCount(int postsCount) {
	this.postsCount = postsCount;
}
public int getFollowersCount() {
	return followersCount;
}
public void setFollowersCount(int followersCount) {
	this.followersCount = followersCount;
}
public int getFriendsCount() {
	return friendsCount;
}
public void setFriendsCount(int friendsCount) {
	this.friendsCount = friendsCount;
}
}
