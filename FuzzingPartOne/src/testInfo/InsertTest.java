package testInfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.DLLImp;

public class InsertTest {
	
	DLLImp d = new DLLImp();
	
	@Before
	public void setUp(){
		d.addAtEnd("Anne");
		d.addAtEnd("Bob");
		d.addAtEnd("Chris");
		
	}

	@Test
	public void insertAtPos() {
		d.insert("Brook", 3);
		assertEquals("The 3rd element should be Brook", "Brook", d.elementAt(3));
		d.insert("Amy", 1);
		assertEquals("The 1st element should be Amy", "Amy", d.elementAt(1));
		d.insert("Zack", 5);
		assertEquals("The 5th element should be Zack", "Zack", d.elementAt(5));
		
		assertEquals("The List should have the orginal size of 3 + 3 = 4", 6, d.getSize());
	}
	
	@Test(expected= NullPointerException.class)
	public void badArg(){
		d.insert("Lou", -1);
		d.insert("Lou", 0);
		d.insert("Lou", 6);
	}
	
}
