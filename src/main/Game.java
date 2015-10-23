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
				System.out.println("Longueur initialis� ...");
			}else{
				System.out.println("Indiquez un entier sup�rieur � 0 ...");
				scan = new Scanner(System.in);
			}
		}
		
		System.out.print("Largueur :");
		while(n<=0){
			if(scan.hasNextInt() && (n=scan.nextInt()) > 0){
				System.out.println("Largueur initialis� ...");
			}else{
				System.out.println("Indiquez un entier sup�rieur � 0 ...");
				scan = new Scanner(System.in);
			}
		}
		System.out.println("Initialisation du plateau termin�.");
		
		
		
		
		//Placement du carre de la mort
		System.out.println("Placement du carr� de la mort ...");
		int i = new Random().nextInt(m);
		int j = new Random().nextInt(n);
		System.out.println("Carr� de la mort plac� en : ["+i+"|"+j+"] \n");

		
		
		System.out.println("Jeu pr�t ! \n\n");
		
		
		
		
		
		
		
		System.out.println("C'est l'heure du duel !\n");
		int res;
		boolean joueur=true;
		String joueur1 = "Joueur 1";
		String joueur2 = "Joueur 2";
		String joueurActuel = "";
		
		
		//Deroulement de la partie
		while(m>1 || n>1){
			
			System.out.println("Repr�sentation du plateau de jeu");
			representationPlateau(m,n,i,j);
			
			if(joueur)
				joueurActuel=joueur1;
			else
				joueurActuel=joueur2;

			System.out.println("\n"+joueurActuel+" joue ...");
			res = exo2.f_dp(m, n, i, j,true,false);
			
	
			
			
			if(res>0){//Gagnant
				System.out.println("Configuration optimal : Le "+joueurActuel+" peut gagner en "+res+" coupes");
			}else{//Perdant
				System.out.println("Configuration optimal : Le "+joueurActuel+" va perdre en "+res+" coupes");
			}
			
			
			
			
			System.out.println("Coupe a faire en longueur ou largueur (long/larg) ?");
			String tmpLine = "";
			int tmpNum = 0;
			scan = new Scanner(System.in);
			boolean longueur = false;
			boolean largueur = false;
			
			while( !longueur && !largueur )
				if(tmpLine.equals("long")){
					longueur=true;
				}else if(tmpLine.equals("larg"))
					largueur=true;
				else
					tmpLine=scan.nextLine();
				
			
			if(longueur){
				System.out.println("Couper � partir de la colonne (inclu) :");
				while(tmpNum<=0 || tmpNum>=m){
					if(scan.hasNextInt() && (tmpNum=scan.nextInt()) > 0){
						if(tmpNum < m)
							System.out.println("On coupe ...");
						else{
							System.out.println("Indiquez un entier sup�rieur � 0 ... et inf�rieur � la longueur du tableau actuel "+m);
						}
					}else{
						System.out.println("Indiquez un entier sup�rieur � 0 ... et inf�rieur � la longueur du tableau actuel "+m);
					}
				}
			}else{
				System.out.println("Couper � partir de la ligne (inclu) :");
				while(tmpNum<=0 || tmpNum>=n){
					if(scan.hasNextInt() && (tmpNum=scan.nextInt()) > 0){
						if(tmpNum < n)
							System.out.println("On coupe ...");
						else{
							System.out.println("Indiquez un entier sup�rieur � 0 ... et inf�rieur � la largueur du tableau actuel "+n);
						}
					}else{
						System.out.println("Indiquez un entier sup�rieur � 0 ... et inf�rieur � la largueur du tableau actuel "+n);
					}
				}
			}
			
			
			if(longueur){
				if(tmpNum<=i){//Coupe a gauche
					System.out.println("Coupe a gauche");
					m=m-tmpNum;
					i=i-tmpNum;
				}else{//Coupe a droite
					System.out.println("Coupe a droite");
					m=tmpNum;
				}
			}else{
				if(tmpNum<=j){//Coupe en haut
					n=n-tmpNum;
					j=j-tmpNum;
				}else{//Coupe en bas
					n=tmpNum;
				}				
			}
			
			System.out.println("Coupe termin� ... � l'adversaire ...");
			joueur=!joueur;
			
		}
		
		System.out.println("\n F�licitation le "+joueurActuel+" a gagn� !");
		
		
	}
	
	public static void representationPlateau(int m, int n, int i, int j){
		for(int k=0;k<n;k++){
			for(int l=0;l<m;l++)
				if(l==i && k==j)
					System.out.print("[X]");
				else
					System.out.print("[ ]");
			System.out.println("");
		}
	}
}
