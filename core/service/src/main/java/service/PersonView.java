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
import java.util.Optional;
import java.util.Comparator;
import java.util.Collections;
public class PersonView {
	private PersonDAO pd;
	private ContactView cv;
	private EntityUtil eu;
	
	Scanner input = new Scanner(System.in).useDelimiter("\\n");
	public PersonView(){
		pd = new PersonDAO();
		cv = new ContactView();
	 	eu = new EntityUtil();
	 }
    
    public void printMenu() {
		int choice = 0;
		do {
			System.out.println("\n===PERSON MENU===");
			System.out.println("[1]Add Person");
			System.out.println("[2]Update Person");
			System.out.println("[3]Delete Person");
			System.out.println("[4]List People");
			System.out.println("[5]Exit");
			System.out.print("Choice: ");
			choice = input.nextInt();
		 	menu(choice);
		 	
		 } while(choice!=5);
		
	 }
	
	
	public void menu(int choice) {
		Person person;
		int id;
		
		switch(choice) {
			case 1: person = addMenu();
					pd.addPerson(person);
				break;
				
			case 2: eu.printList(pd.listPeople(""));
					System.out.print("Select ID: ");
					id = input.nextInt();
					System.out.println("\n=====Editing Person=====");
					person = pd.getPerson(id);
					person = updateMenu(person);
					System.out.println("==========================");
					pd.updatePerson(person);
				break;
			case 3: eu.printList(pd.listPeople(""));
					System.out.print("Select ID: ");
					id = input.nextInt();
					pd.deletePerson(id);
				break;
			case 4:	sortMenu();
				break;
			case 5:
				break;
			
			default: break;
		
		 }
	
	 }
	 public void sortMenu() {
	 	int choice = 0;
	 	int choice2 = 0;
	 	
		 	System.out.println("Sort by: ");
		 	System.out.println("[1] GWA ");
		 	System.out.println("[2] Date Hired");
		 	System.out.println("[3] Last Name");
		 	System.out.println("[4] By ID (Default)");
		 	System.out.print("Choice: ");
		 	choice = input.nextInt();
			
			System.out.println("\nOrder: ");
		 	System.out.println("[1] Ascending (Default)");
		 	System.out.println("[2] Descending");
		 	System.out.print("Choice: ");
		 	choice2 = input.nextInt();
			
		 	sortPerson(choice,choice2);
	 	
	  }
	 public void sortPerson(int choice, int choice2) {
	 	 	String sortQuery = "";
			List persons;
			switch(choice) {
				
				case 2: sortQuery = sortQuery.concat("ORDER BY p.dateHired");
					break;
				
				case 3: sortQuery = sortQuery.concat("ORDER BY p.name.lastName");
					break;
				
				case 1:
				case 4: 			
			 	default: sortQuery = sortQuery.concat("ORDER BY p.id");
			 		break;
			 }
			switch(choice2) {
				case 1: sortQuery = sortQuery.concat(" ASC");
					break;
				case 2: sortQuery = sortQuery.concat(" DESC");
			 		break;
			 }
	 		
	 		//retrieve list
	 		persons = pd.listPeople(sortQuery);
	 		//if choice is equal to 1, sort using Comparator.comparingInt();
	 		if(choice == 1) {
	 			Comparator<Person> personComparator= Comparator.comparing(Person::getGwa);		
	 			if(choice2 == 2) {
	 				personComparator = personComparator.reversed();
	 			 }
	 			Collections.sort(persons,personComparator);
	 		}
	 		eu.printList(persons);
	  }
	 public Person addMenu() {

	 	List<Contact> contactInfo = new ArrayList<Contact>();
	 	Address address;
	 	
	 	Person person = new Person();
	 	Person.Name name = new Person.Name();
	 	
	 	System.out.println("Adding new person");
		person.setName(createName());
		System.out.println("Birthday: ");
		person.setBirthDay(createDate());
		person.setGender(createGender());
		person.setAddress(createAddress());
		person.setSchool(createSchool());
		person.setGwa(createGwa());
		person.setEmployed(createEmployment());
	
		createDateHired(person);
		person.setcontactInfo(createContactInfo(person));
		
		return person;
	  }
	public Person.Name createName(){
		String firstName;
	 	String lastName;
	 	String middleName;
		System.out.print("First name: ");
	 	firstName = input.next();
	 	System.out.print("Last name: ");
	 	lastName = input.next();
	 	System.out.print("Middle name: ");
		middleName = input.next();	
		return new Person.Name(firstName,lastName,middleName);
	
	}
	
