package tema7;

import java.io.IOException;
import java.util.Vector;

public abstract class Solver {
	
	protected Dictionary  dictionary;
	protected Vector<Character> tiles;
	
	public Solver(){
		try {
			dictionary=new Dictionary();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public abstract String getWord(Vector<Character> tiles);
	
	
}
