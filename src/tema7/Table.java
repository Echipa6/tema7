package tema7;

import java.io.IOException;
import java.util.Vector;

class Table {
	private int currentPlayerNumber = -1;
	private boolean available = false;
	private BagTiles bagTiles;
	Vector<Player> players;
	
	public Table()
	{
		try {
			bagTiles=new BagTiles();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		players= new Vector<Player>();
	}
	void addPlayer(Player player)
	{
		players.add(player);
	}
	public Vector<Character> getMissedTiles(int currentNumberTiles)
	{ 
		return bagTiles.getTiles(7-currentNumberTiles);
		
	}
	private void playRound()
	{
		Player currentPlayer=players.elementAt(currentPlayerNumber);
		currentPlayer.addMyTiles(getMissedTiles(currentPlayer.getNumberTiles()));
	}
	
	public synchronized int get(int consNumber) {
		while (!(available && currentPlayerNumber==consNumber)) {
			try {
				wait();
				// Asteapta arbitrul sa puna o valoare
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		available = false;
		System.out.println(	"Consumatorul "+consNumber+" primit:\t" + currentPlayerNumber);
		playRound();
		
		
		notifyAll();
		return currentPlayerNumber;
	}
	public synchronized void put(int number) {
		while (available) {
			try {
				wait();
				// Asteapta jucatorul sa preia valoarea
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.currentPlayerNumber = number;
		available = true;
		System.out.println("Producatorul a pus:\t" + number);
		notifyAll();
	}
}