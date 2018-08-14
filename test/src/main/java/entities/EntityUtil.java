import java.util.List;
import java.util.Iterator;
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
        	printContact(contact);
        }
	
	 }
	 
	public void printContact(Contact contact) {
		System.out.println("\tContact ID: "+contact.getId());
		System.out.println("\tContact Type: "+contact.getType());
		System.out.println("\tContact Value: "+contact.getDetails());
		System.out.println("\tContact Index: "+contact.getIdx());
	 	System.out.println("");	
	 }

 }
