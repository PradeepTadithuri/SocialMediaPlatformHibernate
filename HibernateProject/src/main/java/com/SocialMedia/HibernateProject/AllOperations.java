package com.SocialMedia.HibernateProject;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;


import org.hibernate.Session;


import com.SocialMedia.Dao.PlatformDao;
import com.SocialMedia.DaoImpl.PlatformDaoImpl;
import com.SocialMedia.entity.Comment;
import com.SocialMedia.entity.Like;
import com.SocialMedia.entity.Post;
import com.SocialMedia.entity.User;
import com.SocialMedia.util.HibernateUtil;

public class AllOperations 
{
	//scanner object
	static Scanner sc=new Scanner(System.in);
	
	//calling parent class method with child class reference
	static PlatformDao imp=new PlatformDaoImpl();
	
	static int userid;
	
	//log out method
	public static void logOut()
	{
        Session session = HibernateUtil.getSession(); // Get the active Hibernate session
        
        imp.logoutUser(session); // Log out the user by closing the session
    
	}
	
	//delete account method
	public static void deleteAccount()
	{
		//calling delete user method 
		imp.deleteUser(userid);
	}
	
	//login method
    public static void logIn()
    {
       
    	System.out.println("Enter user id");
    	 userid = sc.nextInt();
    	System.out.println("Enter password");
        String password = sc.next();
        //calling login user method 
        if (imp.loginUser(userid, password)) 
        {
            System.out.println("User logged in successfully.");
            System.out.println("----------------------------");
            System.out.println();
          //calling method
            methods();
        } 
        else 
        {
            System.out.println("Invalid userID or password.Try again");
            
        }
          
    }
    
    //method to view user account details
    public static void myDetails()
    {
    	//calling and storing the data of my details method
    	User account = imp.myDetails(userid);
        if (account != null) 
        {
            System.out.println("My account details:");
         // Print the details of the logged-in user
            System.out.println("userID:"+account.getId()+", username:"+account.getUserName()+", FullName:"+account.getFullName()+", Email:"+account.getEmail()+", AccountCreatedOn: "+account.getDateTime()); 
        }
        System.out.println("----------------------------");
        System.out.println();
        //calling methods
        methods();
    }
    
    //method to see all users
    public static void allUsers()
    {
    	List<User> users = imp.getAllUsers();
        if (users != null) 
        {
            for (User user : users) 
            {
                System.out.println("user ID: "+user.getId()+", userName: "+user.getUserName()+", fullName: "+user.getFullName()+", Email: "+user.getEmail());
            }
        }
        System.out.println("----------------------------");
        System.out.println();
      //calling method
        methods();
    }
    
    //creating account method
    public static void createAccount()
    {
    	User user=UserInputs();
    	User saveUser=imp.createAccount(user);
    	System.out.println(saveUser);
    	System.out.println("Remember userID ");
    	System.out.println("account created successfully, Login to continue");
    	 System.out.println("----------------------------");
         System.out.println();
       //calling method
    	logIn();
    }
    //create account user inputs
    public static User UserInputs()
    {
    	User user=new User();
    	//taking user inputs
    	System.out.println("Enter a User Name");
    	user.setUserName(sc.nextLine());
    	System.out.println("Enter your Full Name");
    	user.setFullName(sc.nextLine());
    	System.out.println("Enter your Email");
    	user.setEmail(sc.nextLine());
    	System.out.println("Enter password");
    	user.setPassword(sc.nextLine());
    	
    	user.setDateTime(LocalDateTime.now());
		return user;
    	
    }
    
    //all methods options
    public static void methods()
    {
    	while(true)
    	{
    		System.out.println("press 1 to view account details"
    				+ "\npress 2 to update account details "
    				+ "\npress 3 to open my posts"
    				+ "\npress 4 to open other users posts"
    				+ "\npress 5 to check friends details"
    				+"\npress 6 to view other users"
    				+ "\npress 7 to log out"
    				+"\npress 8 to delete account");
    		int choice = sc.nextInt();
    		switch(choice)
    		{
    		    case 1:
    			    myDetails();
    			    break;
    		    case 2:
    		    	update();
    		    	break;
    		    case 3:
    		    	myPost();
    		    	break;
    		    case 4:
    		    	allPosts();
    		    	break;
    		    case 5:
    		    	friends();
    		    	break;
    		    case 6:
    		    	allUsers();
    		    	break;
    		    case 7:
    		    	logOut();
    		    	break;
    		    case 8:
    		    	deleteAccount();
    		    	break;
    		    default:
    		    	System.out.println("invalid option");
    	        	 break;
    		}
    		if(choice==1||choice==2||choice==3||choice==4||choice==5||choice==6||choice==7||choice==8)
            {
          	 break; 
            }
    	}
    }
    
