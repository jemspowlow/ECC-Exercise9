import java.util.Scanner;
import entities.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
public class PersonView {
	private PersonDAO pd;
	Scanner input = new Scanner(System.in).useDelimiter("\\n");
	public PersonView(){
		pd = new PersonDAO();
	 }
	
	public void printPerson(Person person){
		System.out.println();
	
	 }
	
	public void printMenu() {
		System.out.println("===Menu===");
		System.out.println("[1]Add Person");
		System.out.println("[2]Update Person");
		System.out.println("[3]Delete Person");
		System.out.println("[4]Exit");
	 }
	public void updateMenu() {
		System.out.println("===Update===");
		System.out.println("[1]Name ");
		System.out.println("[2]Address ");
		System.out.println("[3]Contact");
		System.out.println("[4]Birthday ");
		System.out.println("[5]School ");
		System.out.println("[6]GWA ");
		System.out.println("[7]Employment Status ");
		System.out.println("[8]Date Hired ");
		System.out.println("[9]Exit ");
	 }
	
	public void menu(int choice) {
		Person person;
		switch(choice) {
			case 1: person = addMenu();
					pd.addPerson(person);
				break;
				
			case 2: person = updatePerson();
					pd.updatePerson(person);
			
			case 3:
			
			case 4:
			
			default: break;
		
		 }
	
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
		person.setAddress(createAddress());
		person.setSchool(createSchool());
		person.setGwa(createGwa());
		person.setEmployment(createEmployment());
		
		createDateHired(person);
		
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
		return new Person.Name(firstName,lastName,middleName));
	
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
	 
	 public double createGwa() {
	 	System.out.print("GWA: ");
		gwa = input.nextDouble();
		person.setGwa(gwa);
	 
	  }
	  
	 public String createSchool() {
	 	System.out.print("School: ");
		school = input.next();
		person.setSchool(school);
		 
	  }
	 public boolean createEmployment() {
	 	System.out.println("Employed(1=Yes,2=No): ");
		employed = input.nextInt();
		if(employed==1) return true;
		else return false;
	  }
	  
	 public void createDateHired(Person person) {
	 	if(person.isEmployed()) person.setDateHired(createDate());
	 	else person.setDateHired(null);
	 
	  }
	 public Person updatePerson() {
	 	int choice = 0;
	 	switch(choice) {
	 		case 1: 
	 		
	 		case 2:
	 		
	 		case 3:
	 		
	 		case 4:
	 		
	 		case 5:
	 		
	 		case 6:
	 		
	 		case 7:
	 		
	 		case 8:
	 		
	 		case 9:
	 	
	 	 }
	  }
 }
