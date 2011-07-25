package br.com.abacomm.agilejava;

import java.util.ArrayList;
import java.util.Collections;

import junit.framework.TestCase;

import org.junit.Test;

public class CharacterTest extends TestCase {

	//@Test
	public void testWhitespace() {
		Character newline = new Character('\t');
		Character tab = new Character('\n');
		@SuppressWarnings("unused")
		Character space = new Character('\b');

		assertEquals(true, Character.isWhitespace(newline));
		assertTrue(Character.isWhitespace(tab));
//		assertEquals(true, Character.isWhitespace(space));
	}

	@Test
	public void testSortStringsInPlace() {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> sortedList;

		list.add("Heller");
		list.add("Kafka");
		list.add("Camus");
		list.add("Boyle");

		sortedList = new ArrayList<String>(list);
		Collections.sort(sortedList);

		assertEquals("Boyle", sortedList.get(0));
		assertEquals("Camus", sortedList.get(1));
		assertEquals("Heller", sortedList.get(2));
		assertEquals("Kafka", sortedList.get(3));

		assertEquals("Heller", list.get(0));
		assertEquals("Kafka", list.get(1));
		assertEquals("Camus", list.get(2));
		assertEquals("Boyle", list.get(3));
	}
}