    //method for update user name 
    public static void username()
    {
    	imp.username(userid);
    	 System.out.println("----------------------------");
         System.out.println();
       //calling method
        update();
    }
  //method for update full name 
    public static void fullname()
    {
    	imp.fullname(userid);
    	 System.out.println("----------------------------");
         System.out.println();
       //calling method
        update();
    }
  //method for update email 
    public static void email()
    {
    	imp.email(userid);
    	 System.out.println("----------------------------");
         System.out.println();
        update();
    }
  //method for update password 
    public static void password()
    {
    	imp.password(userid);
    	 System.out.println("----------------------------");
         System.out.println();
       //calling method
        update();
    }
    //main method for update
    public static void update()
    {
    	while(true)
    	{
    		System.out.println("press 1 to update user name "
    				+ "\npress 2 to update full name"
    				+ "\npress 3 to update Email name"
    				+ "\npress 4 to update password name"
    				+ "\npress 5 to main menu");
    		int choice = sc.nextInt();
    		switch(choice)
    		{
    		    case 1:
    			    username();
    			    break;
    		    case 2:
    		    	fullname();
    		    	break;
    		    case 3:
    		    	email();
    		    	break;
    		    case 4:
    		    	password();
    		    	break;
    		    case 5:
    		    	methods();
    		    	break;
    		    default:
    		    	System.out.println("invalid option");
    	        	 break;
    		}
    		if(choice==1||choice==2||choice==3||choice==4||choice==5)
            {
          	 break; 
            }
    	}
    }
    
    //method for view user posts
    public static void viewPost()
    {
    	//calling my posts method using object
    	List<Post> userPosts = imp.myPosts(userid);
    	
        if (userPosts != null && !userPosts.isEmpty()) 
        {
        	//calling method using child class object
            ((PlatformDaoImpl) imp).writeOriginalImages(userPosts);
            System.out.println("My posts:");
            //printing output
            for (Post post : userPosts) 
            {
            	System.out.println("Post ID: " + post.getId());
                System.out.println("Content: " + post.getContent());
                System.out.println("UploadedOn: " + post.getDateTime());
                System.out.println();
            }
            System.out.println("you can view images of your posts in root directory.");
        } else 
        {
            System.out.println("No posts found for the user.");
        }
        System.out.println("----------------------------");
        System.out.println();
        //calling method
       myPost();
    }
    
    //method to upload images(posts)
    public static void uploadMyPost()
    {
    	System.out.println("paste below the image file path to upload");
    	String filePath=sc.next();
    	 File imageFile = new File(filePath); 
    	 imp.uploadPost(userid, imageFile);
    	 System.out.println("----------------------------");
         System.out.println();
    	 //calling again my post
    	 myPost();
    }
    
    //method to delete post
    public static void deletePost()
    {
    	System.out.println("Enter your post id to delete post");
    	//entering post id 
    	int postId=sc.nextInt();
    	 boolean deleted = imp.deletePost(postId,userid);
         if (deleted) 
         {
             System.out.println("Post deleted successfully.");
         } else 
         {
             System.out.println("Failed to delete post. Post not found or does not belong to the user.");
         }
         System.out.println("----------------------------");
         System.out.println();
         //calling again my post method
         myPost();
    }
    
    //method to view likes/comments no my posts
     public static void viewLikesComments()
     {
    	 // View likes for the logged-in user's posts
         List<Like> UserLikes = imp.viewUserLikes(userid);
         if (UserLikes != null && !UserLikes.isEmpty()) 
         {
             System.out.println("Likes for logged-in user's posts:");
             for (Like like : UserLikes) 
             {
                 System.out.println("Post ID: " + like.getPost().getId() + ", Liked by: " + like.getUser().getUserName());
             }
         } 
         else 
         {
             System.out.println("No likes found for logged-in user's posts.");
         }

         // View comments for the logged-in user's posts
         List<Comment> userComments = imp.viewUserComments(userid);
         if (userComments != null && !userComments.isEmpty()) 
         {
             System.out.println("Comments for logged-in user's posts:");
             for (Comment comment : userComments) 
             {
                 System.out.println("Post ID: " + comment.getPost().getId() + ", Comment by: " + comment.getUser().getUserName() + ", Comment: " + comment.getContent());
             }
         } 
         else 
         {
             System.out.println("No comments found for logged-in user's posts.");
         }
         System.out.println("----------------------------");
         System.out.println();
         //calling method
         myPost();
     }
 
