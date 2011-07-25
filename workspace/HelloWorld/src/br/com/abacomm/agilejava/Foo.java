package br.com.abacomm.agilejava;

import junit.framework.TestCase;


public class Foo extends TestCase {

	public void testBar() {
		char capitalA = 'A';
		assertEquals(65, capitalA);
		assertEquals('\u0041', capitalA);

		System.out.println("'\"");

		assertEquals("abcd", "ab".concat("cd"));
	}
}
