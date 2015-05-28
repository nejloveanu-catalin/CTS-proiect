package csie.ase.unitTesting;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestSuiteComandaMasa extends TestCase{
	
	public static TestSuite suite(){
		TestSuite suite = new TestSuite();
		
		suite.addTestSuite(TestComandaMasa.class);
		return suite;
	}

}
