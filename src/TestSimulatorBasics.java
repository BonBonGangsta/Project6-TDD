import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.Assert.fail;

/*
 * Author: Renata Rand McFadden
 * Unit tests for Simulator class
 * Checks that Simulator class exists with correct attributes, constants, constructors, and methods
 */
	
public class TestSimulatorBasics {

	@Test
	// Class exists
	// PASSED
	public void testSimulatorClassExists() {
		try {
	        Class.forName("Simulator");
	    } catch (ClassNotFoundException e) 
	    {
	        fail("Should have a class called Simulator");
	    }
	}
	
	@Test
	// Only builtin constructor exists with no parameters
	// PASSED
	public void testSimulatorConstructorExists() {
		Constructor list[] = Simulator.class.getConstructors();  // get all constructors
		if (list.length > 1)
			fail("Simulator class should only have builtin constructor");

	}

	@Test
	// PASSED
	// Check that Simulator has the required methods:
	//    public int Simulator.getStopsFromUser()  
	public void testGetStopsFromUserExists()
	{
		boolean found = false;  
		Method list[] = Simulator.class.getDeclaredMethods();
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public int Simulator.getStopsFromUser()"))
				found = true;
		}
		if (!found)
			fail("Simulator class should have a public method called getStopsFromUser with no parameters");
	}
	
	@Test
	// PASSED
	// Check that Simulator has the required methods:
	//    public File Simulator.getInputFile()  
	public void testGetInputFileExists()
	{
		boolean found = false;  
		Method list[] = Simulator.class.getDeclaredMethods();
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public java.io.File Simulator.getInputFile()"))
				found = true;
		}
		if (!found)
			fail("Simulator class should have a public method called getInputFile with no parameter that returns File");
	}
	
	@Test
	// PASSED
	// Check that Simulator has the required methods:
	//    public ArrayList<Customer> Simulator.checkFile(int stops, File file)  
	public void testCheckFileExists()
	{
		boolean found = false;  
		Method list[] = Simulator.class.getDeclaredMethods();
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public java.util.ArrayList Simulator.checkFile(int,java.io.File)"))
				found = true;
		}
		if (!found)
			fail("Simulator class should have a public method called checkFile with two parameter and returns ArrayList<Customer>");
	}
	
	@Test
	// PASSED
	// Check that Simulator has the required methods:
	//    public void Simulator.run(int,ArrayList<Customer>)  
	public void testRunExists()
	{
		boolean found = false;  
		Method list[] = Simulator.class.getDeclaredMethods();
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public void Simulator.run(int,java.util.ArrayList)"))
				found = true;
		}
		if (!found)
			fail("Simulator class should have a public method called run with 2 parameters - int and ArrayList<Customer>");
	}
	
	@Test
	// PASSED
	// Check that Simulator has the required methods:
	//    public static void Simulator.main(String[])  
	public void testMainExists()
	{
		boolean found = false;  
		Method list[] = Simulator.class.getDeclaredMethods();
		for(int i = 0; i < list.length; i++) // loop through list of attributes
		{
			String value = ""+list[i]; // convert to string
			if (value.contentEquals("public static void Simulator.main(java.lang.String[])"))
				found = true;
		}
		if (!found)
			fail("Simulator class should have a public method called main with String array parameter");
	}
	
	@Test
	// PASSED
	// Check that Simulator only has the required 5 methods 
	public void testMethodsOnlyFive()
	{
		Method list[] = Simulator.class.getDeclaredMethods();  // get all methods
		if (list.length > 5)
			fail("Simulator class should only have four methods defined");
	}

}
