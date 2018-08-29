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
import java.util.Set;
import java.util.HashSet;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class RolesServiceTest { 
	@Mock
	PersonView pvMock;
	
	@Mock
	PersonDAO pdMock;
	
	@Mock
	RolesDAO rdMock;
	
	@Mock
	EntityUtil euMock;
	
	@Mock
	InputUtil iuMock;
	
	@InjectMocks
	RolesView rvMock;
	
	@Test
	public void constructorTest() { 
	
		RolesView rv = new RolesView();
		assertNotNull(rv);
	 }
	 
	@Test
	public void createRoles1() { 
		String input = "JUNIOR DEV\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		RolesView rv = new RolesView();
		Roles role = rv.createRole();
		
		assertEquals(role.getLabel(),"JUNIOR DEV");
	}
	
	@Test
	public void createRoles2() { 
		String input = "JUNIOR DEV\n";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);
		
		RolesView rv = new RolesView();
		Roles role = rv.createRole();
		
		assertNotEquals(role.getLabel(),"SENIOR DEV");
	}
	
	
	@Test
	public void removeFromPersonTest() { 
		Person p = mock(Person.class);
		Roles r = mock(Roles.class);
		Set<Roles> roless = (HashSet<Roles>) mock(HashSet.class);
		roless.add(r);
		p.setRoles(roless);
		
		when(p.getRoles()).thenReturn(roless);
		
		rvMock.removeFromPerson(p,r);
		verify(pdMock).updatePerson(any(Person.class));
		
	}

}
