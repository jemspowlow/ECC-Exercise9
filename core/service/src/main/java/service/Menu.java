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
import utilities.InputUtil;
import persistence.HibernateUtil;
public class Menu {
	private ContactView cv;
	private PersonView pv;
	private RolesView rv;
	private InputUtil iu;
	public Menu() {
		cv = new ContactView();
		pv = new PersonView();
		iu = new InputUtil();
		rv = new RolesView();
	}
	public void displayMenu() {
		int choice = 0;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		do{ 
			System.out.println("\n===Registration System===");
			System.out.println("Select Entity:");
			System.out.println("[1] Person ");
			System.out.println("[2] Contact ");
			System.out.println("[3] Roles ");
			System.out.println("[4] Exit ");
			System.out.print("Choice: ");
			choice = iu.getInt(0,4);	
			selectMenu(choice);			
		 } while(choice!=4);
		 HibernateUtil.shutdown();
		 return;
	
	 }   
    public void selectMenu(int choice) {
 		
   		
   		switch(choice){
   			case 1: pv.printMenu();
   				break;
   			
   			case 2: cv.printMenu();
   				break;
   			case 3: rv.printMenu();
   				break;
   			default:
   				break;
   		
   		}
   						
    }
	
 }
