package implementation;

import util.Simulate4D;
import util.Symmetry;

public class Exo_v2 {

	public int compteurAppel;
	public int[] tabRes;
	public boolean[] tabChecked;
	public int m_initial;
	public int n_initial;
	public boolean DEBUG;
	
	//variable used for the game
	public int m_choisi;
	public int n_choisi;
	public int res_choisi;
	
	
	public Exo_v2()
	{
		this(false);
	}
	public Exo_v2(boolean debug)
	{
		this.DEBUG=debug;
		this.tabRes = null;
		
		this.res_choisi= Integer.MIN_VALUE;
	}
	
	
	public Symmetry getCoordNextCoupe(int m,int n,int i,int j){
		
		int res=0,res1=0,res2=0;
		int tmpI= -1;
		int tmpJ= -1;
		int tmpM= -1;
		int tmpN= -1;
		int maxNegativ = Integer.MIN_VALUE;
		boolean hasNeg = false;
		int maxPositiv = 0;
		Symmetry s = new Symmetry(1,1,0,0);
		Symmetry ss = new Symmetry(1,1,0,0);
		Symmetry coordResPos = new Symmetry(1,1,0,0);
		Symmetry coordResNeg = new Symmetry(1,1,0,0);
		Symmetry coordRes    = new Symmetry(1,1,0,0);
		

		boolean valNeg = false;

		ss.setSymmetry(m, n, i, j);
		System.out.println(s);
		ss.normalizedSymmetry();
		System.out.println(s);
		valNeg=(tabRes[Simulate4D.convert(ss.m,ss.n,ss.i,ss.j, m_initial, n_initial, m_initial)] > 0); 
		System.out.println(valNeg+" "+tabRes[Simulate4D.convert(ss.m,ss.n,ss.i,ss.j, m_initial, n_initial, m_initial)]);
		
		for(int indice=1;indice<ss.m;indice++){
			tmpI = ss.i;
			tmpJ = ss.j;
			tmpM = indice;
			tmpN = indice;
			
			if (i>=indice){
				tmpI = s.i - indice;
				tmpM = s.m - indice;
			}
			
			s.setSymmetry(tmpM,ss.n,tmpI,ss.j);
			s.normalizedSymmetry();
			
			
			if(!tabChecked[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)])
			{
				System.out.println("ERROR FATALE");
			}
			else
				res1 = tabRes[Simulate4D.convert(s.m,s.n,s.i,s.j, m_initial, n_initial, m_initial)]; //O(1)
			
			
			if (res1<1)
			{
				hasNeg = true;
				//maxNegativ = Math.max(maxNegativ, res1); //O(1)
				if(maxNegativ<res1)
				{
					maxNegativ = res1;
					coordResNeg.setSymmetry(s);
				}
			}
			else{
				maxPositiv = Math.max(maxPositiv, res1);
				if(maxPositiv<res1)
				{
					maxPositiv = res1;
					coordResPos.setSymmetry(s);
				}
			}
		}
		
		for(int indice=1;indice<ss.n;indice++){
			tmpI = ss.i;
			tmpJ = ss.j;
			tmpM = indice;
			tmpN = indice;
			
			if(j>= indice){	
				tmpJ = ss.j - indice;
				tmpN = ss.n - indice;
			}
			s.setSymmetry(ss.m,tmpN,ss.i,tmpJ);
			s.normalizedSymmetry();
			
			
			if(!tabChecked[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)])
			{
				System.out.println("FATALE ERROR NUMBER 2");
			}
			else
				res2 = tabRes[Simulate4D.convert(s.m,s.n,s.i,s.j, m_initial, n_initial, m_initial)]; //O(1)
			
