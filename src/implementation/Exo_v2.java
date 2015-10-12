package implementation;

public class Exo_v2 {

	public int compteurAppel;
	public int[] tabRes;
	public boolean[] tabChecked;
	public int m_initial;
	public int n_initial;
	
	public int f(int m,int n,int i,int j,boolean resetCounter, boolean dp, boolean symmetry)
	{
		if(resetCounter)
			this.compteurAppel=0;
		this.compteurAppel++;
		
		//System.out.println(m+" "+n+" "+i+" "+j);
		
		if(m==1 && n==1)
			return 0;
		
		int res = 0;
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
			tmpM = m;
			tmpN = n;
			
			if(indice<m)
			{
				;//if(i>=)
			}
		}
		
		return 0;
	}
	
}
