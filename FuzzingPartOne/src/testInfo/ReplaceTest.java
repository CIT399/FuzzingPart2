package testInfo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.DLLImp;

public class ReplaceTest {
	
	DLLImp d = new DLLImp();
	
	@Before
	public void setUp(){
		d.addAtEnd("Anne");
		d.addAtEnd("Bob");
		d.addAtEnd("Chris");
		d.replace("Branden", 2);
		d.replace("Amy", 1);
		d.replace("Clara", 3);
		
		
	}
	
	@Test
	public void replaceAtPos() {
		assertEquals("The 2rd element should be Branden after being replaced", "Branden", d.elementAt(2));
		assertEquals("The 1rd element should be Amy after being replaced", "Amy", d.elementAt(1));
		assertEquals("The 3rd element should be Clara after being replaced", "Clara", d.elementAt(3));
		assertEquals("The List should still have the orginal size of 3", 3, d.getSize());

	}
	
	@Test(expected= NullPointerException.class)
	public void badArg(){
		d.replace("Lou", -1);
		d.replace("Lou", 0);
		d.replace("Lou", 4);
	}
	
	
}
