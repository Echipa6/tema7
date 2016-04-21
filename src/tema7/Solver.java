package tema7;

import java.util.Vector;

public abstract class Solver {
	
	protected Vector<Character> tiles;
	
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
