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
import java.util.Set;
import java.util.LinkedHashSet;
public class RolesView {
	private RolesDAO rd;
	private EntityUtil eu;
	private InputUtil iu;
	private PersonDAO pd;
	public RolesView(){
		rd = new RolesDAO();
		eu = new EntityUtil();
	 	iu = new InputUtil();
	 	pd = new PersonDAO();
	 }
	
	
	
	public void printMenu() {
		int choice = 0;
		do{
		System.out.println("\n===ROLE MENU===");
		System.out.println("[1]Add a new Role");
		System.out.println("[2]Update Roles");
		System.out.println("[3]Delete Roles");
		System.out.println("[4]List Roles");
		System.out.println("[5]Exit");
	 	System.out.print("Choice: ");
	 	choice = iu.getInt(0,6);
	 	menu(choice);
	 	} while(choice!=5);
	 }
	 
	
	 
	public void menu(int choice) {
		Roles role;
		int id;
		switch(choice) {
			case 1: System.out.println("Add new Role:");
					role = createRole();
					rd.addRoles(role);
				break;
				
			case 2: id = getRoleId();
					role = rd.getRoles(id);
					role.setLabel(createLabel());
					rd.updateRoles(role);
					
				break;
			case 3: id = getRoleId();
					role = rd.getRoles(id);
					role.getPersons().clear();
					rd.updateRoles(role);
					rd.deleteRoles(id);
				break;
			case 4: System.out.println("List of Roles"); 
					eu.printRolesList(rd.listRoles());
				break;
			case 5:
				break;
			default: break;	
		}
	
	 }

	public Roles createRole() {
		Roles role = new Roles();
		role.setLabel(createLabel());
		return role;
	 }

	public String createLabel() {
		String label;
		eu.printString("Enter label: ");
		label = iu.getString(100);
	 	return label;
	 }
	
	public int getRoleId() { 
		System.out.println("List of Roles"); 
		eu.printRolesList(rd.listRoles());
		System.out.print("Select Roles ID: ");
		int id = iu.getInt(0,0);
		return id;
	}
	
	public void disassociate(Roles role) { 
		
		Set persons = role.getPersons();
		for(Iterator innerIterator = persons.iterator(); innerIterator.hasNext();){
        	Person person = (Person) innerIterator.next();
			removeFromPerson(person, role);
        }
	} 
	
	public void removeFromPerson(Person p,Roles role) { 
		p.getRoles().remove(role);
		pd.updatePerson(p);
	
	}
 }