	public Date createDate(){
		int year,month,day;
		
		System.out.print("Year(YYYY): ");
		year = input.nextInt();
		
		System.out.print("Month(MM): ");
		month = input.nextInt();
		
		System.out.print("Day(DD): ");
		day = input.nextInt();
	 	LocalDate ld = LocalDate.of(year,month,day);
		return Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
	 }
	 
	 public Address createAddress() {
	 	String streetNumber, city, zipCode;
	 	
	 	System.out.println("Address: ");
		System.out.print("Street Number: ");
		streetNumber = input.next();	
		System.out.print("City: ");
		city = input.next();
		System.out.print("Zip Code: ");
		zipCode = input.next();
		return new Address(streetNumber,city,zipCode);
		 
	 }
	 public Gender createGender() {
	 	System.out.print("Gender(1=MALE,2=FEMALE): ");
		int gender = input.nextInt();
		if(gender==1) return Gender.MALE;
		else return Gender.FEMALE;	
	  }
	 public double createGwa() {
	 	System.out.print("GWA: ");
		double gwa = input.nextDouble();
		return gwa;
	 
	  }
	  
	 public String createSchool() {
	 	System.out.print("School: ");
		String school = input.next();
		return school;
		 
	  }
	 public boolean createEmployment() {
	 	System.out.print("Employed(1=Yes,2=No): ");
		int employed = input.nextInt();
		if(employed==1) return true;
		else return false;
	  }
	  
	 public Person createDateHired(Person person) {
	 	if(person.isEmployed()) { 
	 		System.out.println("Date Hired: ");
	 		person.setDateHired(createDate());
	 	}
	 	else person.setDateHired(null);
	 	
	 	return person;
	  }
	 
	 public List<Contact> createContactInfo(Person person) {
	 	List<Contact> contactList;
	 	
	 	int choice = 0;
	  	Optional<List<Contact>> optList = Optional.ofNullable(person.getcontactInfo());
	  	if(!optList.isPresent()) contactList = new ArrayList<Contact>();
        else contactList = optList.get();
 
    	do { 	
    			for(Contact contact : contactList) {
    				eu.printContact(contact);
    			
    			 }
    			System.out.println("\n[1]Add Contact");
    			System.out.println("[2] Exit ");
    			System.out.print("Choice: ");
    			choice = input.nextInt();
    			switch(choice) {
    				case 1: contactList.add(cv.addMenu());
    					break;
    				case 2: 
    					break;
    				default:
    					break;
    			 }	
    		
    		} while(choice != 2);
    	return contactList;
	  }
	 
	 public Person updateMenu(Person person) {
		int choice=0;
		do{
			System.out.println("\n===Update===");
			System.out.println("[1]Name ");
			System.out.println("[2]Address ");
			System.out.println("[3]Contact");
			System.out.println("[4]Birthday ");
			System.out.println("[5]School ");
			System.out.println("[6]GWA ");
			System.out.println("[7]Employment Status ");
			System.out.println("[8]Date Hired ");
			System.out.println("[9]Gender");
			System.out.println("[10]Exit ");
			System.out.print("Choice: ");
			choice = input.nextInt();
			person = updatePerson(person, choice);
		} while(choice!=10);
	 	return person;
	 }
	 public Person updatePerson(Person person, int choice) {
	 
	 	
	 	switch(choice) {
	 		case 1: person.setName(createName());
	 			break;
	 		case 2: person.setAddress(createAddress());
	 			break;
	 		case 3: person.setcontactInfo(createContactInfo(person));
	 			break;
	 		case 4:	person.setBirthDay(createDate());
	 			break;
	 		case 5:	person.setSchool(createSchool());
	 			break;
	 		case 6:	person.setGwa(createGwa());
	 			break;
	 		case 7: person.setEmployed(createEmployment());
	 			break;
	 		case 8: person = createDateHired(person);
	 			break;
	 		case 9: person.setGender(createGender());
	 			break;
	 		case 10:
	 			break;
	 		default:
	 			break;
	 	 }
	 	 return person;
	 }
	   
 }
