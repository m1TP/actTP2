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
		int res = exo.f(4, 4, 1,1);
		System.out.println("res: "+res+" en "+exo.compteurAppel+" appels récursifs") ;
		
		
	}

}
