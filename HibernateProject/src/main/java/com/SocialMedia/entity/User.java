package com.SocialMedia.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Users")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="UserID")
    private int id;
	
	@Column(name="UserName")
    private String userName;
	
	@Column(name="FullName")
    private String fullName;
	
	@Column(name="Email")
    private String email;
	
	@Column(name="Password")
    private String password;
	
	@Column(name="DateTime")
    private LocalDateTime dateTime;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Post> post;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Like> like;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Comment> comment;
	
	 @ManyToMany(fetch=FetchType.EAGER)
	 @JoinTable(
	            name = "Friends",
	            joinColumns = @JoinColumn(name = "UserID1"),
	            inverseJoinColumns = @JoinColumn(name = "UserID2"))
	    private List<User> friends;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String userName, String fullName, String email, String password, LocalDateTime dateTime,
			List<Post> post, List<Like> like, List<Comment> comment, List<User> friends) {
		super();
		this.id = id;
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.dateTime = dateTime;
		this.post = post;
		this.like = like;
		this.comment = comment;
		this.friends = friends;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", fullName=" + fullName + ", email=" + email
				+ ", password=" + password + ", dateTime=" + dateTime + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public List<Like> getLike() {
		return like;
	}

	public void setLike(List<Like> like) {
		this.like = like;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
    
	  
	 
}