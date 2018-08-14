import java.util.Scanner;
import entities.*;
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
	public ContactView(){
		cd = new ContactDAO();
		eu = new EntityUtil();
	 	pd = new PersonDAO();
	 }
	
	
	
	public void printMenu() {
		System.out.println("===Menu===");
		System.out.println("[1]Add Contact");
		System.out.println("[2]Update Contact");
		System.out.println("[3]Delete Contact");
		System.out.println("[4]Exit");
	 }
	public void updateMenu() {
		System.out.println("===Update===");
		System.out.println("[1]Contact Type ");
		System.out.println("[2]Contact Details ");
		System.out.println("[3]Exit ");
	 }
	
	public void menu(int choice) {
		Contact contact;
		int id;
		printMenu();
		switch(choice) {
			case 1: pd.listPeople();
					System.out.print("Select ID: ");
					id = input.nextInt();
					contact = addMenu();
					eu.printContact(contact);
					cd.addContact(id,contact);
				break;
				
			case 2: 
				break;
			case 3:
			
			case 4:
			
			default: break;
		
		 }
	
	 }
	 public Contact addMenu() {
	 	Contact contact = new Contact();
	 	
		contact.setType(createType());
		contact.setDetails(createDetails(contact));
	  	
	  	return contact;
	  }
	
	public void editContact(Contact contact) {
		int choice = 0;
	 	updateMenu();
	 	choice = input.nextInt();
	 	switch(choice) {
	 		case 1: contact.setType(createType());
	 			break;
	 		case 2: contact.setDetails(createDetails(contact));
	 			break;
	 		case 3:
	 			break;

	 		default:
	 			break;
	 	 }
	 	 return;
	
	 }
	public void printAddMenu() {
		System.out.println("Select Contact type: ");
		System.out.println("[1] Email ");
		System.out.println("[2] Landline");
		System.out.println("[3] Mobile ");
		System.out.print("Choice: ");
	 }
	public ContactType createType(){
		printAddMenu();
		int choice = input.nextInt();
		if(choice == 1) return ContactType.EMAIL;
		else if (choice == 2) return ContactType.LANDLINE;
		else if (choice == 3) return ContactType.MOBILE;
		return null;
	}
	
	public String createDetails(Contact contact) {
		System.out.println("Enter value for " + contact.getType());
		System.out.print("Value: ");
		String value = input.next();
		return value;
	 }

	   
 }
