package com.SocialMedia.entity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Posts")
public class Post 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PostID")
    private int id;
	
	 @ManyToOne(fetch = FetchType.EAGER)
	 private User user;
	
	@Lob
    @Column(name="Content")
    private byte[] content;
    
    @Column(name="PostDateTime")
    private LocalDateTime dateTime;
    
    @OneToMany(cascade=CascadeType.ALL)
	private List<Like> like;
    
    @OneToMany(cascade=CascadeType.ALL)
	private List<Comment> comment;

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int id, User user, byte[] content, LocalDateTime dateTime, List<Like> like, List<Comment> comment) {
		super();
		this.id = id;
		this.user = user;
		this.content = content;
		this.dateTime = dateTime;
		this.like = like;
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", user=" + user + ", content=" + Arrays.toString(content) + ", dateTime=" + dateTime
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
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

    
}