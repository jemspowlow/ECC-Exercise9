//package infra;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import entities.*;
public class ManagePerson {
   private static SessionFactory factory;
   
   public ManagePerson() {}
     
   /* Method to add an address record in the database */
   public Address addAddress(String streetNumber, String city, String zipCode) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Integer addressID = null;
      Address address = null;
      
      try {
         tx = session.beginTransaction();
         address = new Address(streetNumber, city, zipCode);
         addressID = (Integer) session.save(address); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return address;
   }

   /* Method to add an employee record in the database */
   public Integer addPerson(String firstName, String lastName, String middleName, Date birthDay, Date dateHired, double gwa, String gender, 	boolean employed, String school, Address address, List<Contact> contactInfo) {
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Integer personID = null;
      
      try {
         tx = session.beginTransaction();
         Person person = new Person(firstName, lastName, middleName, birthDay, dateHired, gwa, gender, employed, school, address, 				contactInfo);
         personID = (Integer) session.save(person); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return personID;
   }

   /* Method to list all the employees detail */
   public void listPeople(){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List persons = session.createQuery("FROM Person").list(); 
         for (Iterator iterator = persons.iterator(); iterator.hasNext();){
            Person person = (Person) iterator.next(); 
            System.out.println("First Name: " + person.getFirstName()); 
            System.out.println("  Last Name: " + person.getLastName()); 
            System.out.println("  GWA: " + person.getGwa());
            Address add = person.getAddress();
            System.out.println("Address ");
            System.out.println("\tStreet: " +  add.getStreetNumber());
            System.out.println("\tCity: " + add.getCity());
            System.out.println("\tZipcode: " + add.getZipCode());
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
     
   }
   
   /* Method to update salary for an employee 
   public void updateEmployee(Integer EmployeeID, int salary ){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
         employee.setSalary( salary );
         session.update(employee);
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   /* Method to delete an employee from the records 
   public void deleteEmployee(Integer EmployeeID){
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
         session.delete(employee); 
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   } */
}
