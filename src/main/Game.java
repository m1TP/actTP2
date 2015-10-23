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
		
		int m_init=m;
		int n_init=n;
		
		
		//Placement du carre de la mort
		System.out.println("Placement du carr� de la mort ...");
	//	int i = new Random().nextInt(m);
	//	int j = new Random().nextInt(n);
		int i=2;
		int j=0;
		System.out.println("Carr� de la mort plac� en : ["+i+"|"+j+"] \n");

		
		
		System.out.println("Jeu pr�t ! \n\n");
		
		
		
		
		
		
		
		System.out.println("C'est l'heure du duel !\n");
		int res;
		boolean joueur=false;
		String joueur1 = "Joueur 1 (Ordinateur)";
		String joueur2 = "Joueur 2";
		String joueurActuel = "";
		
		
		//Deroulement de la partie
		while(m>1 || n>1){
			
			System.out.println("Repr�sentation du plateau de jeu");
			representationPlateau(m,n,i,j);
			
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
							scan = new Scanner(System.in);
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
							scan = new Scanner(System.in);
							
						}
//>>>>>>> 98451e5e1e128ac62fdfb4708deff649d21c73b9
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
				System.out.println("L'ordinateur calcul la meilleure coupe � faire ...");
				
				/*for(int z=0;z<exo2.tabRes.length;z++){
					System.out.println(exo2.tabRes.length+ " " +z+" "+exo2.tabRes[z]);
				}*/
				
				
				//Recherche de la coupe a faire
				boolean hasNeg = false;
				int tmpM = 0;
				int tmpMM = 0;
				int tmpN = 0;
				int tmpNN = 0;
				int tmpI = 0;
				int tmpJ = 0;
				int maxPositiv = 0;
				int maxNegativ = 0;
				Symmetry s = new Symmetry(1,1,0,0);
				
				if(res>0){
					hasNeg=true;
				}
				
				for(int k=0;k<m;k++){
					if(i>= k){	
						tmpI = i - k;
						tmpM = m - k;
					}
					
					s.setSymmetry(tmpM,n,tmpI,j);
					s.normalizedSymmetry();
					
					if(hasNeg){
						//if(Simulate4D.convert(s.m, s.n, s.i, s.j, m_init, n_init, m_init)<exo2.tabRes.length)
							if(exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_init, n_init, m_init)]<maxNegativ){
								System.out.println("coucou tu veux voir mes bytes ! 3");
								System.out.println("Trouv� ! en neg"+" m ="+s.m+" i ="+s.i);
								maxNegativ=exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_init, n_init, m_init)];
								tmpMM=tmpM;
							}		
					}else{
						//if(Simulate4D.convert(s.m, s.n, s.i, s.j, m_init, n_init, m_init)<exo2.tabRes.length)
						System.out.println(exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_init, n_init, m_init)]);
							if(exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_init, n_init, m_init)]>maxPositiv){
							//System.out.println("Trouv� ! en neg"+" m ="+k+" n ="+l+" i ="+p+" j ="+q);
								System.out.println("coucou tu veux voir mes bytes ! 4");
								System.out.println("Trouv� ! en pos"+" m ="+s.m+" i ="+s.i+" res ="+exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_init, n_init, m_init)]);
								maxPositiv=exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_init, n_init, m_init)];
								System.out.println("tmpM "+tmpM);
								tmpMM=tmpM;
							}
					}
				}
					
				for(int k=0;k<n;k++){
					if(j>= k){	
						tmpJ = j - k;
						tmpN = n - k;
					}
					
					s.setSymmetry(m,tmpN,i,tmpJ);
					s.normalizedSymmetry();
					
					if(hasNeg){
							if(exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_init, n_init, m_init)]<maxNegativ){
								//System.out.println("Trouv� ! en neg"+" m ="+k+" n ="+l+" i ="+p+" j ="+q);
								System.out.println("coucou tu veux voir mes bytes ! 2");
								maxNegativ=exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_init, n_init, m_init)];
								tmpNN=tmpN;
							}		
					}else{
						System.out.println(exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_init, n_init, m_init)]);
							if(exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_init, n_init, m_init)]>maxPositiv){
							//System.out.println("Trouv� ! en neg"+" m ="+k+" n ="+l+" i ="+p+" j ="+q);
								System.out.println("coucou tu veux voir mes bytes !");
								maxPositiv=exo2.tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_init, n_init, m_init)];
								tmpNN=tmpN;
							}
					}
				}				
							
						
				System.out.println(tmpM+" "+tmpN+" "+tmpI+" "+tmpJ);
				
				//Coupe
				if(tmpMM>0){
					if(tmpI<i){//Coupe a gauche
						System.out.println('g');
						i=i-(m-tmpMM);
						m=tmpMM;
					}else{//Coupe a droite
						System.out.println('d');
						m=tmpMM;
					}
				}else if(tmpNN>0){
					if(tmpJ<j){//Coupe en haut
						System.out.println('h');
						j=j-(n-tmpNN);
						n=tmpNN;
					}else{//Coupe en bas
						System.out.println('b');
						n=tmpNN;
						j=tmpJ;
					}				
				}else{
					m=1;n=1;i=0;j=0;
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
