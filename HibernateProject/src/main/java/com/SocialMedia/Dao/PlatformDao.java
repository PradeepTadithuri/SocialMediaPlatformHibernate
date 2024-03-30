package com.SocialMedia.Dao;

import java.io.File;
import java.util.List;

import org.hibernate.Session;

import com.SocialMedia.entity.Comment;
import com.SocialMedia.entity.Like;
import com.SocialMedia.entity.Post;
import com.SocialMedia.entity.User;

public interface PlatformDao 
{
	public User myDetails(int userid);
	
    public User createAccount(User user);
     
    public List<User> getAllUsers();

	boolean loginUser(int userid, String password);
	
	public void logoutUser(Session session);

	public void deleteUser(int userId);

	public void username(int userid);

	public void fullname(int userid);

	public void email(int userid);
	
	public void password(int userid);
	
	public List<Post> myPosts(int userId);
	
	public void uploadPost(int userId, File imageFile);
	
	public boolean deletePost(int postId,int userId);
	
	public List<Comment> viewUserComments(int UserId);
	
	public List<Like> viewUserLikes(int UserId);
	
	public List<Post> viewOtherUsersPosts(int loggedInUserId);
	
	public boolean likePost(int postId, int UserId);
	
	public boolean commentOnPost(int postId, int UserId, String Content);
	
	public void addFriend(int userId1, int userId2);
	
	public List<User> friendsList(int userId);
	
	public void removeFriend(int userID1,int userID2);
}
