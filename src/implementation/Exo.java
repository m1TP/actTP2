package implementation;

import util.Simulate4D;
import util.Symmetry;

public class Exo {

	
	public int compteurAppel;

	int[] tabRes;
	boolean[] tabChecked;
	int m_initial;
	int n_initial;

	public Exo()
	{
		this.compteurAppel=0;
		this.tabRes = null;
	}
		
	
	//TODO factoriser les deux boucles?
	private int f(int m,int n,int i,int j,boolean resetCounter,int recursion_lvl)
	{
		if(resetCounter)
			this.compteurAppel=0;
		this.compteurAppel++;
		
		//for(int z=0;z<recursion_lvl;z++)
			//System.out.print("-");
		//System.out.println(m+" "+n+" "+i+" "+j);
		
		if(m==1 && n==1)
			return 0;
		
		int tmpI,tmpJ,res,tmpM,tmpN = -1;
		int maxNegativ = Integer.MIN_VALUE;
		boolean hasNeg = false;
		int maxPositiv = 0;
		
		res = 0;
		for(int indice = 1; indice < m; indice++ )
		{		
			tmpI = i;
			tmpJ = j;
			tmpM = indice;
			
			if(i>= indice)
			{
				tmpI = i - indice;
				tmpM = m-indice;
			}
			
			//System.out.println(tmpM+" "+n+" "+tmpI+" "+tmpJ);
			res = f(tmpM, n, tmpI, tmpJ,false,recursion_lvl+1);
			
			if (res<1)
			{
				hasNeg = true;
				maxNegativ = Math.max(maxNegativ, res);
			}
			else
				maxPositiv = Math.max(maxPositiv, res);
			
		}
		for(int indice = 1; indice < n; indice++)
		{
			tmpI = i;
			tmpJ = j;
			tmpN = indice;
			
			if(j>= indice)
			{
				tmpJ = j - indice;
				tmpN = n - indice;
			}
			
			//System.out.println(m+" "+tmpN+" "+tmpI+" "+tmpJ);
			res = f(m, tmpN, tmpI, tmpJ,false,recursion_lvl+1);
			
			if (res<1)
			{
				hasNeg = true;
				maxNegativ = Math.max(maxNegativ, res);
			}
			else
				maxPositiv = Math.max(maxPositiv, res);
			
		}
		
		
		
		if (hasNeg)
			res = maxNegativ-1;
		else
			res = maxPositiv+1;
		/*
		for(int z=0;z<recursion_lvl;z++)
			System.out.print("_");
		if (hasNeg)
			System.out.println(maxNegativ+" "+(-res));
		else
			System.out.println(maxPositiv+" "+(-res));
		//*/
		return -res;
	}
	
