import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import entities.*;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
public class ContactDAO {
	private EntityUtil eu;
	public ContactDAO() {
	  eu = new EntityUtil();
	 }
		
	public Contact getContact(int id){
      
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Contact contact = null;
      try {
         tx = session.beginTransaction();
         contact = (Contact)session.get(Contact.class, id); 
         eu.printContact(contact);
         tx.commit();
         tx = null;
         
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
         
      } finally {
      	session.close(); 
      	return contact;
      }
   }
	public void addContact(Integer personID, Contact contact) {
      
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Integer ContactID = null;
      
      try {
         tx = session.beginTransaction();
         Person person = (Person)session.get(Person.class, personID);
         person.getcontactInfo().add(contact);
         tx.commit();
         tx = null;
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      
   }
   
   
    public void updateContact(Contact newContact){
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      
      try {
      	 Integer contactID = 1;
         tx = session.beginTransaction();
         //Contact contact = (Contact)session.get(Contact.class, contactID);
         
         //Contact = newContact;
         Contact merged = (Contact) session.merge(newContact);
         
         tx.commit();
         tx = null;
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
         session.close(); 
      } finally {
      }
   }
   
   public void deleteContact(Integer contactID){
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         Contact contact = (Contact)session.get(Contact.class, contactID); 
         session.delete(contact); 
         tx.commit();
         tx = null;
         
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
   }
   
   public void listContacts(){
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Contact contact;
      try {
         tx = session.beginTransaction();
         List contacts = session.createQuery("FROM Contact").list(); 
         for (Iterator iterator = contacts.iterator(); iterator.hasNext();){
            contact = (Contact) iterator.next(); 
          	eu.printContact(contact);
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
     
    }
   
  
 }