			if (res2<1)
			{
				hasNeg = true;
				//maxNegativ = Math.max(maxNegativ, res2);
				if(maxNegativ<res2)
				{
					maxNegativ = res2;
					coordResNeg.setSymmetry(s);
				}
			}
			else{
				//maxPositiv = Math.max(maxPositiv, res2);
				if(maxPositiv<res2)
				{
					maxPositiv = res2;
					coordResPos.setSymmetry(s);
				}
			}
		}
		
		if(valNeg){
			System.out.println(coordResNeg+"neg");
			System.out.println(coordResPos+"pos");
			if (!hasNeg){
				coordRes.setSymmetry(coordResNeg);
			}
			else{
				coordRes.setSymmetry(coordResPos);
			}
		}else{
			if (hasNeg){
				coordRes.setSymmetry(coordResNeg);
			}
			else{
				coordRes.setSymmetry(coordResPos);
			}
		}
		return coordRes;
		
	}
	
	
	
	/**
	 * calcul de la valeur d'une position
	 * 
	 * @param m abscisse 
	 * @param n ordonne
	 * @param i x de la case
	 * @param j y de la case
	 * @param resetCounter compteur d'appel
	 * @param recursion_lvl profondeur de l'appel recursif
	 * @param dp flag qui indique si on utilise la prog dynamique ou non
	 * @param symmetry flag qui indique si on utilise la symmetry ou non
	 * @param game flag qui indique si on est dans le jeu
	 * @return
	 */
	public int f(int m,int n,int i,int j,boolean resetCounter, int recursion_lvl, boolean dp, boolean symmetry, boolean game)
	{
		if(resetCounter)
			this.compteurAppel=0;
		this.compteurAppel++;
		
		if(this.DEBUG)
		{
			for(int z=0;z<recursion_lvl;z++)
				System.out.print("-");	
			System.out.println(m+" "+n+" "+i+" "+j+" entry");
		}
		
		if(m==1 && n==1)
			return 0;
		
		int res=0,res1=0,res2=0;
		int tmpI= -1;
		int tmpJ= -1;
		int tmpM= -1;
		int tmpN= -1;
		int maxNegativ = Integer.MIN_VALUE;
		boolean hasNeg = false;
		int maxPositiv = 0;
		Symmetry s = new Symmetry(1,1,0,0);
		
		
		for(int indice=1;indice<Math.max(m, n);indice++) //(O(m+n))
		{
			tmpI = i;
			tmpJ = j;
			tmpM = indice;
			tmpN = indice;
			if(indice<m){
				if(i>= indice){	
					tmpI = i - indice;
					tmpM = m - indice;
				}
				

				s.setSymmetry(tmpM,n,tmpI,j);  //couteux?

				if(dp){
					if(symmetry){
						s.normalizedSymmetry(); //O(?)
					}

					
					if(!tabChecked[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)])
					{
						res1 = f(s.m, s.n, s.i, s.j,false,recursion_lvl+1,dp,symmetry,game);
						tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)]=res1; //O(1) 
						tabChecked[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)]=true; //O(1)
					}
					else
						res1 = tabRes[Simulate4D.convert(s.m,s.n,s.i,s.j, m_initial, n_initial, m_initial)]; //O(1)
				}
				else
					res1 = f(s.m, s.n, s.i, s.j,false,recursion_lvl+1,dp,symmetry,game);
				
				if (res1<1)
				{
					hasNeg = true;
					maxNegativ = Math.max(maxNegativ, res1); //O(1)
				}
				else
					maxPositiv = Math.max(maxPositiv, res1);
			}
			
			if(indice<n)
			{
				if(j>= indice)
				{
					tmpJ = j - indice;
					tmpN = n - indice;
				}
				
				s.setSymmetry(m,tmpN,i,tmpJ);
				
				if(dp)
				{
					if(symmetry)
						s.normalizedSymmetry();
					
					if(!tabChecked[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)])
					{
						res2 = f(s.m, s.n, s.i, s.j,false,recursion_lvl+1,dp,symmetry,game);
						tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)]=res2;
						tabChecked[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)]=true;
					}
					else
						res2 = tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)];
				}
				else
					res2 = f(s.m, s.n, s.i, s.j,false,recursion_lvl+1,dp,symmetry,game);
				
				if (res2<1)
				{
					hasNeg = true;
					maxNegativ = Math.max(maxNegativ, res2);
				}
				else
					maxPositiv = Math.max(maxPositiv, res2);
			}
		}
		
	
		if (hasNeg)
			res = maxNegativ-1;
		else
			res = maxPositiv+1;
		
		if(this.DEBUG)
		{
			for(int z=0;z<recursion_lvl;z++)
				System.out.print("%");
			if (hasNeg)
				System.out.println(maxNegativ+" "+(-res));
			else
				System.out.println(maxPositiv+" "+(-res));
		}
		//*/
		return -res;
	}
	
	public int f_naif(int m,int n,int i,int j)
	{
		return f(m,n,i,j,true,0,false,false,false);
	}
	
	public int f_dp(int m,int n,int i,int j,boolean symmetry,boolean game)
	{
		int sizetab = m+m*n+m*n*m+m*n*m*n;
		this.m_initial=m;
		this.n_initial=n;
		
		Symmetry s = new Symmetry(m,n,i,j);
		
		if(symmetry){
			s.normalizedSymmetry();
			//System.out.println(s);
			int mm = (s.m);
			int nn = (s.n);
			sizetab = mm+nn+(mm + mm*nn + mm*nn*mm + mm*nn*mm*nn)/2;
			//System.out.println("sizetab:"+sizetab);
		}
		
		if(tabChecked==null || tabChecked.length!=sizetab)
			tabChecked = new boolean[sizetab];
		if(tabRes==null || tabRes.length!=sizetab)
			tabRes = new int[sizetab];
		
		for(int a=0;a<sizetab;a++)
		{
			tabRes[a]=0;
			tabChecked[a]=false;
		}
		tabChecked[Simulate4D.convert(1, 1, 0, 0, this.m_initial, this.n_initial, this.m_initial)]=true;
		
		return f(s.m,s.n,s.i,s.j,true,0,true,symmetry,false);
	}
	
	public int f_dp_naif(int m,int n,int i,int j,boolean game)
	{
		int res = f_dp(m,n,i,j,false,game);
		int count = 0;
		for(int p : tabRes)
			count = (p!=0) ? count+1 : count;
		System.out.println(count+" "+tabRes.length+" "+(float)tabRes.length/count);
		return res;
	}
	
	public int f_dp_symmetry(int m,int n,int i,int j,boolean game)
	{
		int res = f_dp(m,n,i,j,true,game);
		int count = 0;
		for(int p : tabRes)
			count = (p!=0) ? count+1 : count;
		System.out.println(count+" "+tabRes.length+" "+(float)tabRes.length/count);
		return res;
	}
	
	public int f_game(int m,int n, int i, int j)
	{
		return f_dp_naif(m,n,i,j,true);
	}
	
}
