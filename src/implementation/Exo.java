package implementation;

public class Exo {

	
public int compteurAppel;

	public Exo()
	{
		this.compteurAppel=0;
	}
		
	
	private int f(int m,int n,int i,int j,boolean resetCounter)
	{
		if(resetCounter)
			this.compteurAppel=0;
		this.compteurAppel++;
		
		
		if(m==1 && n==1)
			return 0;
		
		int tmpI,tmpJ,res =-1;
		int maxNegativ = Integer.MIN_VALUE;
		boolean hasNeg = false;
		int maxPositiv = 0;
		
		for(int indice = 1; indice < m; indice++ )
		{		
			tmpI = i;
			tmpJ = j;
			
			if(i>= indice)
				tmpI = i - indice;
			if(j>= n)
				tmpJ = j - n;
			
			res = f(indice, n, tmpI, tmpJ,false);
			
			if (res<1)
			{
				hasNeg = true;
				maxNegativ = Math.max(maxNegativ, res);
			}
			else
				maxPositiv = Math.max(maxNegativ, res);
			
		}
		for(int indice = 1; indice < n; indice++)
		{
			tmpI = i;
			tmpJ = j;
			
			if(i>= m)
				tmpI = i - m;
			if(j>= n)
				tmpJ = j - indice;
			
			res = f(m, indice, tmpI, tmpJ,false);
			
			if (res<1)
			{
				hasNeg = true;
				maxNegativ = Math.max(maxNegativ, res);
			}
			else
				maxPositiv = Math.max(maxNegativ, res);
			
		}
		
		
		
		if (hasNeg)
			res = maxNegativ-1;
		else
			res = maxPositiv+1;
		
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
		return f(m,n,i,j,true);
	}
	
	
	public int f_dp_naif(int m,int n,int i,int j ,boolean resetCounter)
	{
		return 0;
	}
	
	public int f_dp_naif(int m,int n,int i,int j)
	{
		return f_dp_naif(m,n,i,j,true);
	}
	
}
