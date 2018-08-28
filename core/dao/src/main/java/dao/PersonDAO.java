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
public class PersonDAO {
	private EntityUtil eu;
	private EntityDAO ed;
	public PersonDAO() { 
		eu = new EntityUtil();
		ed = new EntityDAO(Person.class);
	}

	public Person getPerson(int id) {
      return (Person) ed.getById(id);
   }
	
	public void addPerson(Person person) {
      ed.add(person);
   }
      
    public void updatePerson(Person newPerson){
      ed.update(newPerson);
   }
   
   public void deletePerson(Integer personID){
      ed.delete(personID);
   }
   
   public List listPeople(String sortQuery,String property, boolean order,String entityType) {
	  String query = "FROM Person p left join fetch p.address left join fetch p.contactInfo left join fetch p.roles "+sortQuery;
      return ed.listAll(query,property,order, entityType);
    } 
 }