	/**
	 * calcule le nombre de coup restant avant la fin de la partie.
	 * Si le résultat est positif, c'est le nombre de coup minimum avant de gagner,
	 * sinon c'est le nombre de coup maximum avant de perdre.
	 * 
	 * @param m largeur tab
	 * @param n longeur tab
	 * @param i abscisse case finale
	 * @param j ordonnee case finale
	 * @return valeur de la position (i,j)
	 */
	public int f_naif(int m,int n,int i, int j)
	{
		return f(m,n,i,j,true,0);
	}
	
	
	public int f_dp_naif(int m,int n,int i,int j ,boolean resetCounter)
	{
		if(resetCounter)
			this.compteurAppel=0;
		this.compteurAppel++;
		
		//System.out.println(m+" "+n+" "+i+" "+j);
		
		if(m==1 && n==1)
			return 0;
		
		int tmpI,tmpJ,res,tmpM,tmpN = -1;
		int maxNegativ = Integer.MIN_VALUE;
		boolean hasNeg = false;
		int maxPositiv = 0;
		
		res = 0;
		for(int indice = 1; indice < m; indice++ )
		{		
			tmpI = i;
			tmpJ = j;
			tmpM = indice;
			
			if(i>= indice)
			{
				tmpI = i - indice;
				tmpM = m-indice;
			}
			
			//System.out.println(tmpM+" "+n+" "+tmpI+" "+tmpJ);
			
			if(!tabChecked[Simulate4D.convert(tmpM, n, tmpI, tmpJ, m_initial, n_initial, m_initial)])
			{
				res = f_dp_naif(tmpM, n, tmpI, tmpJ,false);
				tabRes[Simulate4D.convert(tmpM, n, tmpI, tmpJ, m_initial, n_initial, m_initial)]=res;
				tabChecked[Simulate4D.convert(tmpM, n, tmpI, tmpJ, m_initial, n_initial, m_initial)]=true;
			}
			else
				res = tabRes[Simulate4D.convert(tmpM, n, tmpI, tmpJ, m_initial, n_initial, m_initial)];
			
			if (res<1)
			{
				hasNeg = true;
				maxNegativ = Math.max(maxNegativ, res);
			}
			else
				maxPositiv = Math.max(maxPositiv, res);
			
		}
		
		for(int indice = 1; indice < n; indice++)
		{
			tmpI = i;
			tmpJ = j;
			tmpN = indice;
			
			if(j>= indice)
			{
				tmpJ = j - indice;
				tmpN = n - indice;
			}
			
			//System.out.println(m+" "+tmpN+" "+tmpI+" "+tmpJ);
			if(!tabChecked[Simulate4D.convert(m, tmpN, tmpI, tmpJ, m_initial, n_initial, m_initial)])
			{
				res = f_dp_naif(m, tmpN, tmpI, tmpJ,false);
				tabRes[Simulate4D.convert(m, tmpN, tmpI, tmpJ, m_initial, n_initial, m_initial)]=res;
				tabChecked[Simulate4D.convert(m, tmpN, tmpI, tmpJ, m_initial, n_initial, m_initial)]=true;
			}
			else
				res = tabRes[Simulate4D.convert(m, tmpN, tmpI, tmpJ, m_initial, n_initial, m_initial)];
			
			
			if (res<1)
			{
				hasNeg = true;
				maxNegativ = Math.max(maxNegativ, res);
			}
			else
				maxPositiv = Math.max(maxPositiv, res);
			
		}
		
		
		
		if (hasNeg)
			res = maxNegativ-1;
		else
			res = maxPositiv+1;
		
		return -res;
		
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
		
		return f_dp_naif(m,n,i,j,true);
	}
	
	public int f_dp_symmetry(int m,int n,int i,int j ,boolean resetCounter)
	{
		if(resetCounter)
			this.compteurAppel=0;
		this.compteurAppel++;
		
		//System.out.println(m+" "+n+" "+i+" "+j);
		
		if(m==1 && n==1)
			return 0;
		
		int tmpI,tmpJ,res,tmpM,tmpN = -1;
		int maxNegativ = Integer.MIN_VALUE;
		boolean hasNeg = false;
		int maxPositiv = 0;
		
		res = 0;
		for(int indice = 1; indice < m; indice++ )
		{		
			tmpI = i;
			tmpJ = j;
			tmpM = indice;
			
			if(i>= indice)
			{
				tmpI = i - indice;
				tmpM = m-indice;
			}
			
			Symmetry s = new Symmetry(tmpM,n,tmpI,tmpJ);
			s.normalizedSymmetry();
			if(!tabChecked[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)])
			{
				res = f_dp_symmetry(s.m, s.n, s.i, s.j,false);
				tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)]=res;
				tabChecked[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)]=true;
			}
			else
				res = tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)];
			
			if (res<1)
			{
				hasNeg = true;
				maxNegativ = Math.max(maxNegativ, res);
			}
			else
				maxPositiv = Math.max(maxPositiv, res);
			
		}
		
		for(int indice = 1; indice < n; indice++)
		{
			tmpI = i;
			tmpJ = j;
			tmpN = indice;
			
			if(j>= indice)
			{
				tmpJ = j - indice;
				tmpN = n - indice;
			}
			
			Symmetry s = new Symmetry(m,tmpN,tmpI,tmpJ);
			s.normalizedSymmetry();
			if(!tabChecked[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)])
			{
				res = f_dp_symmetry(s.m, s.n, s.i, s.j,false);
				tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)]=res;
				tabChecked[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)]=true;
			}
			else
				res = tabRes[Simulate4D.convert(s.m, s.n, s.i, s.j, m_initial, n_initial, m_initial)];
			
			
			if (res<1)
			{
				hasNeg = true;
				maxNegativ = Math.max(maxNegativ, res);
			}
			else
				maxPositiv = Math.max(maxPositiv, res);
			
		}
		
		
		
		if (hasNeg)
			res = maxNegativ-1;
		else
			res = maxPositiv+1;
		
		return -res;
		
	}
	
	
	public int f_dp_symmetry(int m,int n,int i,int j)
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
		
		return f_dp_symmetry(m,n,i,j,true);
	}
}
