package tema7;

import java.util.Vector;

class Player extends Thread {
	private Table table;
	private int number; 
	AutomatSolver solver;
	
	private Vector<Character> myTiles;
	
	public Player(Table b, int nr) {
		table = b;
		number=nr;
		setMyTiles(new Vector<Character>());
		solver = new AutomatSolver();
	}
	public void run() {
		int value = 0;
		for (int i = 0; i < 300; i++)
		{	
			value = table.get(this.number-1);
			
		}
	}
	public Vector<Character> getMyTiles() {
		return myTiles;
	}
	public void setMyTiles(Vector<Character> myTiles) {
		this.myTiles = myTiles;
	}
	public int getNumberTiles() {
		return this.myTiles.size();
	}
	
	public void addMyTiles(Vector<Character> randomTiles) {
		while(!randomTiles.isEmpty())
		{
			myTiles.add(randomTiles.remove(randomTiles.size()-1));
		}
		
	}
	public void removeMyTiles(String word) {
		
		
		for(int i=0;i<word.length();i++)
		{
				int index_nr=myTiles.indexOf(word.charAt(i));
				myTiles.remove(index_nr);
			
		}
		
	}
}
