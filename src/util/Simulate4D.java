package util;



public class Simulate4D {
	
	
	//May need a long type, or even BigInteger?
	public static int convert(int a,int b,int c,int d, int maxa, int maxb, int maxc)
	{
		//return BigInteger.valueOf((long)(a + maxa*b + c*maxa*maxb + d*maxa*maxb*maxc));
		return a + maxa*b + c*maxa*maxb + d*maxa*maxb*maxc;
	}

}
