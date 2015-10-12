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
		int m = 7;
		int n = 9;
		int i = 6;
		int j = 0;
		//*/
		int res = 0;
		
		
		
		//res = exo.f_naif(m, n, i, j);
		//System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
		Symmetry s = null;
		
		int tmpM=-1,tmpN=-1,tmpI=-1,tmpJ=-1;
		for(int m=2;m<10;m++)
			for(int n=2;n<10;n++)
				for(int i=0;i<m;i++)
					for(int j=0;j<n;j++)
					{
						s = new Symmetry(m,n,i,j);
						int res1 = exo.f_naif(s.m, s.n, s.i, s.j);
						
						s =s.normalizedSymmetry();
						int res2 = exo.f_naif(s.m, s.n, s.i, s.j);
						
						System.out.println(res1+" "+res2);
						if(res1!=res2)
						{
							tmpM=m; tmpN=n; tmpI=i; tmpJ=j;
							System.out.println(new Symmetry(m,n,i,j));
							break;
						}
					}
		System.out.println(new Symmetry(tmpM,tmpN,tmpI,tmpJ));
		//*/
		
		//res = exo.f_naif(m, n, i, j);
		//System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		/*
		res = exo.f_dp_naif(m, n, i, j);
		System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
		res = exo.f_dp_symmetry(m, n, i, j);
		System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
		Symmetry s = new Symmetry(7, 9 ,6 ,0);
		System.out.println(s.normalizedSymmetry());
		//*/
		/*
		res = exo.f_naif(3, 3, 0, 0);
		System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
		res = exo.f_naif(2, 3, 0, 2);
		System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
		res = exo.f_naif(3, 2, 0, 1);
		System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
		res = exo.f_naif(3, 3, 0, 2);
		System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
		/*
		res = exo.f_naif(3, 3, 2, 0);
		System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
		res = exo.f_naif(3, 3, 2, 2);
		System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		//*/
		//res = exo.f_dp_symmetry(2, 5, 0, 1);
		//System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
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
