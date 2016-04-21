package tema7;

import java.io.IOException;
import java.util.Vector;

public abstract class Solver {
	
	protected Vector<Character> tiles;
	protected Dictionary  dictionary;
	
	public Solver(){
		try {
			dictionary=new Dictionary();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Vector<Character> getTiles() {
		return tiles;
	}
	
	
	public void setTiles(Vector<Character> tiles) {
		this.tiles = tiles;
	}
	
	
	
	public void addTiles(Vector<Character> tiles) {
		
	}
	

	public abstract String getWord();
	
	
}
