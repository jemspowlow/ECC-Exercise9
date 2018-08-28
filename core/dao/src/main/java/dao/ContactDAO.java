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
public class ContactDAO {
	private EntityUtil eu;
	private EntityDAO ed;
	public ContactDAO() {
	  eu = new EntityUtil();
	  ed = new EntityDAO(Contact.class);
	 }
		
	public Contact getContact(int id){
      return (Contact) ed.getById(id); 
	 }

    public void updateContact(Contact newContact){
      ed.update(newContact);
    }
   
   public void deleteContact(Integer contactID){
      ed.delete(contactID);
    }

   public List listContacts(){
     String query = "FROM Contact c left join fetch c.person";
     return ed.listAll(query,"id",true,"contact");
    }
   
  
 }
