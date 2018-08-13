import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import entities.*;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
public class PersonDAO {
	public PersonDAO() { }
	/**
	fname
	lastname
	mname
	bday 
		-y 
		-m 
		-d
	address
		-streetnum
		-city
		-zipcode
	
	school
	gwa
	EMPLOYED = y or n
	datehired 
		-y 
		-m 
		-d
	
			
	**/
	/* Method to add an Person record in the database */
	public Integer addPerson(Person person) {
      
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Integer personID = null;
      
      try {
         tx = session.beginTransaction();
         personID = (Integer) session.save(person); 
         tx.commit();
         tx = null;
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return personID;
   }
   
   
    public void updatePerson(Person person){
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Person person = (Person)session.get(Person.class, PersonID); 
         session.update(person);
         tx.commit();
         tx = null;
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   public void deletePerson(Integer PersonID){
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Person Person = (Person)session.get(Person.class, PersonID); 
         session.delete(Person); 
         tx.commit();
         tx = null;
         
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   } 
 }
