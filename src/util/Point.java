package util;

public class Point {

	public int x,y;
	
	
	public Point(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
	
	public String toString()
	{
		return x+","+y;
	}
	
	public boolean equal(Point p)
	{
		return p.x==this.x && p.y==this.y;
	}
}
