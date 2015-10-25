package main;

import java.util.Random;
import java.util.Scanner;

import util.Simulate4D;
import util.Symmetry;
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
				System.out.println("Longueur initialise ...");
			}else{
				System.out.println("Indiquez un entier superieur a 0 ...");
				scan = new Scanner(System.in);
			}
		}
		
		System.out.print("Largueur :");
		while(n<=0){
			if(scan.hasNextInt() && (n=scan.nextInt()) > 0){
				System.out.println("Largueur initialise ...");
			}else{
				System.out.println("Indiquez un entier superieur a 0 ...");
				scan = new Scanner(System.in);
			}
		}
		System.out.println("Initialisation du plateau termine.");
		
		
		//Placement du carre de la mort
		System.out.println("Placement du carre de la mort ...");
		int i = new Random().nextInt(m);
		int j = new Random().nextInt(n);
		//int i=2;
		//int j=0;
		System.out.println("Carre de la mort place en : ["+i+"|"+j+"] \n");

		
		
		System.out.println("Jeu pret ! \n\n");
		
		
		
		
		
		
		
		System.out.println("C'est l'heure du duel !\n");
		int res;
		boolean joueur=false;
		String joueur1 = "Joueur 1 (Ordinateur)";
		String joueur2 = "Joueur 2";
		String joueurActuel = "";
		
		//Deroulement de la partie
		while(m>1 || n>1){
			
			System.out.println("Representation du plateau de jeu");
			representationPlateau(m,n,i,j);
			System.out.println("m: "+m+" n: "+n+" i: "+i+" j: "+j);
			
			
			if(!joueur)
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
			
			
			
			if(joueur){ //Tour Joueur
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
					System.out.println("Couper a partir de la colonne (inclu) :");
					while(tmpNum<=0 || tmpNum>=m){
						if(scan.hasNextInt() && (tmpNum=scan.nextInt()) > 0){
							if(tmpNum < m)
								System.out.println("On coupe ...");
							else{
								System.out.println("Indiquez un entier superieur a 0 ... et inferieur a la longueur du tableau actuel "+m);
							}
						}else{
							System.out.println("Indiquez un entier superieur a 0 ... et inferieur a la longueur du tableau actuel "+m);
							scan = new Scanner(System.in);
						}
					}
				}else{
					System.out.println("Couper a partir de la ligne (inclu) :");
					while(tmpNum<=0 || tmpNum>=n){
						if(scan.hasNextInt() && (tmpNum=scan.nextInt()) > 0){
							if(tmpNum < n)
								System.out.println("On coupe ...");
							else{
								System.out.println("Indiquez un entier superieur a 0 ... et inferieur a la largueur du tableau actuel "+n);
							}
						}else{
							System.out.println("Indiquez un entier superieur a 0 ... et inferieur a la largueur du tableau actuel "+n);
							scan = new Scanner(System.in);
							
						}
					}
				}
				
				//Coupe
				if(longueur){
					if(tmpNum<=i){//Coupe a gauche
						m=m-tmpNum;
						i=i-tmpNum;
					}else{//Coupe a droite
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
			
			}else{
				
				
				//Tour ordinateur
				System.out.println("L'ordinateur calcul la meilleure coupe a faire ...");
				
				
				//Recherche de la coupe a faire
				boolean hasNeg = false;
				int tmpM = 0;
				int tmpN = 0;
				int tmpI = 0;
				int tmpJ = 0;
				int tmpMM = 0;
				int tmpNN = 0;
				int maxPositiv = 0;
				int maxNegativ = 0;
				Symmetry s = new Symmetry(1,1,0,0);
				
				if(res>0){
					hasNeg=true;
				}
				
				for(int k=1;k<m;k++){
					
					if(m>1 || n>1 || i>0 || j>0){
						if(i>= k){	
							tmpI = i - k;
							tmpM = m - k;
						}else{
							tmpI = i;
							tmpM = k;
						}
						
						s.setSymmetry(tmpM,n,tmpI,j);
						s.normalizedSymmetry();
					}
					
					
					if(tmpM==1 && n==1 && tmpI==0 && j==0){//Condition de sortie
						m=1;n=1;i=0;j=0;tmpMM=0;tmpNN=0;
					}else{
						
						if(hasNeg){
							if(exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m, n, m)]<maxNegativ){
								maxNegativ=exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m, n, m)];
								tmpMM=tmpM;
							}		
						}else{
							if(exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m, n, m)]>maxPositiv){
								maxPositiv=exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m, n, m)];
								tmpMM=tmpM;
							}
						}
					}
				}
					
				for(int k=1;k<n;k++){
					if(m>1 || n>1 || i>0 || j>0){
						if(j>= k){	
							tmpJ = j - k;
							tmpN = n - k;
						}else{
							tmpJ = j;
							tmpN = k;
						}
						
						s.setSymmetry(m,tmpN,i,tmpJ);
						s.normalizedSymmetry();
					}
					
					if(m==1 && tmpN==1 && i==0 && tmpJ==0){//Condition de sortie
						m=1;n=1;i=0;j=0;tmpMM=0;tmpNN=0;
					}else{
						if(hasNeg){
								if(exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m, n, m)]<maxNegativ){
									maxNegativ=exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m, n, m)];
									tmpNN=tmpN;
								}		
						}else{
								if(exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m, n, m)]>maxPositiv){
									maxPositiv=exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m, n, m)];
									tmpNN=tmpN;
								}
						}
					}
				}				
							
				
				//Coupe
				if(tmpMM>0){
					if(tmpI<i){//Coupe a gauche
						i=i-(m-tmpMM);
						tmpI=i;
						m=tmpMM;
					}else{//Coupe a droite
						m=tmpMM;
					}
				}else if(tmpNN>0){
					if(tmpJ<j){//Coupe en haut
						j=j-(n-tmpNN);
						tmpJ=j;
						n=tmpNN;
					}else{//Coupe en bas
						n=tmpNN;
					}				
				}
				
			}

			
			System.out.println("Coupe termine ... a l'adversaire ...");
			joueur=!joueur;
			
		}
		System.out.println("\n Felicitation le "+joueurActuel+" a gagne !");
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
