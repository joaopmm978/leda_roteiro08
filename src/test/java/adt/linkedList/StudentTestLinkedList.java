package adt.linkedList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentTestLinkedList {

	protected LinkedList<Integer> lista1;
	protected LinkedList<Integer> lista2;

	@BeforeEach
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

	}

	private void getImplementations() {
		lista1 = new SingleLinkedListImpl<>();
		lista2 = new SingleLinkedListImpl<>();
	}

	@Test
	public void testIsEmpty() {
		assertFalse(lista1.isEmpty());
		assertTrue(lista2.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(3, lista1.size());
		assertEquals(0, lista2.size());
	}

	@Test
	public void testSearch() {
		assertTrue(2 == lista1.search(2));
		assertNull(lista1.search(4));
		assertFalse(3 == lista1.search(2));
	}

	@Test
	public void testInsert() {
		assertEquals(3, lista1.size());
		lista1.insert(5);
		lista1.insert(7);
		assertEquals(5, lista1.size());

		assertEquals(0, lista2.size());
		lista2.insert(4);
		lista2.insert(7);
		assertEquals(2, lista2.size());
	}

	@Test
	public void testRemove() {
		assertEquals(3, lista1.size());
		lista1.remove(2);
		lista1.remove(1);
		assertEquals(1, lista1.size());

	}

	@Test
	public void testToArray() {
		assertArrayEquals(new Integer[] {}, lista2.toArray());
		assertArrayEquals(new Integer[] { 3, 2, 1 }, lista1.toArray());
	}
}