package service;
import entities.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class TestService { 

	@Before
	public void setUp() {
	
	 }
	
	@After
	public void after() { }
	
	@Test
	public void createContactTest1() { 
		String input = "1\njamespaolo.menguito@gmail.com\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ContactView cv = new ContactView();
		Contact contact = cv.addMenu();
		assertEquals("jamespaolo.menguito@gmail.com", contact.getDetails());
	}
	
	@Test
	public void createContactTest2() { 
		String input = "2\n87000\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ContactView cv = new ContactView();
		Contact contact = cv.addMenu();
		assertEquals(ContactType.LANDLINE, contact.getType());
	}
	
	@Test
	public void createContactTest3() {
		String input = "3\n09258890927\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ContactView cv = new ContactView();
		Contact contact = cv.addMenu();
		assertNotEquals("09258890", contact.getDetails());
		
	}
	
	@Test
	public void createContactTest4() { 
		String input = "2\n09258890927\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ContactView cv = new ContactView();
		Contact contact = cv.addMenu();
		assertNotEquals(ContactType.EMAIL, contact.getType());
	}

	@Test
	public void updateContactTest1() { 
		String input = "1\n2\n3\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ContactView cv = new ContactView();		
		Contact contact = new Contact();
		contact.setType(ContactType.EMAIL);
		contact = cv.updateMenu(contact);
		assertEquals(ContactType.LANDLINE, contact.getType());
	}
	
	@Test
	public void updateContactTest2() { 
		String input = "2\njames_menguito@yahoo.com\n3\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ContactView cv = new ContactView();		
		Contact contact = new Contact();
		contact.setType(ContactType.EMAIL);
		contact.setDetails("jamespaolo.menguito@gmail.com");
		contact = cv.updateMenu(contact);
		assertEquals("james_menguito@yahoo.com", contact.getDetails());
	}

 } 
