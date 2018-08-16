package service;
import java.util.Scanner;
import entities.*;
import dao.*;
import utilities.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
public class ContactView {
	private ContactDAO cd;
	private PersonDAO pd;
	private Scanner input = new Scanner(System.in).useDelimiter("\\n");
	private EntityUtil eu;
	private InputUtil iu;
	public ContactView(){
		cd = new ContactDAO();
		eu = new EntityUtil();
	 	pd = new PersonDAO();
	 	iu = new InputUtil();
	 }
	
	
	
	public void printMenu() {
		int choice = 0;
		do{
		System.out.println("\n===CONTACT MENU===");
		System.out.println("[1]Add Contact to Person");
		System.out.println("[2]Update Contact");
		System.out.println("[3]Delete Contact");
		System.out.println("[4]List Contact");
		System.out.println("[5]Exit");
	 	System.out.print("Choice: ");
	 	choice = iu.getInt(0,5);
	 	menu(choice);
	 	} while(choice!=5);
	 }
	 
	public void menu(int choice) {
		Contact contact;
		int id;
		switch(choice) {
			case 1: eu.printList(pd.listPeople(""));
					System.out.print("Select Person ID: ");
					id = iu.getInt(0,0);
					contact = addMenu();
					eu.printContact(contact);
					cd.addContact(id,contact);
				break;
				
			case 2: System.out.println("List of Contacts"); 
					cd.listContacts();
					System.out.print("Select Contact ID: ");
					id = iu.getInt(0,0);
					contact = cd.getContact(id);
					
					contact = updateMenu(contact);
					
				break;
			case 3: System.out.println("List of Contacts"); 
					cd.listContacts();
					System.out.print("Select Contact ID: ");
					id = iu.getInt(0,0);
					cd.deleteContact(id);
				break;
			case 4: System.out.println("List of Contacts"); 
					cd.listContacts();
				break;
			case 5:
				break;
			
			default: break;	
		}
	
	 }
	public Contact updateMenu(Contact contact) {
		int choice = 3;
		do {
		System.out.println("===Update===");
		System.out.println("[1]Contact Type ");
		System.out.println("[2]Contact Details ");
		System.out.println("[3]Exit ");
		choice = iu.getInt(0,3);
		contact = editContact(contact,choice);
		} while(choice!=3);
		return contact;
	 }
	
	
	
	
	public Contact editContact(Contact contact, int choice) {

		switch(choice) {
		 		case 1: int type = printAddMenu();
		 				contact.setType(createType(type));
		 			break;
		 		case 2: contact.setDetails(createDetails(contact));
		 			break;
		 		case 3:
		 			break;

		 		default:
		 			break;
	 	 }
	 	 return contact;
	
	 }
	
	
	public Contact addMenu() {
	 	Contact contact = new Contact();
	 	int choice = printAddMenu();
		contact.setType(createType(choice));
		contact.setDetails(createDetails(contact));
	  	
	  	return contact;
	}
	
	public int printAddMenu() {
		int choice;
		System.out.println("\nSelect Contact type: ");
		System.out.println("[1] Email ");
		System.out.println("[2] Landline");
		System.out.println("[3] Mobile ");
		System.out.print("Choice: ");
	 	choice = iu.getInt(0,3);
	 	return choice;
	 }
	 
	public ContactType createType(int choice){

		if(choice == 1) return ContactType.EMAIL;
		else if (choice == 2) return ContactType.LANDLINE;
		else if (choice == 3) return ContactType.MOBILE;
		else return null;
	}
	
	public String createDetails(Contact contact) {
		System.out.println("Enter value for " + contact.getType());
		System.out.print("Value: ");
		String value = iu.getString(100);
		return value;
	 }

	   
 }
