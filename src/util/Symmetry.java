package util;

public class Symmetry {

	public int m,n,i,j;
	
	public Symmetry(int m,int n, int i, int j)
	{
		this.m=m;
		this.n=n;
		this.i=i;
		this.j=j;

	}
	
	//same as constructor, but dont reallocate memory
	public void setSymmetry(int m,int n,int i,int j)
	{
		this.m=m;
		this.n=n;
		this.i=i;
		this.j=j;
	}
	
	public void setSymmetry(Symmetry s)
	{
		this.m=s.m;
		this.n=s.n;
		this.i=s.i;
		this.j=s.j;
	}
	
	/**
	 * find a form that is on the upper left corner of the array
	 * 
	 */
	public void normalizedSymmetry()
	{
		int mm = this.m;
		int nn = this.n;
		int ii = this.i;
		int jj = this.j;
		
		if(m<n)
		{
			mm = this.n;
			nn = this.m;
			ii = this.j;
			jj = this.i;
		}
		
		
		if(ii>=mm/2)
			ii = mm-1-ii;
		if(jj>=nn/2)
			jj = nn-1-jj;
		setSymmetry(mm,nn,ii,jj);

	}
	
	public boolean isSymmetry(int m, int n, int i, int j)
	{
		
		if(this.m == m && this.n == n && this.i == i && this.j == j)
			return true;
		
		int mm = m;
		int nn = n;
		int ii = i;
		int jj = j;
		if(this.m == n && this.n == m && m!=n)
		{
			mm = n;
			nn = m;
			ii = j;
			jj = i;
		}
		
		if(this.m == mm && this.n == nn && this.i == ii && this.j == jj)
			return true;
		
		//System.out.println(verticalSymmetry(mm, nn, ii, jj) + " " + horizontalSymmetry(mm, nn, ii, jj) +" "+ horizontalAndVerticalSymmetry(mm, nn, ii, jj));
		return verticalSymmetry(mm, nn, ii, jj) || horizontalSymmetry(mm, nn, ii, jj) || horizontalAndVerticalSymmetry(mm, nn, ii, jj);
		
	}
	
	public boolean verticalSymmetry(int m,int n,int i,int j)
	{
		
		if(!(this.m==m && this.n==n && this.j == j)) //on a le mm tableau
			return false;
		
		if(this.m-1-i==this.i) 
			return true;
		return false;
	}
	
	public boolean horizontalSymmetry(int m,int n,int i,int j)
	{
		if(!(this.m==m && this.n==n && this.i == i)) //on a le mm tableau
			return false;
		
		if(this.n-1-j==this.j) 
			return true;
		return false;
	}
	
	public boolean horizontalAndVerticalSymmetry(int m,int n,int i,int j)
	{
		if(!(this.m==m && this.n==n))
			return false;
	
		return verticalSymmetry(m,n,i,this.j) && horizontalSymmetry(m,n,this.i,j);
	}
	
	public String toString()
	{
		return this.m+" "+this.n+" "+this.i+" "+this.j;
	}

	public boolean equals(Symmetry s)
	{
		return (this.m==s.m && this.n==s.n && this.i==s.i && this.j==s.j);
	}

	
}
