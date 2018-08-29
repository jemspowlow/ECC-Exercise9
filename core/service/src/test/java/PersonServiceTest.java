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
import java.util.Date;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PersonServiceTest { 
	@Test
	public void constructorTest() { 
		PersonView pv = new PersonView();
		assertNotNull(pv);
	}
	@Test
	public void createPersonTest1() { 
		String input = "James\nMenguito\nWagas\n1996\n09\n23\n1\n9\nPasig\n1600\nuplb\n2.0\n2\n2\n2\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = pv.addMenu();
		assertEquals("James", person.getName().getFirstName());
		
	}
	
	@Test
	public void createPersonTest2() { 
		String input = "James\nMenguito\nWagas\n1996\n09\n23\n1\n9\nPasig\n1600\nuplb\n2.0\n2\n2\n2\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = pv.addMenu();
		assertEquals("Menguito", person.getName().getLastName());
		
	}
	
	@Test
	public void createPersonTest3() { 
		String input = "James\nMenguito\nWagas\n1996\n09\n23\n1\n9\nPasig\n1600\nuplb\n2.0\n2\n2\n2\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = pv.addMenu();
		assertEquals(Gender.MALE, person.getGender());
		
	}
	
	@Test
	public void createPersonTest4() { 
		String input = "James\nMenguito\nWagas\n1996\n09\n23\n1\n9\nPasig\n1600\nuplb\n2.0\n2\n2\n2\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = pv.addMenu();
		assertNull(person.getDateHired());
		
	}
	
	@Test
	public void createPersonTest5() { 
		String input = "James\nMenguito\nWagas\n1996\n09\n23\n1\n9\nPasig\n1600\nuplb\n2.0\n2\n2\n2\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = pv.addMenu();
		assertNotNull(person.getBirthDay());
	}
	
	@Test
	public void createPersonTest6() { 
		String input = "James\nMenguito\nWagas\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = new Person();
		person.setName(pv.createName());
		assertEquals(person.getName().getLastName(), "Menguito");
	}
	
	@Test
	public void createPersonTest7() { 
		String input = "James\nMenguito\nWagas\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = new Person();
		person.setName(pv.createName());
		assertNotEquals(person.getName().getMiddleName(), "Menguito");
	}
	
	
	@Test
	public void createPersonTest8() { 
		String input = "1996\n09\n23\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = new Person();
		person.setBirthDay(pv.createDate());
		assertTrue(person.getBirthDay() instanceof Date);
	 }
	
	@Test
	public void createPersonTest9() { 
		String input = "900\n1996\n09\n23\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = new Person();
		person.setBirthDay(pv.createDate());
		assertTrue(person.getBirthDay() instanceof Date);
	 }

	@Test
	public void createAddressTest1() { 
		String input = "9\nPasig\n1600\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = new Person();
		person.setAddress(pv.createAddress());
		assertTrue(person.getAddress() instanceof Address);	
	}
	
	@Test
	public void createAddressTest2() { 
		String input = "9\nPasig\n1600\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = new Person();
		person.setAddress(pv.createAddress());
		assertEquals(person.getAddress().getCity(),"Pasig");	
	}
	
	@Test
	public void createSchoolTest1() { 
		String input = "uplb\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = new Person();
		person.setSchool(pv.createSchool());
		assertEquals(person.getSchool(),"uplb");	
	}
	
	@Test
	public void createSchoolTest2() { 
		String input = "upd\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = new Person();
		person.setSchool(pv.createSchool());
		assertNotEquals(person.getSchool(),"uplb");	
	}
	
	
	@Test
	public void updatePersonTest1() { 
		String input = "James\nMenguito\nWagas\n1996\n09\n23\n1\n9\nPasig\n1600\nuplb\n2.0\n2\n2\n2\nJohn Lloyd\nCruz\nPopoy\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = pv.addMenu();
		person = pv.updatePerson(person,1);
		assertEquals("Cruz", person.getName().getLastName());
	
	}
	
	@Test
	public void updatePersonTest2() { 
		String input = "James\nMenguito\nWagas\n1996\n09\n23\n1\n9\nPasig\n1600\nuplb\n2.0\n2\n2\n2\nJohn Lloyd\nCruz\nPopoy\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		PersonView pv = new PersonView();
		Person person = pv.addMenu();
		person = pv.updatePerson(person,1);
		assertNotEquals("Menguito", person.getName().getLastName());
	
	}
	
		
	
	
	
}
