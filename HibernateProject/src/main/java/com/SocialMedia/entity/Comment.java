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
@Table(name="Comments")
public class Comment 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CommentID")
	private int id;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 private Post post;
	 
	 @ManyToOne(fetch = FetchType.EAGER) 
	 private User user;

    @Column(name="Content")
    private String content;
    
    @Column(name="CommentDate")
    private LocalDateTime dateTime;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int id, Post post, User user, String content, LocalDateTime dateTime) {
		super();
		this.id = id;
		this.post = post;
		this.user = user;
		this.content = content;
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", post=" + post + ", user=" + user + ", content=" + content + ", dateTime="
				+ dateTime + "]";
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
    
    
    
   
}