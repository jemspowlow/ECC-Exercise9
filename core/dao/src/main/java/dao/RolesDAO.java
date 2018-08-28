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
public class RolesDAO {
	private EntityUtil eu;
	private EntityDAO ed;
	public RolesDAO() {
		eu = new EntityUtil();
	 	ed = new EntityDAO(Roles.class);
	 }
	
	public Roles getRoles(int id){
     return (Roles) ed.getById(id);
     }
	
	public void addRoles(Roles role) {
     ed.add(role);     
     }  
    
    public void updateRoles(Roles newRoles){
     ed.update(newRoles);
     }
   
    public void deleteRoles(Integer roleID){
     ed.delete(roleID);
     }
   
    public List listRoles(){
      String query = "FROM Roles role left join fetch role.persons";
      return ed.listAll(query,"id",true,"roles");
     }
	
 }
