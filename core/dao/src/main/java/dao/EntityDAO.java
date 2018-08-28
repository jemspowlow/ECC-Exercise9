package dao;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.LinkedHashSet;
import entities.*;
import utilities.*;
import persistence.HibernateUtil;
import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.Hibernate;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.FetchMode;
public class EntityDAO<T> { 
	private final Class<T> entityClass;
	public EntityDAO (Class<T> entityClass) {
		this.entityClass = entityClass;
	 }
	
	public T getById(Integer id) {
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      T entity = null;
      try {
          entity = (T)session.load(entityClass, id); 
		 //Hibernate.initialize(person.getRoles());
      } catch (HibernateException e) {
         System.out.println("An error has occurred! Person ID does not exist!");
         if (tx!=null) tx.rollback();

         
      } finally {
      	session.close(); 
      	return entity;
      }
   }
	
	public void add(T entity) {
      
      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Integer personID = null;
      
      try {
         tx = session.beginTransaction();
         session.save(entity); 
         tx.commit();
         tx = null;
      } catch (HibernateException e) {
         System.out.println("Error adding entity to database.");
         e.printStackTrace();
         if (tx!=null) tx.rollback();

      } finally {
         session.close(); 
      }

   }
      
    public void update(T entity){
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         T merged = (T) session.merge(entity);
         tx.commit();
         tx = null;
      } catch (HibernateException|IllegalArgumentException e) {
         System.out.println("An error has occurred trying to update entity!");
         if (tx!=null) tx.rollback();
         tx = null;
         //e.printStackTrace(); 
         
      } finally {
      	 session.close(); 
      }
   }
   
   public void delete(Integer id){
      Session session =  HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      
      try {
         tx = session.beginTransaction();
         T entity = (T)session.get(entityClass, id); 
         session.delete(entity); 
         tx.commit();
         tx = null;
         
      } catch (HibernateException|IllegalArgumentException e) {
         System.out.println("An error has occurred while trying to delete entity!");
         if (tx!=null) tx.rollback();

      } finally {
         session.close(); 
      }
   }
   
   public List listAll(String query,String property, boolean order, String entityType) {

      Session session = HibernateUtil.getSessionFactory().openSession();
      Transaction tx = null;
      Set entitySet = null;
      Criteria cr = session.createCriteria(entityClass);
      
      //set order
      if(order) { 
      	cr.addOrder(Order.asc(property));
      } else { 
      	cr.addOrder(Order.desc(property));
      }
      if(entityType.equals("person")) { 
      	cr.setFetchMode("roles", FetchMode.EAGER)
      	  .setFetchMode("address",FetchMode.EAGER)
      	  .setFetchMode("contactInfo",FetchMode.EAGER);
       } else if (entityType.equals("contact")) {
      	cr.setFetchMode("person", FetchMode.EAGER);	
       } else if (entityType.equals("roles")) { 
       	cr.setFetchMode("persons", FetchMode.EAGER);
       }
      
      try {
         tx = session.beginTransaction();
         entitySet = new LinkedHashSet(cr.list()); 
		
       } catch (HibernateException e) {
         
         e.printStackTrace(); 
       } finally {
         session.close(); 
       }
  		
  		return new ArrayList(entitySet);   
    } 

}
