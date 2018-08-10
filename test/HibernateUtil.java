import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	static {
		try {
			
			sessionFactory = new Configuration().configure()
												.buildSessionFactory();
		 } catch (Throwable ex) {
		 	
		 	throw new ExceptionInInitializerError(ex);	
		 }	
	 }
	//return sessionFactory
	public static SessionFactory getSessionFactory() {
	
		return sessionFactory;
	 }
	//close the connection
	public static void shutdown() { 
 		getSessionFactory().close();
 	 }
 }
