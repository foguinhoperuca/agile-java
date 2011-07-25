package br.com.abacomm.agilejava;

import junit.framework.TestSuite;

public class AllSuites {
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(CharacterTest.class);
		return suite;
	}
}
