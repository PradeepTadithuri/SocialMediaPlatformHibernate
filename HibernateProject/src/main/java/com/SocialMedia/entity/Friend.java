package com.SocialMedia.entity;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Friends")
public class Friend 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FriendID")
	private int id;
	
	 @ManyToOne
	 @JoinColumn(name = "UserID1")
	 private User user1;

	 @ManyToOne
	 @JoinColumn(name = "UserID2")
	 private User user2;

    @Column(name="DateOfFriends")
    private LocalDateTime dateTime;

	public Friend() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Friend(int id, User user1, User user2, LocalDateTime dateTime) {
		super();
		this.id = id;
		this.user1 = user1;
		this.user2 = user2;
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "Friend [id=" + id + ", user1=" + user1 + ", user2=" + user2 + ", dateTime=" + dateTime + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
    
   
}
