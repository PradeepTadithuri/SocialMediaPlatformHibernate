package com.SocialMedia.DaoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.SocialMedia.Dao.PlatformDao;
import com.SocialMedia.entity.Comment;
import com.SocialMedia.entity.Friend;
import com.SocialMedia.entity.Like;
import com.SocialMedia.entity.Post;
import com.SocialMedia.entity.User;
import com.SocialMedia.util.HibernateUtil;

public class PlatformDaoImpl implements PlatformDao
{
	//scanner object
      static Scanner sc=new Scanner(System.in);
      
      //method to view my details
      @Override
      public User myDetails(int userid)
      {
    	  //opening session by calling HibernateUtil class getSession method
    	  try (Session session = HibernateUtil.getSession()) 
    	  {
              // Retrieve the user entity from the database
              User user = session.get(User.class, userid);
              if (user != null) 
              {
                  // Return the user entity representing the logged-in user
                  return user;
              } 
              else 
              {
                  System.out.println("User with ID " + userid + " not found.");
              }
          } catch (HibernateException e) 
    	  {
              System.out.println("Error fetching logged-in user details: " + e.getMessage());
              e.printStackTrace();
          }
          return null;
      }
   
     //method to create new account
	@Override
	public User createAccount(User user) 
	{
		//exception handling
		try(Session session=HibernateUtil.getSession())
		{
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		//returning user details
		return user;
		}
		catch(HibernateException e)
		{
			System.out.println(e);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}

	//method to get all user details
	@Override
	public List<User> getAllUsers() 
	{
		try (Session session = HibernateUtil.getSession()) 
		{
			// using HQL query to get all users
            Query<User> query = session.createQuery("FROM User", User.class);
            return query.list();
        } 
		catch (HibernateException e) 
		{
            System.out.println("Error fetching users: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
	}

	//method to login 
	@Override
	  public boolean loginUser(int userid, String password) 
	{
        try (Session session = HibernateUtil.getSession()) 
        {
        	//Hql query to give userID and password
            Query<User> query = session.createQuery("FROM User WHERE UserID = :userID AND Password = :password", User.class);
            //giving parameters for hql query
            query.setParameter("userID", userid);
            query.setParameter("password", password);
            User user = query.uniqueResult();
            return user != null;
        } 
        catch (HibernateException e) 
        {
            System.out.println("Error authenticating user: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
	}
	
	//method to logout user
	@Override
	public void logoutUser(Session session) 
	{
        if (session != null && session.isOpen()) 
        {
            session.close();  // Close the Hibernate session
            System.out.println("User logged out successfully.");
        } 
        else 
        {
            System.out.println("No active session found.");
        }
	}
	
	//method to update full name
	@Override
	public void fullname(int userid)
    {
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) 
        {
            transaction = session.beginTransaction();

            // Retrieve the user entity from the database
            User user = session.get(User.class, userid);
            if (user != null) 
            {
                // Update user details
            	System.out.println("Enter new Full name");
                user.setFullName(sc.next());
                

                // Save the updated user entity
                session.update(user);
                transaction.commit();
                System.out.println(user);
                System.out.println("User details updated successfully.");
            } 
            else 
            {
                System.out.println("User invalid");
            }
        } 
        catch (HibernateException e) 
        {
            if (transaction != null) 
            {
                transaction.rollback();  // Rollback the transaction if an exception occurs
            }
            System.out.println("Error updating user details: " + e.getMessage());
            e.printStackTrace();
        }
    }

	//method to update password
	@Override
	public void password(int userid)
	{
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) 
        {
            transaction = session.beginTransaction();

            // Retrieve the user entity from the database
            User user = session.get(User.class, userid);
            System.out.println("Enter old password for verification");
            String password=sc.next();
            //checking password is matched
            if(user.getPassword().equals(password))
            {
            if (user != null) 
            {
                // Update user details
            	System.out.println("Enter new password");
                user.setPassword(sc.next());
                

                // Save the updated user entity
                session.update(user);
                transaction.commit();
                System.out.println(user);
                System.out.println("User details updated successfully.");
            } 
            }
            else 
            {
                System.out.println("User invalid");
            }
        } 
        catch (HibernateException e) 
        {
            if (transaction != null) 
            {
                transaction.rollback();  // Rollback the transaction if an exception occurs
            }
            System.out.println("Error updating user details: " + e.getMessage());
            e.printStackTrace();
        }
	}

	//method to update email
	@Override
	public void email(int userid)
	{
		Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) 
        {
            transaction = session.beginTransaction();

            // Retrieve the user entity from the database
            User user = session.get(User.class, userid);
            if (user != null) 
            {
                // Update user details
            	System.out.println("Enter new Email");
                user.setEmail(sc.next());
                

                // Save the updated user entity
                session.update(user);
                transaction.commit();
                System.out.println(user);
                System.out.println("User details updated successfully.");
            } 
            else 
            {
                System.out.println("User invalid");
            }
        } 
        catch (HibernateException e) 
        {
            if (transaction != null) 
            {
                transaction.rollback();  // Rollback the transaction if an exception occurs
            }
            System.out.println("Error updating user details: " + e.getMessage());
            e.printStackTrace();
        }
	}

	//method to update user name
	@Override
	public void username(int userid)
    {
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) 
        {
            transaction = session.beginTransaction();

            // Retrieve the user entity from the database
            User user = session.get(User.class, userid);
            if (user != null) 
            {
                // Update user details
            	System.out.println("Enter new username");
                user.setUserName(sc.next());
                

                // Save the updated user entity
                session.update(user);
                transaction.commit();
                System.out.println(user);
                System.out.println("User details updated successfully.");
            } 
            else 
            {
                System.out.println("User invalid");
            }
        } 
        catch (HibernateException e) 
        {
            if (transaction != null) 
            {
                transaction.rollback();  // Rollback the transaction if an exception occurs
            }
            System.out.println("Error updating user details: " + e.getMessage());
            e.printStackTrace();
        }
    }
	
	//method to delete user from data base
	@Override
	public void deleteUser(int userId) 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) 
        {
            transaction = session.beginTransaction();

            // Retrieve the user entity from the database
            User user = session.get(User.class, userId);
            if (user != null) 
            {
                // Delete the user entity
                session.delete(user);
                transaction.commit();
                System.out.println("your account with ID " + userId + " deleted successfully.");
                
            } 
            else 
            {
                System.out.println("User with ID " + userId + " not found.");
            }
        } 
        catch (HibernateException e) 
        {
            if (transaction != null) 
            {
                transaction.rollback();  // Rollback the transaction if an exception occurs
            }
            System.out.println("Error deleting user: " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	//method to view user posts
	@Override
	public List<Post> myPosts(int userId) 
	{
		try (Session session = HibernateUtil.getSession()) 
		{
			//HQL query to only retrieve only user posts
            Query<Post> query = session.createQuery("FROM Post p WHERE p.user.id = :userId", Post.class);
            query.setParameter("userId", userId);
            return query.getResultList();
        } 
		catch (HibernateException e) 
		{
            e.printStackTrace();
            return null;
        }
    }
	 // Method to write original images of posts to disk
    public void writeOriginalImages(List<Post> posts) 
    {
    	//using file output stream to view post(orginal image) 
        for (Post post : posts) 
        {
            try (FileOutputStream fos = new FileOutputStream("post_" + post.getId() + ".jpg")) 
            {
                // Write post content (image) to file
                fos.write(post.getContent());
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

    //method to upload a post
    @Override
	public void uploadPost(int userId, File imageFile) 
	{
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) 
        {
            transaction = session.beginTransaction();

            // Retrieve the user entity from the database
            User user = session.get(User.class, userId);
            if (user != null) 
            {
                // Create a new post entity
                Post post = new Post();
                post.setUser(user);
                post.setDateTime(LocalDateTime.now()); // Set current date and time

                // Read and set image data
                byte[] imageData = readImageFile(imageFile);
                post.setContent(imageData);

                // Save the post entity to the database
                session.save(post);

                transaction.commit();
                System.out.println("Post image uploaded successfully.");
            } 
            else 
            {
                System.out.println("User with ID " + userId + " not found.");
            }
        } 
        catch (HibernateException e) 
        {
            if (transaction != null) 
            {
                transaction.rollback();  // Rollback the transaction if an exception occurs
            }
            System.out.println("Error uploading post image: " + e.getMessage());
            e.printStackTrace();
        }
    }
    //to upload a image file
    private byte[] readImageFile(File file) 
    {
    	//to read image using file input stream
        try (FileInputStream inputStream = new FileInputStream(file)) 
        {
            byte[] imageData = new byte[(int) file.length()];
            inputStream.read(imageData);
            return imageData;
        } 
        catch (IOException e) 
        {
            System.out.println("Error reading image file: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    //method to view user likes on posts
    @Override
    public List<Like> viewUserLikes(int UserId) 
    {
        try (Session session = HibernateUtil.getSession()) 
        {
            Query<Like> query = session.createQuery("FROM Like l WHERE l.post.user.id = :userId", Like.class);
            query.setParameter("userId", UserId);
            return query.getResultList();
        } 
        catch (HibernateException e) 
        {
            e.printStackTrace();
            return null;
        }
    }

    //method to view user comments on posts 
    @Override
    public List<Comment> viewUserComments(int UserId) 
    {
        try (Session session = HibernateUtil.getSession()) 
        {
        	//Hql query to retrieve all comments of a user
            Query<Comment> query = session.createQuery("FROM Comment c WHERE c.post.user.id = :userId", Comment.class);
            query.setParameter("userId", UserId);
            return query.getResultList();
        } 
        catch (HibernateException e) 
        {
            e.printStackTrace();
            return null;
        }
    }
    
    //method to delete post of user 
    @Override
    public boolean deletePost(int postId, int userId) 
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) 
        {
            transaction = session.beginTransaction();

            // Retrieve the post to be deleted
            Post post = session.get(Post.class, postId);

            // Check if the post exists and belongs to the logged-in user
            if (post != null && post.getUser().getId() == userId) 
            {
                session.delete(post);
                transaction.commit();
                return true; // Post deleted successfully
            } 
            else 
            {
                return false; // Post not found or does not belong to the user
            }
        } 
        catch (HibernateException e) 
        {
            if (transaction != null) 
            {
                transaction.rollback(); // Rollback the transaction if an exception occurs
            }
            e.printStackTrace();
            return false; // Error occurred while deleting post
        }
    }
    
    //method to view all other users posts
    @Override
    public List<Post> viewOtherUsersPosts(int loggedInUserId) 
    {
        try (Session session = HibernateUtil.getSession()) 
        {
            Query<Post> query = session.createQuery("FROM Post p WHERE p.user.id != :userId", Post.class);
            query.setParameter("userId", loggedInUserId);
            return query.getResultList();
        } 
        catch (HibernateException e) 
        {
            e.printStackTrace();
            return null;
        }
    }
    
    //method to comment on user posts 
    @Override
    public boolean commentOnPost(int postId, int UserId, String Content) 
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) 
        {
            transaction = session.beginTransaction();

            // Check if the post exists
            Post post = session.get(Post.class, postId);
            if (post == null) {
                return false; // Post not found
            }

            // Create a new Comment object
            Comment comment = new Comment();
            comment.setUser(session.get(User.class, UserId));
            comment.setPost(post);
            comment.setContent(Content);
            comment.setDateTime(LocalDateTime.now());

            session.save(comment);
            transaction.commit();
            return true; // Comment added successfully
        } 
        catch (HibernateException e) 
        {
            if (transaction != null) 
            {
                transaction.rollback(); // Rollback the transaction if an exception occurs
            }
            e.printStackTrace();
            return false; // Error occurred while adding comment
        }
    }
    
    //method to like on user posts 
    @Override
    public boolean likePost(int postId, int UserId) 
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) 
        {
            transaction = session.beginTransaction();

            // Check if the post exists
            Post post = session.get(Post.class, postId);
            if (post == null) 
            {
                return false; // Post not found
            }

            // Create a new Like object
            Like like = new Like();
            like.setUser(session.get(User.class, UserId));
            like.setPost(post);
            like.setDateTime(LocalDateTime.now());

            session.save(like);
            transaction.commit();
            return true; // Like added successfully
        } 
        catch (HibernateException e) 
        {
            if (transaction != null) 
            {
                transaction.rollback(); // Rollback the transaction if an exception occurs
            }
            e.printStackTrace();
            return false; // Error occurred while adding like
        }
    }
    
    //method to add friend
    @Override
    public void addFriend(int userId1, int userId2) 
    {
    	 Transaction transaction = null;
         try (Session session = HibernateUtil.getSession()) 
         {
             transaction = session.beginTransaction();

             // Retrieve the user entities from the database
             User user1 = session.get(User.class, userId1);
             User user2 = session.get(User.class, userId2);

             if (user1 != null && user2 != null)
             {
               
                 Friend friendship = new Friend();
                 friendship.setUser1(user1);
                 friendship.setUser2(user2);
                 friendship.setDateTime(LocalDateTime.now());

                 // Save the Friendship entity to the database
                 session.save(friendship);

                 transaction.commit();
                 System.out.println("Friendship ID: "+friendship.getId()+", userID1: "+userId1+", user1 name:"+friendship.getUser1().getUserName()+", userID2:"+userId2+", user2 name:"+friendship.getUser2().getUserName()+", DateTime:"+friendship.getDateTime());
                 System.out.println("Friendship added successfully. ");
             } 
             else 
             {
                 System.out.println("One or both users not found.");
             }
         } 
         catch (HibernateException e) 
         {
             if (transaction != null) 
             {
                 transaction.rollback();  // Rollback the transaction if an exception occurs
             }
             System.out.println("Error adding friendship: " + e.getMessage());
             e.printStackTrace();
         }
    }
    
    //method to view friends list of user
    @Override
    public List<User> friendsList(int userId)
    {
    	try (Session session = HibernateUtil.getSession()) 
    	{
            // Retrieve the user entity from the database
            User user = session.get(User.class, userId);
            if (user != null) 
            {
                // Return the list of friends for the user
                return user.getFriends();
            } 
            else 
            {
                System.out.println("User with ID " + userId + " not found.");
            }
        } 
    	catch (HibernateException e) 
    	{
            System.out.println("Error fetching friends list: " + e.getMessage());
            e.printStackTrace();
        }
    	catch(Exception e)
    	{
    		System.out.println("Error fetching friends list: " + e.getMessage());
            e.printStackTrace();
    	}
        return null;
    }
    
    //method to remove friend of user 
    @Override
    public void removeFriend(int UserId, int friendId) 
    {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) 
        {
            transaction = session.beginTransaction();

            // Retrieve the logged-in user and the friend to be removed
            User user = session.get(User.class, UserId);
            User friend = session.get(User.class, friendId);

            if (user != null && friend != null) 
            {
                // Check if the friendToRemove exists in the loggedInUser's friends list
                if (user.getFriends().contains(friend)) 
                {
                    // Remove the friendship entry from the Friends table
                    Friend unFriend = findFriendship(session, user, friend);
                    if (unFriend != null) 
                    {
                        session.delete(unFriend);
                        transaction.commit();
                        System.out.println("Friend removed successfully.");
                    } 
                    else 
                    {
                        System.out.println("Friendship not found.");
                    }
                } 
                else 
                {
                    System.out.println("Friend not found in the user's friend list.");
                }
            } 
            else 
            {
                System.out.println("Logged-in user or friend to remove not found.");
            }
        } 
        catch (HibernateException e) 
        {
            if (transaction != null) 
            {
                transaction.rollback();  // Rollback the transaction if an exception occurs
            }
            System.out.println("Error removing friend: " + e.getMessage());
            e.printStackTrace();
        }
    }
    //finding friendship to remove friends
    private Friend findFriendship(Session session, User user1, User user2) 
    {
        // Query the database to find the friendship entry based on the user IDs
        return session.createQuery("FROM Friend WHERE (user1 = :user1 AND user2 = :user2) " +
                                   "OR (user1 = :user2 AND user2 = :user1)", Friend.class)
                      .setParameter("user1", user1)
                      .setParameter("user2", user2)
                      .uniqueResult();
    }

}
