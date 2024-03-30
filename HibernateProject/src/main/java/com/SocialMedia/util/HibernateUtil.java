package com.SocialMedia.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.SocialMedia.entity.Comment;
import com.SocialMedia.entity.Friend;
import com.SocialMedia.entity.Like;
import com.SocialMedia.entity.Post;
import com.SocialMedia.entity.User;

public class HibernateUtil 
{
    //storing data of buildSessionFactory in sessionfactory
	private final static SessionFactory sessionfactory=buildSessionFactory();
	//method to build session factory for all classes
	private static SessionFactory buildSessionFactory()
	{
		try
		{
			//configuration for classes
			return new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(User.class)
			.addAnnotatedClass(Post.class)
			.addAnnotatedClass(Like.class)
			.addAnnotatedClass(Comment.class)
			.addAnnotatedClass(Friend.class)
			.buildSessionFactory();
			
		}catch(Throwable e)
		{
			throw new ExceptionInInitializerError(e);
	    }
	}
	//returning session factory to get session
public static SessionFactory getSessionFactory() {
	return sessionfactory;
}

//method to open session for all classes
public static Session getSession()
{
	return getSessionFactory().openSession(); //session opened
}
}
