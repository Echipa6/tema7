package tema7;

import java.io.IOException;
import java.util.Vector;

import javax.swing.JTextArea;

class Table {
	private int currentPlayerNumber = -1;
	 JTextArea textArea;
	private boolean available = false;
	private BagTiles bagTiles;
	Vector<Player> players;
	
	public Table( JTextArea textArea)
	{
		this.textArea=textArea;
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
		currentPlayer.setLabelActive();
		if(currentPlayer.getNumberTiles()!=7)
		{
		
		currentPlayer.addMyTiles(getMissedTiles(currentPlayer.getNumberTiles()));
		
		for(int i=0;i<currentPlayer.getMyTiles().size();i++)
		{
			this.textArea.append(currentPlayer.getMyTiles().elementAt(i).toString()+'\n');
		}
		System.out.println("************8");
		}
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