    // main method for post
    public static void myPost()
    {
    	while(true)
    	{
    		System.out.println("press 1 to view your post "
    				+"\npress 2 upload new post"
    				+ "\npress 3 to see likes/comments on your post"
    				+"\npress 4 to delete post"
    				+ "\npress 5 to main menu");
    		int choice = sc.nextInt();
    		switch(choice)
    		{
    		    case 1:
    			    viewPost();
    			    break;
    		    case 2:
    		    	uploadMyPost();
    		    	break;
    		    case 3:
    		    	viewLikesComments();
    		    	break;
    		    case 4:
    		    	deletePost();
    		    	break;
    		    case 5:
    		    	methods();
    		    	break;
    		    default:
    		    	System.out.println("invalid option");
    	        	 break;
    		}
    		if(choice==1||choice==2||choice==3||choice==4||choice==5)
            {
          	 break; 
            }
    	}
    }
    
    //method to view all users posts
    public static void othersPosts()
    {
    	List<Post> otherUsersPosts = imp.viewOtherUsersPosts(userid);
        if (otherUsersPosts != null && !otherUsersPosts.isEmpty()) 
        {
            System.out.println("Other users' posts:");
            for (Post post : otherUsersPosts) 
            {
                System.out.println("Post ID: " + post.getId() + ", Content: " + post.getContent());
            }
        } 
        else 
        {
            System.out.println("No posts from other users found.");
        }
        System.out.println("----------------------------");
        System.out.println();
    	//calling again all posts method
    	allPosts();
    }

    //method to like posts
    public static void likePost()
    {
    	System.out.println("enter post id to like post");
    	int postId=sc.nextInt();
    	boolean liked = imp.likePost(postId, userid);
        if (liked) 
        {
            System.out.println("Post liked successfully.");
        } 
        else 
        {
            System.out.println("Failed to like post. Post not found.");
        }
        System.out.println("----------------------------");
        System.out.println();
        //calling all posts method
        allPosts();
    }
    
    //method to comment on post
    public static void commentPost()
    {
    	System.out.println("enter post id to comment post");
    	int postId=sc.nextInt();
    	System.out.println("Type your comment");
    	sc.nextLine();
    	String content=sc.nextLine();
    	boolean commented = imp.commentOnPost(postId, userid, content);
        if (commented) 
        {
            System.out.println("Comment added successfully.");
        } 
        else 
        {
            System.out.println("Failed to add comment. Post not found.");
        }
        System.out.println("----------------------------");
        System.out.println();
      //calling all posts method
        allPosts();
    }
    
    //main method for other user posts
    public static void allPosts()
    {
    	while(true)
    	{
    		System.out.println("press 1 to view other user posts "
    				+ "\npress 2 to like on other user posts"
    				+ "\npress 3 to comment on other user posts"
    				+ "\npress 4 to main menu");
    		int choice = sc.nextInt();
    		switch(choice)
    		{
    		    case 1:
    			    othersPosts();
    			    break;
    		    case 2:
    		    	likePost();
    		    	break;
    		    case 3:
    		    	commentPost();
    		    	break;
    		    case 4:
    		    	methods();
    		    	break;
    		    default:
    		    	System.out.println("invalid option");
    	        	 break;
    		}
    		if(choice==1||choice==2||choice==3||choice==4)
            {
          	 break; 
            }
    	}
    }
    
    //main method for friends
    public static void friends()
    {
    	while(true)
    	{
    		System.out.println("press 1 to view my friends "
    				+ "\npress 2 to remove friend"
    				+"\npress 3 to add friend"
    				+ "\npress 4 to main menu");
    		int choice = sc.nextInt();
    		switch(choice)
    		{
    		    case 1:
    			    myFriends();
    			    break;
    		    case 2:
    		    	removeFriend();
    		    	break;
    		    case 3:
    		    	addFriend(); 
    		    	break;
    		    case 4:
    		    	methods();
    		    	break;
    		    default:
    		    	System.out.println("invalid option");
    	        	 break;
    		}
    		if(choice==1||choice==2||choice==3||choice==4)
            {
          	 break; 
            }
    	}
    }
    
    //method to add friend
    public static void addFriend()
    {
    	System.out.println("Enter your friend user id ");
    	int userid2=sc.nextInt();
    	//calling method
    	imp.addFriend(userid, userid2); 
    	 System.out.println("----------------------------");
         System.out.println();
    	//calling again friends method
    	friends();
    }
    
    //method to view my friends
    public static void myFriends()
    {
    	 List<User> friendsList = imp.friendsList(userid);
         if (friendsList != null) 
         {
        	 
             System.out.println("Friends list for user with ID " + userid + ":");
             for (User friend : friendsList) 
             {
                 System.out.println("userID:"+friend.getId()+", username:"+friend.getUserName()); // Print each friend's details
             }
         }
         System.out.println("----------------------------");
         System.out.println();
       //calling again friends method
     	friends();
    }
    //method to remove friend
    public static void removeFriend()
    {
    	System.out.println("Enter your friend user id ");
    	int userid2=sc.nextInt();
    	//calling method
    	imp.removeFriend(userid, userid2); 
    	 System.out.println("----------------------------");
         System.out.println();
    	//calling again friends method
    	friends();
    }
}
