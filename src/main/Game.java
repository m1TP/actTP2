package main;

import java.util.Random;
import java.util.Scanner;

import implementation.Exo_v2;

public class Game {

	private static Scanner scan;
	private static Exo_v2 exo2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		exo2 = new Exo_v2();
		scan = new Scanner(System.in);
		
		int m=0,n=0;
		
		//Affichage
		System.out.println("Initialisation du plateau de jeu ...");
		
		//Initialisation du plateau de jeu
		System.out.println("Veuillez indiquer la taille de votre plateau de jeu : (ex: longueur : 10/largueur : 10)");
		System.out.print("Longueur :");
		while(m<=0){
			if(scan.hasNextInt() && (m=scan.nextInt()) > 0){
				System.out.println("Longueur initialisé ...");
			}else{
				System.out.println("Indiquez un entier supérieur à 0 ...");
				scan = new Scanner(System.in);
			}
		}
		
		System.out.print("Largueur :");
		while(n<=0){
			if(scan.hasNextInt() && (n=scan.nextInt()) > 0){
				System.out.println("Largueur initialisé ...");
			}else{
				System.out.println("Indiquez un entier supérieur à 0 ...");
				scan = new Scanner(System.in);
			}
		}
		System.out.println("Initialisation du plateau terminé.");
		
		
		
		
		//Placement du carre de la mort
		System.out.println("Placement du carré de la mort ...");
		int i = new Random().nextInt(m);
		int j = new Random().nextInt(n);
		System.out.println("Carré de la mort placé en : ["+i+"|"+j+"] \n");

		
		
		System.out.println("Jeu prêt ! \n\n");
		
		
		
		
		
		
		
		System.out.println("C'est l'heure du duel !\n");
		int res;
		
		
		
		
		
		//Deroulement de la partie
		//while(m!=1 && n!=1){
			System.out.println("Représentation du plateau de jeu");
			for(int k=0;k<m;k++){
				for(int l=0;l<n;l++)
					if(l==i && k==j)
						System.out.print("[X]");
					else
						System.out.print("[ ]");
				System.out.println("");
			}
			
			System.out.println("Joueur 1 joue ...");
			res = exo2.f_dp(m, n, i, j, true);
			
			if(res>0){//Gagnant
				System.out.println("Le joueur 1 peut gagner en "+res+" coupes");
			}else{//Perdant
				System.out.println("Le joueur 1 va perdre en "+res+" coupes");
			}
			
	//}
		
		
	}
}
