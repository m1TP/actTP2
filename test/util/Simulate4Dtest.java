package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class Simulate4Dtest {

	@Test
	public void testConvert1() {
		int res = Simulate4D.convert(1, 1, 0, 0, 30, 30, 30);
		assertEquals(res, 1+1*30);
	}
	
	@Test
	public void testConvert2() {
		int res = Simulate4D.convert(10, 10, 0, 0, 30, 30, 30);
		assertEquals(res, 10+10*30);
	}
	
	@Test
	public void testConvert3() {
		int res = Simulate4D.convert(10, 15, 2, 0, 30, 30, 30);
		assertEquals(res, 10+15*30+2*30*30);
	}
	
	
	@Test
	public void testConvert4() {
		int res = Simulate4D.convert(10, 15, 2, 6, 30, 30, 30);
		assertEquals(res, 10+15*30+2*30*30+6*30*30*30);
	}

}
