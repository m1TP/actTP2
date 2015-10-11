package main;

import java.util.ArrayList;
import java.util.HashMap;

import util.Simulate4D;
import util.Symmetry;
import implementation.Exo;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Exo exo = new Exo();
		
		/*
		int m = 5;
		int n = 5;
		int i = 0;
		int j = 0;
		//*/
		int res = 0;
		
		
		//res = exo.f_naif(m, n, i, j);
		//System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
		/*
		for(int m=2;m<10;m++)
			for(int n=2;n<10;n++)
				for(int i=0;i<m;i++)
					for(int j=0;j<n;j++)
					{
						int res1 = exo.f_dp_naif(m, n, i, j);
						
						int res2 = exo.f_dp_symmetry(m, n, i, j);
						
						if(res1!=res2)
							System.out.println(new Symmetry(m,n,i,j));
					}
		//*/
		/*
		res = exo.f_dp_naif(m, n, i, j);
		System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
		res = exo.f_dp_symmetry(m, n, i, j);
		System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
		//*/
		
		res = exo.f_dp_naif(2, 5, 0, 1);
		System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
		res = exo.f_dp_symmetry(2, 5, 0, 1);
		System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
		/*
		for(int i1 = 0; i1<127; i1++)
		{
			for( int j1 =0; j1<127; j1++)
			{
				if (exo.f_dp_naif(100, 100, i1, j1)==127)
					System.out.println(i+" "+j);
			}
		}
		//*/
		
		/*
		Symmetry s = new Symmetry(4, 5, 3, 3);
		s = s.normalizedSymmetry();
		System.out.println(s);
		//*/
	}

}
