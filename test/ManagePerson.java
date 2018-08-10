//package infra;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import models.*;
public class ManagePerson {
   private static SessionFactory factory;
   
   public ManagePerson() {} 
   public static void main(String[] args) {
      
      
      try {
         factory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      
      ManageEmployee ME = new ManageEmployee();

      Address address = ME.addAddress("9","Pasig","1600");

      /* Add employee records in the database */
      Integer personID1 = ME.addEmployee("James","Menguito","Wagas",LocalDate.of(1996,9,23),LocalDate.of(2018,6,18),2.50,Gender.MALE,true,"UPLB",address,contactInfo);
      /* Add another employee record in the database */
     // Integer personID2 = ME.addEmployee("Dilip", "Kumar", 3000, address);

      /* List down all the employees */
      ME.listPeople();

      /* Update employee's salary records */
      //ME.updateEmployee(empID1, 5000);

      /* Delete an employee from the database */
      //ME.deleteEmployee(empID2);

      /* List down all the employees */
      //ME.listEmployees();

   }
   
   
   /* Method to add an address record in the database */
   public Address addAddress(String streetNumber, String city, String zipCode) {
      Session session = factory.openSession();
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
   public Integer addPerson(String firstName, String lastName, String middleName, LocalDate birthDay, LocalDate dateHired, double gwa, Gender gender, boolean employed, String school, Address address, List<Contact> contactInfo) {
      Session session = factory.openSession();
      Transaction tx = null;
      Integer employeeID = null;
      
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
      Session session = factory.openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         List persons = session.createQuery("FROM person").list(); 
         for (Iterator iterator = employees.iterator(); iterator.hasNext();){
            Person person = (Person) iterator.next(); 
            System.out.println("First Name: " + person.getFirstName()); 
            System.out.println("  Last Name:" + person.getLastName()); 
            System.out.println("  GWA: " + person.getGWA());
           
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
