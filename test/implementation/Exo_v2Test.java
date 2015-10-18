package implementation;

import static org.junit.Assert.*;

import org.junit.Test;

public class Exo_v2Test {

	@Test
	public void testF_naif() {
		Exo_v2 exo = new Exo_v2();
		int res = exo.f_naif(1, 1, 0, 0);
		assertEquals(res,0);
		
		//(2,2)-----------------------
		res = exo.f_naif(2, 2, 0, 1);
		assertEquals(res,-2);
		
		res = exo.f_naif(2, 2, 1, 0);
		assertEquals(res,-2);
		
		res = exo.f_naif(2, 2, 1, 1);
		assertEquals(res,-2);
		//(3,3)-----------------------
		res = exo.f_naif(3, 3, 0, 0);
		assertEquals(res,-4);
		
		res = exo.f_naif(3, 3, 0, 1);
		assertEquals(res,3);
		
		res = exo.f_naif(3, 3, 0, 2);
		assertEquals(res,-4);
		
		res = exo.f_naif(3, 3, 1, 0);
		assertEquals(res,3);
		
		res = exo.f_naif(3, 3, 1, 1);
		assertEquals(res,-4);
		
		res = exo.f_naif(3, 3, 1, 2);
		assertEquals(res,3);
		
		res = exo.f_naif(3, 3, 2, 0);
		assertEquals(res,-4);
		
		res = exo.f_naif(3, 3, 2, 1);
		assertEquals(res,3);
		
		res = exo.f_naif(3, 3, 2, 2);
		assertEquals(res,-4);
		//(3,2)----------------------
		res = exo.f_naif(3, 2, 0, 0);
		assertEquals(res,3);
		
		res = exo.f_naif(3, 2, 0, 1);
		assertEquals(res,3);
		
		res = exo.f_naif(3, 2, 1, 0);
		assertEquals(res,3);
		
		res = exo.f_naif(3, 2, 1, 1);
		assertEquals(res,3);
		
		res = exo.f_naif(3, 2, 2, 0);
		assertEquals(res,3);
		
		res = exo.f_naif(3, 2, 2, 1);
		assertEquals(res,3);
		
		//(2,3)----------------------
		res = exo.f_naif(2, 3, 0, 0);
		assertEquals(res,3);
		
		res = exo.f_naif(2, 3, 0, 1);
		assertEquals(res,3);
		
		res = exo.f_naif(2, 3, 0, 2);
		assertEquals(res,3);
		
		res = exo.f_naif(2, 3, 1, 0);
		assertEquals(res,3);
		
		res = exo.f_naif(2, 3, 1, 1);
		assertEquals(res,3);
		
		res = exo.f_naif(2, 3, 1, 2);
		assertEquals(res,3);
	}

	@Test
	public void testF_dp_naif() {
		Exo_v2 exo = new Exo_v2();
		
		int res = exo.f_dp_naif(1, 1, 0, 0);
		assertEquals(res,0);
		
		//(2,2)-----------------------
		res = exo.f_dp_naif(2, 2, 0, 1);
		assertEquals(res,-2);
		
		res = exo.f_dp_naif(2, 2, 1, 0);
		assertEquals(res,-2);
		
		res = exo.f_dp_naif(2, 2, 1, 1);
		assertEquals(res,-2);
		//(3,3)-----------------------
		res = exo.f_dp_naif(3, 3, 0, 0);
		assertEquals(res,-4);
		
		res = exo.f_dp_naif(3, 3, 0, 1);
		assertEquals(res,3);
		
		res = exo.f_dp_naif(3, 3, 0, 2);
		assertEquals(res,-4);
		
		res = exo.f_dp_naif(3, 3, 1, 0);
		assertEquals(res,3);
		
		res = exo.f_dp_naif(3, 3, 1, 1);
		assertEquals(res,-4);
		
		res = exo.f_dp_naif(3, 3, 1, 2);
		assertEquals(res,3);
		
		res = exo.f_dp_naif(3, 3, 2, 0);
		assertEquals(res,-4);
		
		res = exo.f_dp_naif(3, 3, 2, 1);
		assertEquals(res,3);
		
		res = exo.f_dp_naif(3, 3, 2, 2);
		assertEquals(res,-4);
		//(3,2)----------------------
		res = exo.f_dp_naif(3, 2, 0, 0);
		assertEquals(res,3);
		
		res = exo.f_dp_naif(3, 2, 0, 1);
		assertEquals(res,3);
		
		res = exo.f_dp_naif(3, 2, 1, 0);
		assertEquals(res,3);
		
		res = exo.f_dp_naif(3, 2, 1, 1);
		assertEquals(res,3);
		
		res = exo.f_dp_naif(3, 2, 2, 0);
		assertEquals(res,3);
		
		res = exo.f_dp_naif(3, 2, 2, 1);
		assertEquals(res,3);
		
		//(2,3)----------------------
		res = exo.f_dp_naif(2, 3, 0, 0);
		assertEquals(res,3);
		
		res = exo.f_dp_naif(2, 3, 0, 1);
		assertEquals(res,3);
		
		res = exo.f_dp_naif(2, 3, 0, 2);
		assertEquals(res,3);
		
		res = exo.f_dp_naif(2, 3, 1, 0);
		assertEquals(res,3);
		
		res = exo.f_dp_naif(2, 3, 1, 1);
		assertEquals(res,3);
		
		res = exo.f_dp_naif(2, 3, 1, 2);
		assertEquals(res,3);
	}

