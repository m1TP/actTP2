package main;

import java.util.ArrayList;
import java.util.HashMap;

import implementation.Exo;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	//	Exo exo = new Exo();
		//int res = exo.f(4, 4, 1,1);
		//System.out.println("res: "+res+" en "+exo.compteurAppel+" appels récursifs") ;
		
		Double[] arrayName = new Double[4];
		
		
		HashMap<Integer,ArrayList<Double>> hashmap = new HashMap<Integer, ArrayList<Double>>(); 
		ArrayList<Double> l = new ArrayList<Double>();
		l.add(2.);
		l.add(3.);
		
		hashmap.put(1, l);
		
		arrayName = hashmap.get(1).toArray(arrayName);
		System.out.println(arrayName[0]);
	}

}
