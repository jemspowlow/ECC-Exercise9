import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.LinkedHashSet;
import entities.*;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
public class PersonDAO {
	private EntityUtil eu;
	public PersonDAO() { 
		eu = new EntityUtil();
	}

	public Person getPerson(int id){
      EntityUtil eu = new EntityUtil();
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Person person = null;
      try {
         tx = session.beginTransaction();
         person = (Person)session.get(Person.class, id); 
         eu.printPerson(person);
         tx.commit();
         tx = null;
         
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
         
      } finally {
      	session.close(); 
      	return person;
      }
   }
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
      
    public void updatePerson(Person newPerson){
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      
      try {
      	 Integer PersonID = 1;
         tx = session.beginTransaction();
         //Person person = (Person)session.get(Person.class, PersonID);
         
         //person = newPerson;
         Person merged = (Person) session.merge(newPerson);
         
         tx.commit();
         tx = null;
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
         session.close(); 
      } finally {
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
   
   public List listPeople(String sortQuery) {

      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Set persons = null;
      try {
         tx = session.beginTransaction();
         persons = new LinkedHashSet(session.createQuery("FROM Person p left join fetch p.address left join fetch p.contactInfo "+sortQuery).list()); 
		
         tx.commit();
       } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
       } finally {
         session.close(); 
       }
  		
  		return new ArrayList(persons);   
    } 
 }
