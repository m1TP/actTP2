package main;

import implementation.Exo_v2;
import util.Simulate4D;
import util.Symmetry;

public class Game_ {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Exo_v2 exo = new Exo_v2();
		
		int m=4;
		int n=4;
		int i=2;
		int j=2;
		
		Symmetry s = new Symmetry(m,n,i,j);
		//s.normalizedSymmetry();
		
		System.out.println(exo.f_dp_symmetry(s.m, s.n, s.i, s.j, false));
		System.out.println(exo.getCoordNextCoupe(s.m, s.n, s.i, s.j));
		for(int e : exo.tabRes)
			System.out.println(e);
	}

}
