package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class SymmetryTest {

	@Test
	public void testNormalizedSymmetry() {
		Symmetry s = new Symmetry(5, 4, 1, 0);
		assertEquals((new Symmetry(5, 4, 1, 0)).normalizedSymmetry().equals(s),true);
		assertEquals((new Symmetry(5, 4, 1, 3)).normalizedSymmetry().equals(s),true);
		assertEquals((new Symmetry(5, 4, 3, 0)).normalizedSymmetry().equals(s),true);
		assertEquals((new Symmetry(5, 4, 3, 3)).normalizedSymmetry().equals(s),true);
		assertEquals((new Symmetry(4, 5, 0, 1)).normalizedSymmetry().equals(s),true);
		assertEquals((new Symmetry(4, 5, 0, 3)).normalizedSymmetry().equals(s),true);
		assertEquals((new Symmetry(4, 5, 3, 1)).normalizedSymmetry().equals(s),true);
		assertEquals((new Symmetry(4, 5, 3, 3)).normalizedSymmetry().equals(s),true);
	}

	@Test
	public void testIsSymmetry() {
		Symmetry s = new Symmetry(5, 4, 1, 0);
		assertEquals(s.isSymmetry(5, 4, 1, 0),true);
		assertEquals(s.isSymmetry(5, 4, 1, 3),true);
		assertEquals(s.isSymmetry(5, 4, 3, 0),true);
		assertEquals(s.isSymmetry(5, 4, 3, 3),true);
		assertEquals(s.isSymmetry(4, 5, 0, 1),true);
		assertEquals(s.isSymmetry(4, 5, 0, 3),true);
		assertEquals(s.isSymmetry(4, 5, 3, 1),true);
		assertEquals(s.isSymmetry(4, 5, 3, 3),true);
	}

	@Test
	public void testVerticalSymmetry1() {
		Symmetry s = new Symmetry(5, 4, 1, 0);
		assertEquals(s.verticalSymmetry(5, 4, 3, 0),true);
	}
	
	@Test
	public void testVerticalSymmetry2() {
		Symmetry s = new Symmetry(5, 4, 3, 0);
		assertEquals(s.verticalSymmetry(5, 4, 1, 0),true);
	}
	
	@Test
	public void testVerticalSymmetry3() {
		Symmetry s = new Symmetry(4, 4, 1, 0);
		assertEquals(s.verticalSymmetry(4, 4, 2, 0),true);
	}
	
	@Test
	public void testVerticalSymmetry4() {
		Symmetry s = new Symmetry(1, 1, 0, 0);
		assertEquals(s.verticalSymmetry(1, 1, 0, 0),true);
	}
	
	@Test
	public void testVerticalSymmetry5() {
		Symmetry s = new Symmetry(2, 2, 0, 0);
		assertEquals(s.verticalSymmetry(2, 2, 1, 0),true);
	}
	
	@Test
	public void testHorizontalSymmetry1() {
		Symmetry s = new Symmetry(4, 5, 0, 1);
		assertEquals(s.horizontalSymmetry(4, 5, 0, 3),true);
	}
	
	@Test
	public void testHorizontalSymmetry2() {
		Symmetry s = new Symmetry(4, 5, 0, 3);
		assertEquals(s.horizontalSymmetry(4, 5, 0, 1),true);
	}
	
	@Test
	public void testHorizontalSymmetry3() {
		Symmetry s = new Symmetry(4, 4, 0, 1);
		assertEquals(s.horizontalSymmetry(4, 4, 0, 2),true);
	}
	
	@Test
	public void testHorizontalSymmetry4() {
		Symmetry s = new Symmetry(1, 1, 0, 0);
		assertEquals(s.horizontalSymmetry(1, 1, 0, 0),true);
	}
	
	@Test
	public void testHorizontalSymmetry5() {
		Symmetry s = new Symmetry(2, 2, 0, 0);
		assertEquals(s.horizontalSymmetry(2, 2, 0, 1),true);
	}

	@Test
	public void testHorizontalAndVerticalSymmetry1() {
		Symmetry s = new Symmetry(4, 5, 0, 1);
		assertEquals(s.horizontalAndVerticalSymmetry(4, 5, 3, 3),true);
	}
	
	@Test
	public void testHorizontalAndVerticalSymmetry2() {
		Symmetry s = new Symmetry(5, 4, 1, 0);
		assertEquals(s.horizontalAndVerticalSymmetry(5, 4, 3, 3),true);
	}
	
	@Test
	public void testHorizontalAndVerticalSymmetry3() {
		Symmetry s = new Symmetry(4, 4, 1, 0);
		assertEquals(s.horizontalAndVerticalSymmetry(4, 4, 2, 3),true);
	}
	
	@Test
	public void testHorizontalAndVerticalSymmetry4() {
		Symmetry s = new Symmetry(1, 1, 0, 0);
		assertEquals(s.horizontalAndVerticalSymmetry(1, 1, 0, 0),true);
	}
	
	@Test
	public void testHorizontalAndVerticalSymmetry5() {
		Symmetry s = new Symmetry(2, 2, 0, 0);
		assertEquals(s.horizontalAndVerticalSymmetry(2, 2, 1, 1),true);
	}

	
}
