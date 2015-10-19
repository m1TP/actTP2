package implementation;

public class Moteur {

	
	public boolean ordiTurn; //true if its the turn of the cpu to play
	
	
	public Moteur(boolean ordiTurn)
	{
		this.ordiTurn=ordiTurn;
	}
	
	public Moteur()
	{
		this(true);
	}
	
	
	
}
