package utilities;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.Optional;
import entities.*;
public class EntityUtil {
	public EntityUtil(){};
	public void printPerson(Person person){
		System.out.println("===============================================================");
        System.out.println("ID: "+person.getId());
        System.out.println("First Name: " + person.getName().getFirstName());
        System.out.println("Last Name: " + person.getName().getLastName());
        System.out.println("Middle Name: " + person.getName().getMiddleName()); 
        System.out.println("Birthday: " + person.getBirthDay());
        System.out.println("Gender: "+ person.getGender());
        System.out.println("Address ");
        System.out.println("\tStreet Number: " +  person.getAddress().getStreetNumber());
        System.out.println("\tCity: " + person.getAddress().getCity());
        System.out.println("\tZipcode: " + person.getAddress().getZipCode());
        System.out.println("School: " + person.getSchool());
        System.out.println("GWA: " + person.getGwa());
        System.out.println("Employed: "+person.isEmployed());
        System.out.println("Date Hired: "+person.getDateHired());
        System.out.println("Contact List: ");
        List contacts = person.getcontactInfo();
        for(Iterator innerIterator = contacts.iterator(); innerIterator.hasNext();){
        	Contact contact = (Contact) innerIterator.next();
        	Optional<Contact> optCon = Optional.ofNullable(contact);
        	if(!optCon.isPresent()) continue;
        	printContactLess(contact);
        }
        printString("Roles: \n");
        Set roles = person.getRoles();
        
        for(Iterator iterator = roles.iterator(); iterator.hasNext();) {
        	Roles role = (Roles) iterator.next();
        	Optional<Roles> optRole = Optional.ofNullable(role);
        	if(!optRole.isPresent()) continue;
        	printString("\t"+role.getLabel()+"\n");
         }
	 }
	public void printPersonNames(Person person) { 
		System.out.println("\t"+person.getName().getLastName() + ", " + person.getName().getFirstName() + " " +person.getName().getMiddleName());
	}
	public void printContact(Contact contact) {
		System.out.println("\tContact ID: "+contact.getId());
		System.out.println("\tContact Type: "+contact.getType());
		System.out.println("\tContact Value: "+contact.getDetails());
		System.out.println("\tContact Index: "+contact.getIdx());

	 }
	public void printContactMore(Contact contact) { 
		printString("\t Owner: "+contact.getPerson().getName().getLastName()+", " + contact.getPerson().getName().getFirstName()+"\n\n");
	}
	public void printContactLess(Contact contact) {
		printString("\t Contact Type: "+contact.getType()+"\n");
		printString("\t Contact Value: "+contact.getDetails()+"\n\n");
	
	 }
	public void printRolesList(List roles) { 
		for (Iterator iterator = roles.iterator(); iterator.hasNext();){
            Roles role = (Roles) iterator.next(); 
          	printRoles(role);
         }
	}
	
	public void printContactList(List contact) { 
		for (Iterator iterator = contact.iterator(); iterator.hasNext();){
            Contact contactz = (Contact) iterator.next(); 
          	printContact(contactz);
         	printContactMore(contactz);
         }
	}
	public void printRoles(Roles role) {
		printString("======================================================\n");
		System.out.println("\tRole ID: "+role.getId());
		System.out.println("\tRole Title: "+role.getLabel());
		System.out.println("\tList of Persons: ");
		
		role.getPersons().stream()
						 .forEach(p -> printPersonNames(p));
		
	 }
	public void printList(List persons) {
		
		for (Iterator iterator = persons.iterator(); iterator.hasNext();){
            Person person = (Person) iterator.next(); 
          	printPerson(person);
         }
	 }
	
	public void printString(String string) { 
		System.out.print(string);
	}
 }