	@Test
	public void testF_dp_symmetry()
	{
		Exo_v2 exo = new Exo_v2();
		
		int res = exo.f_dp_symmetry(1, 1, 0, 0);
		assertEquals(res,0);
		
		//(2,2)-----------------------
		res = exo.f_dp_symmetry(2, 2, 0, 1);
		assertEquals(res,-2);
		
		res = exo.f_dp_symmetry(2, 2, 1, 0);
		assertEquals(res,-2);
		
		res = exo.f_dp_symmetry(2, 2, 1, 1);
		assertEquals(res,-2);
		//(3,3)-----------------------
		res = exo.f_dp_symmetry(3, 3, 0, 0);
		assertEquals(res,-4);
		
		res = exo.f_dp_symmetry(3, 3, 0, 1);
		assertEquals(res,3);
		
		res = exo.f_dp_symmetry(3, 3, 0, 2);
		assertEquals(res,-4);
		
		res = exo.f_dp_symmetry(3, 3, 1, 0);
		assertEquals(res,3);
		
		res = exo.f_dp_symmetry(3, 3, 1, 1);
		assertEquals(res,-4);
		
		res = exo.f_dp_symmetry(3, 3, 1, 2);
		assertEquals(res,3);
		
		res = exo.f_dp_symmetry(3, 3, 2, 0);
		assertEquals(res,-4);
		
		res = exo.f_dp_symmetry(3, 3, 2, 1);
		assertEquals(res,3);
		
		res = exo.f_dp_symmetry(3, 3, 2, 2);
		assertEquals(res,-4);
		//(3,2)----------------------
		res = exo.f_dp_symmetry(3, 2, 0, 0);
		assertEquals(res,3);
		
		res = exo.f_dp_symmetry(3, 2, 0, 1);
		assertEquals(res,3);
		
		res = exo.f_dp_symmetry(3, 2, 1, 0);
		assertEquals(res,3);
		
		res = exo.f_dp_symmetry(3, 2, 1, 1);
		assertEquals(res,3);
		
		res = exo.f_dp_symmetry(3, 2, 2, 0);
		assertEquals(res,3);
		
		res = exo.f_dp_symmetry(3, 2, 2, 1);
		assertEquals(res,3);
		
		//(2,3)----------------------
		res = exo.f_dp_symmetry(2, 3, 0, 0);
		assertEquals(res,3);
		
		res = exo.f_dp_symmetry(2, 3, 0, 1);
		assertEquals(res,3);
		
		res = exo.f_dp_symmetry(2, 3, 0, 2);
		assertEquals(res,3);
		
		res = exo.f_dp_symmetry(2, 3, 1, 0);
		assertEquals(res,3);
		
		res = exo.f_dp_symmetry(2, 3, 1, 1);
		assertEquals(res,3);
		
		res = exo.f_dp_symmetry(2, 3, 1, 2);
		assertEquals(res,3);
	}
}
