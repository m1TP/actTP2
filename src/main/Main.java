package main;

import java.util.ArrayList;
import java.util.HashMap;

import implementation.Exo;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Exo exo = new Exo();
		
		int m = 3;
		int n = 3;
		
		int res = exo.f_naif(m, n, 2, 2);
		
		System.out.println("res: "+ res+" en "+exo.compteurAppel+" appels récursifs");
		
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				System.out.println("res: "+exo.f_naif(m, n, i, j)+" en "+exo.compteurAppel+" appels récursifs") ;
		
		
	}

}
