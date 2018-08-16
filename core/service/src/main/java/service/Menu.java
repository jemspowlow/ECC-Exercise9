package service;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import java.util.Scanner;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.Transaction;
import entities.*;
import persistence.HibernateUtil;
public class Menu {
	private ContactView cv;
	private PersonView pv;
	private Scanner input = new Scanner(System.in);
	public Menu() {
		cv = new ContactView();
		pv = new PersonView();
	}
	public void displayMenu() {
		int choice = 0;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		do{ 
			System.out.println("\n===Registration System===");
			System.out.println("Select Entity:");
			System.out.println("[1] Person ");
			System.out.println("[2] Contact ");
			System.out.println("[3] Exit ");
			System.out.print("Choice: ");
			choice = input.nextInt();	
			selectMenu(choice);			
		 } while(choice!=3);
		 HibernateUtil.shutdown();
		 return;
	
	 }   
    public void selectMenu(int choice) {
 		
   		
   		switch(choice){
   			case 1: pv.printMenu();
   				break;
   			
   			case 2: cv.printMenu();
   				break;
   			case 3:
   				break;
   			default:
   				break;
   		
   		}
   						
    }
	
 }
