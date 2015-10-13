package implementation;

import util.Simulate4D;

public class Exo_v2 {

	public int compteurAppel;
	public int[] tabRes;
	public boolean[] tabChecked;
	public int m_initial;
	public int n_initial;
	public boolean DEBUG;
	
	public Exo_v2()
	{
		this(false);
	}
	public Exo_v2(boolean debug)
	{
		this.DEBUG=debug;
		this.tabRes = null;
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
	 * @return
	 */
	public int f(int m,int n,int i,int j,boolean resetCounter, int recursion_lvl, boolean dp, boolean symmetry)
	{
		if(resetCounter)
			this.compteurAppel=0;
		this.compteurAppel++;
		
		if(this.DEBUG)
		{
			for(int z=0;z<recursion_lvl;z++)
				System.out.print("-");	
			System.out.println(m+" "+n+" "+i+" "+j);
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
		
		for(int indice=1;indice<Math.max(m, n);indice++)
		{
			tmpI = i;
			tmpJ = j;
			tmpM = indice;
			tmpN = indice;
			
			if(indice<m)
			{
				if(i>= indice)
				{
					tmpI = i - indice;
					tmpM = m - indice;
				}
				
				if(dp)
				{
					if(tabRes[Simulate4D.convert(tmpM, n, tmpI, j, m_initial, n_initial, m_initial)]==0)
					{
						res1 = f(tmpM, n, tmpI, j,false,recursion_lvl+1,true,false);
						tabRes[Simulate4D.convert(tmpM, n, tmpI, j, m_initial, n_initial, m_initial)]=res;
					}
					else
						res1 = tabRes[Simulate4D.convert(tmpM, n, tmpI, j, m_initial, n_initial, m_initial)];
				}
				else
					res1 = f(tmpM, n, tmpI, j,false,recursion_lvl+1,false,false);
				
				if (res1<1)
				{
					hasNeg = true;
					maxNegativ = Math.max(maxNegativ, res1);
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
				
				if(dp)
				{
					if(tabRes[Simulate4D.convert(m, tmpN, i, tmpJ, m_initial, n_initial, m_initial)]==0)
					{
						res = f(m, tmpN, i, tmpJ,false,recursion_lvl+1,true,false);
						tabRes[Simulate4D.convert(m, tmpN, i, tmpJ, m_initial, n_initial, m_initial)]=res;
					}
					else
						res = tabRes[Simulate4D.convert(m, tmpN, i, tmpJ, m_initial, n_initial, m_initial)];
				}
				else
					res2 = f(m, tmpN, i, tmpJ,false,recursion_lvl+1,false,false);
				
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
		return f(m,n,i,j,true,0,false,false);
	}
	
	public int f_dp_naif(int m,int n,int i,int j)
	{
		int sizetab = m+m*n+m*n*m+m*n*m*n;
		this.m_initial=m;
		this.n_initial=n;
		
		tabChecked = new boolean[sizetab];
		tabRes = new int[sizetab];
		
		for(int a=0;a<sizetab;a++)
		{
			tabRes[a]=0;
			tabChecked[a]=false;
		}
		tabChecked[Simulate4D.convert(1, 1, 0, 0, this.m_initial, this.n_initial, this.m_initial)]=true;
		
		return f(m,n,i,j,true,0,true,false);
	}
	
}
