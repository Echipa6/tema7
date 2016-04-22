package tema7;

import java.util.Vector;

import javax.swing.JOptionPane;

public class ManualSolver extends Solver {
	String wordToValidate;
	boolean valid=false;
	public void setWordToValidate(String wordToValidate) {
		this.wordToValidate = wordToValidate;
		validate(wordToValidate);
		System.out.println(wordToValidate);
		if(!valid)
		{
			JOptionPane.showMessageDialog(App.mainFrame,
				    "Cuvantul scris de tine nu e bun.");
		}
	}
	@Override
	public String getWord(Vector<Character> tiles) {
		this.tiles=tiles;
		while(!valid)
		{
			
		}
		
		
		valid=false;
		return wordToValidate;
	}
	private void validate(String wordToValidate) {
		boolean ok=true;
		String auxWord=wordToValidate;
		Vector<Character> auxTiles=this.tiles;
		
		for(int i=0;i<auxWord.length();i++)
		{
			int index_nr=auxTiles.indexOf(auxWord.charAt(i));
			if(index_nr==-1)
			{
				System.out.println(auxTiles.toString());
				System.out.println("nu avem litera"+auxWord.charAt(i));
				ok=false;
			}
			else
			{
				auxTiles.remove(index_nr);
			}
				

		}
		System.out.println("e cuvint?"+dictionary.voc.getNode(wordToValidate).isWord());
		valid=ok && dictionary.voc.getNode(wordToValidate).isWord();
		
	}
	

}
