package service;
import entities.*;
import dao.*;
import utilities.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import org.mockito.invocation.*;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class ContactServiceTest { 

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);	
	 }
	@Mock
	private ContactDAO cdMock;
	
	@Mock
	private PersonDAO pdMock;
	
	@Mock
	private InputUtil iuMock;
	
	@Mock
	private EntityUtil euMock;
	
	@Mock
	private Person personMock;
	
	@Mock
	private Contact contactMock;
	
	@Mock
	private ContactView cvMock2;	
	
	@InjectMocks
	private ContactView cvMock;
		
	@After
	public void after() {
	
	 }
	
	@Test
	public void constructorTest() { 
		ContactView cv = new ContactView();
		assertNotNull(cv);
	}
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
	
	@Test
	public void updateContactTest3() { 
		String input = "1\n2\n3\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ContactView cv = new ContactView();		
		Contact contact = new Contact();
		contact.setType(ContactType.EMAIL);
		contact = cv.updateMenu(contact);
		assertNotEquals(ContactType.MOBILE, contact.getType());
	}
	
	@Test
	public void updateContactTest4() { 
		String input = "2\nmenguito@yahoo.com\n3\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		ContactView cv = new ContactView();		
		Contact contact = new Contact();
		contact.setType(ContactType.EMAIL);
		contact.setDetails("james_menguito@gmail.com");
		contact = cv.updateMenu(contact);
		assertNotEquals("james_menguito@yahoo.com", contact.getDetails());
	}
	/*
	@Test
	public void menuTest1() {
		when(iuMock.getInt(anyInt(),anyInt())).thenReturn(3);
		when(pdMock.getPerson(anyInt())).thenReturn(new Person());
		when(personMock.getcontactInfo()).thenReturn(anyListOf(Contact.class));
		when(personMock.getcontactInfo().add(any(Contact.class))).thenReturn(true);
		cvMock.menu(1);
		verify(pdMock).updatePerson(any(Person.class));
	
	}
	*/
	@Test
	public void menuTest2() { 
		
		//when(cdMock.listContacts()).thenReturn(anyList());
		when(iuMock.getInt(anyInt(),anyInt())).thenReturn(3);
		cvMock.menu(2);
		verify(cdMock).getContact(anyInt());
	 }
	@Test
	public void menuTest3() { 
		when(iuMock.getInt(anyInt(),anyInt())).thenReturn(1);
		cvMock.menu(3);
		verify(cdMock,times(1)).listContacts();
		verify(euMock,times(1)).printContactList(anyList());
		verify(cdMock,times(1)).deleteContact(anyInt());	
		
	}
	
 } 
