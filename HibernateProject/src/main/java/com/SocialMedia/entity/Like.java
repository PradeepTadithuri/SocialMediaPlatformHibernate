package com.SocialMedia.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Likes")
public class Like 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LikeID")
	private int id;

     @ManyToOne(fetch = FetchType.EAGER)
	 private Post post;
     
     @ManyToOne(fetch = FetchType.EAGER)
	 private User user;
	
    @Column(name="LikeDate")
    private LocalDateTime dateTime;

	public Like() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Like(int id, Post post, User user, LocalDateTime dateTime) {
		super();
		this.id = id;
		this.post = post;
		this.user = user;
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Like [id=" + id + ", post=" + post + ", user=" + user + ", dateTime=" + dateTime + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
    
   
}