package com.SocialMedia.HibernateProject;

import java.util.Scanner;

public class App 
{
    static Scanner sc=new Scanner(System.in);
    public static void main( String[] args )
    {
        
        System.out.println("     Welcome to Social Media Platform");
        System.out.println();
       while(true)
        {
         System.out.println("press 1 to login \npress 2 to create a new account");	
         int choice =sc.nextInt();
         switch(choice)
          {
           case 1: 
        	  AllOperations.logIn();
        	  break;
           case 2:
        	   AllOperations.createAccount();
        	  break;
           default:
        	  System.out.println("invalid option");
        	  break;
           }
          if(choice==1||choice==2)
          {
        	 break; 
          }
        }
        
    }
}
